# Practice Problems Index

Every class below lives in `src/main/java/practice/<package>/` and has a JUnit 5 test in `src/test/java/practice/<package>/`.
Run everything with `mvn test`, or one module with `mvn test -Dtest='ArrayProblemsTest'`.

| # | Module | Class | Problems |
|---|--------|-------|----------|
| 01 | Java Basics | `basics.BasicsProblems` | Celsius→Fahrenheit, leap year, simple interest, bitwise even check, overflow-safe average |
| 02 | Control Flow | `controlflow.ControlFlowProblems` | FizzBuzz, primality, grade switch, Collatz steps, star triangle |
| 03 | Methods | `methods.MethodProblems` | factorial, GCD, Fibonacci, digit sum, overloaded `max`, varargs `sum` |
| 04 | Arrays | `arrays.ArrayProblems` | reverse, second largest, rotate, binary search, two-sum, transpose, bubble sort |
| 05 | Strings | `strings.StringProblems` | palindrome, reverse words, vowels, anagram, first unique char, run-length encoding |
| 06 | OOP | `oop.*` | `Shape`/`Circle`/`Rectangle` polymorphism, encapsulated `BankAccount`, `Animals` inheritance and dynamic dispatch |
| 07 | Packages | `packages.util.TextUtil` | title case, slugify, package-private `normalize` tested from the same package |
| 08 | Exception Handling | `exceptions.*` | custom checked exception, parse with fallback, validation, `finally` order, try-with-resources order, exception wrapping |
| 09 | Collections | `collections.CollectionProblems` | word frequency, dedupe keeping order, balanced brackets, group by length, k-th largest, intersection |
| 10 | Generics | `generics.GenericProblems` | generic `Pair`, bounded `maxOf`, `? extends` sum, `? super` fill, generic `Stack` |
| 11 | Wrapper Classes | `wrappers.WrapperProblems` | null-safe sum, default unboxing, value vs identity equality, hex parsing, overflow detection |
| 12 | Enums | `enums.*` | `Day`, `TrafficLight` state machine, `Operation` with lambdas, `EnumMap` |
| 13 | Date & Time | `datetime.DateProblems` | days between, age, weekend, business days, formatting, strict parsing, end of month |
| 14 | File Handling | `filehandling.FileProblems` | write/read lines, append, word count, longest line, `key=value` parser (tests use `@TempDir`) |
| 15 | Java IO | `io.IoProblems` | stream copy, read all, upper-case copy, count byte, read all bytes |
| 16 | Multithreading | `concurrency.ConcurrencyProblems` | parallel sum, synchronized counter, atomic counter, ordered `Callable` results |
| 17 | Lambda | `lambda.LambdaProblems` | apply twice, comparator chaining, closures, reduce, composable validators, method references |
| 18 | Stream API | `streams.StreamProblems` | even squares, average, grouping, top earners, payroll by dept, longest word, prime count, CSV join |
| 19 | Functional Programming | `functional.FunctionalProblems` | combine predicates, pipeline, memoize, lazy supplier, currying, consumers |
| 20 | JDBC | `jdbc.JdbcProblems` | schema, batch insert, top-N, aggregate, injection-safe lookup, transactional bonuses with rollback |
| 21 | Serialization | `serialization.SerializationProblems` | round trip, `transient`, deep copy, non-serialisable field failure |
| 22 | Annotations | `annotations.*` | custom `@Range` / `@NotBlank`, reflection-based validator, count annotated methods |
| 23 | Reflection | `reflection.ReflectionProblems` | list methods, create by name, constructor lookup, read/write private fields, invoke private methods |
| 24 | Regex | `regex.RegexProblems` | email, numbers, hashtags, mobile number, password strength, masking, date reformat |
| 25 | Design Patterns | `patterns.DesignPatterns` | Singleton (enum), Factory, Builder, Observer, Strategy |
| 26 | DSA in Java | `dsa.DsaProblems` | Kadane, reverse list, cycle detection, level order, BST validation, height, BFS shortest path, coin change, LIS, permutations, merge sort |
| 27 | Projects | `projects.student.*`, `projects.bank.*` | Student manager and Bank with H2 persistence, transactions and tests |

## Ideas for next steps
- Add a `Calculator`, `Quiz` or `Library` project on top of the same repository pattern used in `projects.student`.
- Swap H2 for SQLite (`org.xerial:sqlite-jdbc`) by changing the dependency and the JDBC URL — only the `AUTO_INCREMENT` DDL needs adjusting.
