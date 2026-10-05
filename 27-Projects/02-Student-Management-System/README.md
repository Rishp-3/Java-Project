# Student Management System

## 📌 Topic
Console project jisme students add, search, update, delete aur topper nikalne ka kaam `ArrayList` aur OOP se kiya jata hai.

## 🎯 What You Will Learn

- Class design (Student, Manager)
- `ArrayList` ke saath CRUD
- Search aur Stream se topper nikalna
- Encapsulation

## 💻 Code

```java
import java.util.*;

class Student {
    private final int id;
    private String name;
    private int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    int getId() { return id; }
    String getName() { return name; }
    int getMarks() { return marks; }
    void setMarks(int marks) { this.marks = marks; }

    public String toString() {
        return String.format("%-3d %-10s %d", id, name, marks);
    }
}

class StudentManager {
    private final List<Student> students = new ArrayList<>();

    void add(Student s) { students.add(s); }

    Student find(int id) {
        for (Student s : students) if (s.getId() == id) return s;
        return null;
    }

    boolean delete(int id) {
        Student s = find(id);
        return s != null && students.remove(s);
    }

    void showAll() {
        System.out.println("ID  Name       Marks");
        students.forEach(System.out::println);
    }

    Student topper() {
        return students.stream().max(Comparator.comparingInt(Student::getMarks)).orElse(null);
    }

    double average() {
        return students.stream().mapToInt(Student::getMarks).average().orElse(0);
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManager m = new StudentManager();
        m.add(new Student(1, "Rishabh", 85));
        m.add(new Student(2, "Amit", 72));
        m.add(new Student(3, "Neha", 92));

        m.showAll();
        System.out.println("Topper: " + m.topper().getName());
        System.out.println("Average: " + m.average());

        m.find(2).setMarks(80);
        System.out.println("Updated Amit: " + m.find(2));

        System.out.println("Deleted 1: " + m.delete(1));
        System.out.println("Find 1: " + m.find(1));
        m.showAll();
    }
}
```

> 💡 Note: Is project me demo ke liye values code me hi di gayi hain taaki output hamesha same aaye. Project ko aage `Scanner` se menu-driven banana tumhara practice task hai.

## 🧠 Explanation

### `Student`
Model class. `id` final hai kyunki baad me badalna nahi chahiye.

### `StudentManager`
Saari students ki list aur unke operations (add, find, delete, topper, average).

### `topper()`
Stream ka `max()` aur `Comparator` se sabse zyada marks wala student.

## ▶️ Output

```text
ID  Name       Marks
1   Rishabh    85
2   Amit       72
3   Neha       92
Topper: Neha
Average: 83.0
Updated Amit: 2   Amit       80
Deleted 1: true
Find 1: null
ID  Name       Marks
2   Amit       80
3   Neha       92
```

## 🔑 Important Points

- Ek class ka ek hi kaam (Single Responsibility).
- `find()` null return karta hai to caller ko check karna padta hai; `Optional<Student>` behtar option hai.
- Data file ya database me save karne par project aur real banega.

## 📝 Practice

1. Naam se search jodo.
2. Grade (A/B/C) calculate karo.
3. Students ko marks se sort karke print karo.
4. File me save/load jodo.

## 🚀 Challenge

Student me `email` aur `course` jodo aur duplicate id add hone se roko.
