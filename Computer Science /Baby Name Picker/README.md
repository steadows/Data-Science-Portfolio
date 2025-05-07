# Baby Name Picker

[![Java](https://img.shields.io/badge/Java-17+-orange)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue)](https://opensource.org/licenses/MIT)
[![Build Status](https://img.shields.io/badge/Build-Passing-green)]()

## Overview

The **Baby Name Picker** is a Java console application designed to help parents collaboratively choose a baby name by selecting and rating names for boys and girls. Each parent inputs their preferred names, rates a combined list, and the program identifies names both parents rate highly (5 or above) and determines the top-rated names based on average ratings. This project was personally significant, as it was used to choose the name of my son, Miles Meadows.

## Features

- **Parent Input**: Each parent enters their name and selects 5 boy and 5 girl names.
- **Random Name Addition**: Adds 5 random names from a predefined list of top 100 boy and girl names.
- **Name Rating**: Parents rate each name from 1 to 10.
- **Intersection of Preferences**: Identifies names both parents rated 5 or higher.
- **Top Name Selection**: Calculates the highest average-rated names for each gender.
- **Interactive Console**: User-friendly interface with pauses and clear prompts.
- **Cross-Platform Terminal Clearing**: Supports Windows and Unix-based systems.

## Project Structure

The project consists of two main Java files:

- **`BabyNamePicker.java`**: Main application logic, parent class, and methods for collecting names, ratings, and managing flow.
- **`NameRatingIntersection.java`**: Logic for finding intersecting names, calculating top names, and printing results.

### Key Methods

- **BabyNamePicker.java**:
  - `main`: Orchestrates program flow, including parent input, name collection, rating, and result display.
  - `getNamesFromUser`: Collects names from each parent for a given gender.
  - `rateNames`: Prompts parents to rate names and validates input (1-10).
  - `getRandomNames`: Adds random names from a top 100 list.
  - `getTop100BoyNames` / `getTop100GirlNames`: Returns lists of popular baby names.
  - `clearTerminal`: Clears the console for a clean UI.

- **NameRatingIntersection.java**:
  - `getIntersectedNames`: Finds names rated 5 or higher by both parents.
  - `getTopNames`: Identifies names with the highest average rating.
  - `printIntersectedNames`: Displays names both parents rated highly.
  - `printTopNames`: Shows top-rated names with average ratings.

## How It Works

1. **Parent Setup**: Parents enter their names.
2. **Name Selection**: Each parent enters 5 boy and 5 girl names. The program adds 5 random names per gender.
3. **Name Rating**: Parents rate the combined list of names (1-10).
4. **Results**:
   - Displays names both parents rated 5 or higher.
   - Shows top-rated names based on average ratings.
5. **Output**: Results are printed to the console, organized by gender.

## Installation

1. **Prerequisites**:
   - Java Development Kit (JDK) 8 or higher.
   - Java IDE (e.g., IntelliJ IDEA, Eclipse) or terminal.

2. **Setup**:
   - Clone or download the project files.
   - Ensure `BabyNamePicker.java` and `NameRatingIntersection.java` are in the same directory.

3. **Compile and Run**:
   ```bash
   javac BabyNamePicker.java NameRatingIntersection.java
   java BabyNamePicker