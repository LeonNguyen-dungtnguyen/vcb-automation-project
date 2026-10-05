# Local checkout and diff

These steps are specific to `apac-sdlc-code-review-fix-loop`, which applies fixes to a local working tree. `apac-sdlc-code-review` never checks out a repo: its MR mode is API-only (see its `references/diff-and-content.md`), and its Local mode *reads* the working tree via `references/local-changes.md` but never checks out, fetches, or writes the index.

## Resolving the remote — never assume `origin`

Every fetch in this skill needs a remote name, and `origin` is a guess that fails in exactly the cases a review loop meets: on a **fork-based PR** `origin` is the fork while the target branch lives on the upstream, and a clone may have no remote named `origin` at all. Do not hardcode `origin` anywhere in this run.

Resolve it **once**, in Step 2 item 3, and reuse that one name for every fetch in the run:

```bash
git remote -v
```

The MR/PR URL always names the **target** repo (that is where the PR object lives), so match on it: pick the remote whose URL's **repo path** equals the URL's owner/project/repo. Compare the *path*, never the host string — an SSH alias like `git@github-personal:owner/repo.git` is a legitimate remote for `github.com/owner/repo`. This is the sanity-check comparison [../../_shared/platform-commands.md](../../_shared/platform-commands.md) sanctions for a caller that has a clone; it is **not** an identity gate (that is the `HEAD == headSha` check in Step 2 item 4), so a mismatch here is a question for the user, never a silent abort.

- **Exactly one match** → that is `<remote>`.
- **Several match** → prefer the one the source branch tracks after checkout: `git rev-parse --abbrev-ref --symbolic-full-name @{upstream}` and take the part before the `/`. This is a **tiebreak, not a requirement** — it exits non-zero when the branch has no upstream, which is the normal case for a branch the GitLab arm below created from `FETCH_HEAD`. On failure, or when the upstream names a remote that did not match the URL's repo path, fall through to asking the user; never treat the missing upstream as an error in itself.
- **No match** → do **not** guess and do **not** fall back to `origin`. Show `git remote -v` alongside the URL's repo path and ask the user which remote hosts the MR's repo.

Note that on a fork-based PR the *source* branch may live on a different remote than `<remote>`. Neither checkout form below needs it to: `gh pr checkout` adds whatever refspec or remote it needs on its own, and the GitLab form fetches the MR head ref, which the **target** project always carries even for a fork MR. `<remote>` is the **target-side** remote, and the target side is what every fetch below is after.

## Checkout the source branch

**Never pass a bare id to `gh`/`glab` here.** A bare `<number>`/`<iid>` is resolved against the CLI's *default repo* for the current clone, not against the URL the user gave. In a fork+upstream clone — the setup the section above exists for — that default is ambiguous: the CLI either picks the fork and resolves a different PR of the same number, or stops to prompt for a default repo, which hangs an unattended run. Every identifier below comes from the parsed URL (see [../../_shared/platform-commands.md](../../_shared/platform-commands.md)), the same invariant the API calls hold.

```bash
# GitLab — do not use `glab mr checkout`: its repo-override support varies by
# version, and a bare <iid> hits the default-repo problem above. Fetch the MR
# head ref instead — every GitLab instance exposes it on the TARGET project, so
# this works for fork-based MRs without adding the fork as a remote.
# <branch> = metadata source_branch. <remote> is resolved above.
git fetch <remote> "refs/merge-requests/<iid>/head"

if git show-ref --verify --quiet "refs/heads/<branch>"; then
  git switch <branch> && git merge --ff-only FETCH_HEAD
else
  git switch -c <branch> FETCH_HEAD
fi

# GitHub — pass the full PR URL (carries host, owner, repo, and number in one
# token), or the equivalent -R form. `gh pr checkout <number>` alone is the
# default-repo bug above, and on GitHub Enterprise it targets the wrong host.
gh pr checkout "<PR URL>"
# equivalently: gh pr checkout <number> -R <host>/<owner>/<repo>

# Azure DevOps — no CLI equivalent, so do it by hand.
# sourceRefName is like "refs/heads/feature-x" — strip refs/heads/ first.
# <remote> is resolved above and is NOT necessarily "origin".
git fetch <remote> <branch>

if git show-ref --verify --quiet "refs/heads/<branch>"; then
  # Local branch already exists — fast-forward it onto the remote.
  git switch <branch> && git merge --ff-only "<remote>/<branch>"
else
  # No local branch — create one tracking the resolved remote.
  git switch --track "<remote>/<branch>"
fi
```

**GitLab and Azure DevOps: never use the bare `git checkout <branch>` DWIM form.** Git resolves a bare branch name against remote-tracking refs only when **exactly one** remote carries it. Now that `<remote>` is no longer pinned to `origin`, a clone holding the branch on two remotes — fork and upstream, precisely the setup the section above exists for — makes the name ambiguous and the checkout fails outright:

```
hint: If you meant to check out a remote tracking branch on, e.g. 'origin',
hint: you can do so by fully qualifying the name with the --track option:
hint:     git checkout --track origin/<name>
```

The branching form above is explicit in both directions, and the two halves are not interchangeable:

- `git switch --track <remote>/<branch>` (and `git switch -c <branch> FETCH_HEAD` in the GitLab arm) **errors if a local branch of that name already exists**, so neither can be the only form.
- `git switch -C` / `git checkout -B` would take that case silently — by **resetting** the existing branch and discarding any local commits on it. The clean-tree check in Step 2 item 2 does not protect against this: it passes a tree whose *committed* work is about to be thrown away. Do not use the force variants here. Note the case matters: lowercase `-c` is the safe form used above, uppercase `-C` is the destructive one.
- If the `--ff-only` merge fails, the local branch has genuinely diverged from the MR head. **Stop and tell the user** — show both SHAs. Never fall back to a force reset or a merge commit; hard rule 1 puts that decision with the user.

(`git switch` needs git 2.23+. On older git the equivalents are `git checkout <branch>` for the first arm, `git checkout --track <remote>/<branch>` for the Azure DevOps second arm, and `git checkout -b <branch> FETCH_HEAD` for the GitLab one.)

## Where the diff comes from

No diff is built in this file, and no target-branch fetch is needed: the re-review is `apac-sdlc-code-review` in **Local mode**, which owns the diff — `git diff HEAD` (staged + unstaged) plus `git ls-files --others --exclude-standard` for untracked files, reviewed against full working-tree file content. It needs no base commit and makes no network call.

The old `git add -N` trick that used to make new files visible is **not** to be reintroduced — it writes the index, and the sub-skill deliberately avoids that (see its `references/local-changes.md`).
