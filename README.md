# Campus Management DSA System

A Java-based Campus Management System that demonstrates the practical implementation of core Data Structures and Algorithms through six independent real-world campus management features.

## Features

### 1. Lost and Found Management
Implements a Lost and Found management feature using a **Singly Linked List** to dynamically store item records. The system allows users to add, search, remove, and display lost or found items while demonstrating dynamic memory management and linked list traversal.

### 2. Priority-Based Room Booking
Implements a room booking system using a **Priority Queue** to manage reservation requests according to their assigned priority. The feature ensures that higher-priority requests are processed before lower-priority ones, supporting efficient and organized booking management.

### 3. Student Orientation and Campus Navigation
Models the campus as a **Graph using an Adjacency Matrix**, where buildings represent vertices and paths represent weighted edges. The system applies **Dijkstra's Algorithm** to calculate the shortest path between campus locations and assist students with efficient navigation.

### 4. Undo and Redo System
Implements an action history mechanism using **two Stacks backed by a Doubly Linked List**. User actions are stored in the Undo stack, while undone actions are transferred to the Redo stack, enabling efficient Undo and Redo operations.

### 5. Event Participation Registration
Implements an event registration system using a **Queue backed by a Singly Linked List**. The feature follows the **First-In, First-Out (FIFO)** principle to register and process students fairly in the order they join the event queue.

### 6. Student Locker Allocation
Implements a locker allocation system using a **Binary Search Tree (BST)**, with student IDs used as keys for storing locker assignments. The system supports assigning, searching, removing, and displaying locker records in sorted order.

## Technologies and Concepts

- Java
- Object-Oriented Programming
- Data Structures
- Algorithms
- Singly and Doubly Linked Lists
- Stacks and Queues
- Priority Queues
- Binary Search Trees
- Graphs and Adjacency Matrices
- Dijkstra's Shortest Path Algorithm
- Time and Space Complexity Analysis
