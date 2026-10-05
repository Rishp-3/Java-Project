# Association in Java

## 📌 Topic
Association do classes ke beech ka relationship hota hai. Iske do roop hain: Aggregation (weak, 'has-a') aur Composition (strong, 'part-of').

## 🎯 What You Will Learn

- Association, Aggregation aur Composition
- 'Has-a' relationship
- Composition me object ka lifecycle
- Inheritance ('is-a') se difference

## 💻 Code

```java
import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    Student(String name) { this.name = name; }
}

class Department {
    String name;
    List<Student> students = new ArrayList<>();      // Aggregation

    Department(String name) { this.name = name; }

    void addStudent(Student s) { students.add(s); }

    void show() {
        System.out.println(name + " students:");
        for (Student s : students) {
            System.out.println(" - " + s.name);
        }
    }
}

class Engine {
    void start() { System.out.println("Engine started"); }
}

class Car {
    private final Engine engine = new Engine();          // Composition

    void drive() {
        engine.start();
        System.out.println("Car is moving");
    }
}

public class Association {
    public static void main(String[] args) {
        Student s1 = new Student("Rishabh");
        Student s2 = new Student("Amit");

        Department cs = new Department("Computer Science");
        cs.addStudent(s1);
        cs.addStudent(s2);
        cs.show();

        new Car().drive();
    }
}
```

## 🧠 Explanation

### `Aggregation`
`Department` ke paas students hain, par student department ke bina bhi exist kar sakte hain (bahar se object diya gaya).

### `Composition`
`Car` apna `Engine` khud banati hai. Car khatam to engine bhi khatam, engine ka alag existence nahi.

### `has-a vs is-a`
`Car has-a Engine` (association), `Dog is-a Animal` (inheritance).

## ▶️ Output

```text
Computer Science students:
 - Rishabh
 - Amit
Engine started
Car is moving
```

## 🔑 Important Points

- Jab 'has-a' relation ho to inheritance nahi, association use karo.
- Composition aggregation se zyada strong relationship hai.
- Composition ko inheritance se zyada prefer kiya jata hai (flexible design).

## 📝 Practice

1. `Library` aur `Book` ka aggregation banao.
2. `House` aur `Room` ka composition banao.
3. `Teacher` aur `Student` ka many-to-many relation sochho.
4. `Employee` has-a `Address` banao.

## 🚀 Challenge

`Company` -> `Employee` (aggregation) aur `Employee` -> `Address` (composition) banao aur sab print karo.
