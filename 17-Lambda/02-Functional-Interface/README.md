# Functional Interface in Java

## 📌 Topic
Aisa interface jisme sirf ek abstract method hota hai, use Functional Interface kehte hain. Lambda isi ke saath kaam karta hai.

## 🎯 What You Will Learn

- Functional interface kya hai
- `@FunctionalInterface` annotation
- Apna functional interface banana
- Built-in functional interfaces

## 💻 Code

```java
@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

@FunctionalInterface
interface Greeter {
    void greet(String name);

    default void hello() {
        System.out.println("Hello!");
    }
}

public class FunctionalInterface1 {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println(add.operate(5, 3));
        System.out.println(multiply.operate(5, 3));

        Greeter g = name -> System.out.println("Welcome, " + name);
        g.hello();
        g.greet("Rishabh");
    }
}
```

## 🧠 Explanation

### `@FunctionalInterface`
Compiler ko batata hai ki ye functional interface hai. Ek se zyada abstract method hue to compile error dega.

### `Calculator add = (a, b) -> a + b;`
Lambda is interface ke ek abstract method ka implementation ban jata hai.

### `default method`
Default aur static methods ginti me nahi aate, isliye interface phir bhi functional rehta hai.

## ▶️ Output

```text
8
15
Hello!
Welcome, Rishabh
```

## 🔑 Important Points

- Ek hi abstract method hona chahiye.
- Built-ins: `Runnable`, `Comparator`, `Callable`, aur `java.util.function` ke `Predicate`, `Function`, `Consumer`, `Supplier`.
- Annotation optional hai par lagana achhi practice hai.

## 📝 Practice

1. `StringOperation` functional interface banao (do strings ko jodna).
2. `Validator` interface banao jo `boolean validate(int)` ho.
3. Teen alag lambdas ek hi interface ke liye likho.
4. Ek se zyada abstract method dekar compile error dekho.

## 🚀 Challenge

`MathOperation` functional interface banao aur add, subtract, multiply, divide ke lambdas ek `Map<String, MathOperation>` me rakho.
