# 🏰 Dominating Set Finder

[![Java](https://img.shields.io/badge/Built%20With-Java-007396?logo=java&logoColor=white)](https://www.java.com/)
[![Status](https://img.shields.io/badge/status-Completed-brightgreen)]()
[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

---

## 📘 Overview

This project implements an algorithm to compute **minimum dominating sets** in labeled graphs, with support for multiple test files. A *dominating set* is a subset of nodes such that every node in the graph is either in the subset or adjacent to a node in it.

This program reads an adjacency matrix from an input file, uses label constraints, and identifies the smallest set of nodes that dominates the graph according to the rules defined in `NodeLabel` and `SetOfLabels`.

---

## 🧠 Key Concepts

- Graph theory: minimum dominating sets
- Labeled graph constraints
- Greedy approximation algorithm
- Java object-oriented design

---

## 📂 File Structure

| File | Description |
|------|-------------|
| `DominatingSet.java` | Main class that reads input, parses the graph, and finds dominating sets |
| `SetOfLabels.java` | Represents a set of labels with efficient lookup |
| `NodeLabel.java` | Stores label info for each graph node |
| `testDominatingSet*.txt` | Adjacency matrix test files |
| `*.class` | Compiled class files (not required if building from `.java`) |

---

## 🛠️ How to Compile and Run

### 🔧 Compile:
```bash
javac DominatingSet.java SetOfLabels.java NodeLabel.java
