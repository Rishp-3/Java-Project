# reduce() in Stream API

## 📌 Topic
`reduce()` stream ke saare elements ko ek hi value me jod deta hai, jaise sum, product, max.

## 🎯 What You Will Learn

- `reduce()` kaise kaam karta hai
- Identity value ke saath aur bina identity
- Sum, product, max, string join
- `reduce` aur built-in methods (`sum`, `max`)

## 💻 Code

```java
import java.util.List;
import java.util.Optional;

public class Reduce {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        int sum = nums.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);

        int product = nums.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);

        Optional<Integer> max = nums.stream().reduce(Integer::max);
        System.out.println("Max: " + max.get());

        String joined = List.of("Java", "is", "fun").stream().reduce("", (a, b) -> a + b + " ").trim();
        System.out.println(joined);

        int empty = List.<Integer>of().stream().reduce(0, Integer::sum);
        System.out.println("Empty sum: " + empty);
    }
}
```

## 🧠 Explanation

### `reduce(0, (a, b) -> a + b)`
`0` identity (starting value) hai. Har step me `a` ab tak ka result hota hai aur `b` agla element.

### `reduce(Integer::max)`
Identity ke bina `Optional` return karta hai, kyunki stream khali ho sakti hai.

### `Method reference`
`Integer::sum` aur `Integer::max` lambdas ka chhota roop hain.

## ▶️ Output

```text
Sum: 15
Product: 120
Max: 5
Java is fun
Empty sum: 0
```

## 🔑 Important Points

- Identity wali version stream khali hone par bhi identity return karti hai.
- Operation associative honi chahiye (khaskar parallel streams me).
- Sum/max/min ke liye `IntStream.sum()` aur `max()` zyada readable hain.

## 📝 Practice

1. `reduce` se list ke elements ka sum nikalo.
2. Sabse lambi string `reduce` se nikalo.
3. `reduce` se factorial nikalo (`1..n`).
4. Strings ko `reduce` se jodo.

## 🚀 Challenge

`reduce` se `1` se `10` tak ke numbers ka factorial nikalo.

```text
3628800
```
