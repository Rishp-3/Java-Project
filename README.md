# ☕ Java Project — A to Z

A complete, topic-wise Java roadmap, from the basics to design patterns, DSA and projects.
Every topic folder contains a starter `.java` file with a `main()` method and a `README.md` with notes, so you can learn by reading, running, and modifying code.

![Java](https://img.shields.io/badge/Java-17+-orange?logo=openjdk)
![Topics](https://img.shields.io/badge/Topics-27-blue)
![Status](https://img.shields.io/badge/Status-Complete-brightgreen)

---

## 📁 Project Structure

```
<repo-name>/
├── 01-Java-Basics/
│   ├── *.java           # starter file with main()
│   └── README.md        # notes and explanation
├── 02-Control-Flow/
├── ...
├── 27-Projects/
└── README.md            # you are here
```

---

## 🗺️ Roadmap

### 🟢 Core Java
| # | Topic | What you'll learn |
|---|-------|-------------------|
| 01 | [Java-Basics](./01-Java-Basics) | JDK/JRE/JVM, syntax, variables, data types, operators |
| 02 | [Control-Flow](./02-Control-Flow) | `if/else`, `switch`, loops, `break/continue` |
| 03 | [Methods](./03-Methods) | parameters, return types, overloading, recursion |
| 04 | [Arrays](./04-Arrays) | 1D/2D arrays, `Arrays` class |
| 05 | [Strings](./05-Strings) | `String`, `StringBuilder`, `StringBuffer` |

### 🟡 Object-Oriented Programming & Fundamentals
| # | Topic | What you'll learn |
|---|-------|-------------------|
| 06 | [OOP](./06-OOP) | classes, inheritance, polymorphism, abstraction, encapsulation |
| 07 | [Packages](./07-Packages) | `package`, `import`, access modifiers |
| 08 | [Exception-Handling](./08-Exception-Handling) | `try/catch/finally`, `throw/throws`, custom exceptions |

### 🟠 Collections & Data Handling
| # | Topic | What you'll learn |
|---|-------|-------------------|
| 09 | [Collections](./09-Collections) | `List`, `Set`, `Map`, `Queue` |
| 10 | [Generics](./10-Generics) | generic classes/methods, bounded types, wildcards |
| 11 | [Wrapper-Classes](./11-Wrapper-Classes) | autoboxing, unboxing, `Integer`, `Double`, etc. |
| 12 | [Enums](./12-Enums) | enum basics, fields, methods, `EnumMap` |
| 13 | [Date-Time](./13-Date-Time) | `LocalDate`, `LocalDateTime`, `Duration`, formatting |

### 🔵 I/O & Concurrency
| # | Topic | What you'll learn |
|---|-------|-------------------|
| 14 | [File-Handling](./14-File-Handling) | `File`, `Path`, `Files` (NIO) |
| 15 | [Java-IO](./15-Java-IO) | streams, readers/writers, buffering |
| 16 | [Multithreading](./16-Multithreading) | `Thread`, `Runnable`, synchronization, `ExecutorService` |

### 🔴 Modern Java (Functional Style)
| # | Topic | What you'll learn |
|---|-------|-------------------|
| 17 | [Lambda](./17-Lambda) | lambda expressions, functional interfaces |
| 18 | [Stream-API](./18-Stream-API) | `map`, `filter`, `reduce`, `collect` |
| 19 | [Functional-Programming](./19-Functional-Programming) | `Optional`, method references, pure functions |

### 🟣 Advanced Java
| # | Topic | What you'll learn |
|---|-------|-------------------|
| 20 | [JDBC](./20-JDBC) | connecting to databases, CRUD with SQL |
| 21 | [Serialization](./21-Serialization) | `Serializable`, `transient`, object streams |
| 22 | [Annotations](./22-Annotations) | built-in and custom annotations |
| 23 | [Reflection](./23-Reflection) | inspecting classes and methods at runtime |
| 24 | [Regex](./24-Regex) | `Pattern`, `Matcher`, common patterns |

### ⚫ Design, DSA & Practice
| # | Topic | What you'll learn |
|---|-------|-------------------|
| 25 | [Design-Patterns](./25-Design-Patterns) | Singleton, Factory, Builder, Observer, etc. |
| 26 | [DSA-in-Java](./26-DSA-in-Java) | searching, sorting, linked lists, trees, graphs |
| 27 | [Projects](./27-Projects) | hands-on mini and major projects |

---

## 🚀 Getting Started

### Prerequisites
- **JDK 17 or later** ([download](https://adoptium.net/))
- Any IDE (IntelliJ IDEA, VS Code, Eclipse) or just a terminal

```bash
java -version
javac -version
```

### Clone the repo
```bash
git clone https://github.com/Rishp-3/Java-Project.git
cd Java-Project
```

### Run a topic
```bash
cd 01-Java-Basics
javac Main.java
java Main
```

---

## 📖 How to Use This Repo

1. Follow the topics in order, from `01` to `27`.
2. Read the topic's `README.md` first.
3. Open the `.java` file, write your code inside `main()`, and run it.
4. Change the examples and experiment.
5. Finish with `27-Projects` to put everything together.

---

## 🤝 Contributing

1. Fork the repository
2. Create a branch: `git checkout -b feature/topic-name`
3. Commit your changes: `git commit -m "Add: topic-name examples"`
4. Push: `git push origin feature/topic-name`
5. Open a Pull Request

---

## 👤 Author

**Rishabh** — [@Rishp-3](https://github.com/Rishp-3)

## 📄 License

This project is licensed under the MIT License.

---

⭐ If this repo helps you, give it a star!