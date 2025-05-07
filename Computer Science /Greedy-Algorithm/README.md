# 🎨 Greedy Graph Coloring Algorithm

[![Python](https://img.shields.io/badge/Built%20With-Python-3776AB?logo=python&logoColor=white)](https://www.python.org/)
[![Status](https://img.shields.io/badge/status-Completed-brightgreen)]()
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

---

## 🧠 Overview

This project implements a **greedy coloring algorithm** for graphs. The goal is to assign the minimum number of colors to graph vertices such that no two adjacent vertices share the same color.

---

## 📚 Features

- Assigns the smallest valid color to each vertex using a greedy strategy
- Supports arbitrary graph structures represented as Python dictionaries
- Clean and modular implementation with helper functions:
  - `get_neighbors`
  - `get_colors`
  - `check_color`

---

## 🧪 Example

```python
greedy({
  'A': ['B','C','D','E'],
  'B': ['A','C','E'],
  'C': ['A','B','D'],
  'D': ['A','C'],
  'E': ['A','B']
}, ['E', 'D', 'B', 'C', 'A'])
