---
name: apac-sdlc-code-review
description: Code review with two modes, chosen by the argument. With a full PR/MR URL — single-shot automated review of the pull/merge request entirely via platform API (GitHub, GitLab, or Azure DevOps) that POSTS real inline review comments back to the PR/MR after user confirmation (or unattended, without asking, when the `--auto-post` flag is given); it never reads local files and works from any directory. With no argument — reviews the local uncommitted changes (staged, unstaged, and untracked files) of the current repository and reports structured findings in chat; it never contacts a platform and needs no network. Both modes review diff hunks with full-file context and normalize findings to Blocker/High/Medium/Low/Nit. Use when the user provides a PR/MR URL and asks to review it and leave comments on the PR/MR itself, or when the user asks to review their local uncommitted changes.
argument-hint: <PR/MR URL> [--auto-post]
---

# APAC SDLC — Code Review

Two independent modes, chosen by the argument. **MR mode** (a full PR/MR URL): review the MR diff entirely via platform API and **post real inline comments back to the PR/MR** as one bundled review, after a preview and explicit confirmation. **Local mode** (no argument): review the uncommitted changes of the repository the command runs in and report structured findings in chat. The modes share the review rubric and the full-file-context principle, nothing else — no flag combines them. The only flag, `--auto-post`, is MR-mode-only (hard rule 9).

**Hard rules — read first:**

1. **Mode dispatch is by argument shape.** A full PR/MR URL → MR mode. No argument → Local mode. The URL may carry exactly one flag, `--auto-post`, on either side (`<URL> --auto-post` or `--auto-post <URL>`). Anything else is an error — say what was not understood and stop, never guess: a bare ID (`!42`, `#42`, `42` — carries no host, project, or platform; **not accepted** as a URL), `--auto-post` with no URL (Local mode never posts, so the flag is meaningless there — say so), any other `--` flag, any stray token.
2. **MR mode is pure API/CLI.** Never `git clone`, `checkout`, or `fetch`. Works from any directory and never reads a local working copy, even if a matching clone is present.
3. **Local mode is read-only on the repository.** Never stages, stashes, commits, fetches, or writes the index (`git add -N` included); no network or platform call. Its findings live only in chat.
4. **MR mode skips draft, closed, or merged PRs — unconditionally.** Stop and tell the user why; do not review.
5. **Severity scale is `Blocker / High / Medium / Low / Nit`** in both modes — normalize every finding to exactly one; never invent or borrow another scale. Levels and tie-break rules: [../_shared/severity.md](../_shared/severity.md).
6. **MR mode confidence-gates every finding before posting** (Step 8). A finding that fails is never silently dropped — it goes into the run summary as "not posted."
7. **MR mode dedupes against existing comments** before posting — never post the same issue twice across runs.
8. **One bundled review/publish action per platform**, with one summary body — never post inline comments one at a time.
9. **Always confirm before posting** — full preview (summary + every inline comment), explicit go-ahead, then the write call. Posting is real, team-visible, and hard to undo as a batch. **Sole exception: `--auto-post`** — the flag is the user's up-front confirmation for this one run, so Step 10 does not ask. Opt-in per invocation: typed explicitly every time, never a default, never read from config or environment. It changes nothing else — gate, dedupe, line validation, and bundling all still apply — and Step 12 echoes the full posted content in place of the preview the user never saw.

## Modes

| Invocation | What is reviewed | Full-file context from | Line space | Posts? |
| --- | --- | --- | --- | --- |
| `<PR/MR URL>` | MR diff hunks — all via API, from any directory | platform API at the head SHA | head SHA | yes, after confirmation |
| `<PR/MR URL> --auto-post` | same | same | head SHA | yes, **without** confirmation — posted content echoed in Step 12 |
| *(no argument)* | local uncommitted changes: staged + unstaged (`git diff HEAD`) and untracked files | the working tree | working tree | never — structured findings in chat |

Parse `$ARGUMENTS` per hard rule 1. URL → MR mode at Step 1, recording `auto_post` (`true` only when the flag is present; Steps 9, 10, and 12 branch on it). Empty → Local mode at Step L1.

---

# MR mode

## Step 1 — Identify the platform and the PR

Determine the platform from the URL's path shape and parse its identifiers with the table in [../_shared/platform-commands.md](../_shared/platform-commands.md) — read it now (MR mode only). Required CLI missing or unauthenticated → stop and name the fix (`glab auth login`, `gh auth login`, `az login`).

## Step 2 — Eligibility check

Fetch metadata with `platform-commands.md`'s metadata command (state / draft / head-SHA fields) and apply the "Eligibility check" section of [references/diff-and-content.md](references/diff-and-content.md) — hard rule 4.

## Step 3 — Fetch the diff

Per "Fetching the diff / patch per file" in [references/diff-and-content.md](references/diff-and-content.md). Azure DevOps has no diff API: fetch the latest iteration's changed files and diff blob contents locally — still no checkout.

- Parse hunk headers (`@@ -a,b +c,d @@`) into the set of valid **new-file** line numbers per path — Step 7 gates on it.
- Record both paths per file — pre-image `old_path`, post-image `new_path` — per "Path pairs — renames": Step 11's GitLab position needs the pair, and it cannot be recovered from hunk text later. Findings anchor to the post-image.

## Step 4 — Fetch full file content for context

For each changed, non-deleted, non-binary file under the ~1500-line cap, fetch the full content at the head SHA per "Full file content at head SHA" in the same reference. Over the cap → hunk-only context; note it in Step 12.

## Step 5 — Review

**Read [../_shared/severity.md](../_shared/severity.md) before producing any finding** — it defines both scales. For each hunk, with the hunk plus the file's full content as context, produce findings: file, new-file line (head-SHA line numbers throughout this mode), severity, confidence (`High/Medium/Low`), one-line rationale.

## Step 6 — Dedupe

Fetch existing comments/threads with `platform-commands.md`'s comment-fetch command and apply "Dedupe against existing comments" in [references/post-review.md](references/post-review.md). Matched findings → `skipped — already flagged`: not posted, kept in the summary.

## Step 7 — Line-anchor validation

A surviving finding whose line is not in Step 3's valid-line set is demoted to summary-only — no platform can anchor an inline comment there.

## Step 8 — Confidence gate

Apply "The post-inline gate" in [references/post-review.md](references/post-review.md). Failing findings are summary-only, never posted (hard rule 6).

## Step 9 — GitLab stale-draft check

**GitLab only.** Per "GitLab: check for stale draft notes first" in [references/post-review.md](references/post-review.md): pending draft notes → show them and ask whether to delete them first (`bulk_publish` would otherwise publish them alongside this run's). **With `--auto-post`, do not ask — abort the post, fail closed:** create nothing, publish nothing, delete nothing; tell the user to delete them or rerun without the flag; go to Step 12 with every finding not posted, reason `aborted — pending GitLab drafts`. GitHub and Azure DevOps have no pending-draft surface, so no equivalent abort.

## Step 10 — Preview and confirm (not asked with `--auto-post`)

Build the exact summary body and inline list (file, line, severity, confidence, body) that Steps 6–8 left postable, per "Preview and confirmation" in [references/post-review.md](references/post-review.md). Show it in full and ask for explicit confirmation (AskUserQuestion). Declined → post nothing, write nothing to disk, go to Step 12.

**With `--auto-post`:** build the same payload, do not show it, do not call AskUserQuestion, continue to Step 11. Zero postable inline findings → make no write call at all; go to Step 12 and report "nothing to post" with the full not-posted list.

## Step 11 — Post

Call the platform's bundled endpoint per "Posting the bundled review" in [references/post-review.md](references/post-review.md) — GitHub: one review call, `event: "COMMENT"`; GitLab: draft notes, then `bulk_publish`; Azure DevOps: one thread per finding plus a summary thread, not atomic. A single bad position (GitHub 422 / GitLab 400) → demote that finding to summary-only, retry the rest once.

## Step 12 — Wrap up

Runs after Step 11, after a Step 10 decline or auto-post zero-findings skip, and after a Step 9 auto-post abort. Tell the user, in plain text:

- the link/id of the posted review (GitHub review URL, GitLab MR URL, Azure DevOps PR URL) — or that nothing was posted, and why,
- counts: posted / deduped / note-only (failed confidence gate) / line-invalid,
- the full list of not-posted findings with reasons, restated directly in chat — never only in an API payload the user cannot easily re-read,
- **with `--auto-post` only:** the exact summary body and every posted inline comment (file, line, severity, confidence, body), restated in full — the user never saw a preview, so this is the only place they see what went out.

---

# Local mode

No URL, no platform, no network. Every step's mechanics live in [references/local-changes.md](references/local-changes.md) — read it now.

## Step L1 — Preflight

Per "Preflight": confirm the cwd is inside a git work tree, resolve the repo root, check `git status --porcelain`. Not a work tree → stop and say so. Clean tree → report "nothing to review — the working tree is clean" and stop: a normal result, not an error.

## Step L2 — Collect the changes

Per "Collecting the hunks": staged + unstaged hunks from `git diff HEAD` at the repo root, plus one synthetic 1..EOF hunk per untracked file. Read-only throughout (hard rule 3). Skip binary files and files over the ~1500-line cap; note both in Step L5.

## Step L3 — Full file content for context

Per "Full file content as context": one working-tree read per file — the only file state this mode reviews. A file deleted in the working tree gets hunk-only context; the cap applies per file.

## Step L4 — Review

**Read [../_shared/severity.md](../_shared/severity.md) first**, exactly as in MR mode. For each hunk, with the full working-tree file as context, produce findings: severity, confidence, file, line(s), issue, one-line reason — all in working-tree line numbers, pointing at the file as it stands on disk.

No dedupe (no platform comments to compare against), no confidence gate, no line-anchor validation, no preview — those exist to protect a platform from bad posts, and this mode never posts.

## Step L5 — Report

The findings list **is** the output — emit one object per finding, in severity order:

| Key | Value |
| --- | --- |
| `severity` | `Blocker` / `High` / `Medium` / `Low` / `Nit` |
| `confidence` | `High` / `Medium` / `Low` |
| `file` | repo-root-relative path |
| `lines` | line or range — **working-tree** line numbers, always |
| `issue` | what is wrong — the finding's own description |
| `reason` | why it is wrong — the one-line rationale |

Emit every finding — nothing is gated, so nothing is withheld. Also report any file skipped for the size cap or binary content, untracked files included. A calling skill (such as `apac-sdlc-code-review-fix-loop`) consumes this list directly; a human reader gets the same list rendered readably.
