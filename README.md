# ☕ Java-Project

A complete, structured Java learning repository — from **Hello World** to **Design Patterns, DSA, JDBC and full console projects**. Every topic has its own folder with practice programs so you can learn step by step.

![Java](https://img.shields.io/badge/Java-17+-orange?logo=openjdk)
![Status](https://img.shields.io/badge/Status-Complete-brightgreen)
![License](https://img.shields.io/badge/License-MIT-green)

---

## 📌 About This Repository

This repository contains my Java learning journey, organised topic by topic:

- Clean, beginner-friendly code examples
- Practice problems for every concept
- Mini projects to apply what I learn
- DSA in Java for interview preparation

**Status:** All 27 modules are complete — every topic folder has a real, working `.java` example (no placeholders) plus its own `README.md`, and all 142 files compile cleanly with no errors.

Every topic folder follows the same simple layout:

```
NN-Topic-Name/
├── README.md      # what the topic covers, in a couple of sentences
└── TopicName.java # a complete, runnable example with explanatory comments
```

---

## 📚 Table of Contents

| # | Module | What's Inside |
|---|--------|---------------|
| 01 | **Java Basics** | HelloWorld, Variables, Data Types, Input/Output, Type Casting, Operators, Comments |
| 02 | **Control Flow** | if-else, nested if, switch, for, while, do-while, break, continue |
| 03 | **Methods** | Basics, Parameters, Return Type, Overloading, Recursion |
| 04 | **Arrays** | 1D, 2D, Multidimensional, Searching, Sorting, Problems |
| 05 | **Strings** | String Basics, Methods, StringBuilder, StringBuffer, Problems |
| 06 | **OOP** | Class & Object, Constructor, this, static, Encapsulation, Inheritance, Polymorphism, Abstraction, Interface, Association |
| 07 | **Packages** | Package Basics, Import, Access Modifiers |
| 08 | **Exception Handling** | try-catch, multiple catch, finally, throw, throws, Custom Exception |
| 09 | **Collections** | ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap, Queue, Deque |
| 10 | **Generics** | Generic Class, Generic Method, Wildcards |
| 11 | **Wrapper Classes** | Autoboxing, Unboxing |
| 12 | **Enums** | Enum basics and usage |
| 13 | **Date & Time** | LocalDate, LocalTime, LocalDateTime, DateTimeFormatter |
| 14 | **File Handling** | File, FileReader, FileWriter, BufferedReader |
| 15 | **Java IO** | InputStream, OutputStream, Reader, Writer |
| 16 | **Multithreading** | Thread, Runnable, Synchronization, ExecutorService |
| 17 | **Lambda** | Lambda Basics, Functional Interface |
| 18 | **Stream API** | filter, map, sorted, reduce, collect |
| 19 | **Functional Programming** | Predicate, Consumer, Supplier, Function |
| 20 | **JDBC** | Connection, Statement, PreparedStatement, CRUD |
| 21 | **Serialization** | Serialization, Deserialization |
| 22 | **Annotations** | Built-in and custom annotations |
| 23 | **Reflection** | Reflection API |
| 24 | **Regex** | Pattern and Matcher |
| 25 | **Design Patterns** | Singleton, Factory, Builder, Observer, Strategy |
| 26 | **DSA in Java** | Complexity, Arrays, Strings, LinkedList, Stack, Queue, Hashing, Recursion, Backtracking, Trees, BST, Heap, Graph, Greedy, DP, Sorting & Searching |
| 27 | **Projects** | Calculator, Student / Bank / Library / Employee Management, ATM, Quiz App, Ticket Booking, E-Commerce |

---

## 🗂️ Project Structure

```
Java-Project/
├── 01-Java-Basics/
├── 02-Control-Flow/
├── 03-Methods/
├── 04-Arrays/
├── 05-Strings/
├── 06-OOP/
├── 07-Packages/
├── 08-Exception-Handling/
├── 09-Collections/
├── 10-Generics/
├── 11-Wrapper-Classes/
├── 12-Enums/
├── 13-Date-Time/
├── 14-File-Handling/
├── 15-Java-IO/
├── 16-Multithreading/
├── 17-Lambda/
├── 18-Stream-API/
├── 19-Functional-Programming/
├── 20-JDBC/
├── 21-Serialization/
├── 22-Annotations/
├── 23-Reflection/
├── 24-Regex/
├── 25-Design-Patterns/
├── 26-DSA-in-Java/
└── 27-Projects/
```

---

## 🛠️ Prerequisites

- **JDK 17 or higher** — [Download](https://www.oracle.com/java/technologies/downloads/)
- Any IDE: IntelliJ IDEA / Eclipse / VS Code
- **Git** (optional, for cloning)
- **MySQL + the MySQL JDBC driver on your classpath** (only needed to actually *run* the `20-JDBC` module — the code compiles without it, but connecting requires a real database)

---

## 🚀 How to Run

**1. Clone the repository**

```bash
git clone https://github.com/Rishp-3/Java-Project.git
cd Java-Project
```

**2. Go to any topic folder**

```bash
cd 01-Java-Basics/01-HelloWorld
```

**3. Compile and run**

```bash
javac HelloWorld.java
java HelloWorld
```

Every other topic works the same way — `cd` into its folder, `javac` the `.java` file, then `java` the class name (without `.java`). A few things to keep in mind:

- Files under **`27-Projects`** are interactive (they use `Scanner` for input), so run them from an actual terminal, not just an IDE's output panel.
- Files under **`20-JDBC`** will print a friendly "connection failed" message unless you have a real database and driver configured — that's expected, the code itself is correct and complete.
- A couple of examples (e.g. under **`14-File-Handling`**, **`21-Serialization`**) create a small file, print it, and then delete it again, so they leave your folder clean after running.

---

## 🎯 Learning Path

Follow the folders in order (01 → 27) for the best experience:

1. **Beginner** → Modules 01–05
2. **Intermediate** → Modules 06–15
3. **Advanced** → Modules 16–25
4. **Interview / Practice** → Modules 26–27

---

## 🧩 Featured Projects

- 🧮 Calculator
- 🎓 Student Management System
- 🏦 Bank Management System
- 💳 ATM System
- 📖 Library Management System
- 👨‍💼 Employee Management System
- ❓ Quiz Application
- 🎟️ Ticket Booking System
- 🛒 E-Commerce Console Application

---

## 🤝 Contributing

Suggestions and improvements are welcome!

1. Fork the repo
2. Create a branch: `git checkout -b feature/your-feature`
3. Commit: `git commit -m "Add your feature"`
4. Push: `git push origin feature/your-feature`
5. Open a Pull Request

---

## 👤 Author

**Rishp-3**
GitHub: [@Rishp-3](https://github.com/Rishp-3)

---

## ⭐ Support

If this repository helped you, please give it a **star** ⭐ — it motivates me to keep adding more content!

---

