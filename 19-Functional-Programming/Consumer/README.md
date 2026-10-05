# Consumer in Java

## 📌 Topic
`Consumer<T>` ek built-in functional interface hai jo ek value leta hai aur kuch return nahi karta (jaise print karna ya save karna).

## 🎯 What You Will Learn

- `Consumer<T>` aur `accept()`
- `andThen()` se do consumers jodna
- `forEach()` me Consumer
- `BiConsumer`

## 💻 Code

```java
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Consumer1 {
    public static void main(String[] args) {
        Consumer<String> print = s -> System.out.println("Hello " + s);
        Consumer<String> shout = s -> System.out.println(s.toUpperCase());

        print.accept("Java");
        print.andThen(shout).accept("lambda");

        List<Integer> nums = List.of(1, 2, 3);
        nums.forEach(n -> System.out.println(n * 10));

        BiConsumer<String, Integer> show = (k, v) -> System.out.println(k + " = " + v);
        show.accept("age", 20);

        Map<String, Integer> map = Map.of("x", 1);
        map.forEach(show);
    }
}
```

## 🧠 Explanation

### `Consumer<String>`
Input `String`, output kuch nahi (`void accept(T t)`).

### `andThen()`
Ek ke baad doosra consumer same input par chalata hai.

### `BiConsumer`
Do inputs leta hai. `Map.forEach()` ye hi use karta hai.

## ▶️ Output

```text
Hello Java
Hello lambda
LAMBDA
10
20
30
age = 20
x = 1
```

## 🔑 Important Points

- Consumer side-effects (print, save, update) ke liye hota hai.
- `Iterable.forEach()` ka parameter `Consumer` hai.
- Primitive versions: `IntConsumer`, `DoubleConsumer`.

## 📝 Practice

1. `Consumer` se list ke saare elements print karo.
2. Do consumers `andThen` se chain karo.
3. Map ko `BiConsumer` se print karo.
4. `Consumer<List<String>>` banao jo list me element add kare.

## 🚀 Challenge

`Consumer<Employee>` banao jo employee ki salary 10% badha de aur doosra jo details print kare.
