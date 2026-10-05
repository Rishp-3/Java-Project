# filter() in Stream API

## 📌 Topic
`filter()` stream me se sirf unhi elements ko rakhta hai jo diye gaye condition (`Predicate`) ko pass karte hain.

## 🎯 What You Will Learn

- `filter()` ka syntax
- Multiple conditions
- Objects ko filter karna
- `filter()` ke saath `count`/`collect`

## 💻 Code

```java
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evens = nums.stream()
                                  .filter(n -> n % 2 == 0)
                                  .collect(Collectors.toList());
        System.out.println("Evens: " + evens);

        long count = nums.stream().filter(n -> n > 3 && n < 8).count();
        System.out.println("Between 4 and 7: " + count);

        List<String> names = List.of("Rishabh", "Amit", "Neha", "Anita", "Rahul");
        List<String> startsWithA = names.stream()
                                        .filter(s -> s.startsWith("A"))
                                        .collect(Collectors.toList());
        System.out.println("Starts with A: " + startsWithA);

        names.stream()
             .filter(s -> s.length() > 4)
             .filter(s -> !s.equals("Rahul"))
             .forEach(System.out::println);
    }
}
```

## 🧠 Explanation

### `filter(n -> n % 2 == 0)`
Condition true wale elements aage jate hain, baaki hat jate hain.

### `Multiple filter()`
Do `filter()` chain karna `&&` se ek condition likhne jaisa hi hai.

### `collect(Collectors.toList())`
Filtered elements ko wapas list me jama karta hai.

## ▶️ Output

```text
Evens: [2, 4, 6, 8, 10]
Between 4 and 7: 4
Starts with A: [Amit, Anita]
Rishabh
Anita
```

## 🔑 Important Points

- `filter()` original collection nahi badalta.
- Argument `Predicate<T>` hota hai (boolean return karne wala lambda).
- Java 16+ me `.toList()` seedha bhi likh sakte ho.

## 📝 Practice

1. List me se 50 se bade numbers filter karo.
2. Strings me se jinki length 5 se zyada ho wo nikalo.
3. Employee list me se salary > 50000 wale filter karo.
4. Null values filter karo (`Objects::nonNull`).

## 🚀 Challenge

Numbers ki list me se prime numbers `filter()` se nikalo.
