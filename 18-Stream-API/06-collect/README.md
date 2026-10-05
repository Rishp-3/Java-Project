# collect() in Stream API

## 📌 Topic
`collect()` ek terminal operation hai jo stream ke elements ko list, set, map ya string jaisi final result me jama karta hai.

## 🎯 What You Will Learn

- `Collectors.toList()`, `toSet()`, `toMap()`
- `joining()`
- `groupingBy()` aur `counting()`
- `partitioningBy()`

## 💻 Code

```java
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Collect {

    record Emp(String name, String dept, int salary) {}

    public static void main(String[] args) {
        List<String> words = List.of("apple", "banana", "cherry", "avocado", "blueberry");

        System.out.println(words.stream().filter(w -> w.length() > 5).collect(Collectors.toList()));
        System.out.println(words.stream().collect(Collectors.joining(" | ")));
        System.out.println(words.stream().collect(Collectors.toMap(w -> w, String::length)).get("banana"));

        Map<Character, List<String>> byLetter = words.stream()
                .collect(Collectors.groupingBy(w -> w.charAt(0)));
        System.out.println(byLetter);

        List<Emp> emps = List.of(new Emp("A", "IT", 50), new Emp("B", "HR", 40), new Emp("C", "IT", 70));

        Map<String, Long> countByDept = emps.stream()
                .collect(Collectors.groupingBy(Emp::dept, Collectors.counting()));
        System.out.println(countByDept);

        Map<String, Integer> salaryByDept = emps.stream()
                .collect(Collectors.groupingBy(Emp::dept, Collectors.summingInt(Emp::salary)));
        System.out.println(salaryByDept);

        Map<Boolean, List<Integer>> parts = List.of(1, 2, 3, 4, 5, 6).stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(parts);
    }
}
```

## 🧠 Explanation

### `Collectors.joining(" | ")`
Strings ko ek hi string me separator ke saath jodta hai.

### `groupingBy(...)`
Elements ko kisi key ke hisab se groups me baantta hai (SQL ke GROUP BY jaisa).

### `counting() / summingInt()`
Downstream collectors jo har group par count ya sum nikalte hain.

### `partitioningBy(...)`
Do hi groups banata hai: `true` aur `false`.

## ▶️ Output

```text
[banana, cherry, avocado, blueberry]
apple | banana | cherry | avocado | blueberry
6
{a=[apple, avocado], b=[banana, blueberry], c=[cherry]}
{HR=1, IT=2}
{HR=40, IT=120}
{false=[1, 3, 5], true=[2, 4, 6]}
```

## 🔑 Important Points

- `toMap()` me duplicate key aaye to `IllegalStateException` aata hai, merge function do.
- `HashMap` ka print order guarantee nahi hota.
- Java 16+ me list ke liye `stream.toList()` bhi hai.

## 📝 Practice

1. Words ko length ke hisab se group karo.
2. Employees ko department ke hisab se group karo.
3. Numbers ko even/odd me partition karo.
4. Student naam aur marks ka `Map` banao.

## 🚀 Challenge

Employee list ko department ke hisab se group karke har department ki average salary nikalo (`averagingInt`).
