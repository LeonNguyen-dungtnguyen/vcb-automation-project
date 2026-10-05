# Guide: Convert Excel to APAC-SDLC Knowledge Base

**Objective:** Transform your Excel file (containing testcases, flows, requirements) into APAC-SDLC-ready documentation and knowledge base.

**Status:** 🔄 Step-by-step setup guide

---

## 📋 Table of Contents
1. [Prerequisites](#prerequisites)
2. [Step 1: Prepare Your Excel File](#step-1-prepare-your-excel-file)
3. [Step 2: Setup APAC-SDLC](#step-2-setup-apac-sdlc)
4. [Step 3: Convert Excel to Requirements](#step-3-convert-excel-to-requirements)
5. [Step 4: Initialize Knowledge Base](#step-4-initialize-knowledge-base)
6. [Step 5: Verify Setup](#step-5-verify-setup)
7. [Troubleshooting](#troubleshooting)

---

## Prerequisites

### Installed Tools
- ✅ Node.js 18+
- ✅ Claude Code CLI (on PATH)
- ✅ Python 3.10+
- ✅ Git (for version control)

### Skills Already Loaded
- ✅ `anthropic-skills:xlsx` - Read/write Excel files
- ✅ `anthropic-skills:docx` - Create Word documents
- ✅ `claude-api` - Claude API reference

### Model
- **Default:** `claude-opus-5-5` (balanced capability & cost)
- **Cost-conscious:** `claude-sonnet-5-5`

---

## Step 1: Prepare Your Excel File

### 1.1 Upload Your Excel File

**Location:** Place your Excel file in the project root:
```
/Users/dung.nguyen/Documents/VCB/real/vcb-automation-project/
├── your-excel-file.xlsx          ← Place here
├── GUIDE_EXCEL_TO_APAC_SDLC.md
└── ...
```

**File Structure Expected:**
Your Excel should contain sheets like:
- `TestCases` - with columns: TC ID, Description, Steps, Expected Result, Status
- `Flows` - business flows or process flows
- `Requirements` - functional/non-functional requirements
- (Any other relevant sheets)

### 1.2 Example: Describe Your File Structure

Share with Claude:
```
My Excel file structure:
- Sheet 1 "TestCases": columns are [ID, TestCase Name, Steps, Expected, Actual, Status]
- Sheet 2 "BusinessFlows": [Flow ID, Flow Name, Description, Actors, Steps]
- Sheet 3 "Requirements": [Req ID, Requirement, Priority, Status]
```

---

## Step 2: Setup APAC-SDLC (One-Time Setup)

### 2.1 Initialize APAC-SDLC

Run this in your project directory:

```bash
apac-sdlc init
```

**What it does:**
- ✅ Installs SDLC skills and templates
- ✅ Creates `CLAUDE.md` configuration file
- ✅ Sets up `.claude/skills/` directory

**Review:** After running, read and correct `CLAUDE.md` (should be < 200 lines)

### 2.2 Add Knowledge Base

Choose one pattern (recommended: `graphify` for simplicity):

```bash
# Option 1: Graphify (Recommended - visualizes code structure)
apac-sdlc add knowledge-base --pattern graphify

# Option 2: LLM-Wiki (AI-maintained wiki)
apac-sdlc add knowledge-base --pattern llm-wiki

# Option 3: RAG (Advanced - requires server setup)
apac-sdlc add knowledge-base --pattern rag
```

### 2.3 Add SDD Framework

```bash
apac-sdlc add sdd --framework spec-kit
```

**This starts a Claude session to:**
- Answer architecture questions
- Build your project constitution
- Set up `.specify/` directory

**You'll need to:** Type `approve` after reviewing the proposed constitution.

---

## Step 3: Convert Excel to Requirements

### 3.1 Run Excel-to-Requirements Conversion

Once your Excel file is in place, ask Claude:

```
I have an Excel file at: [exact-path-to-file]

Please:
1. Read and analyze the Excel structure
2. Extract all testcases, flows, and requirements
3. Create requirement documents (DOCX format)
4. Generate specification files (Markdown format)
5. Create a summary of what was extracted

My Excel structure:
[Describe your sheets and columns]
```

### 3.2 What Gets Generated

Claude will create:

```
/requirements/
├── BRD_TestCases.docx          ← Requirement doc from testcases
├── BRD_Flows.docx              ← Business flows document
├── BRD_Requirements.docx       ← Functional requirements doc
└── ANALYSIS_SUMMARY.md         ← What was extracted

/specs/
├── specification.md            ← Master specification
├── test-cases.md              ← Extracted test cases
└── flows.md                   ← Business flows in spec format
```

---

## Step 4: Initialize Knowledge Base

### 4.1 Initialize Knowledge Base (Graphify Pattern)

```bash
/graphify ./
```

**What it does:**
- 📊 Creates graph visualization of your codebase
- 📄 Generates `graph.json`, `graph.html`, `GRAPH_REPORT.md`
- 🔍 Index for AI to understand project structure

### 4.2 Configure .gitignore

Update `.gitignore` to ignore build artifacts but track reports:

```bash
# Ignore graphify output files (except reports)
graphify-out/*
!graphify-out/graph.html
!graphify-out/graph.json
!graphify-out/GRAPH_REPORT.md
```

### 4.3 Update Knowledge Base Periodically

After major changes, refresh the graph:

```bash
# Re-extract only what changed (cheap)
/graphify ./ --update
```

---

## Step 5: Verify Setup

### 5.1 Checklist: Is Everything Ready?

Run through this checklist:

```
Setup Verification Checklist
============================

Core Files:
☐ CLAUDE.md exists and < 200 lines
☐ APAC-SDLC-GUIDE.md exists (created by apac-sdlc init)
☐ .claude/skills/ contains APAC-SDLC skills

Knowledge Base:
☐ graphify-out/graph.json exists
☐ graphify-out/GRAPH_REPORT.md exists
☐ .graphifyignore file exists
☐ .specify/memory/constitution.md exists (sections I-VIII filled)
☐ .specify/kb/graphify.md exists with instructions

Documentation:
☐ /requirements/ folder created with DOCX files
☐ /specs/ folder created with MD files
☐ ANALYSIS_SUMMARY.md created

Git:
☐ All above files staged and ready to commit
☐ .gitignore updated for graphify-out/
```

### 5.2 Verify Commands Work

Test the APAC-SDLC commands:

```bash
# Should show available commands
apac-sdlc --help

# Should show GUIDE.md
cat APAC-SDLC-GUIDE.md | head -50
```

---

## Step 6: Ready for Daily Workflow

Once setup is complete, you're ready for the APAC-SDLC per-ticket loop:

```
Daily Workflow (Per Ticket)
===========================

0. Jira Ticket Ready (problem statement + acceptance criteria)
   ↓
1. /apac-sdlc-speckit-specify [TICKET-ID]  → creates spec.md
   ↓
2. /apac-sdlc-speckit-clarify             → questions & answers
   ↓
3. /apac-sdlc-speckit-plan                → technical plan
   ↓
4. /apac-sdlc-speckit-tasks               → actionable tasks
   ↓
5. /apac-sdlc-speckit-analyze             → cross-check coverage
   ↓
6. /apac-sdlc-speckit-implement           → code (in slices)
   ↓
7. /apac-sdlc-speckit-converge            → verify completion

Each step produces reviewable artifacts (spec.md, plan.md, tasks.md)
with human approval gates before code.
```

---

## Troubleshooting

### Issue: `apac-sdlc` command not found

**Solution:**
```bash
npm install -g apac-sdlc
```

Then verify:
```bash
apac-sdlc --version
```

### Issue: Excel file is too large or has many sheets

**Solution:**
- Upload only the relevant sheets (TestCases, Flows, Requirements)
- Remove empty columns/rows before conversion
- Split into smaller files if needed

### Issue: Knowledge base initialization fails

**Solution for graphify:**
```bash
# Clear and rebuild
rm -rf graphify-out/
/graphify ./ --force
```

### Issue: Git conflicts on generated files

**Solution:**
```bash
# Stage all verification files
git add GUIDE_EXCEL_TO_APAC_SDLC.md APAC-SDLC-GUIDE.md CLAUDE.md .specify/ requirements/ specs/
git commit -m "setup: initialize APAC-SDLC with Excel-derived requirements"
```

---

## Quick Reference: Key Files & Their Purpose

| File | Purpose | Who Creates |
|------|---------|-------------|
| `CLAUDE.md` | Project configuration for Claude Code | `apac-sdlc init` |
| `APAC-SDLC-GUIDE.md` | Team runbook (fill in team conventions in section 6) | `apac-sdlc init` |
| `GRAPH_REPORT.md` | Knowledge base: code structure overview | `/graphify` |
| `graph.json` | Machine-readable code graph (for AI indexing) | `/graphify` |
| `.specify/memory/constitution.md` | Project architecture & standards | User (tech lead) |
| `.specify/kb/graphify.md` | Knowledge base instructions | `apac-sdlc add knowledge-base` |
| `requirements/*.docx` | Extracted requirement documents | Claude (from Excel) |
| `specs/*.md` | Specification files for SDD workflow | Claude (from Excel) |

---

## Next Steps

1. ✅ **Upload your Excel file** to the project root
2. ✅ **Run Step 1-2:** Setup APAC-SDLC
3. ✅ **Run Step 3:** Convert Excel → Requirements
4. ✅ **Run Step 4-5:** Initialize Knowledge Base & Verify
5. ✅ **Commit:** `git add . && git commit -m "setup: APAC-SDLC initialized with Excel-derived requirements"`
6. 🚀 **Start the workflow:** Use the daily per-ticket loop above

---

## Support & Questions

If you get stuck:
1. Check the **Troubleshooting** section above
2. Read `APAC-SDLC-GUIDE.md` for detailed workflow
3. Run `apac-sdlc --help` for all available commands
4. Read `shared/` files referenced in guides

---

**Last Updated:** 2026-10-05  
**Guide Version:** 1.0  
**Framework:** APAC-SDLC with Spec Kit  
**Knowledge Base Pattern:** Graphify (recommended)
