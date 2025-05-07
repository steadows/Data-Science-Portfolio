# 🎓 Havel-Hakimi Algorithm in Python

[![Python](https://img.shields.io/badge/Built%20With-Python-3776AB?logo=python&logoColor=white)](https://www.python.org/)
[![Status](https://img.shields.io/badge/status-Completed-brightgreen)]()
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

---

## 🧠 Overview

This project implements the **Havel-Hakimi algorithm** to determine whether a given degree sequence can represent a **simple undirected graph**.

The Havel-Hakimi theorem provides a recursive method for verifying whether a degree sequence is graphical — meaning it corresponds to some graph.

---

## 🔍 How It Works

The algorithm follows these steps:

1. **Sort** the degree sequence in non-increasing order.
2. **Check for negative degrees** – if any are found, return `False`.
3. If all degrees are **zero**, return `True` (this is a valid empty graph).
4. If all degrees are `1` and the number of vertices is **odd**, return `False`.
5. Otherwise, remove the first element (call it `count`) and subtract 1 from the next `count` elements.
6. **Recurse** with the new sequence.

---

## 📜 Example

```python
Havel_Hakimi([1, 1, 1, 1])  # Output: True
Havel_Hakimi([4, 2, 1, 1, 1])  # Output: False
