# Autoboxing in Java

## 📌 Topic
Primitive type ko automatically uske Wrapper class ke object me convert karna Autoboxing kehlata hai (`int` -> `Integer`).

## 🎯 What You Will Learn

- Wrapper classes kya hain
- Autoboxing
- Collections me autoboxing ka use
- `Integer` caching ka concept

## 💻 Code

```java
import java.util.ArrayList;

public class Autoboxing {
    public static void main(String[] args) {
        int a = 10;
        Integer obj = a;
        System.out.println(obj);

        double d = 5.5;
        Double dObj = d;
        char c = 'J';
        Character cObj = c;
        System.out.println(dObj + " " + cObj);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);

        Integer x = 100, y = 100;
        Integer p = 1000, q = 1000;
        System.out.println(x == y);
        System.out.println(p == q);
        System.out.println(p.equals(q));
    }
}
```

## 🧠 Explanation

### `Integer obj = a;`
Compiler khud `Integer.valueOf(a)` laga deta hai. Isi ko autoboxing kehte hain.

### `list.add(1)`
`ArrayList` objects store karti hai, isliye `int` `1` automatically `Integer` ban jata hai.

### `Integer cache`
`-128` se `127` tak ke `Integer` cache hote hain, isliye `100 == 100` true aata hai par `1000 == 1000` false.

## ▶️ Output

```text
10
5.5 J
[1, 2]
true
false
true
```

## 🔑 Important Points

- Wrapper classes: `Byte`, `Short`, `Integer`, `Long`, `Float`, `Double`, `Character`, `Boolean`.
- Wrapper objects ko `==` se nahi, `equals()` se compare karo.
- Autoboxing se thoda performance cost aata hai, bade loops me dhyan rakho.
- Wrapper me `null` ho sakta hai, primitive me nahi.

## 📝 Practice

1. `int`, `double`, `boolean` ko wrapper me box karo.
2. `ArrayList<Double>` me values add karo.
3. `Integer` caching ka test chalao.
4. `Integer.valueOf()` aur `new Integer()` ka difference dekho.

## 🚀 Challenge

`ArrayList<Character>` me `'a'` se `'e'` tak chars autoboxing se daalo aur print karo.
