# Posting the review — write commands

These are this skill's **only** write/create calls, and they belong to MR mode alone — Local mode posts nothing and never reaches this file. Everything in `../../_shared/platform-commands.md` and `diff-and-content.md` is read-only; the write commands are kept in this one file so that guarantee is easy to audit.

## The post-inline gate

Both scales — severity and confidence — are defined in [../../_shared/severity.md](../../_shared/severity.md), and are assigned back in Step 5. This section covers only what the two of them decide together here: what gets posted.

A finding is posted as an inline comment only if:

```
(severity in {Blocker, High} and confidence in {Medium, High})
  OR
(severity in {Medium, Low, Nit} and confidence == High)
```

Everything else — failed the gate, deduped, or line-anchor-invalid — goes into the run summary as "not posted," with its reason. Never silently drop a finding; every one is accounted for in the final report to the user.

## Dedupe against existing comments

Existing comments and this mode's findings both anchor to **head-SHA** line numbers, so they compare directly.

Using the existing-comment/thread fetch from `../../_shared/platform-commands.md`, for each candidate finding: look at existing comments on the same file within a **±3-line window** of the finding's line. If, on reading the existing comment body, it already reports substantially the same issue (semantic match — not exact string match, wording will differ), mark the finding `skipped — already flagged` instead of posting it. Keep it in the summary.

## Preview and confirmation (required before every post, unless `--auto-post`)

Before calling any write endpoint, build and show the user:
- the exact summary body text that will be posted,
- every inline comment that will be posted: file, line, severity, confidence, body text.

Then ask for explicit confirmation (AskUserQuestion). If declined, stop — nothing is posted, and nothing is written to disk; findings only exist in the chat transcript for this run.

**Under `--auto-post`** the same preview is built (it is the payload for the write call and the content of the Step 12 wrap-up) but it is not shown for approval and AskUserQuestion is not called — the flag, typed explicitly for this run, is the confirmation. Two consequences: if zero inline findings survived the gate, dedupe, and line validation, make **no** write call at all (an unattended empty review is noise) and report "nothing to post"; and the Step 12 wrap-up must carry the full posted content, because it is the only place the user ever sees it. The gate itself, dedupe, and line validation are unchanged by the flag.

## GitLab: check for stale draft notes first

`bulk_publish` (below) publishes **every** pending draft note on the MR under the current user, including leftovers from a previous interrupted run — not just this run's.

```bash
glab api "projects/<url-encoded-path>/merge_requests/<iid>/draft_notes" --hostname <host>
```

If this returns any notes, show them to the user and ask whether to delete them before proceeding:

```bash
glab api --method DELETE "projects/<url-encoded-path>/merge_requests/<iid>/draft_notes/<id>" --hostname <host>
```

**Under `--auto-post`, any pending draft note aborts the run before the first write.** List the drafts, create no draft note, call no `bulk_publish`, delete nothing, and tell the user to delete them or rerun without the flag. Still produce the Step 12 wrap-up, with every finding listed as not posted, reason `aborted — pending GitLab drafts` — the review is not discarded, only the post. Publishing them unattended ships content nobody reviewed; deleting them unattended is a destructive action nobody approved. Fail closed.

## Posting the bundled review

### GitHub

One atomic call. `event: "COMMENT"` — never `REQUEST_CHANGES` or `APPROVE`; a single automated pass shouldn't hold merge-blocking authority or grant approval, regardless of the severity mix found.

```bash
jq -n --arg body "$SUMMARY" --arg commit "$HEAD_SHA" --argjson comments "$COMMENTS_JSON" \
  '{commit_id: $commit, event: "COMMENT", body: $body, comments: $comments}' \
  | gh api "repos/<owner>/<repo>/pulls/<number>/reviews" --hostname <host> --input -
```

Each element of `$COMMENTS_JSON`: `{path, line, side: "RIGHT", body}`.

If the call 422s because of one bad comment position, remove that finding from `$comments`, demote it to summary-only, and retry the call once with the rest.

### GitLab

One draft note per posted finding, plus one positionless draft note for the summary, then a single publish call.

```bash
glab api --method POST "projects/<url-encoded-path>/merge_requests/<iid>/draft_notes" --hostname <host> \
  -f note="<finding body>" \
  -f position[position_type]=text \
  -f position[base_sha]=<base_sha> -f position[start_sha]=<start_sha> -f position[head_sha]=<head_sha> \
  -f position[old_path]=<oldPath> -f position[new_path]=<newPath> -f position[new_line]=<line>
# repeat per posted finding. Both paths are required even when identical, or GitLab 400s the position.

glab api --method POST "projects/<url-encoded-path>/merge_requests/<iid>/draft_notes" --hostname <host> \
  -f note="<summary body>"   # no position = general/top-of-MR note

glab api --method POST "projects/<url-encoded-path>/merge_requests/<iid>/draft_notes/bulk_publish" --hostname <host>
```

`base_sha`/`start_sha`/`head_sha` come from the MR metadata's `diff_refs` (fetched in `platform-commands.md`'s metadata call).

`<oldPath>`/`<newPath>` are the file's path pair from Step 3 (see `diff-and-content.md`, "Path pairs — renames"). **On a renamed file they differ, and sending `<newPath>` for both is rejected** — GitLab matches the position against the diff, which records the rename. That failure is silent in practice: the 400-handler below demotes the finding to summary-only and the run continues, so a renamed file would simply never receive an inline comment and nothing would say why. Use the real pre-image path; do not substitute the post-image.

If a single draft-note creation 400s (bad position), skip that finding (demote to summary-only) and continue creating the rest — only call `bulk_publish` once all remaining draft notes are created. **If the skipped findings cluster on one file, name that file and the 400 in the wrap-up** rather than reporting a bare count — a position rejected for every finding on a single path is a payload bug, not a bad line number, and a silent demotion buries it.

### Azure DevOps

No bundle primitive. Create every inline thread, then one general summary thread. **Not atomic** — if a call fails partway, report which findings posted and which didn't; do not attempt to roll back already-created threads (a delete-comment action is its own risk, not clearly safer than a partial post).

```bash
az devops invoke --area git --resource pullrequestthreads --http-method POST \
  --route-parameters project=<project> repositoryId=<repo> pullRequestId=<id> \
  --organization "https://dev.azure.com/<org>" --api-version 7.1 \
  --in-file thread-payload.json
```

Payload per inline finding:

```json
{
  "comments": [{"parentCommentId": 0, "content": "<finding body>", "commentType": 1}],
  "status": 1,
  "threadContext": {
    "filePath": "/<path>",
    "rightFileStart": {"line": <n>, "offset": 1},
    "rightFileEnd": {"line": <n>, "offset": 1}
  },
  "pullRequestThreadContext": {
    "iterationContext": {"firstComparingIteration": 1, "secondComparingIteration": <latest_iteration_id>}
  }
}
```

Then one more thread with no `threadContext`, carrying the summary body, as the stand-in for a "review submission" (Azure DevOps has no single review-submission object the way GitHub/GitLab do).

The wrap-up report that follows every post, decline, or abort is defined once, in `SKILL.md` Step 12.
