# Lambda Expressions in Java

## 📌 Topic
Lambda expression (Java 8+) anonymous function ka chhota roop hai. Isse kam code me functional interface ka implementation likh sakte hain.

## 🎯 What You Will Learn

- Lambda ka syntax `(parameters) -> expression`
- Lambda ke alag-alag forms
- Lambda se `Runnable`, `Comparator` banana
- `forEach` me lambda

## 💻 Code

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaBasics {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello from lambda");
        r.run();

        List<String> names = new ArrayList<>(List.of("Rishabh", "Amit", "Neha", "Bob"));

        Collections.sort(names, (a, b) -> a.length() - b.length());
        System.out.println(names);

        names.sort((a, b) -> b.compareTo(a));
        System.out.println(names);

        names.forEach(n -> System.out.println("Hi " + n));

        names.removeIf(n -> n.length() < 4);
        System.out.println(names);
    }
}
```

## 🧠 Explanation

### `() -> ...`
Bina parameters wala lambda.

### `(a, b) -> a.length() - b.length()`
Do parameters wala lambda. Type likhna zaroori nahi, compiler infer kar leta hai.

### `n -> ...`
Ek parameter ho to bracket optional hai.

### `{ ... } aur return`
Multiple statements ho to curly braces aur `return` likhna padta hai.

## ▶️ Output

```text
Hello from lambda
[Bob, Amit, Neha, Rishabh]
[Rishabh, Neha, Bob, Amit]
Hi Rishabh
Hi Neha
Hi Bob
Hi Amit
[Rishabh, Neha, Amit]
```

## 🔑 Important Points

- Lambda sirf functional interface (ek abstract method wala interface) ke saath chalta hai.
- Lambda ke andar local variables `final` ya effectively final hone chahiye.
- Lambda se code short aur readable hota hai, par zyada lamba ho to alag method banao.

## 📝 Practice

1. Lambda se do numbers ka sum nikalo.
2. List ko string length ke hisab se sort karo.
3. `removeIf` se odd numbers hatao.
4. Anonymous class ko lambda me convert karo.

## 🚀 Challenge

List me se 5 se bade saare numbers `forEach` aur lambda se print karo.
