# 🖥️ Computer Science Portfolio

[![Java](https://img.shields.io/badge/Java-17+-orange)](https://www.oracle.com/java/)
[![Python](https://img.shields.io/badge/Python-3.8+-blue)](https://www.python.org/)
[![C](https://img.shields.io/badge/C-Standard-blue)](https://en.wikipedia.org/wiki/C_(programming_language))
[![Android](https://img.shields.io/badge/Android-Studio-3DDC84?logo=android)](https://developer.android.com/studio)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 📘 Overview

This folder showcases a collection of projects from my studies in **Computer Science**, highlighting my expertise in **data structures and algorithms**, **discrete mathematics**, **operating systems**, and **software development**. Each project demonstrates practical applications of core concepts, with a focus on clean code, modular design, and real-world problem-solving. These works reflect my ability to bridge theoretical foundations with functional implementations, culminating in tools like the **Baby Name Picker**, which I used to name my son, Miles Meadows.

## 🎯 Purpose

The projects in this portfolio were developed to:
- Apply fundamental computer science principles to solve diverse problems.
- Demonstrate proficiency in multiple programming languages (Java, Python, C).
- Showcase skills in algorithm design, system-level programming, and user-focused software development.
- Highlight my ability to create practical, reusable, and well-documented solutions.

## 📂 Projects

Below is a summary of the projects included in this folder, organized by the core computer science areas they address.

### 🧮 Data Structures and Algorithms

- **[Dominating Set Finder](./Dominating-Set-Finder)**  
  **Language**: Java  
  **Description**: Implements a greedy approximation algorithm to compute minimum dominating sets in labeled graphs. Uses adjacency matrices and label constraints to find the smallest set of nodes that dominates the graph.  
  **Key Concepts**: Graph theory, greedy algorithms, set operations, object-oriented design.

- **[Havel-Hakimi Algorithm](https://github.com/steadows/Data-Science-Portfolio/tree/main/Computer%20Science%20/Havel-Hakimi-Algorithm)**  
  **Language**: Python  
  **Description**: Verifies whether a degree sequence can represent a simple undirected graph using the Havel-Hakimi theorem. Implements a recursive approach to validate graphical sequences.  
  **Key Concepts**: Graph theory, recursion, sequence processing.

- **[Floyd-Warshall Algorithm](https://github.com/steadows/Data-Science-Portfolio/tree/main/Computer%20Science%20/Warshalls-Algorithm)**  
  **Language**: Python  
  **Description**: Computes all-pairs shortest paths in a directed weighted graph using dynamic programming. Processes adjacency matrices to output shortest path distances.  
  **Key Concepts**: Dynamic programming, graph algorithms, matrix operations.

- **[Greedy Graph Coloring Algorithm](https://github.com/steadows/Data-Science-Portfolio/tree/main/Computer%20Science%20/Greedy-Algorithm)**  
  **Language**: Python  
  **Description**: Assigns the minimum number of colors to graph vertices such that no adjacent vertices share the same color, using a greedy strategy.  
  **Key Concepts**: Graph coloring, greedy algorithms, dictionary-based data structures.

### ➗ Discrete Mathematics

- **[Havel-Hakimi Algorithm](https://github.com/steadows/Data-Science-Portfolio/tree/main/Computer%20Science%20/Havel-Hakimi-Algorithm)**  
  **Description**: Applies discrete mathematics to validate graph degree sequences, ensuring they adhere to the properties of simple graphs.  
  **Key Concepts**: Graph theory, degree sequences, combinatorial validation.

- **[Dominating Set Finder](./Dominating-Set-Finder)**  
  **Description**: Leverages set theory and graph properties to identify dominating sets, incorporating label constraints for complex graph structures.  
  **Key Concepts**: Set theory, graph domination, combinatorial optimization.

### 🖧 Operating Systems

- **[Bad Apple: Signal-Based Message Passing](https://github.com/steadows/Data-Science-Portfolio/tree/main/Computer%20Science%20/Interprocess%20Comms%20-%20Bad%20Apple)**  
  **Language**: C  
  **Description**: Simulates a network of processes passing a message through pipes, with a randomly selected "bad apple" node scrambling the message. Demonstrates inter-process communication and signal handling.  
  **Key Concepts**: IPC, pipes, signal handling (`SIGINT`), process forking, synchronization.

- **[Baking Project: Multithreading & Synchronization](https://github.com/steadows/Data-Science-Portfolio/tree/main/Computer%20Science%20/Multithreading%20-%20Baking%20Project)**  
  **Language**: C  
  **Description**: Simulates a multi-baker kitchen using POSIX threads and semaphores, with shared resources and a "Gordon Ramsay" thread that randomly sabotages bakers.  
  **Key Concepts**: Multithreading, semaphores, resource contention, signal handling, synchronization.

### 💻 Software Development

- **[Baby Name Picker](https://github.com/steadows/Data-Science-Portfolio/tree/main/Computer%20Science%20/Baby%20Name%20Picker)**  
  **Language**: Java  
  **Description**: A console application that helps parents collaboratively choose baby names by selecting and rating names. Identifies highly rated names and top averages. Personally significant for naming my son, Miles Meadows.  
  **Key Concepts**: Object-oriented design, user input handling, set operations, interactive CLI.

- **[Memory Card Game](https://github.com/steadows/Data-Science-Portfolio/tree/main/Computer%20Science%20/Memory%20Game%20(Android%20App))**  
  **Language**: Java (Android)  
  **Description**: An Android app for a single-player memory card game with Traditional and Time Trial modes. Features card flipping, level progression, and UI testing.  
  **Key Concepts**: Mobile development, UI design, event-driven programming, testing (Espresso).

- **[Java Workout Generator](https://github.com/steadows/Data-Science-Portfolio/tree/main/Computer%20Science%20/Workout-Generator)**  
  **Language**: Java  
  **Description**: Generates randomized home gym workouts (Strength, Tabata, EMOM) with tapered training schedules. Built to automate workout planning during COVID lockdowns.  
  **Key Concepts**: Object-oriented design, randomization, CLI interface, modular programming.

## 🛠️ Setup and Installation

Each project includes its own `README.md` with specific instructions for compilation and execution. General requirements:
- **Java**: JDK 8 or higher (for Java-based projects).
- **Python**: Python 3.8 or higher (for Python-based projects).
- **C**: GCC compiler with POSIX support (for C-based projects).
- **Android**: Android Studio for the Memory Card Game.
- **Terminal/IDE**: For compiling and running projects.

Example compilation for Java projects:
```bash
javac *.java
java MainClass
