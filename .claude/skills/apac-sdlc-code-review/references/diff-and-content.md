# Diff, file content, and eligibility — API only

MR mode only. Everything here is a read call. Metadata (with `state`/`draft`/head-SHA fields) and existing-comment fetches are already covered by [../../_shared/platform-commands.md](../../_shared/platform-commands.md) — read that first. This file adds the diff/patch fetch and full-file-content fetch that `platform-commands.md` doesn't cover, since those are specific to this skill.

## Eligibility check

Using the metadata fields from `platform-commands.md`'s metadata call, stop before doing anything else if the PR is draft, closed, or merged — **unconditionally, no exceptions**:

| Platform | Closed/merged | Draft |
| --- | --- | --- |
| GitHub | `state != "OPEN"` | `isDraft == true` |
| GitLab | `state != "opened"` | `draft == true` (or `work_in_progress == true` on older instances) |
| Azure DevOps | `status != "active"` | `isDraft == true` |

Tell the user which condition triggered the skip (closed, merged, or draft) and stop — do not review. This is the operative form of hard rule 4 in [../SKILL.md](../SKILL.md). Local mode never fetches MR metadata, so this check never applies there.

## Fetching the diff / patch per file

```bash
# GitHub — structured file diff with patch text
gh api "repos/<owner>/<repo>/pulls/<number>/files" --hostname <host> --paginate \
  | jq -s 'add | [.[] | {path: .filename, previous_path: .previous_filename, status, patch}]'
```

GitHub omits `.patch` for large or binary files — treat a missing `patch` as "no hunk data" for that file (same handling as a file over the full-content size cap below: skip review of that file, note it in the summary).

```bash
# GitLab — unified diff per file (diff_refs already fetched by the metadata call)
# MUST paginate: this endpoint defaults to per_page=20, so an MR with more than
# 20 changed files silently returns only the first page — a partial review that
# looks complete. (--paginate concatenates arrays, hence jq -s 'add'.)
glab api "projects/<url-encoded-path>/merge_requests/<iid>/diffs?per_page=100" --hostname <host> --paginate \
  | jq -s 'add | [.[] | {old_path, new_path, diff, new_file, deleted_file, renamed_file}]'
```

Never drop `--paginate` here. Unlike the metadata call, a truncated diff produces no error and no empty result — the run reviews 20 files, reports success, and the remaining files are never seen. If the CLI in use does not support `--paginate`, page manually via `X-Next-Page` until it is empty, and state the file count reviewed in the wrap-up so a truncation is visible.

Azure DevOps has **no unified-diff API**. Get the latest iteration id, then the changed files for that iteration, then diff the two blob contents locally (still zero checkout — two REST reads plus a text diff):

```bash
# Latest iteration id (also needed later for posting — see post-review.md)
az devops invoke --area git --resource pullrequestiterations \
  --route-parameters project=<project> repositoryId=<repo> pullRequestId=<id> \
  --organization "https://dev.azure.com/<org>" --api-version 7.1 \
  | jq '.value[-1].id'

# Changed files for that iteration
az devops invoke --area git --resource pullrequestiterationchanges \
  --route-parameters project=<project> repositoryId=<repo> pullRequestId=<id> iterationId=<latest> \
  --organization "https://dev.azure.com/<org>" --api-version 7.1
```

For each changed path, fetch the file content at the base commit and at the head commit (see below) and diff them locally (`diff -u`) to derive hunks. This is the only way to get hunk boundaries on Azure DevOps without a checkout.

Each entry carries a `changeType` (`add`, `edit`, `delete`, `rename`, or a combination such as `edit, rename`); on a rename the pre-image path is `sourceServerItem`. Keep both — see the next section.

## Path pairs — renames

Every changed file has **two** paths: the pre-image (`old_path`) and the post-image (`new_path`). They are identical for an ordinary edit and differ for a rename, and **both must survive to the posting step** — GitLab's inline-comment position requires the pair, and sending the post-image twice makes it reject the position (see `post-review.md`, "GitLab"). Record the pair per file at fetch time; it cannot be recovered later from the hunk text.

| Platform | Post-image | Pre-image |
| --- | --- | --- |
| GitHub | `.filename` | `.previous_filename` — present **only** when `status == "renamed"`; fall back to `.filename` |
| GitLab | `new_path` | `old_path` — always returned, already equal to `new_path` when nothing moved |
| Azure DevOps | the change entry's path | `sourceServerItem` when `changeType` includes `rename`; otherwise the same path |

Review findings are always anchored in the **post-image** path and its line numbers. The pre-image is carried for the GitLab position payload alone — GitHub (`path`) and Azure DevOps (`filePath`) take the post-image only and need nothing extra.

## Full file content at head SHA

Fetch for context on every changed file that is not a pure deletion, not binary, and not over the size cap (**~1500 lines** — above that, fall back to hunk-only context for that file and note the fallback in the summary; this bounds review cost on very large files without silently doing a shallower review with no indication).

```bash
# GitHub — raw bytes, no base64 decode needed
gh api "repos/<owner>/<repo>/contents/<path>?ref=<headSha>" --hostname <host> \
  -H "Accept: application/vnd.github.raw"

# GitLab — raw endpoint
glab api "projects/<url-encoded-path>/repository/files/<url-encoded-file-path>/raw?ref=<headSha>" --hostname <host>

# Azure DevOps — Items API via invoke
az devops invoke --area git --resource items \
  --route-parameters project=<project> repositoryId=<repo> \
  --query-parameters path=<path> versionDescriptor.version=<headSha> versionDescriptor.versionType=commit includeContent=true \
  --organization "https://dev.azure.com/<org>" --api-version 7.1
```

The Azure DevOps `items` response may return `.content` as plain text or base64 depending on file type — check the response shape at call time (a JSON `content` field vs. a `contentMetadata.encoding` marker) before treating it as ready-to-use text.
