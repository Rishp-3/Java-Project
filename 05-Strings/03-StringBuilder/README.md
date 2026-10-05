# StringBuilder in Java

## 📌 Topic
`StringBuilder` mutable (changeable) string class hai. Jahan string baar-baar badalni ho wahan ye `String` se bahut fast hai.

## 🎯 What You Will Learn

- StringBuilder kya hai aur kyu use karte hain
- `append()`, `insert()`, `delete()`, `reverse()`, `replace()`
- String vs StringBuilder performance

## 💻 Code

```java
public class Stringbuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");

        sb.append(" World");
        System.out.println(sb);

        sb.insert(5, ",");
        System.out.println(sb);

        sb.replace(0, 5, "Hi");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        sb.reverse();
        sb.delete(2, 3);
        System.out.println(sb);

        System.out.println("Length: " + sb.length());
        String result = sb.toString();
        System.out.println(result.toUpperCase());
    }
}
```

## 🧠 Explanation

### `append()`
End me text jodta hai aur usi object ko badalta hai (naya object nahi banata).

### `insert(5, ",")`
Given index par text daalta hai.

### `reverse()`
String ko ulta kar deta hai. Palindrome problems me kaam aata hai.

### `toString()`
StringBuilder ko normal `String` me badalta hai.

## ▶️ Output

```text
Hello World
Hello, World
Hi, World
dlroW ,iH
Hi World
Length: 8
HI WORLD
```

## 🔑 Important Points

- `StringBuilder` thread-safe nahi hai, par fast hai.
- Loop me string concatenation (`s += x`) ke bajaye `StringBuilder` use karo.
- `StringBuilder` par `equals()` content compare nahi karta.
- Capacity default 16 hoti hai aur zaroorat par badhti hai.

## 📝 Practice

1. Loop me 1 se 10 numbers StringBuilder me jodke print karo.
2. String ko `reverse()` se ulta karo.
3. StringBuilder me ek character delete karo.
4. `String +=` aur `StringBuilder` ka time compare karo (1 lakh iterations).

## 🚀 Challenge

`StringBuilder` se check karo ki `madam` palindrome hai ya nahi.

```text
madam is palindrome
```
