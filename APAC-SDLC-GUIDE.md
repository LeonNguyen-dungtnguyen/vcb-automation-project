# apac-sdlc — Team Setup Guide

This project uses **apac-sdlc**: Claude Code skills, a project knowledge base, and a
Spec-Driven Development (SDD) workflow.

**The short version: run `apac-sdlc` with no arguments.** It opens a Claude Code session here,
works out which of the steps below are already done, and walks you through the rest one at a
time. `apac-sdlc status` prints the same picture without starting a session.

The steps below are the reference for what that session is doing, and the manual path if you
would rather run them yourself. Run them **in order, once per project**. Steps 1-3 are the CLI
bootstrap, and 3 includes the interview a tech lead has to sit through. Steps 4-5 fill and wire up
the knowledge base, and 6 is what your team agrees on. After that, everyone
works through the [daily workflow](#daily-workflow) at the bottom.

Prerequisites: Node.js 18+, [Claude Code](https://docs.claude.com/en/docs/claude-code) on `PATH`,
Python 3.10+ (for the graphify knowledge base), and `npm install -g apac-sdlc`.

---

## 1. Install the SDLC skills

```bash
apac-sdlc init
```

Installs the generic skills into `.claude/skills/` (`/apac-sdlc-code-review`,
`/apac-sdlc-commit-msg`, `/apac-sdlc-pr-description`, `/apac-sdlc-security-review`,
`/apac-sdlc-requirement`, `/apac-sdlc-estimation`, `/apac-sdlc-prototype`), creates
`.claude/docs/` and `.claude/rules/`, seeds `CLAUDE.md`, then runs Claude's `/init` and
`/apac-sdlc-optimize-claude-md` to tailor `CLAUDE.md` to this codebase.

**You must:** read the resulting `CLAUDE.md`. It is what every Claude session in this repo loads
first — wrong facts there get repeated in every answer. Keep it under 200 lines; push detail into
`.claude/rules/` and `.claude/docs/`.

Re-running is safe: existing skills and an existing `CLAUDE.md` are left alone.

---

## 2. Scaffold the knowledge base

```bash
apac-sdlc add knowledge-base --pattern graphify
```

Installs graphify (PyPI package `graphifyy`), registers the `/graphify` skill with Claude Code, and
scaffolds at the project root:

- `.graphifyignore` — what the graph builder skips (same syntax as `.gitignore`). Claude scans the
  project first and suggests patterns for your stack; if `claude` isn't on `PATH`, a bundled
  template is used instead. **Read it** — anything wrongly ignored is invisible to every later step.
- `graphify-out/` — empty until step 4 indexes the project
- `GRAPHIFY.md` — usage guide
- the `.gitignore` block that keeps `GRAPH_REPORT.md`, `graph.html` and `graph.json` and ignores
  the rest, including the multi-megabyte `cache/`

Nothing is indexed yet; that happens in step 4.

The `.gitignore` block is written for you because it has one correct answer and getting it wrong
fails silently: it must be `graphify-out/*` with a star. The bare `graphify-out/` form excludes
the directory, and git will not re-include a file inside an excluded directory, so the three `!`
lines below it do nothing. If anything later breaks it, `apac-sdlc status` reports this step as
broken and `apac-sdlc status --fix` repairs it.

> Alternatives: `--pattern llm-wiki` (an LLM-maintained markdown wiki) or `--pattern rag`
> (RAG MCP server). Pick **one** — spec-kit queries exactly one knowledge base per project.

---

## 3. Install the SDD workflow and constitution

```bash
apac-sdlc add sdd --framework spec-kit
```

Copies the framework's skills into `.claude/skills/`, the workflow into `.specify/`, and merges a
section into `.claude/CLAUDE.md`. Greenfield vs brownfield is auto-detected (override with
`--mode green|brown`; preview with `--dry-run`).

`--framework` names which SDD workflow to install. Run `apac-sdlc --help` for the list. While
spec-kit is the only one bundled, onboarding installs it without asking; add a second and it asks
which one first.

**If the project already has an SDD framework and this CLI did not install it**, onboarding stops
and offers two actions rather than overwriting the team's work. Keep the existing install, which
leaves every file alone and treats this step as finished, including the team's own constitution.
Or replace it with the version this CLI ships, which overwrites `.specify/memory/constitution.md`
and any customised templates, skills and hook config. Those edits are only recoverable from git.

### The constitution

Installing the workflow is half the step. `add sdd` then launches
`/apac-sdlc-speckit-constitution`, which interviews you section by section and writes
`.specify/memory/constitution.md`, the governing document for the project: every spec, plan, task,
and implementation is checked against it. A sloppy constitution quietly degrades everything
downstream, so budget ten minutes and a tech lead who can answer for the project.

Two things have to be true before this step counts as done, and they are different facts:

1. The sections hold real content. `apac-sdlc status` reads the file and says which are still
   the shipped template, and warns about any section under 40 characters.
2. Somebody has read them. Nothing on disk shows that, so you record it:
   `apac-sdlc status --approve sdd`.

Read Claude's questions and every file it creates or updates. On a brownfield project the
pre-interview hook drafts sections inferred from the code, which you review against the written
file. A greenfield interview has no gate at all.

Sections I-VIII are yours: stack, architecture, code style, testing, security, performance,
definition of done. Section IX (Behavioral Principles) is locked, pre-filled and non-negotiable.

Re-run `/apac-sdlc-speckit-constitution` any time the project's constraints change.

---

## 4. Put something in the knowledge base

Scaffolding a knowledge base does not fill it, and an empty one fails silently: every spec is
drafted with no project context and nothing says so. What to run depends on the pattern you chose
at step 2.

| Pattern | What fills it |
| --- | --- |
| graphify | `/graphify ./` |
| llm-wiki | Ask Claude to read the project and write the first pages, then update `llm-wiki/index.md` |
| rag | Start the server, let it index this branch, check `rag_query` returns something, then run `apac-sdlc status --approve kb-populate` |

For graphify, `/graphify ./` indexes the project and writes `graphify-out/`:

| File | What it is |
| --- | --- |
| `graph.html` | Interactive graph — open it in a browser |
| `GRAPH_REPORT.md` | Key insights and suggested questions |
| `graph.json` | The full graph, used for queries |

It also writes `cache/`, `cost.json` and `manifest.json` — build state, not artefacts to share.
That is what the `.gitignore` block written in step 2 keeps out of the repo.

Open `GRAPH_REPORT.md` once the build finishes — if whole areas of the codebase are missing, the
culprit is usually an over-broad pattern in `.graphifyignore` from step 2.

Keeping the graph current is a **recurring** job, not a setup step — see
[Keeping the graph fresh](#keeping-the-graph-fresh) below.

---

## 5. Connect the knowledge base to the SDD workflow

```
/apac-sdlc-integrate-kb
```

Detects which knowledge base is installed and writes `.specify/kb/<pattern>.md` — the detection
signal plus the query approach for that KB. If more than one is installed, it asks you to pick.

After this, the `kb-context` extension automatically loads relevant context before
`/apac-sdlc-speckit-specify`, `/apac-sdlc-speckit-clarify`, and `/apac-sdlc-speckit-converge`. No
manual sync, no pasting context by hand.

**Verify:** `.specify/kb/` contains exactly one `.md` file.

---

## 6. Team conventions

<!-- EDIT THIS SECTION. The defaults below match what the tooling already does. -->

**Branches.** `/apac-sdlc-speckit-specify` creates the feature branch for you (the
`feature-branch` extension). The shape comes from `feature_numbering` in
`.specify/init-options.json`:

- `timestamp` (default) → `20260319-143022-user-auth`
- `sequential` → `003-user-auth`

For work outside the SDD cycle, use `<type>/<short-description>`, e.g. `fix/login-redirect-loop`,
`chore/bump-node-20`.

**Commits.** [Conventional Commits](https://www.conventionalcommits.org/) —
`feat:`, `fix:`, `docs:`, `refactor:`, `test:`, `chore:`. Run `/apac-sdlc-commit-msg` to generate
one from the staged diff.

**Pull requests.** One feature branch per spec. Generate the description with
`/apac-sdlc-pr-description`, and run `/apac-sdlc-code-review` (plus
`/apac-sdlc-security-review` when the change touches auth, data handling, or external input)
before asking for a human review.

**Definition of done.** Section VIII of `.specify/memory/constitution.md` — not this file. Keep it
there so the SDD workflow enforces it.

<!-- Add anything else your team standardizes on: environments, secrets handling, release cadence,
     who approves what. -->

---

## Daily workflow

Once setup is done, every feature runs through the SDD cycle:

```
/apac-sdlc-speckit-specify      →  spec.md          (branch is created for you)
/apac-sdlc-speckit-clarify      →  resolve ambiguities (on demand)
        review gate — read the spec before planning
/apac-sdlc-speckit-plan         →  plan.md
        review gate — approve the plan before tasks
/apac-sdlc-speckit-tasks        →  tasks.md
/apac-sdlc-speckit-analyze      →  cross-artifact consistency check
        review gate — resolve CRITICAL findings before building
/apac-sdlc-speckit-implement    →  code, one task at a time
/apac-sdlc-speckit-converge     →  assess the code against spec/plan/tasks
```

`/apac-sdlc-speckit-converge` is the closing gate: it reads `spec.md`, `plan.md`, and `tasks.md`,
inspects what the code actually does, and appends whatever is still missing, partial, contradictory,
or unrequested to `tasks.md` as a new `## Phase N: Convergence` block. It never edits the spec, the
plan, existing tasks, or your code. Run `/apac-sdlc-speckit-implement` on the appended tasks and
converge again — the feature is done when it reports **✅ Converged**.

Run `/apac-sdlc-speckit` any time for the command index.

### Keeping the graph fresh

```
/graphify ./ --update
```

Re-extracts only what changed, so it is cheap to run often. Tie it to something that already
happens — after a merge to the main branch, or at the start of a planning session. This is not a
one-time setup step: a stale graph feeds confident, outdated context into `specify`, `clarify`, and
`converge`, which is worse than no graph at all.

---

## Where things live

```
CLAUDE.md                        # project context — Claude loads this first
APAC-SDLC-GUIDE.md               # this file
GRAPHIFY.md                      # knowledge graph usage
.graphifyignore                  # what the graph builder skips
graphify-out/                    # graph.html, GRAPH_REPORT.md, graph.json (+ cache/, cost.json)
specs/                           # one directory per feature — spec.md, plan.md, tasks.md
.claude/
  CLAUDE.md                      # speckit workflow section
  skills/                        # slash commands
  rules/  docs/                  # project rules and long-form docs
.specify/
  memory/constitution.md         # the governing document — Sections I–VIII are yours
  templates/                     # spec / plan / tasks / checklist templates
  extensions.yml                 # hook registry (kb-context, feature-branch, brownfield-detect)
  kb/                            # the connected knowledge base
  feature.json                   # which feature is active (machine-local, git-ignored)
  scripts/bash/                  # helpers the skills call
  logs/                          # extension hook log
```

## Troubleshooting

| Symptom | Fix |
| --- | --- |
| Slash commands missing | Restart Claude Code — skills are read at session start |
| `/graphify` not found | `graphify install`, then restart Claude Code |
| Specs ignore the knowledge base | `.specify/kb/` is empty → re-run `/apac-sdlc-integrate-kb` (step 5) |
| Constitution is still placeholders | Run `/apac-sdlc-speckit-constitution` and answer the interview |
| Skills feel out of date | `npm install -g apac-sdlc@latest`, then `apac-sdlc add sdd --force` |
| Converge keeps re-adding a task you rejected | It compares code against `spec.md`/`plan.md`. If you don't intend to build it, change the spec — deleting the task only postpones the finding |
| Converge appended nothing, but you expected gaps | Read its summary: it reports what it checked. Zero findings means the code satisfies the *specified* scope — widen the spec, don't argue with converge |
| `tasks.md` is all ticked, so you skip converge | Don't. Ticked tasks say work was attempted, not that it satisfies the spec — converge is what checks the code |
