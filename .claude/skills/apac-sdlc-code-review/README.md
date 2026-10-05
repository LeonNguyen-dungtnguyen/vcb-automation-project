# apac-sdlc-code-review

Code review skill for Claude Code with two independent modes, chosen by the argument.

| Invocation | Mode | What is reviewed | Posts to the platform? |
| --- | --- | --- | --- |
| `/apac-sdlc-code-review <PR/MR URL>` | MR mode | The PR/MR diff, fetched entirely via the platform API | Yes, after a full preview and explicit confirmation |
| `/apac-sdlc-code-review <PR/MR URL> --auto-post` | MR mode, unattended | Same | Yes, without asking; the posted content is echoed afterwards |
| `/apac-sdlc-code-review` | Local mode | Uncommitted changes of the current repository | Never; findings are reported in chat |

The two modes share only the review rubric and the full-file-context principle. No flag combines them.

## Quick start

```
# Review a merge request and post inline comments after confirming the preview
/apac-sdlc-code-review https://gitlab.com/group/project/-/merge_requests/42
/apac-sdlc-code-review https://github.com/owner/repo/pull/42
/apac-sdlc-code-review https://dev.azure.com/org/project/_git/repo/pullrequest/42

# Same, but post without a confirmation prompt (flag may go on either side of the URL)
/apac-sdlc-code-review https://github.com/owner/repo/pull/42 --auto-post
/apac-sdlc-code-review --auto-post https://github.com/owner/repo/pull/42

# Review the uncommitted changes in the repository you are standing in
/apac-sdlc-code-review
```

### Inputs that are rejected

The skill stops and says what it did not understand. It never guesses.

- A bare ID such as `!42`, `#42`, or `42`. It carries no host, project, or platform.
- `--auto-post` with no URL. Local mode never posts, so the flag is meaningless there.
- Any other `--` flag, or any stray token next to the URL.

## Prerequisites

- **MR mode:** the CLI for the platform, authenticated: `glab auth login` (GitLab), `gh auth login` (GitHub), or `az login` (Azure DevOps). `jq` is used to trim API output. Self-hosted GitLab and GitHub Enterprise work the same way, because the platform is detected from the URL's path shape, not its hostname.
- **Local mode:** the current directory must be inside a git work tree. No network, no CLI, no token.
- Both skills in this repository and the shared `_shared/` directory must be installed as siblings under the same `skills/` directory, since the skill files link to `../_shared/`.

## MR mode

Reviews the PR/MR entirely through the platform API and posts one bundled review back to it.

What it guarantees:

- **Pure API.** It never runs `git clone`, `checkout`, or `fetch`, and never reads a local working copy, even when a matching clone is present. It works from any directory.
- **Skips draft, closed, or merged PRs**, unconditionally. It tells you why and stops.
- **Full-file context.** Each hunk is reviewed with the full content of the file at the head SHA. Files over roughly 1500 lines fall back to hunk-only context, which is noted in the wrap-up.
- **Dedupe.** Findings that match an existing comment on the PR are never posted twice. They appear in the summary as `skipped — already flagged`.
- **Line-anchor validation.** A finding whose line is not part of the diff cannot carry an inline comment on any platform. It is kept as summary-only.
- **Confidence gate.** Each finding is checked against a severity-and-confidence gate before posting. A finding that fails is never silently dropped. It is listed in the run summary as "not posted".
- **One bundled post.** GitHub: one review with `event: "COMMENT"`. GitLab: draft notes followed by `bulk_publish`. Azure DevOps: one thread per finding plus a summary thread (not atomic). Inline comments are never posted one at a time.
- **Preview and confirm.** Before the write call you see the exact summary body and every inline comment (file, line, severity, confidence, body) and are asked to confirm. Declining posts nothing.
- **Wrap-up.** After the run you get the link to the posted review (or the reason nothing was posted), counts of posted / deduped / note-only / line-invalid findings, and the full list of not-posted findings with reasons, restated in chat.

### `--auto-post`

The flag is your up-front confirmation for this one run. The preview is skipped and nothing is asked. Everything else still applies: dedupe, line validation, confidence gate, bundling.

- It must be typed explicitly on every invocation. It is never a default and never read from config or the environment.
- The wrap-up echoes the exact summary body and every posted inline comment in full, because you never saw a preview.
- **GitLab with pending draft notes:** the skill aborts the post and fails closed. Nothing is created, published, or deleted. Delete the drafts or rerun without the flag. Without `--auto-post`, the skill shows the pending drafts and asks whether to delete them first.
- Zero postable findings: no write call is made at all, and the wrap-up reports "nothing to post" with the full not-posted list.

## Local mode

Reviews the uncommitted changes of the repository the command runs in: staged and unstaged hunks from `git diff HEAD`, plus every untracked file as one synthetic hunk. Full working-tree file content is the context.

- **Read-only.** It never stages, stashes, commits, fetches, or writes the index (`git add -N` included). No network or platform call.
- A clean working tree is reported as "nothing to review — the working tree is clean". That is a normal result, not an error.
- Binary files and files over roughly 1500 lines are skipped and listed.
- No dedupe, confidence gate, line validation, or preview. Those protect a platform from bad posts, and this mode never posts.

The output is one entry per finding, in severity order:

| Key | Value |
| --- | --- |
| `severity` | `Blocker` / `High` / `Medium` / `Low` / `Nit` |
| `confidence` | `High` / `Medium` / `Low` |
| `file` | repo-root-relative path |
| `lines` | line or range, in working-tree line numbers |
| `issue` | what is wrong |
| `reason` | why it is wrong, one line |

`apac-sdlc-code-review-fix-loop` consumes this list directly for its re-review passes.

## Severity and confidence

Both modes normalize every finding to exactly one of `Blocker / High / Medium / Low / Nit` and one confidence of `High / Medium / Low`. The scales, their tie-break rules, and why the two axes are independent are defined once in [`../_shared/severity.md`](../_shared/severity.md).

## Files

| File | Purpose |
| --- | --- |
| [`SKILL.md`](SKILL.md) | The skill itself: hard rules, mode dispatch, MR-mode Steps 1–12, Local-mode Steps L1–L5 |
| [`references/diff-and-content.md`](references/diff-and-content.md) | MR mode: eligibility check, fetching the diff and full file content per platform |
| [`references/post-review.md`](references/post-review.md) | MR mode: dedupe, the confidence gate, GitLab stale-draft check, preview, posting the bundled review |
| [`references/local-changes.md`](references/local-changes.md) | Local mode: preflight, collecting hunks, reading working-tree content |
| [`../_shared/severity.md`](../_shared/severity.md) | Severity and confidence scales shared by every skill |
| [`../_shared/platform-commands.md`](../_shared/platform-commands.md) | Read-only, repo-context-free API commands for GitHub, GitLab, and Azure DevOps |

## Related

- [`apac-sdlc-code-review-fix-loop`](../apac-sdlc-code-review-fix-loop/README.md) fixes the unresolved `Blocker`/`High`/`Medium` comments on an MR (URL argument) or the `Blocker`/`High`/`Medium` findings in your uncommitted changes (no argument), re-reviewing in a loop by calling this skill in Local mode. This skill's Local mode is review-only.
