# String Methods in Java

## 📌 Topic
String class me bahut saare built-in methods hote hain jo text par operations karne me madad karte hain.

## 🎯 What You Will Learn

- `length()`, `charAt()`, `substring()`
- `toUpperCase()`, `toLowerCase()`, `trim()`
- `contains()`, `indexOf()`, `replace()`
- `split()`, `startsWith()`, `endsWith()`

## 💻 Code

```java
public class StringMethods {
    public static void main(String[] args) {
        String s = "  Hello Java World  ";

        System.out.println(s.length());
        System.out.println(s.trim());
        String t = s.trim();
        System.out.println(t.toUpperCase());
        System.out.println(t.toLowerCase());
        System.out.println(t.charAt(1));
        System.out.println(t.substring(6));
        System.out.println(t.substring(0, 5));
        System.out.println(t.indexOf("Java"));
        System.out.println(t.contains("World"));
        System.out.println(t.replace("Java", "Python"));
        System.out.println(t.startsWith("Hello"));

        String[] words = t.split(" ");
        for (String w : words) {
            System.out.println(w);
        }
    }
}
```

## 🧠 Explanation

### `trim()`
Shuru aur end ke extra spaces hata deta hai.

### `substring(6) / substring(0, 5)`
`substring(start)` start se end tak deta hai. `substring(start, end)` me end index shamil nahi hota.

### `indexOf("Java")`
Text jahan pehli baar milta hai uska index deta hai, na mile to `-1`.

### `split(" ")`
String ko space par todkar `String[]` array deta hai.

## ▶️ Output

```text
20
Hello Java World
HELLO JAVA WORLD
hello java world
e
Java World
Hello
6
true
Hello Python World
true
Hello
Java
World
```

## 🔑 Important Points

- Ye saare methods naya string return karte hain, original nahi badalte.
- `charAt()` galat index par `StringIndexOutOfBoundsException` deta hai.
- `isEmpty()` aur `isBlank()` (Java 11+) me difference hai.
- `String.valueOf()` se number ko string banate hain.

## 📝 Practice

1. Sentence me words count karo.
2. String me vowels count karo.
3. String ke pehle letter ko capital karo.
4. `replace()` se saare spaces hata do.

## 🚀 Challenge

Sentence ke har word ka pehla letter capital karo. Input: `java is fun`

```text
Java Is Fun
```
