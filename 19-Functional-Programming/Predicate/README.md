# Predicate in Java

## 📌 Topic
`Predicate<T>` ek built-in functional interface hai jo ek value leta hai aur `boolean` (true/false) return karta hai. Conditions check karne ke liye use hota hai.

## 🎯 What You Will Learn

- `Predicate<T>` aur uska `test()` method
- `and()`, `or()`, `negate()`
- `Predicate` ko `filter()` me use karna

## 💻 Code

```java
import java.util.List;
import java.util.function.Predicate;

public class Predicate1 {
    public static void main(String[] args) {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;

        System.out.println(isEven.test(4));
        System.out.println(isEven.test(7));

        System.out.println(isEven.and(isPositive).test(-4));
        System.out.println(isEven.or(isPositive).test(-4));
        System.out.println(isEven.negate().test(7));

        Predicate<String> longWord = s -> s.length() > 4;
        List<String> words = List.of("Java", "Lambda", "Stream", "API");
        words.stream().filter(longWord).forEach(System.out::println);
    }
}
```

## 🧠 Explanation

### `Predicate<Integer>`
Input `Integer`, output `boolean`. Abstract method: `boolean test(T t)`.

### `and / or / negate`
Do conditions ko jodne (`&&`, `||`) ya ulta karne (`!`) ke default methods.

### `filter(longWord)`
Stream ka `filter()` khud `Predicate` leta hai.

## ▶️ Output

```text
true
false
false
true
true
Lambda
Stream
```

## 🔑 Important Points

- Predicate ko variable me rakh ke baar-baar reuse kar sakte ho.
- Do input ke liye `BiPredicate<T, U>` hota hai.
- Primitive versions: `IntPredicate`, `DoublePredicate` (autoboxing bachate hain).

## 📝 Practice

1. `isAdult` predicate banao (age >= 18).
2. Do predicates `and()` se jodo.
3. `Predicate<String>` banao jo empty string check kare.
4. `Predicate.not(...)` try karo.

## 🚀 Challenge

`Predicate<String>` se password validation banao: length >= 8 aur digit ho.
