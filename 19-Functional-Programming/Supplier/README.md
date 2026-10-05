# Supplier in Java

## 📌 Topic
`Supplier<T>` ek built-in functional interface hai jo koi input nahi leta par ek value return karta hai (value supply karta hai).

## 🎯 What You Will Learn

- `Supplier<T>` aur `get()`
- Lazy value generation
- Random/date/new object supply karna
- `Optional.orElseGet()`

## 💻 Code

```java
import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Supplier1 {
    public static void main(String[] args) {
        Supplier<String> greeting = () -> "Hello from Supplier";
        System.out.println(greeting.get());

        Supplier<LocalDate> fixedDate = () -> LocalDate.of(2025, 1, 1);
        System.out.println(fixedDate.get());

        int[] counter = {0};
        Supplier<Integer> next = () -> ++counter[0];
        System.out.println(next.get() + " " + next.get() + " " + next.get());

        Optional<String> empty = Optional.empty();
        System.out.println(empty.orElseGet(() -> "default value"));

        Stream.generate(() -> "ping").limit(3).forEach(System.out::println);
    }
}
```

## 🧠 Explanation

### `Supplier<String>`
Koi input nahi, output `String` (`T get()`).

### `Lazy`
Value tab banti hai jab `get()` call hota hai, pehle nahi. Costly kaam ko late karne ke liye achha hai.

### `orElseGet(supplier)`
Value tabhi calculate hoti hai jab Optional khali ho.

### `Stream.generate()`
Supplier se infinite stream banta hai, `limit()` zaroori hai.

## ▶️ Output

```text
Hello from Supplier
2025-01-01
1 2 3
default value
ping
ping
ping
```

## 🔑 Important Points

- Constructor reference: `Supplier<Student> s = Student::new;`.
- Primitive versions: `IntSupplier`, `BooleanSupplier`.
- `orElse(x)` me `x` hamesha calculate hota hai, `orElseGet()` me sirf zaroorat par.

## 📝 Practice

1. `Supplier` se random number return karo.
2. `Supplier<List<String>>` se nayi list banao.
3. `Student::new` constructor reference try karo.
4. `Stream.generate()` se 5 random numbers print karo.

## 🚀 Challenge

`Supplier<Integer>` banao jo har call par agla Fibonacci number de.
