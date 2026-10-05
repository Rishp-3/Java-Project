# map() in Stream API

## 📌 Topic
`map()` stream ke har element par ek function lagakar use dusre rup (value ya type) me badal deta hai.

## 🎯 What You Will Learn

- `map()` ka syntax
- Transformation (square, uppercase, length)
- Objects se field nikalna
- `map` aur `filter` ko saath use karna

## 💻 Code

```java
import java.util.List;
import java.util.stream.Collectors;

public class Map1 {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        List<Integer> squares = nums.stream()
                                    .map(n -> n * n)
                                    .collect(Collectors.toList());
        System.out.println("Squares: " + squares);

        List<String> names = List.of("rishabh", "amit", "neha");
        List<String> upper = names.stream()
                                  .map(String::toUpperCase)
                                  .collect(Collectors.toList());
        System.out.println(upper);

        List<Integer> lengths = names.stream()
                                     .map(String::length)
                                     .collect(Collectors.toList());
        System.out.println("Lengths: " + lengths);

        int sumOfEvenSquares = nums.stream()
                                   .filter(n -> n % 2 == 0)
                                   .map(n -> n * n)
                                   .mapToInt(Integer::intValue)
                                   .sum();
        System.out.println("Sum of even squares: " + sumOfEvenSquares);
    }
}
```

## 🧠 Explanation

### `map(n -> n * n)`
Har element ko uske square se badal deta hai. Elements ki sankhya same rehti hai.

### `map(String::length)`
Type bhi badal sakta hai: `String` -> `Integer`.

### `mapToInt`
`Stream<Integer>` ko `IntStream` me badalta hai, taaki `sum()`, `average()` jaise methods mil sakein.

## ▶️ Output

```text
Squares: [1, 4, 9, 16, 25]
[RISHABH, AMIT, NEHA]
Lengths: [7, 4, 4]
Sum of even squares: 20
```

## 🔑 Important Points

- `map()` 1-to-1 transformation karta hai, 1-to-many ke liye `flatMap()` use hota hai.
- `map()` ka argument `Function<T, R>` hota hai.
- `filter` pehle lagao taaki `map` kam elements par chale.

## 📝 Practice

1. Prices ki list me 10% GST jodo.
2. Student names ko lowercase me convert karo.
3. Employee list se sirf naam ki list banao.
4. `flatMap` se list of lists ko ek list banao.

## 🚀 Challenge

Strings ki list `{"1", "2", "3"}` ko `map(Integer::parseInt)` se `int` me badalke sum nikalo.

```text
6
```
