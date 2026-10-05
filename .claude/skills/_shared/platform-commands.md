# Platform commands — shared read-only PR/MR access

Shared reference for any skill that reads a pull/merge request across GitHub, GitLab, and Azure DevOps. **Read-only.** Never call endpoints that create, resolve, or reply to comments/threads — a skill that posts keeps its write commands in its own reference file, so this file's read-only guarantee holds for every skill that includes it.

Every command below is **repo-context-free**: it takes host/owner/project/org explicitly and works from any directory, with no reliance on a checked-out repo, `git remote`, or `az devops configure` defaults. A skill that also works against a local clone keeps its checkout/diff commands in its own reference file, not here.

**Always pipe API output through the `jq` filters below** — raw responses are 10–50× larger than the fields needed. Never let an unfiltered discussions/threads response into the conversation.

## Parsing the MR/PR URL

Everything below is driven by fields taken from the URL the user supplied. Match the **path shape** — the host is data, not a discriminator, so self-hosted GitLab and GitHub Enterprise parse identically to the SaaS hosts (`glab` and `gh` already resolve per-host auth from their own config).

| Platform | Example URL | Fields |
| --- | --- | --- |
| GitLab | `https://gitlab.com/group/sub/repo/-/merge_requests/42` | host `gitlab.com`, project path `group/sub/repo`, iid `42` |
| GitLab (self-hosted) | `https://git.company.com/group/sub/repo/-/merge_requests/42` | host `git.company.com`, project path `group/sub/repo`, iid `42` |
| GitHub | `https://github.com/owner/repo/pull/42` | host `github.com`, owner `owner`, repo `repo`, number `42` |
| Azure DevOps | `https://dev.azure.com/org/project/_git/repo/pullrequest/42` | org `org`, project `project`, repo `repo`, id `42` |
| Azure DevOps (legacy) | `https://org.visualstudio.com/project/_git/repo/pullrequest/42` | org from the subdomain, project `project`, repo `repo`, id `42` |

Notes:
- GitLab project path = everything between the host and `/-/merge_requests/`; it may contain nested subgroups. URL-encode it (`%2F` for `/`) when using it as `projects/<path>` in a REST call.
- Azure DevOps: always pass `--organization "https://dev.azure.com/<org>"` explicitly (never rely on `az devops configure` defaults — those are per-machine state, not derivable from the URL alone).
- A caller that also has a local clone may additionally want to compare this repo/project against `git remote get-url origin` — compare the **repo path**, not the host string, since an SSH host alias (`git@github-personal:owner/repo.git`) is a legitimate remote for `github.com/owner/repo`. That comparison is out of scope for a caller with no local clone.

## GitLab (`glab`)

Works for gitlab.com and self-hosted. Always pass `--hostname <host>` explicitly and the full encoded project path — do not rely on `glab`'s `:id` shortcut, which only resolves inside a checked-out repo.

```bash
# MR metadata, trimmed to the fields callers use
glab api "projects/<url-encoded-path>/merge_requests/<iid>" --hostname <host> \
  | jq '{iid, title, web_url, source_branch, target_branch, state, draft, work_in_progress, sha, diff_refs}'
```

`state` is `opened`/`closed`/`merged`; `draft` is the boolean draft flag. Older instances expose `work_in_progress` instead, so the projection returns **both** — if `draft` is `null`, read `work_in_progress`. Do not trim either from the filter; a field that is not projected cannot be checked later. `sha` is the MR's current head commit; `diff_refs` (`base_sha`/`start_sha`/`head_sha`) is needed later for posting diff-anchored comments (see `post-review.md`) — fetched here once since it comes free on the same call.

```bash
# All open comments — inline, file-level, and general (plain, non-resolvable) notes
# (--paginate concatenates arrays, hence jq -s 'add')
glab api "projects/<url-encoded-path>/merge_requests/<iid>/discussions?per_page=100" --hostname <host> --paginate \
  | jq -s 'add | [.[] | .notes[]? | select((.system != true) and ((.resolvable == true and .resolved == false) or (.resolvable != true))) | {id, source: (if .position == null then "general" elif .position.position_type == "file" then "file" else "inline" end), author: .author.username, body, path: (.position.new_path // .position.old_path), line: (.position.new_line // .position.old_line)}]'

# Commit comments: list the MR commits, then fetch each commit's discussions
glab api "projects/<url-encoded-path>/merge_requests/<iid>/commits" --hostname <host> | jq '[.[].id]'
glab api "projects/<url-encoded-path>/repository/commits/<sha>/discussions?per_page=100" --hostname <host> \
  | jq '[.[] | .notes[]? | select(.system != true) | {id, source: "commit", author: .author.username, body, path: (.position.new_path // .position.old_path), line: (.position.new_line // .position.old_line)}]'
```

Comment web URL (`comment_url` for a report): the API returns no per-note URL — construct it (best-effort deep link, standard GitLab anchor format):

- MR discussion note: `<MR web_url>#note_<note id>`
- Commit comment: `<project web URL>/-/commit/<sha>#note_<note id>` (project web URL = MR `web_url` up to before `/-/merge_requests/...`)

Notes:
- Plain (non-resolvable) notes and commit comments have no resolved flag — treat them as open and judge staleness against the current code before fixing/deduping.
- For comments on deleted lines, `position.new_path`/`new_line` are null; the `//` fallbacks in both filters above already substitute `old_path`/`old_line`, so `path`/`line` are never null for a positioned note. Do not trim those fallbacks — without them a deleted-line comment arrives with `path: null` and cannot be located. A path that came from the pre-image refers to the file **before** the MR's changes; treat it as a locator, not as a line to patch.

Fallback without `glab`: REST with a token, same `jq` filters (without the `-s 'add'` wrapper — a single page is one array; follow `X-Next-Page` headers for more) —
`curl -H "PRIVATE-TOKEN: $GITLAB_TOKEN" "https://<host>/api/v4/projects/<url-encoded-path>/merge_requests/<iid>/discussions?per_page=100" | jq '[.[] | .notes[]? | ...]'`.

## GitHub (`gh`)

Always pass the host explicitly, but **with the right flag for the subcommand**: `gh pr` takes `-R <host>/<owner>/<repo>`; `gh api` takes `--hostname <host>` and reads owner/repo from the endpoint path. `-R` is *not* a `gh api` flag — `gh api ... -R ...` fails outright with `unknown shorthand flag: 'R' in -R`, and omitting `--hostname` silently sends the call to github.com, which breaks GitHub Enterprise. Every `gh` command below works with no checked-out repo. Thread resolution state is **only in GraphQL** — do not use the REST comments list to decide what is unresolved.

```bash
# PR metadata
gh pr view <number> -R <host>/<owner>/<repo> \
  --json title,headRefName,baseRefName,url,number,state,isDraft,headRefOid
```

`state` is `OPEN`/`CLOSED`/`MERGED`; `headRefOid` is the head commit SHA. `--json` returns only the fields listed — a field not requested here cannot be checked later.

```bash
# One round trip: unresolved review threads (inline + file-level), general
# conversation comments, review SUMMARY bodies, and the PR's commit SHAs.
# All FOUR connections are separately paginated — see "Paginating this query" below.
# Every cursor is null on the first call; pass only the one you are advancing.
gh api graphql --hostname <host> -f query='
  query($owner: String!, $repo: String!, $pr: Int!,
        $tCursor: String, $cCursor: String, $rCursor: String, $vCursor: String) {
    repository(owner: $owner, name: $repo) {
      pullRequest(number: $pr) {
        reviewThreads(first: 100, after: $tCursor) {
          pageInfo { hasNextPage endCursor }
          nodes {
            id isResolved isOutdated path line subjectType
            comments(first: 50) { nodes { author { login } body url } }
          }
        }
        comments(first: 100, after: $cCursor) {
          pageInfo { hasNextPage endCursor }
          nodes { id isMinimized author { login } body url }
        }
        reviews(first: 100, after: $rCursor) {
          pageInfo { hasNextPage endCursor }
          nodes { id state body url author { login } }
        }
        commits(first: 100, after: $vCursor) {
          pageInfo { hasNextPage endCursor }
          nodes { commit { oid } }
        }
      }
    }
  }' -f owner=<owner> -f repo=<repo> -F pr=<number> \
  | jq '{
      threads: [.data.repository.pullRequest.reviewThreads.nodes[] | select(.isResolved == false) | {id, source: (if .subjectType == "FILE" then "file" else "inline" end), path, line, isOutdated, comments: [.comments.nodes[] | {author: .author.login, body, url}]}],
      general: [
        (.data.repository.pullRequest.comments.nodes[] | select(.isMinimized == false) | {id, source: "general", author: .author.login, body, url}),
        (.data.repository.pullRequest.reviews.nodes[] | select(.state != "PENDING" and ((.body // "") | gsub("^\\s+|\\s+$"; "")) != "") | {id, source: "general", author: .author.login, body, url})
      ],
      commit_shas: [.data.repository.pullRequest.commits.nodes[].commit.oid],
      page: {
        threads:  .data.repository.pullRequest.reviewThreads.pageInfo,
        comments: .data.repository.pullRequest.comments.pageInfo,
        reviews:  .data.repository.pullRequest.reviews.pageInfo,
        commits:  .data.repository.pullRequest.commits.pageInfo
      }
    }'

# Commit comments (blob view / unchanged lines): one cheap call per PR commit SHA.
# Most PRs have zero — an empty array per SHA is the normal result.
gh api "repos/<owner>/<repo>/commits/<sha>/comments" --hostname <host> \
  | jq '[.[] | {id, source: "commit", path, line, author: .user.login, body, url: .html_url}]'
```

### Paginating this query

**Do not skip this.** All four connections cap at 100 and truncate **silently** — a PR with 101 commits or 101 conversation comments returns a well-formed result that is simply missing data, with nothing in the payload saying so. That is why the `page` object exists in the `jq` projection: it is the only truncation signal, so never trim it from the filter.

After every call, check `.page.<connection>.hasNextPage`. For each one that is `true`, re-run the **same** query advancing only that connection's cursor, and merge only that connection's nodes from the result (the other three come back identical and are discarded):

```bash
# e.g. more review threads. Cursors are strings — use -f, never -F.
gh api graphql --hostname <host> -f query='<same query>' \
  -f owner=<owner> -f repo=<repo> -F pr=<number> \
  -f tCursor='<.page.threads.endCursor>'
```

Repeat per connection until its `hasNextPage` is `false`. The cursor variables are `tCursor` (reviewThreads), `cCursor` (comments), `rCursor` (reviews), `vCursor` (commits).

Flag types matter here: `-F` parses its value as JSON when it can, so it is right for `pr` (an `Int!`) and wrong for every `String!`/`String` — a repo literally named `123`, or a cursor that happens to parse as a number, would be sent as an integer and rejected as a type error. Use `-f` for `owner`, `repo`, and all four cursors; `-F` for `pr` alone.

If a run cannot paginate for any reason, say in the wrap-up how many threads/comments/commits were read, so a truncated fetch is visible to the user rather than being reported as a complete pass.

Comment web URL: GitHub returns it directly — GraphQL `url` on each comment node, REST `html_url`. Use it as the report's `comment_url` (for a thread, use the first comment's `url`).

Notes:
- `threads` covers inline (`subjectType LINE`) and file-level (`subjectType FILE`, null line) comments. `isOutdated == true` means the commented lines have since changed — still address/consider the comment if it applies, otherwise mark it `skipped (outdated)`.
- `general` = Conversation-tab comments **plus review summary bodies**, which are two different surfaces on GitHub. A review submitted with a body (`POST pulls/<n>/reviews` with `body`, as `apac-sdlc-code-review` does) lands on `pullRequest.reviews.nodes.body` and **never** appears in `pullRequest.comments` — querying only `comments` silently drops every review summary, including this toolchain's own. `state == "PENDING"` is an unsubmitted draft visible only to its author: skip it. A review with an empty body is a bare approval or a thread-only review, already covered by `threads`: skip it too.
- GitHub has no resolve flag for either `general` surface; `isMinimized == false` is the "still open" heuristic for Conversation-tab comments, and a review body has no flag at all. Judge staleness against the current code.

## Azure DevOps (`az repos` / `az devops invoke`)

Always pass `--organization "https://dev.azure.com/<org>"` explicitly. `az repos pr thread` **does not exist** in the `azure-devops` CLI extension — thread read/write must go through `az devops invoke` (generic REST). Verify the exact resource name/casing once against a live org before relying on it: `az devops invoke --query "[?contains(area,'git')]" --organization "https://dev.azure.com/<org>"`.

```bash
# PR metadata, trimmed
az repos pr show --id <id> --organization "https://dev.azure.com/<org>" \
  | jq '{pullRequestId, title, sourceRefName, targetRefName, status, isDraft, headSha: .lastMergeSourceCommit.commitId, baseSha: .lastMergeTargetCommit.commitId, repo: .repository.name, project: .repository.project.name}'

# Unresolved (active/pending) comment threads only, system comments dropped.
# Covers all types: inline, file-level, and general PR comments are all threads here.
az devops invoke --area git --resource pullrequestthreads \
  --route-parameters project=<project> repositoryId=<repo> pullRequestId=<id> \
  --organization "https://dev.azure.com/<org>" --api-version 7.1 \
  | jq '[.value[] | select(.status == "active" or .status == "pending") | {id, source: (if .threadContext == null then "general" elif .threadContext.rightFileStart == null then "file" else "inline" end), path: .threadContext.filePath, line: .threadContext.rightFileStart.line, comments: [.comments[] | select(.commentType != "system") | {author: .author.displayName, body: .content}]}]'
```

Dropped statuses: `fixed`, `closed`, `wontFix`, `byDesign`. Azure DevOps has no separate commit-comment surface for PRs — the thread list above is complete.

Comment web URL: not in the thread payload — construct it (best-effort deep link to the thread): `<PR web URL>?discussionId=<thread id>` (PR web URL = `https://dev.azure.com/<org>/<project>/_git/<repo>/pullrequest/<id>`).
