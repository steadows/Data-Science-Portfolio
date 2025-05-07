# 💪 Java Workout Generator

[![Java](https://img.shields.io/badge/Built%20With-Java-007396?logo=java&logoColor=white)](https://www.java.com/)
![Status](https://img.shields.io/badge/status-Completed-brightgreen)
![Last Updated](https://img.shields.io/badge/last%20updated-May%202025-orange)

## 🏋️ Overview

During the COVID lockdowns, my gym closed, and I needed a way to stay in shape. I went online, bought as much gym equipment as I could find, and got to work training at home. But after a few months, I got tired of manually creating new workouts every day. I wanted variety, but it was taking me 15–30 minutes just to plan a session. So I wrote this program to automate the process and keep things creative.

This command-line Java application generates randomized workouts for a home gym setting. It supports multiple training styles including Strength, Tabata, and EMOM (Every Minute on the Minute), and incorporates logic for **tapered training schedules** to ensure variation, recovery, and peak performance.

## 📁 File Structure

```
.
├── workoutGenerator.java   # Entry point and launcher
├── mainMenu.java           # Handles main menu options and user prompts
├── emomMenu.java           # Generates EMOM-style workouts
├── strengthMenu.java       # Handles randomized strength training formats
├── tabataMenu.java         # Tabata protocol workouts (20s on / 10s off)
├── getWorkout.java         # Exercise pool and tapering logic
├── exercise.java           # Object class for defining exercises
```

## ▶️ How to Run

1. **Compile all Java files**:
```bash
javac *.java
```

2. **Run the application**:
```bash
java workoutGenerator
```

3. **Choose a workout mode** from the interactive menu:
- Strength
- Tabata
- EMOM

## 🔧 Features

- 🎯 **Three Workout Modes**  
  - **Strength**: Traditional multi-set rep schemes (e.g., 5x5, 4x4, 3x3)  
  - **Tabata**: 20s work / 10s rest for 8 rounds per movement  
  - **EMOM**: A new exercise every minute for a specified duration  

- 🔁 **Tapered Training Schedules**  
  Taper logic built into the strength mode gradually reduces volume or intensity over time:  
  - Week 1: 5x5  
  - Week 2: 4x4  
  - Week 3: 3x3 (Deload)  
  Promotes recovery and long-term progress.

- 🧠 **Randomized Exercise Selection**  
  Each session is different using an internal pool of bodyweight, barbell, and dumbbell exercises.

- ⚙️ **Object-Oriented Design**  
  Modular and extendable — simply add new `exercise` objects or training formats.

- 🖥️ **CLI-Based User Interface**  
  Simple, fast navigation through text-based prompts.

## 💡 Example Output

### Strength Mode
```
Workout Type: Strength
-----------------------
1. Barbell Deadlift - 5 sets of 5 reps
2. Dumbbell Bench Press - 4 sets of 6 reps
3. Pull-Ups - 3 sets of 8 reps
```

### Tabata Mode
```
Workout Type: Tabata
---------------------
Perform each of the following for 20s work, 10s rest x 8 rounds:
1. Jump Squats
2. Push-ups
3. Mountain Climbers
4. Sit-ups
```

### EMOM Mode
```
Workout Type: EMOM - 12 minutes
-------------------------------
Minute 1: 10 Burpees  
Minute 2: 12 Kettlebell Swings  
Minute 3: 15 Air Squats  
...
Repeat until time expires.
```

## 🚀 Future Improvements

- Save past workout logs  
- User-defined equipment filters (e.g. “no barbell”)  
- Load workouts based on current fatigue level  
- Export plans to printable PDF  

## 👤 Author

**Steve Meadows**  
Data Scientist & Home Gym Enthusiast  
GitHub: [@SteveMeadows](https://github.com/steadows/data-science-portfolio)

---

_This tool was created to support varied, structured training at home using classic programming principles adapted to personal fitness._
