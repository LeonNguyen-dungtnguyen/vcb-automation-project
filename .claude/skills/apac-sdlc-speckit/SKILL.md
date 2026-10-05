---
name: "apac-sdlc-speckit"
description: "Spec-Driven Development (SDD) workflow skills for Claude Code. Provides the full Constitution → Specify → Clarify → Plan → Tasks → Analyze → Implement → Converge cycle."
compatibility: "Requires spec-kit project structure with .specify/ directory"
metadata:
  author: "github-spec-kit"
  version: "1.1.0"
---

# Speckit SDD Skills

Available slash commands:

| Command | Description | When to use |
|---|---|---|
| `/apac-sdlc-speckit-constitution` | Initialize or update the project constitution | Once per project, or when principles need updating |
| `/apac-sdlc-speckit-specify` | Write a feature specification | Start of every feature |
| `/apac-sdlc-speckit-clarify` | Resolve ambiguities in a spec | On-demand, between specify and plan |
| `/apac-sdlc-speckit-plan` | Create a technical architecture plan | After spec is approved |
| `/apac-sdlc-speckit-tasks` | Break plan into atomic, actionable tasks | After plan is approved |
| `/apac-sdlc-speckit-analyze` | Cross-artifact consistency analysis (read-only) | After tasks, before implement |
| `/apac-sdlc-speckit-implement` | Execute implementation of tasks | After analysis passes |
| `/apac-sdlc-speckit-converge` | Assess the codebase against spec/plan/tasks and append the remaining work to `tasks.md` | After implement, to close the gap between intent and code |

## Workflow

Full automated cycle: `/apac-sdlc-speckit-specify` → review → `/apac-sdlc-speckit-plan` → review → `/apac-sdlc-speckit-tasks` → `/apac-sdlc-speckit-analyze` → review → `/apac-sdlc-speckit-implement` → `/apac-sdlc-speckit-converge`

`/apac-sdlc-speckit-converge` is append-only: it never edits `spec.md`, `plan.md`, or existing tasks, and never touches code. It reports what is still missing and adds it to `tasks.md` as a new `## Phase N: Convergence` block. Re-run `/apac-sdlc-speckit-implement` on those tasks, then converge again — the loop ends when converge reports **✅ Converged**.

On-demand: `/apac-sdlc-speckit-clarify` (anytime), `/apac-sdlc-speckit-constitution` (project setup)

## Constitution

The project constitution at `.specify/memory/constitution.md` is authoritative. All skills respect it. Section IX (Behavioral Principles) is non-negotiable and pre-filled on bootstrap.
