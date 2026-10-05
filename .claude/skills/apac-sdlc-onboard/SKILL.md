---
name: "apac-sdlc-onboard"
description: "Drive apac-sdlc onboarding end to end. Reads `apac-sdlc status --json`, shows what is done and what is left, offers the next step as a choice, runs it, verifies it, and repeats until every step passes. Once setup is complete, hands off to a new or in-progress spec."
argument-hint: "Optional: a step id (init | knowledge-base | sdd | kb-populate | integrate-kb | conventions) to jump straight to it, or `status` to print the trail and stop"
compatibility: "Requires the apac-sdlc CLI on PATH or at $APAC_SDLC_BIN. Works on an empty project and on a fully onboarded one."
metadata:
  author: "apac-sdlc-framework"
user-invocable: true
disable-model-invocation: true
---

## User Input

```text
$ARGUMENTS
```

If the user passed a step id, skip the greeting and go straight to Step 4 with that step
preselected. If they passed `status`, print the trail from Step 3 and stop.

---

## Operating rules

These outrank everything below. They matter most late in a long session, when the earlier
turns have scrolled out of view.

1. `apac-sdlc status --json` is the only source of truth about progress. Never infer that a
   step is finished from what you did earlier in this conversation, from a file you read, or
   from memory.
2. Never run a step the user did not choose in the turn immediately before this one. Chaining
   ahead because it seems helpful is the single easiest way to lose their trust.
3. Never do by hand what a command does. If the JSON gives you a `command`, run that.
4. Never declare a step done. Only `apac-sdlc status` decides that.
5. Never spawn `claude`. You are already inside it. Every CLI step gets `--no-claude`.
6. Never paraphrase an error. Quote it in a fenced block.
7. If two consecutive status calls return the same `next` and the same `doneCount`, stop and
   ask the user. Do not try a third time.
8. Every decision goes through AskUserQuestion. Do not write "shall I proceed?" in prose.
9. Costs, durations and consequences come from the JSON. Never estimate your own.
10. A step is not finished until you have re-run `status --json` and said what changed. Handing
    control back to the user without that is a bug, not a pause. This matters most after a
    `claude` step, where another skill has taken over the conversation and its closing output
    looks like a natural place to stop. It is not. Come back and re-check.

---

## Step 0 - Resolve the CLI, once

In order: `apac-sdlc` if `command -v apac-sdlc` succeeds, then `"$APAC_SDLC_BIN"` executed
directly if that variable is set, then `npx -y apac-sdlc`. Remember what you resolved and reuse
it for every later call. If none work, tell the user to run `npm install -g apac-sdlc` and stop.

The project root is the current working directory. Do not ask for it and do not go looking.

## Step 1 - Read the state

Run `<cli> status --json` and parse it. Do not open any project file yet.

If the output does not parse, show it raw, say you cannot proceed safely, and stop. Never
guess a state.

Hold on to: `phase`, `next`, `doneCount`, `totalCount`, `steps[]`, `warnings[]`, `specs[]`.

## Step 2 - Greet, once per session

Branch on `phase`. Four sentences maximum in every case.

- `fresh`: welcome them, say what apac-sdlc sets up (Claude Code skills, a project knowledge
  base, and the spec-kit SDD workflow), say it is `totalCount` steps, and say each one is
  checked afterwards rather than assumed.
- `partial`: one line. "Welcome back. `doneCount` of `totalCount` done, picking up at step N."
  If any step has a `lastAttempt`, add one line quoting its `note`, and offer to resume from
  where it says rather than from the beginning of that step.
- `complete`: one line, naming the active spec if `specs[]` has one. Go to Step 8.

## Step 3 - Show the trail

Print `render.trail` in your own message, exactly as given, and **not** inside a code fence. It is
already markdown: the emoji, bold and backticks are what give it weight, and fencing renders them
as literal characters.

Print it. Do not rely on the output of a command to display it. `apac-sdlc status --color` produces
a nicer coloured version, but the host often collapses command output to a single "ran a command"
line, and a trail the user cannot see is worse than a duller one they can. That flag is for a
person running the CLI in their own terminal, not for you.

Do not reformat it, re-sort it, add lines or drop lines. The CLI generates it, so what you show
and what you act on cannot disagree.

One glyph per state, and no legend:

| Glyph | State | Means |
|---|---|---|
| ✅ | `done` | finished and verified |
| 🔄 | `running` | in flight right now, or a session died while it was |
| ❌ | `failed` | it was run and did not land; the reason leads with what was recorded |
| ⚠️ | `broken` / `unknown` | artifacts exist but are wrong, or cannot be checked from here |
| ⬜ | `pending` | not started, or waiting on an earlier step |
| ⏭️ | `skipped` / `not-applicable` | deliberately stepped over, or does not apply to this project |

Checked and unchecked carry the list, because it is a checklist. They are emoji, which is the one
way a glyph in a chat message has colour of its own. Every one of them is two cells wide, and they
are used on every row for that reason: a single-cell glyph on one row throws that row out of line
with the rest. Use these six and no others.

A step that cannot be skipped is tagged `` `[REQUIRED]` `` after its title. Everything else is
optional, which the skip option on the question already makes plain, so do not tag those.

Each row reads a two-cell gutter, glyph, then "N.", then title, tag and reason. There is no
further indent: the gutter exists only to hold the pointer, so rows without one still line up. The step you are
about to do carries a ❯ in the gutter, and its number, dot and title are bolded as one unit.
Every other row stays plain so that one is what the eye lands on. The indent and gutter are non-breaking spaces on purpose:
markdown collapses ordinary leading whitespace, and four real spaces would turn the row into a
code block and strip its bold and backticks. The heading has no blank line after it for the same
reason: that makes every row a continuation line, and only continuations keep their indent. Rows carry no list marker and end in
two spaces, which is a markdown hard break: that keeps one step per line without the renderer
drawing its own bullet beside the glyph, and the number carries the ordering instead. The number
matches the `Step N of M` in your question header, so the two can be read together. Print the
trail exactly as given and the spacing takes care of itself.

In a message the only thing that renders in colour is inline code and the emoji glyphs. ANSI
shows as literal escape codes, so never pass `--color` and never paste escape codes. Backticks are already used where they earn it — the step you are about
to do, blocking step names, the `required` tag — so do not spread them further: if everything is
backticked, nothing stands out. Do not strike through
completed titles, and do not add any other decoration: the checkbox already says what is
finished. There is no `$` / `>` / `.` column either: inside a guided session you run every step,
so where a command would have been typed is not a distinction worth showing.

## Step 4 - Offer the next step

Build the candidate list in this order:

1. any step with `status: "broken"` and an empty `blockedBy` (these look finished and are not,
   so they always come first)
2. the step named by `next`
3. one or two more steps with an empty `blockedBy`, as alternatives

Never offer a step whose `blockedBy` is non-empty. That is the whole of dependency enforcement
on your side.

Then ask exactly one AskUserQuestion, header `Next step`. Use these four slots, with these
exact labels. Do not invent, reword, reorder or merge them: the user walks this loop several
times, and a slot that changes meaning between steps is worse than a slot that is dull.

| Slot | Label | Description |
|---|---|---|
| 1 | the step's `action.label`, verbatim (a short name like `Init`) | the verbatim `action.commands`, then `detail`, then `cost` |
| 2 | `Explain this step` | what the command writes and why it matters. Runs nothing. |
| 3 | `Skip this step` | the step's `skipConsequence`, verbatim. **Omit this slot entirely when `skippable` is false.** |
| 4 | `Stop onboarding` | leave it at N of M; you print the trail and how to resume. The session stays open. |

**When the step carries exactly two `choices`, they replace slot 1 and slot 2.** The step is a
decision, not a command, so putting the decision one question later hides it behind an option
that reads as "just install it". One slot per entry: label is `choices[].label` verbatim,
description is `choices[].description` verbatim, and picking it runs that entry's `command`.
`Explain this step` goes, because the two descriptions are the explanation. Keep `Skip this step`
and `Stop onboarding`, which fills the four slots exactly.

With three or more `choices` the slots will not fit, so slot 1 stands as written and you ask the
choice as a second question in Step 5.

Slot 1's label is always `action.label` and never anything else. It is deliberately a short
name, not a command: labels are read at a glance, and the command goes in the description where
it can be read carefully. Do not lengthen it with the command, with `fix`, or with the slash
commands a step runs internally. A step keeps one label in every state, pending or broken.
`fix` is prose explaining what is wrong, never a command to promote into the option.

`skippable` is data on the step, not a judgement. Step 1 (`init`) is the only one with
`skippable: false`, because all seven others require it: offering to skip it offers a dead end.
When a step also carries `dontSkip`, keep slot 3 but lead its description with the consequence.

One exception, because that command has a dry run: when a step's `action.commands` is
`apac-sdlc status --fix`, slot 2 is `Show the diff first` and runs `<cli> status --fix --dry-run`.

Do not spend a slot on "something else". Free text is always available.

If the project already has files the step will touch and the step carries no `choices`, say so in
slot 1's description rather than adding a slot for it. When it does carry `choices`, the CLI has
already turned that into the decision above: ask it, and never pick for them.

## Step 5 - Run the chosen step

**Slots 2, 3 and 4 are not step runs.** Handle them first:

- Slot 2 (`Explain this step`, or `Show the diff first` when the command has a dry run): explain, or run the
  dry run. Then ask the **identical** question again, slot for slot and word for word. Do not
  re-run `status` first: nothing changed, and re-deriving the options is exactly how slot 1
  drifts. An explanation is not a choice.
- Slot 3 (`Skip this step`): see "When the user skips". This slot exists only when `skippable`
  is true, which is what makes a step optional; the one step without it is tagged `required` in
  the trail.
- Slot 4 (`Stop onboarding`): see "When the user stops".

Otherwise they chose slot 1.

**If the step has a non-empty `choices`, there is a decision to make first.** Do not run
anything and do not pick for them. Ask a second AskUserQuestion, header `Knowledge base`, with
one slot per entry in `choices`: the label is `choices[].label`, the description is
`choices[].description`, both verbatim. Then run that entry's `command`. Skip this question when
the step had exactly two choices, because Step 4 already asked it. `choices` is absent once the
filesystem shows what they picked, so this is asked once per project.

Before running anything, record the attempt: `<cli> status --attempt <id>`. That marks the step
in flight, and tells the next session which step was running if this one dies. It is not a failure: do not report it as one.

Otherwise run `action.commands` in order, dispatching on `action.kind`:

- `cli`: run each command through Bash with `--no-claude` appended, streaming the output.
- `claude`: say in one line what you are about to run and that you will re-check status when it
  returns, then invoke each slash command in this session, in the order given. If the step's
  `cost` mentions money, confirm once before starting. When the slash command finishes, your
  very next action is Step 6. Do not stop, do not summarise and wait: these commands often end
  with output that reads like a conclusion, and the step still has to be verified.
- `manual`: the work is yours. When `action.commands` is non-empty, run it and show the result.
  If that command is `apac-sdlc status --fix` you must never hand-edit `.gitignore` instead: the
  correct form is `graphify-out/*` and tidying it to `graphify-out/` silently breaks the three
  negations. When `action.commands` is empty the work
  has no command: read `detail`, do what it describes, then let `status` judge it. For
  `conventions`, run the interview in the reference section below.

**`sdd` installs a workflow and answers its constitution, so it has several gates behind one
step.** Which one you are on is in `action.commands` and `action.label`, never in your own
judgement. Re-read `status` after each and keep going until the step is `done`:

- `apac-sdlc add sdd --framework <name>` means nothing is installed. Run it. When the step offers
  `choices`, the project already has that framework and this CLI did not install it: ask the
  two-slot question verbatim from `choices` and never pick for them. Replacing a team's own
  workflow overwrites files they wrote, and keeping it ends the step there, constitution included.
- The framework's constitution command means the sections are not written yet. Run the interview.
  On a brownfield project a `before_constitution` hook drafts Sections I-VIII from the code first
  and reports what it inferred; it does not ask for approval, because the review happens once
  against the written file. If anything in this flow does ask you to approve a draft, that is not
  the step finishing.
- `apac-sdlc status --approve sdd` means the sections are written and unread. Run the section
  review in the reference section below, then that command. Never approve on their behalf, never
  approve because the interview just produced the text, and never claim they approved something
  you summarised rather than showed them.

After any `cli` step, scan stdout for lines beginning `APAC_SDLC_FOLLOWUP:`. Each names a slash
command the CLI wanted to run but did not, because you are already in a session. Run each one,
in order, in this session, before you re-check status.

## Step 6 - Verify

Re-run `<cli> status --json`. Compare that step's status before and after.

- Now `done`: say so in one line, using a number from `facts` where there is one, then go to
  Step 7. Never end your turn here.
- Unchanged: record it as a real failure first, `<cli> status --attempt <id> --outcome failed
  --note "<what stopped>"`, so the trail stops showing the step as in flight. Then say so plainly
  in the first sentence, quote the step's `reason` from the fresh JSON, and go to the failure
  procedure. A slash command that produced a lot of pleasant output and
  changed nothing is the single most likely thing to happen in this loop, usually because an
  interview was never finished. Do not describe it as done, do not move on to the next step, and
  do not go quiet.

## Step 7 - Loop

Reprint the trail, return to Step 4. Continue until `phase` is `complete` or the user stops.

## Step 8 - When setup is complete

**Do not ask a question here.** Setup is a sequence with a next step; what comes after it is not.
A modal choice at this point forces a decision the user may not have come to make, and it hides
everything not in the four slots. Print suggestions and stop, so they can pick one, type
something else, or leave.

Print `render.suggestions` in your own message, exactly as given and not fenced, the same way you
print `render.trail`.
The CLI builds it from `specs[]` and `warnings[]`, so it cannot disagree with what
`apac-sdlc status` shows in a terminal. Do not reformat it, add lines, or drop lines. It looks
like this:

**What usually comes next**

- `/apac-sdlc-speckit-implement` — continue rate-limiting, 14 of 22 tasks done
- `/apac-sdlc-speckit-specify` — start a new spec
- `/graphify ./ --update` — refresh the graph, last built 41 days ago
- `apac-sdlc status` — this summary again, any time

Print any `warnings[]` not already covered by a suggestion line above the block. Then stop. One closing sentence at most. Do not re-render the trail, do not ask what they want,
and do not start anything on your own.

## When a step fails

In this order, without improvising:

1. Do not retry. Do not hand-edit what the command was supposed to write.
2. Re-run `<cli> status --json` immediately. Failures are usually partial, and status is the
   only honest account of what actually landed. The step will now read `failed` with a red circle,
   because the attempt you recorded before running it is still outstanding; it clears itself when
   the step reaches `done`.
3. Quote the last 20 lines of output in a fenced block. No paraphrase.
4. Print the step's `reason` and `fix` from the JSON verbatim. `fix` is prose for the user;
   what you actually run is always `action.commands`.
5. Offer exactly four options: Try again / Look at it with me / Skip this step / Stop here.

Steps of kind `claude` produce no exit code, so pleasant-looking output proves nothing. The
only test is what `status` says afterwards.

## When the user skips

Record it: `<cli> status --skip <id>`. An unrecorded skip is indistinguishable from a step
nobody reached, which is exactly how step 7 disappears today. Say the step's `skipConsequence`
once, verbatim, then re-run status so they can watch the steps in its `blocks` list go grey.

If the user asks to skip a step whose `skippable` is false, say plainly what its `blocks` list
costs and that there is nothing to onboard without it. Do not record the skip.

## When the user types free text

Sort it into one of five buckets:

1. A question about the step: answer it, then ask the identical question again, slot for slot
   and word for word. An answer is
   not a choice.
2. A request for a different step: look up its status. Blocked means naming the dependency and
   offering to run that instead. Unblocked means honouring the request. The order is a default;
   only the `requires` links are hard.
3. A skip with a reason: treat it as a skip, echo the consequence, confirm once, and record
   their words.
4. Something unrelated: do it, then reprint the trail and return to the loop. Do not drop the
   onboarding thread silently.
5. Ambiguous: ask again. Never infer consent from ambiguity.

## When the user stops

Run status once more, print the trail a final time, and give two ways back: `apac-sdlc` to
resume here, and the step's own `action.commands` to do it by hand. Write nothing else. Do not
ask whether they are sure.

You cannot close this session and must not try. There is no tool for it, and killing a parent
process would take down the terminal or the editor hosting you. Say plainly that onboarding has
stopped and the session is still open, so they can keep working here or leave it themselves
(ctrl+D, or `/exit`). Never claim to have exited.

---

## Reference - the constitution review

This runs for the review gate of the `sdd` step, when `action.commands` is
`apac-sdlc status --approve sdd`. Exactly one AskUserQuestion per section, eight in
total, in order I to VIII. Never two sections in one question, never all eight at once, never a
batch of unrelated questions in one call. The shape is identical for all eight so the user learns
it once.

For each section:

- header: `Section <roman>`
- question: quote that section's text in full, then ask whether it is right
- slots, with these exact labels every time:

| Slot | Label | Description |
|---|---|---|
| 1 | `Approve` | this section is correct as written |
| 2 | `Change it` | tell me what is wrong and I rewrite it |
| 3 | `Stop reviewing` | leave the rest for later; the step stays unapproved |

On `Change it`: ask in plain text what to change, edit that section in
`.specify/memory/constitution.md`, show the new text, and ask the same three-slot question again
for that same section. Do not move to the next section until this one is approved.

On `Stop reviewing`: record where they got to with
`<cli> status --attempt sdd --outcome failed --note "reviewed I-V, stopped at VI"`, naming the
real sections. Approval is recorded for the constitution as a whole, so nothing is half-approved,
but that note is what lets the next session offer to resume at the right section instead of
starting over. Then go to "When the user stops".

Only after all eight sections are approved, run the step's `action.commands`.

## Reference - the conventions interview

The `conventions` step fills the `Team conventions` section of `APAC-SDLC-GUIDE.md` (find it by
heading text, not by number). Ask four questions,
each with a "keep the default" option so the fast path stays fast:

1. Branch naming for work outside the SDD cycle. Default: `<type>/<short-description>`.
2. Commit message convention. Default: Conventional Commits.
3. What has to happen before a PR gets a human reviewer. Offer `/apac-sdlc-code-review`,
   `/apac-sdlc-security-review` on auth and data changes, CI green, two approvals.
4. Anything else the team standardises on: environments, secrets, release cadence, approvals.

Then edit that section with the Edit tool, replacing the
`<!-- EDIT THIS SECTION. ... -->` marker with their answers. Change nothing outside the
section. Definition of done stays in constitution section VIII, not here, so do not write one
into the guide even if asked about it.

If "keep the defaults" is chosen for everything, still remove the marker and say the team read
the defaults and accepted them. That turns a silent non-decision into a recorded one.

## Reference - what each step is really for

Take these from the JSON's `detail` field rather than from memory. They exist because each one
names a way onboarding has actually gone wrong:

- `init` writes the `CLAUDE.md` that every future session in this repo loads first.
- `knowledge-base` writes `.graphifyignore`. Review it here, as part of this step, and offer to
  add anything obviously missing: this is the last point before it costs money to be wrong. Do
  not carry that review forward to `kb-populate` — by then the file has already decided what gets
  indexed, and asking there just delays the build.
- `sdd` is the step most likely to look finished and not be. Its constitution interview is long;
  if the user stops answering partway, the file is never written and status still reads "still
  entirely the shipped template". A written constitution is also not a read one, which is why the
  step has a review gate after it. It is checked by every spec, plan, task and
  implementation. Only the brownfield path asks for the word `approve`, and even there it approves
  a draft rather than the file; on a greenfield project nothing gates it at all.
- `kb-populate` differs by pattern, and it is the step people mistake for already done.
  A scaffolded knowledge base is not a filled one, and an empty one fails silently.
  - graphify: run `/graphify ./` immediately, with no further questions. Anything about
    `.graphifyignore` was settled at `knowledge-base`. Detection is `graphify-out/graph.json`.
  - llm-wiki: no command. Read the project and write the first entity and concept pages, then
    update `llm-wiki/index.md`. Detection notices real pages appearing, so do the work and let
    status judge it.
  - rag: the index lives on the server, so the repo cannot show it. Walk the user through
    starting the server and checking `rag_query` returns results for a term they know is in the
    codebase, then run the recorded confirmation in `action.commands`. Never confirm it yourself.
- `knowledge-base` also owns the graphify `.gitignore` block, because it has one correct answer.
  If it reports broken with a `.gitignore` reason, `apac-sdlc status --fix` repairs it.
- A step reporting `unknown` cannot be checked from the repo (the rag index lives on a server).
  Say so, tell them what to verify, and offer `<cli> status --mark-done <id>` once they have.
- `integrate-kb` is the step that gets skipped silently, leaving specs with no project context
  and no warning that anything is missing.
