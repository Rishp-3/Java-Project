# Unboxing in Java

## 📌 Topic
Wrapper class ke object ko automatically primitive type me convert karna Unboxing kehlata hai (`Integer` -> `int`).

## 🎯 What You Will Learn

- Unboxing kya hai
- Arithmetic me unboxing
- `NullPointerException` ka risk
- Wrapper ke useful methods

## 💻 Code

```java
import java.util.ArrayList;

public class Unboxing {
    public static void main(String[] args) {
        Integer obj = 50;
        int a = obj;
        System.out.println(a);

        Integer x = 10, y = 20;
        int sum = x + y;
        System.out.println("Sum: " + sum);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(15);
        int total = 0;
        for (int n : list) {
            total += n;
        }
        System.out.println("Total: " + total);

        System.out.println(Integer.parseInt("123") + 1);
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Character.isDigit('7'));

        try {
            Integer nothing = null;
            int bad = nothing;
        } catch (NullPointerException e) {
            System.out.println("Cannot unbox null");
        }
    }
}
```

## 🧠 Explanation

### `int a = obj;`
Compiler khud `obj.intValue()` laga deta hai.

### `x + y`
Arithmetic me wrapper objects automatically unbox hote hain.

### `Integer nothing = null; int bad = nothing;`
`null` ko unbox karne par `NullPointerException` aata hai.

## ▶️ Output

```text
50
Sum: 30
Total: 20
124
1010
2147483647
true
Cannot unbox null
```

## 🔑 Important Points

- Unboxing ke time `null` check karna zaroori hai.
- Useful methods: `Integer.parseInt()`, `Double.parseDouble()`, `Integer.valueOf()`, `Character.isLetter()`.
- `Integer.compare(a, b)` safe comparison deta hai.

## 📝 Practice

1. `Double` ko `double` me unbox karo.
2. `ArrayList<Integer>` ka average nikalo.
3. `String` ko `int` aur `double` me parse karo.
4. `null` unboxing ka exception pakdo.

## 🚀 Challenge

`ArrayList<Double>` me prices rakho aur unka total unboxing se nikalo.
