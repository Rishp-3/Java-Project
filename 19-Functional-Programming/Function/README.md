# Function in Java

## 📌 Topic
`Function<T, R>` ek built-in functional interface hai jo ek type ki value leke dusre type ki value return karta hai (transformation).

## 🎯 What You Will Learn

- `Function<T, R>` aur `apply()`
- `andThen()` aur `compose()`
- `Function` ko `map()` me use karna
- `BiFunction` aur `UnaryOperator`

## 💻 Code

```java
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Function1 {
    public static void main(String[] args) {
        Function<Integer, Integer> square = n -> n * n;
        Function<Integer, String> toText = n -> "Number is " + n;

        System.out.println(square.apply(5));
        System.out.println(square.andThen(toText).apply(4));

        Function<Integer, Integer> plusTwo = n -> n + 2;
        System.out.println(square.compose(plusTwo).apply(3));

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(10, 20));

        UnaryOperator<String> shout = s -> s.toUpperCase() + "!";
        System.out.println(shout.apply("hello"));

        Function<String, Integer> length = String::length;
        System.out.println(length.apply("Functional"));
    }
}
```

## 🧠 Explanation

### `Function<Integer, String>`
Input `Integer`, output `String`. Abstract method: `R apply(T t)`.

### `f.andThen(g)`
Pehle `f`, phir uske result par `g` chalata hai.

### `f.compose(g)`
Pehle `g`, phir uske result par `f` chalata hai.

### `UnaryOperator<T>`
`Function<T, T>` ka special case (input aur output same type).

## ▶️ Output

```text
25
Number is 16
25
30
HELLO!
10
```

## 🔑 Important Points

- `BiFunction` do inputs leta hai.
- `andThen` aur `compose` ka order ulta hai, dhyan rakho.
- Stream ka `map()` `Function` leta hai.

## 📝 Practice

1. `Function` se string ki length nikalo.
2. Celsius ko Fahrenheit me convert karne wala `Function` banao.
3. Do functions `andThen` se chain karo.
4. `Function.identity()` try karo.

## 🚀 Challenge

Teen `Function` chain karo: string trim -> uppercase -> length.
