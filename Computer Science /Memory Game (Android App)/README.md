# 🧠 Memory Card Game

[![Android](https://img.shields.io/badge/Built%20With-Android%20Studio-3DDC84?logo=android)](https://developer.android.com/studio)
[![Java](https://img.shields.io/badge/Language-Java-blue.svg)](https://www.java.com/)
[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)
![Status](https://img.shields.io/badge/status-Completed-brightgreen)
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 📱 Overview

The Memory Card Game is a single-player Android app where users flip pairs of hidden cards in an attempt to find matches. The goal is to match all pairs as quickly as possible in **Traditional Mode**, or before time runs out in **Time Trial Mode**.

This app was developed using Java in Android Studio for CIS 350: Software Engineering.

## 🎮 Game Modes

### ✅ Traditional Mode
- Clock counts **up** from 0.
- Three difficulty levels:  
  - Easy: 6 cards  
  - Medium: 12 cards  
  - Hard: 20 cards  
- Match all cards to win!

### ⏱️ Time Trial Mode
- Clock counts **down**.
- Eight levels, each with increasing difficulty and number of cards.
- Fail the level if time runs out before all matches are found.

| Level | Cards | Time Limit |
|-------|-------|------------|
| 1     | 6     | 30 sec     |
| 2     | 12    | 45 sec     |
| 3     | 16    | 1 min      |
| 4     | 20    | 1 min      |
| 5     | 24    | 1.5 min    |
| 6     | 32    | 2.5 min    |
| 7     | 40    | 3 min      |
| 8     | 48    | 3 min      |

## 💡 Features

- Card flipping, match tracking, and animated transitions
- Level progression system
- Instruction screen for user onboarding
- Main menu with intuitive navigation
- Fully random card deck using in-app algorithms
- Manual + automated UI testing with Espresso
- SonarLint-compliant code with enforced team standards

## 🧪 Development Tools & Testing

- **IDE:** Android Studio
- **Language:** Java
- **Testing:** Espresso for UI; Manual testing for gameplay
- **Static Analysis:** SonarLint (with documented false positives)

## 📸 Screenshots

- Main Menu
- Submenu (level select, instructions)
- Gameplay boards (Levels 1–8)
- Completion and instructions screens

## 🗂️ Folder Structure

```plaintext
/app
 └── java/
     └── com.memory/
         ├── MainActivity.java
         ├── LevelXActivity.java (1–8)
         └── UtilityClasses/
             ├── CardRandomizer.java
             └── TimerHandler.java
