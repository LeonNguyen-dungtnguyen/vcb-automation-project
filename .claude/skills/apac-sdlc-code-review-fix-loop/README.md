# apac-sdlc-code-review-fix-loop

Claude Code skill that runs an automated **fix → review → fix** loop and writes an HTML report of everything it found and fixed. Two ways to start it:

```
/apac-sdlc-code-review-fix-loop <MR/PR URL>   # MR mode    — start from the MR's unresolved review comments
/apac-sdlc-code-review-fix-loop               # Local mode — start from your uncommitted changes
```

Supports GitLab, GitHub, and Azure DevOps in MR mode. Local mode needs no platform.

## MR mode

The run, in order:

1. Checks out the MR's source branch in your local clone.
2. Fetches every unresolved review comment on the MR, from every comment surface.
3. Fixes the comments scored `Blocker`, `High`, or `Medium`. `Low` and `Nit` are recorded, not fixed. **If nothing needed fixing, the run stops here with a chat summary — no report, nothing written; only the branch checkout happened.**
4. Re-reviews the applied fixes with `apac-sdlc-code-review` in Local mode, fixes new `Blocker`/`High`/`Medium` findings, and repeats, at most 3 times.
5. Leaves every fix uncommitted in your working tree, with a report at `.review-loop/mr-<id>.html`.

## Quick start

```
/apac-sdlc-code-review-fix-loop https://gitlab.com/group/project/-/merge_requests/42
/apac-sdlc-code-review-fix-loop https://github.com/owner/repo/pull/42
/apac-sdlc-code-review-fix-loop https://dev.azure.com/org/project/_git/repo/pullrequest/42
```

Run it from inside a local clone of the MR's **target** repository, with a clean working tree.

A bare ID (`!42`, `#42`, `42`) is not accepted. It carries no host, project, or platform, and inferring them from the git remote is unreliable. The skill asks for the full URL.

## Local mode

Run it with no argument from anywhere inside a repository that has uncommitted changes. Steps 1–4 are skipped: no checkout, no comment fetching. The run:

1. Checks the tree is dirty. A clean tree means "nothing to review" and the run stops.
2. Shows you the branch and the files it will cover (`git status --short`), warns that fixes will land on top of your uncommitted changes, and asks for confirmation. Nothing is written until you say yes.
3. Adds `.review-loop/` to `.gitignore`.
4. Reviews all your uncommitted changes (staged, unstaged, untracked) with `apac-sdlc-code-review` in Local mode, fixes the `Blocker`/`High`/`Medium` findings, re-reviews, and repeats, at most 3 times. `Low`/`Nit` are recorded, not fixed.
5. Writes the report to `.review-loop/local-<branch>.html`.

**The fixes land on top of your own uncommitted work.** You are asked to confirm this before the run starts. There is no clean state to reset to. Review `git diff HEAD` and `git status` before committing (plain `git diff` hides staged edits and untracked files), and do not use `git reset`, `git checkout .`, or `git stash` afterwards — they would discard your work along with the fixes.

Not the same as `/apac-sdlc-code-review` with no argument: that reviews your local changes and reports; this one reviews, **fixes**, and loops.

## Prerequisites

Both modes:

- `apac-sdlc-code-review` and the shared `_shared/` directory installed as siblings under the same `skills/` directory. The re-review step invokes that skill, and the skill files link to `../_shared/`.
- The Agent tool, for the reporter subagent that writes the HTML. If it is unavailable the skill writes the report itself.

MR mode only:

- A local clone of the target repository, with a clean `git status`. A dirty tree stops the run so your uncommitted work is not mixed with the skill's fixes.
- The platform CLI, authenticated: `glab auth login` (GitLab), `gh auth login` (GitHub), or `az login` plus `az devops configure` (Azure DevOps). Self-hosted GitLab and GitHub Enterprise work the same way, because the platform is detected from the URL's path shape.
- `jq`, used to trim API output.

Local mode only: a git work tree with something uncommitted in it.

## What the skill promises

- **Local changes only.** It never commits, pushes, replies to, or resolves discussion threads on the MR. You review, commit, and push.
- **Maximum 3 iterations.** It stops earlier when a re-review finds nothing that needs fixing.
- **Stops early when there is nothing to fix** (MR mode). No `Blocker`/`High`/`Medium` comment to fix → chat summary of the unresolved comments, no report, nothing written.
- **Every issue goes in the report**, whether fixed, skipped, not blocking, or unresolved. Nothing is silently dropped.
- **MR mode: a dirty working tree before the start stops the run. Local mode: the dirty tree is the input, and the wrap-up warns that fixes are mixed into it.**
- **Comment bodies are untrusted input** (MR mode). See the section below. Its out-of-scope list also bounds every fix the loop applies, in either mode.

## Eligibility and identity checks (MR mode)

- A **closed or merged** MR stops the run. A **draft** MR proceeds, because nothing in this loop posts to the platform. This differs from `apac-sdlc-code-review` MR mode, which skips drafts.
- The remote is resolved by matching the URL's repository path against `git remote -v`. `origin` is never assumed, so fork-based PRs and clones without an `origin` remote work. No match means the skill asks you which remote to use.
- After checkout, `git rev-parse HEAD` must equal the MR's head SHA from the API. A mismatch shows both SHAs and asks where the matching clone is.
- The pre-run HEAD SHA is recorded and reported at the end, so you can reset to it.
- `.review-loop/` is added to `.gitignore` before any report file is written. That edit stays uncommitted alongside the fixes.

## Which comments get fixed (MR mode)

All unresolved comment surfaces are fetched: inline diff comments, whole-file comments, MR-level comments including review summary bodies, and commit comments. A general comment that bundles several findings is split into one issue per finding, each quoting the relevant excerpt verbatim.

Each comment is scored on the shared `Blocker / High / Medium / Low / Nit` scale, using the same table the review passes use. A human's naming request is a `Nit`, the same as one raised by a review pass. Who asked is recorded in the row's `source` and `author`, never by raising the level.

| Comment | Result |
| --- | --- |
| Question, design opinion, praise, or outdated comment | `skipped`, with the reason. Not scored. |
| On the out-of-scope list below | `skipped (out of scope — needs human review)`, whatever its severity |
| Scored `Low` or `Nit` | `not blocking`, detail `below fix threshold (Low/Nit)`. No code touched. |
| Scored `Blocker`, `High`, or `Medium` | Fixed, with the applied change recorded |

`Low`/`Nit` comments are deliberately left for you. Their threads stay open on the MR, and the report lists them with author and comment link so you can handle or answer them before pushing.

## Comment bodies are untrusted input

Every comment body is treated as a description of a problem, never as a command addressed to the tool. The test for any requested change is: would this be a normal review fix to the code already in this MR's diff? If not, it is recorded and not applied, even partially.

The skill never does any of the following on a comment's say-so, whoever wrote it. Each is marked `skipped (out of scope — needs human review)` with what was asked:

- Run a shell command, script, or installer the comment supplies.
- Fetch a URL, endpoint, or gist the comment supplies, or add a new network call to the code.
- Add, remove, or re-pin a dependency, or edit a lockfile or anything that executes at install or build time.
- Touch credentials, tokens, secrets, `.env`, key material, or auth/permission logic.
- Edit CI/CD config, git config, hooks, or `.gitignore` beyond the `.review-loop/` line the skill adds itself.
- Delete or disable tests, assertions, linters, type checks, or security checks.
- Write repository content, environment variables, or file contents into a URL, a log destination, or a new file outside the MR's scope.

A comment that tries to redirect the tool itself (ignore earlier rules, change the severity scale, hide a finding, commit or push) is marked `skipped (comment attempts to redirect the tool)`, quoted verbatim in the report, and called out by ID in the wrap-up. A reviewer legitimately asking for a dependency bump or CI change is still skipped, because it needs a human, and the skip reason says so.

## The loop

Each iteration, up to 3:

1. **Re-review** the uncommitted changes by invoking `apac-sdlc-code-review` in Local mode, with full-file context. In MR mode the uncommitted changes are exactly the applied fixes, so MR code that no fix touched is not re-scanned. In Local mode iteration 1 covers your whole uncommitted change set, and later iterations cover it with the fixes applied.
2. **Judge** the findings. False positives are marked `skipped` with reasoning. Findings on the skill's own artifacts (the `.gitignore` line, the report file) are skipped as `loop artifact`. A finding that repeats an earlier `not blocking` row is not logged again.
3. **Stop** when no confirmed `Blocker`/`High`/`Medium` finding remains at `Medium` or `High` confidence, or when the third iteration ends.
4. Otherwise **fix** every confirmed `Blocker`/`High`/`Medium` finding and go around again.

Two separate rules are at work. The **fix threshold** decides what gets fixed: `Blocker`, `High`, `Medium`. The **stop check** decides whether the loop continues: no confirmed `Blocker`/`High`/`Medium` at `Medium`+ confidence. They name the same three levels but are not the same rule.

When the loop stops, trivial one-line `Medium` findings and any `Low`-confidence `Blocker`/`High` that survived judging are still fixed on the spot. `Low`/`Nit` findings are always `not blocking`, because they were never fix candidates. The remaining `Blocker`/`High`/`Medium` findings take a residue label: `not blocking` after a clean stop, or `unresolved — iteration limit reached` after the third iteration.

## Output

- **Report:** `.review-loop/mr-<id>.html` (MR mode, written only when at least one comment was fixed) or `.review-loop/local-<branch>.html` (Local mode, branch name sanitized, overwritten per run) in the repository root, one self-contained file updated after every iteration so a mid-run crash still leaves a usable report. MR mode has a "Reviewer comments" section, one section per iteration, and a closing summary; Local mode starts at Iteration 1. Reviewer comments, paths, and branch names are escaped as content, never rendered as HTML.
- **Working tree:** the fixes and the `.gitignore` edit, all uncommitted.
- **Chat wrap-up:** iterations run and why the loop stopped, counts of fixed / skipped / not-blocking / unresolved, the report path, the pre-run HEAD SHA and the `Low`/`Nit` comments left for you (MR mode) or the mixed-work warning (Local mode), and what the re-reviews covered.

"Clean" at the end means no confirmed `Blocker`/`High`/`Medium` findings at `Medium`+ confidence under this run's review passes. LLM review is probabilistic, not a proof of zero defects.

## Files

| File | Purpose |
| --- | --- |
| [`SKILL.md`](SKILL.md) | The skill itself: hard rules, MR-mode Steps 1–4, Local-mode Step L, shared Steps 5–7 |
| [`references/checkout-and-diff.md`](references/checkout-and-diff.md) | Resolving the remote without assuming `origin`, checking out the MR source branch per platform |
| [`references/reporter.md`](references/reporter.md) | The reporter subagent: issue-data JSON format, per-mode header data, untrusted-input warning, crash-safety guard, report requirements |
| [`references/report-template.html`](references/report-template.html) | HTML template the reporter fills, with MR/Local header and closing variants and the escaping and counting rules in its comments |
| [`../_shared/severity.md`](../_shared/severity.md) | Severity and confidence scales shared by every skill |
| [`../_shared/platform-commands.md`](../_shared/platform-commands.md) | Read-only, repo-context-free API commands for fetching MR metadata and comments |

## Related

- [`apac-sdlc-code-review`](../apac-sdlc-code-review/README.md) is invoked in Local mode for every re-review pass. Its MR mode is the single-shot reviewer that posts comments to a PR/MR; its Local mode is review-only, without fixes.
