# Local mode — collecting and reviewing uncommitted changes

Everything in this file runs **only** in Local mode (the skill was invoked with no URL). MR mode never touches a local repo and never reads this file.

Every command here is **read-only**. Nothing stages, stashes, commits, fetches, or writes the index. In particular: do **not** use `git add -N` to make untracked files visible to `git diff` — it mutates the index of a tree the user is actively working in. Untracked files are collected by listing them instead (below).

## Preflight

```bash
# 1. Inside a work tree at all
git rev-parse --is-inside-work-tree

# 2. Repo root — every later command runs from here, NOT from the cwd
git rev-parse --show-toplevel

# 3. Anything to review?
git status --porcelain
```

Not a git work tree → stop: this mode reviews local changes, so it must run from inside a repository.

An empty `git status --porcelain` → report "nothing to review — the working tree is clean" and stop. That is a normal result, not an error; a caller running this in a loop treats it as zero findings.

**Resolve the repo root and use it for everything downstream.** The user may invoke the skill from any subdirectory of the clone (`repo/src/`, say), and the collection commands below are cwd-scoped by default — run from a subdirectory they would silently cover only that subtree, producing a partial review that looks complete. Either `cd` to the root once, or prefix every git call with `git -C <root>` and read files as `<root>/<path>` (diff output paths are always repo-root-relative).

There is no SHA gate and no remote comparison in this mode: no MR is involved, so there is nothing to match the working tree against. Whatever HEAD is, the uncommitted changes on top of it are the review scope.

## Collecting the hunks

All of these run from the repo root resolved in the preflight — `git -C <root> …`, never bare from the cwd.

```bash
# Tracked files: staged + unstaged, against the committed state.
# No pathspec — a `-- .` here would scope the diff to the cwd.
git -C <root> diff HEAD

# Untracked files (absent from the diff above)
git -C <root> ls-files --others --exclude-standard
```

Use `git ls-files --others --exclude-standard`, **not** `git status --porcelain` filtered on `??`. Porcelain collapses an untracked *directory* into a single `?? dir/` entry, so every file inside a newly created directory would be silently skipped, and splitting its output on whitespace truncates paths containing spaces. `ls-files --others` enumerates the individual files, honors `.gitignore`, and emits one path per line.

Parse the `git diff HEAD` hunk headers (`@@ -a,b +c,d @@`) into per-file hunks; the `+c,d` side gives the working-tree line ranges. Each untracked file becomes one synthetic hunk covering lines 1..EOF. Skip binary files, and skip files over the ~1500-line cap, noting both in the wrap-up.

## Full file content as context

One read per file, from the working tree:

```bash
cat <root>/<path>
```

The working tree is the only file state this mode reviews — the diff was taken against it and the findings' line numbers point into it, so context, hunks, and line numbers all agree by construction. Never read a file at some commit (`git show`) for context here: committed content predates the uncommitted edits and would produce findings on code that no longer exists.

- The ~1500-line cap applies per file; over the cap, fall back to hunk-only context and note it.
- A file **deleted in the working tree** produces a deletion hunk in `git diff HEAD` but no longer exists to read — give it hunk-only context and skip the `cat`.

## One line space

Everything in this mode lives in **working-tree line numbers**: the hunks, the context, and every finding. A caller can open `<root>/<path>` at a finding's line and see exactly the code the finding describes — no remapping, no second coordinate system. This is what makes the mode safe to run repeatedly (a fix-and-review loop): an issue fixed on disk disappears from the next run's diff and is not re-reported.
