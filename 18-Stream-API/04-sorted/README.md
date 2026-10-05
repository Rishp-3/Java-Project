# sorted() in Stream API

## 📌 Topic
`sorted()` stream ke elements ko sort karta hai. Natural order ya custom `Comparator` dono ke saath chalta hai.

## 🎯 What You Will Learn

- `sorted()` natural order me
- `sorted(Comparator)` custom order me
- `Comparator.comparing()` aur `reversed()`
- `limit()` aur `distinct()`

## 💻 Code

```java
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorted {

    record Student(String name, int marks) {}

    public static void main(String[] args) {
        List<Integer> nums = List.of(5, 3, 8, 1, 9, 3);

        System.out.println(nums.stream().sorted().collect(Collectors.toList()));
        System.out.println(nums.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println(nums.stream().distinct().sorted().limit(3).collect(Collectors.toList()));

        List<Student> students = List.of(
            new Student("Rishabh", 85),
            new Student("Amit", 72),
            new Student("Neha", 92)
        );

        students.stream()
                .sorted(Comparator.comparingInt(Student::marks).reversed())
                .forEach(s -> System.out.println(s.name() + " " + s.marks()));

        System.out.println(students.stream()
                .map(Student::name)
                .sorted()
                .collect(Collectors.joining(", ")));
    }
}
```

## 🧠 Explanation

### `sorted()`
Natural order me (numbers chhote se bade, strings alphabetical). Custom objects me `Comparable` zaroori hai.

### `Comparator.comparingInt(...).reversed()`
Kisi field ke basis par sort aur phir ulta order.

### `distinct() / limit(n)`
`distinct` duplicates hatata hai, `limit` pehle `n` elements rakhta hai.

### `record`
Java 16+ ka chhota data class. Getter methods (`name()`, `marks()`) khud ban jate hain.

## ▶️ Output

```text
[1, 3, 3, 5, 8, 9]
[9, 8, 5, 3, 3, 1]
[1, 3, 5]
Neha 92
Rishabh 85
Amit 72
Amit, Neha, Rishabh
```

## 🔑 Important Points

- `sorted()` original list ko nahi badalta, naya sorted stream deta hai.
- Pehle `filter`, phir `sorted` lagao, kam data par sorting fast hoti hai.
- Multi-level sorting ke liye `thenComparing()` use karo.

## 📝 Practice

1. Naam alphabetically sort karo.
2. Marks descending order me sort karo.
3. Top 3 marks wale students nikalo.
4. Pehle marks, phir naam se sort karo (`thenComparing`).

## 🚀 Challenge

Employees ko salary descending me sort karo aur top 2 ke naam print karo.
