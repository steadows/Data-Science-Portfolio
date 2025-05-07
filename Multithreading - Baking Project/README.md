# 🧁 Baking Project (Multithreading & Synchronization)

**Authors**: Steve Meadows
**Project**: Project 2 – *The Baking Simulation*

> “STOP, BAKER NUMBER 2! You idiot!” – *Gordon Ramsay (probably)*

---

## 🧠 Overview

This project simulates a **multi-baker kitchen** environment using **POSIX threads and semaphores**. Each baker thread attempts to prepare a list of recipes using shared kitchen resources, including:

- Pantry (dry ingredients)
- Fridge (wet ingredients)
- Bowls, spoons, mixers, and a single oven

However, one unlucky baker may be **randomly sabotaged by a Gordon Ramsay thread**, which interrupts their process and forces them to restart their recipe—complete with colorful commentary.

---

## 🎯 Learning Objectives

- Practice **multithreading** with `pthread`
- Manage **critical sections** using **POSIX semaphores**
- Simulate **shared resources** and contention
- Implement **asynchronous interrupts** using `signal` and `pthread_join`
- Handle **dynamic memory management** and resource cleanup
- Inject fun with **randomized behavior and thread-based "sabotage"**

---

## ⚙️ Key Features

- 🔁 Each baker prepares **5 different recipes**, collecting ingredients and using tools
- 🔒 Shared kitchen resources are protected with **semaphores**
- 🍳 A random "Gordon Ramsay" thread may appear and **force a baker to restart** mid-recipe
- 🧼 Memory and resource cleanup handled on `SIGINT` (Ctrl+C)

---

## 🍪 Recipe List

Each baker prepares the following:

1. Cookies  
2. Pancakes  
3. Homemade Pizza Dough  
4. Soft Pretzels  
5. Cinnamon Rolls

Each recipe requires a unique mix of pantry and fridge ingredients, which must be acquired using **synchronized access**.

---

## 🧵 Threads & Synchronization

- Each baker runs in its own **`pthread`**
- One **Ramsay thread** is optionally created to interrupt a baker mid-process
- Shared tools use the following semaphore limits:
  - Mixers: 2  
  - Fridge: 2  
  - Pantry: 1  
  - Bowls: 3  
  - Spoons: 5  
  - Oven: 1

---

## 🧪 How to Compile & Run

### Compilation

**Important:** If running on EOS or another Unix environment, include `-lpthread`:
```bash
gcc Project02.c -o Project02 -lpthread
