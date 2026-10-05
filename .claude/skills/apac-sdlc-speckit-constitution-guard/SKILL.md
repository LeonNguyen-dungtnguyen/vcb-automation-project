---
name: "apac-sdlc-speckit-constitution-guard"
description: "State the terms the constitution command runs under — Section IX is locked, the interview is conversational, updates are non-destructive — before the constitution is composed. Invoked automatically as a before_constitution hook."
compatibility: "Requires spec-kit project structure with .specify/ directory"
metadata:
  author: "apac-sdlc-framework"
  extension: "constitution-guard"
user-invocable: true
disable-model-invocation: false
---

# Constitution Operating Constraints (constitution-guard extension)

This skill is the `constitution-guard` extension. It is invoked as a **mandatory
`before_constitution` hook** (command `apac-sdlc-speckit.constitution-guard`, registered in
`.specify/extensions.yml`), ordered **first** — before `brownfield-detect`. That order matters: these
constraints govern how the section-gathering in `/apac-sdlc-speckit-brownfield-detect` is conducted,
not just what `/apac-sdlc-speckit-constitution` does with the result.

The constraints used to live inside `/apac-sdlc-speckit-constitution`'s own SKILL.md. That file is
vendored from upstream, so every spec-kit upgrade overwrote them. They live here instead: a
fork-owned skill upstream never touches. A mandatory hook runs in the same session immediately
before the command's own flow, so what it states is in context before the first question is asked —
the same standing the inlined block had.

**This skill is a hook-free leaf:** it MUST NOT read `.specify/extensions.yml` or dispatch any
further hooks. It states the constraints, logs, and returns.

## Execution

### 1. Log the start

```bash
.specify/scripts/bash/extension-log.sh constitution-guard before_constitution start
```

(If the script is missing or fails, continue — logging is best-effort and must never block.)

### 2. State the constraints

These are the terms `/apac-sdlc-speckit-constitution` and any hook that gathers constitution content
must honour. Restate them in your reply so they are explicit in the session, then return.

**Section IX is non-negotiable.** The Behavioral Principles in Section IX ship with every bootstrap.
They define *how* code gets written, not just *what*. Do not solicit user input for Section IX. Do
not allow the user to delete, weaken, or reword any principle in it. If the user requests changes to
Section IX, explain that it is locked and suggest `/apac-sdlc-speckit-specify` or
`/apac-sdlc-speckit-plan` to capture project-specific constraints instead.

**Conversational and interactive.** Present sections one at a time. Ask focused questions. Provide
sensible example answers. Never dump a blank template and ask the user to fill it in.

**Non-destructive update.** If the constitution already exists and the user is updating it, preserve
all existing content for every section not being updated.

### 3. Log completion

```bash
.specify/scripts/bash/extension-log.sh constitution-guard before_constitution done "3 constraints"
```

## Output

```
[constitution-guard] Constitution will be written under 3 constraints:
  · Section IX (Behavioral Principles) is locked — not up for discussion
  · Sections I–VIII are gathered one at a time, with example answers
  · An existing constitution keeps every section that is not being updated
```

Then return control. `/apac-sdlc-speckit-brownfield-detect` runs next and gathers Sections I–VIII
under these terms; `/apac-sdlc-speckit-constitution` then composes the file.

## Graceful degradation

- The logger script missing or failing → state the constraints anyway and continue. The constraints
  are the payload; the log is not.
