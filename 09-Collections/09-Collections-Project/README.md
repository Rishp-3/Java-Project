# Collections Mini Project

## 📌 Topic
Is mini project me ek Student Record system banaya hai jisme `ArrayList`, `HashMap` aur `TreeSet` ka saath me use dikhaya gaya hai.

## 🎯 What You Will Learn

- Alag-alag collections ko saath use karna
- Objects ko `ArrayList` me store karna aur sort karna
- `HashMap` se fast lookup
- `Comparator` ka use

## 💻 Code

```java
import java.util.*;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return id + " " + name + " (" + marks + ")";
    }
}

public class CollectionsProject {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Rishabh", 85));
        list.add(new Student(2, "Amit", 72));
        list.add(new Student(3, "Neha", 92));
        list.add(new Student(4, "Rahul", 72));

        Map<Integer, Student> byId = new HashMap<>();
        for (Student s : list) byId.put(s.id, s);
        System.out.println("Find id 3: " + byId.get(3));

        list.sort((a, b) -> b.marks - a.marks);
        System.out.println("Rank list:");
        for (Student s : list) System.out.println(s);

        TreeSet<String> names = new TreeSet<>();
        for (Student s : list) names.add(s.name);
        System.out.println("Alphabetical: " + names);

        Set<Integer> uniqueMarks = new TreeSet<>();
        for (Student s : list) uniqueMarks.add(s.marks);
        System.out.println("Unique marks: " + uniqueMarks);
    }
}
```

## 🧠 Explanation

### `ArrayList<Student>`
Saare students ki list, jise sort aur traverse kar sakte hain.

### `HashMap<Integer, Student>`
Student id se seedha student dhoondhne ke liye O(1) lookup.

### `list.sort((a, b) -> ...)`
Lambda Comparator se marks ke hisab se descending sort.

### `TreeSet`
Naam aur unique marks sorted order me chahiye the.

## ▶️ Output

```text
Find id 3: 3 Neha (92)
Rank list:
3 Neha (92)
1 Rishabh (85)
2 Amit (72)
4 Rahul (72)
Alphabetical: [Amit, Neha, Rahul, Rishabh]
Unique marks: [72, 85, 92]
```

## 🔑 Important Points

- Sahi collection chunna important hai: list (order), set (unique), map (key-value).
- Custom object print karne ke liye `toString()` override karo.
- Interface type use karo: `List`, `Map`, `Set`.

## 📝 Practice

1. Student delete karne ka option jodo.
2. Sabse zyada marks wala student print karo.
3. Average marks nikalo.
4. Same marks wale students group karo (`Map<Integer, List<Student>>`).

## 🚀 Challenge

Is project ko `Scanner` se menu-driven banao: add, delete, search, display.
