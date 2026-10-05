# Knowledge Graph (graphify)

Knowledge graph powered by [graphify](https://github.com/Graphify-Labs/graphify). Maps source documents into an interactive, queryable graph — nodes are concepts and entities, edges are relationships.

Source documents live at the project root. Drop files here and run `/graphify ./`.

## Structure

```
<project>/
├── .graphifyignore           ← ignore rules
├── graphify-out/             ← graphify writes here
│   ├── graph.html            ← open in browser — click, filter, search
│   ├── GRAPH_REPORT.md       ← key insights and suggested questions
│   └── graph.json            ← full graph for querying
└── GRAPHIFY.md               ← this file
```

## Prerequisites

- Python 3.10+
- graphify installed: `pip install graphifyy && graphify install` — note the double `y` in the
  package name; the command, the skill and the tool are all `graphify`

## Quickstart

```bash
# 1. drop a source document at project root
cp ~/Downloads/my-article.md .

# 2. build the graph
/graphify ./

# 3. open the visualization
open graphify-out/graph.html

# 4. read the highlights
cat graphify-out/GRAPH_REPORT.md
```

## Core Operations

### Build graph
```
/graphify ./
```

### Incremental update (changed files only)
```
/graphify ./ --update
```

### Query
```
/graphify query "what connects authentication to the database?"
/graphify path "ConceptA" "ConceptB"
/graphify explain "EntityName"
```

### Export architecture diagram
```bash
graphify export callflow-html
```

## Ignoring files

Edit `.graphifyignore` at project root to exclude files from the graph. Same syntax as `.gitignore`.

## Git setup

Commit the three shareable outputs so teammates start with the graph, and ignore the working
files (`cache/` alone runs to several megabytes). Add to `.gitignore`:
```
# graphify: ignore working files, keep the three shareable outputs
graphify-out/*
!graphify-out/GRAPH_REPORT.md
!graphify-out/graph.html
!graphify-out/graph.json
```

Order matters, and so does the `*`. The bare `graphify-out/` form excludes the directory
itself, and git will not re-include a file inside an excluded directory, so the three `!`
lines below it would silently do nothing.

`apac-sdlc status --fix` writes this block for you and then checks the result with
`git check-ignore`.

## Supported file types

Code (29 languages), Markdown, PDFs, images, DOCX, XLSX, video/audio (with extras).
See [graphify docs](https://github.com/Graphify-Labs/graphify) for full list.
