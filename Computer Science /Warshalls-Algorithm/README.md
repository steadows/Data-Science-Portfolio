# 🔀 Floyd-Warshall Algorithm

[![Python](https://img.shields.io/badge/Built%20With-Python-3776AB?logo=python&logoColor=white)](https://www.python.org/)
[![Status](https://img.shields.io/badge/status-Completed-brightgreen)]()
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

---

## 🧠 Overview

This project implements the **Floyd-Warshall algorithm**, a classic dynamic programming solution for finding **all-pairs shortest paths** in a directed weighted graph.

It accepts an adjacency matrix as input and outputs a matrix containing the shortest distances between all pairs of vertices.

---

## ⚙️ How It Works

- Any `0` (except self-loops) in the adjacency matrix is treated as "no path" and is replaced with `infinity`.
- The algorithm performs **three nested loops** to update the shortest path between every pair `(i, j)` considering each node `k` as an intermediate step.
- At the end, the matrix contains the shortest path lengths between every pair of vertices.

---

## 🧪 Example

```python
Floyd_Warshall([
    [0, 3, 0, 0, 5, 0, 0, 0],
    [0, 0, 4, 4, 0, 0, 0, 0],
    [1, 0, 0, 0, 2, 5, 4, 0],
    [0, 2, 0, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 2, 8],
    [0, 0, 0, 0, 0, 0, 0, 0],
    [0, 0, 9, 0, 2, 0, 0, 6],
    [0, 0, 0, 0, 0, 9, 0, 0]
])
