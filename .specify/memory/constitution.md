# Project Constitution

<!-- This file governs all AI-assisted development on this project.
     Sections I–VIII are project-specific — fill them in before running /apac-sdlc-speckit-specify.
     Section IX is pre-filled and applies without modification to every project. -->

---

## I. Project Overview

<!-- Fill in: what this project is, who it's for, and what problem it solves.

     Prompts:
     - What is the one-sentence description of this project?
     - Who are the primary users or consumers?
     - What pain point or need does it address?
     - What does success look like in six months?

     Example:
     > This is a B2B invoice management API serving finance teams at mid-market companies.
     > It replaces manual spreadsheet workflows with automated reconciliation and PDF export.
-->

---

## II. Technology Stack

<!-- Fill in: languages, frameworks, databases, infrastructure, and key libraries.

     Prompts:
     - Primary language and version (e.g. TypeScript 5.x, Python 3.12)
     - Web framework (e.g. Express, FastAPI, Rails)
     - Database(s) and ORM (e.g. PostgreSQL + Prisma)
     - Infrastructure and deployment target (e.g. AWS Lambda, Docker + Kubernetes)
     - Key third-party services (e.g. Stripe, SendGrid, Auth0)
     - Package manager and build toolchain

     Example:
     > Language: TypeScript 5.x (Node 20 LTS)
     > Framework: Express 4.x
     > Database: PostgreSQL 15 via Prisma
     > Infrastructure: AWS ECS (Fargate), deployed via GitHub Actions
     > Auth: JWT (RS256) issued by Auth0
-->

---

## III. Architecture Principles

<!-- Fill in: key architectural decisions and hard constraints that all code must respect.

     Prompts:
     - Monolith, modular monolith, microservices, or serverless?
     - Sync vs async: where do you prefer each?
     - How is the codebase layered (e.g. controllers → services → repositories)?
     - What patterns are mandated (e.g. repository pattern, CQRS, event sourcing)?
     - What is explicitly forbidden (e.g. no ORM in hot paths, no direct DB access outside repo layer)?

     Example:
     > Layered architecture: routes → controllers → services → repositories.
     > Services must not import from other services directly — communicate via shared interfaces.
     > No business logic in route handlers.
     > Background jobs use BullMQ; never block the request thread for async work.
-->

---

## IV. Code Style & Conventions

<!-- Fill in: naming, formatting, linting, and structural conventions.

     Prompts:
     - Naming: camelCase, PascalCase, snake_case — where does each apply?
     - File naming convention (e.g. kebab-case, one class per file)
     - Linter and formatter (e.g. ESLint + Prettier, Black + Ruff)
     - Import ordering rules
     - Comment policy: when are comments required vs. discouraged?
     - Any project-specific idioms to follow or avoid

     Example:
     > Files: kebab-case. Classes/types: PascalCase. Variables/functions: camelCase.
     > Linting: ESLint with project config; Prettier for formatting (no manual formatting).
     > No inline comments unless the logic is non-obvious. Prefer self-documenting names.
     > All exports from a module go through an index.ts barrel file.
-->

---

## V. Testing Standards

<!-- Fill in: coverage requirements, test types, frameworks, and what must be tested.

     Prompts:
     - Unit test framework (e.g. Jest, Pytest, RSpec)
     - Integration test approach (e.g. supertest, TestClient, Pact)
     - Minimum coverage threshold (e.g. 80% lines)
     - What must always have tests (e.g. all service methods, all API endpoints)
     - What is explicitly out of scope for tests (e.g. third-party SDK internals)
     - Test naming convention

     Example:
     > Framework: Jest + ts-jest. Coverage minimum: 80% for services.
     > All new service methods require unit tests. All API routes require integration tests.
     > Test files live alongside source files as *.test.ts.
     > Describe blocks use the function name; it blocks describe the scenario.
-->

---

## VI. Security & Compliance

<!-- Fill in: authentication model, authorization rules, data handling, and compliance requirements.

     Prompts:
     - Authentication mechanism (e.g. JWT, sessions, API keys)
     - Authorization model (e.g. RBAC, ABAC, ownership checks)
     - What data is sensitive and how must it be handled?
     - Input validation rules (where, how, with what library)
     - Secrets management (e.g. env vars via Vault, AWS Secrets Manager)
     - Compliance requirements (e.g. GDPR, SOC2, HIPAA)

     Example:
     > Auth: JWT (RS256). All routes except /health and /auth/* require a valid token.
     > Authorization: RBAC with roles: admin, member, viewer. Enforced at service layer.
     > PII (email, name) must never appear in logs. Mask before logging.
     > All inputs validated with Zod schemas at the controller layer.
     > Secrets via environment variables — never hardcoded, never committed.
-->

---

## VII. Performance Targets

<!-- Fill in: latency budgets, throughput requirements, and scalability constraints.

     Prompts:
     - P99 latency targets for API endpoints (e.g. < 200ms for reads)
     - Throughput targets (e.g. 500 req/s at peak)
     - Database query budgets (e.g. no query > 100ms, no N+1 queries)
     - Caching strategy (e.g. Redis for session data, CDN for static assets)
     - Known bottlenecks to avoid

     Example:
     > P99 API response time: < 300ms for read endpoints, < 500ms for writes.
     > No N+1 queries — use eager loading or dataloaders.
     > Redis caching for all list endpoints with > 1s DB query time.
     > Target: handle 1,000 concurrent users without horizontal scaling.
-->

---

## VIII. Definition of Done

<!-- Fill in: what "done" means for a feature — the checklist every task must pass before merging.

     Prompts:
     - Tests written and passing?
     - Code reviewed?
     - Documentation updated?
     - Migrations reviewed and reversible?
     - Feature flag or rollback plan in place?
     - Performance benchmarked?
     - Security reviewed?

     Example:
     > - All acceptance criteria from the spec met
     > - Unit and integration tests written and passing (CI green)
     > - Code reviewed by at least one other engineer
     > - API docs updated (if endpoints changed)
     > - DB migration tested with rollback
     > - No new CRITICAL/HIGH findings from /apac-sdlc-speckit-analyze
-->

---

## IX. Behavioral Principles

The preceding sections define **what** the codebase looks like. This section defines
**how** code gets written. These principles apply to every spec, plan, task, and
implementation — without exception.

### 1. Think Before Coding

**Don't assume. Don't hide confusion. Surface tradeoffs.**

Before implementing:
- State your assumptions explicitly. If uncertain, ask.
- If multiple interpretations exist, present them — don't pick silently.
- If a simpler approach exists, say so. Push back when warranted.
- If something is unclear, stop. Name what's confusing. Ask.

### 2. Simplicity First

**Minimum code that solves the problem. Nothing speculative.**

- No features beyond what was asked.
- No abstractions for single-use code.
- No "flexibility" or "configurability" that wasn't requested.
- No error handling for impossible scenarios.
- If you write 200 lines and it could be 50, rewrite it.

Ask yourself: "Would a senior engineer say this is overcomplicated?" If yes, simplify.

### 3. Surgical Changes

**Touch only what you must. Clean up only your own mess.**

When editing existing code:
- Don't "improve" adjacent code, comments, or formatting.
- Don't refactor things that aren't broken.
- Match existing style, even if you'd do it differently.
- If you notice unrelated dead code, mention it — don't delete it.

When your changes create orphans:
- Remove imports/variables/functions that YOUR changes made unused.
- Don't remove pre-existing dead code unless asked.

The test: Every changed line should trace directly to the user's request.

### 4. Goal-Driven Execution

**Define success criteria. Loop until verified.**

Transform tasks into verifiable goals:
- "Add validation" → "Write tests for invalid inputs, then make them pass"
- "Fix the bug" → "Write a test that reproduces it, then make it pass"
- "Refactor X" → "Ensure tests pass before and after"

For multi-step tasks, state a brief plan:
```
1. [Step] → verify: [check]
2. [Step] → verify: [check]
3. [Step] → verify: [check]
```

Strong success criteria let you loop independently. Weak criteria ("make it work")
require constant clarification.

---

**Version**: [CONSTITUTION_VERSION] | **Ratified**: [RATIFICATION_DATE] | **Last Amended**: [LAST_AMENDED_DATE]
