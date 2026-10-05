# Severity and confidence — shared definitions

Definitions only. No commands, nothing to execute, nothing to write — this file is safe for any skill to read at any point.

Every skill that labels a finding uses these two scales and nothing else. Read this **before** producing the first finding, not when you go to act on one: a level assigned from the bare word "Blocker" and a level assigned from the table below are not the same judgment.

## Severity

Judge by the impact if the issue reaches production — not by how much code it touches, not by how strongly anyone feels about it.

| Severity | Meaning |
| --- | --- |
| `Blocker` | Breaks the build or tests, crashes, corrupts or loses data, or opens a security hole. Merging is not safe. |
| `High` | Correctness bug on a path ordinary use hits; missing error handling where failure is likely and consequential. |
| `Medium` | Bug reachable only on an edge case; questionable logic; missing validation. |
| `Low` | Style and consistency, minor inefficiency, non-idiomatic code. Correct as it stands. |
| `Nit` | Cosmetic — formatting, naming, comment wording. |

### Deciding rules

These are what make two independent passes agree. Apply them in order.

- **Reachability separates `High` from `Medium`.** A path ordinary use hits → `High`. Reachable only on an edge case → `Medium`.
- **Correctness separates `Medium` from `Low`.** Code that is correct **for every input it can actually receive** cannot rank above `Low`, however ugly it is. Missing validation and questionable logic stay at `Medium` — correct for the inputs seen so far is not the same as correct.
- **Naming, formatting, and comment wording are always `Nit`** — including when the reviewer clearly felt strongly about it. Strength of feeling is not impact.
- **Security, data loss, and a broken build are `Blocker`** regardless of how small the diff is.
- **Not everything is a finding.** A question, a design opinion needing human judgment, or praise is not scored at all — the caller decides what to do with it (a fix loop marks it `skipped`). Forcing one onto this scale produces a meaningless label.

### Reviewer comments use the same table

A finding written by a human and a finding produced by a review pass are scored identically. A reviewer's naming request is a `Nit`, the same as one the review pass raised on its own.

That a human asked is recorded in the finding's `source` field — never by raising its level. Inflating severity because someone took the time to write it is what makes `Blocker` and `High` counts stop meaning anything across a report.

## Confidence

How sure the finding is real, given only the context actually available.

| Confidence | Anchor |
| --- | --- |
| `High` | You can name the concrete input, state, or call path that triggers it, and the visible code confirms it. |
| `Medium` | The reasoning holds for the code in front of you, but depends on something you have not read — a caller, a config value, a library's contract. |
| `Low` | Pattern-based suspicion. Confirming it needs more code than was fetched, or actually running it. |

**Confidence is not importance.** A `Nit` can be `High` confidence — a misspelled identifier is plainly visible. A `Blocker` can be `Low` — a suspected race you cannot prove from the diff. The two axes are independent, which is exactly why a gate built on both (see `apac-sdlc-code-review/references/post-review.md`) can separate "serious" from "solid enough to act on."
