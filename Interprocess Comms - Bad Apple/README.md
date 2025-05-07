# 🍎 Bad Apple: Signal-Based Message Passing with Sabotage Simulation

**Authors**: Steve Meadows
**Project**: Inter-Process Communication and Signal Handling

---

## 🧠 Overview

**Bad Apple** simulates a network of processes (nodes) passing a message—called an "apple"—through a chain of pipes using UNIX signals and `fork()`. One node is randomly selected as the "bad apple" and will intercept and **scramble** the message with randomized text before passing it on.

This project demonstrates:
- Inter-process communication (IPC) with pipes
- Parent-child process forking and coordination
- Signal handling (`SIGINT`)
- Message tampering simulation
- Struct-based message encapsulation
- Dynamic memory and string manipulation

---

## ⚙️ How It Works

- The parent node (`node 0`) prompts the user for a target node and a message.
- The message (an "apple") is passed through a chain of child processes (`node 1...k`) via pipes.
- A randomly chosen **bad apple node** will scramble the message upon receiving it.
- If the message reaches the intended node, it acknowledges it and sends an empty apple back.
- The apple always returns to the parent, completing the round trip.

Each node:
- Checks if the message is intended for them
- Either processes, tampers, or forwards the apple
- Simulates delay and output for visibility of message flow

---

## 🧪 Key Concepts Demonstrated

- `fork()`, `pipe()`, `read()`, `write()`
- `SIGINT` signal handling and process termination
- Struct-based data transmission between processes
- Random number generation and string scrambling
- Inter-process collaboration with controlled message routing

---

## 🧵 Program Structure

- `struct myApple`: Contains the message, its destination node, and bad apple info
- `forkChildren(int n)`: Spawns child nodes and sets up pipe chains
- `badApple()`: Scrambles the message if the node is the bad apple
- `checkNode()`: Determines if a message is meant for the current node
- `sigHandler()`: Gracefully terminates child or parent process on `Ctrl+C`

---

## 🏁 How to Compile & Run

### Compile:
```bash
gcc -o bad_apple bad_apple.c
