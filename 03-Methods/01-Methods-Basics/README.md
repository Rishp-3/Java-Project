# Methods in Java

## 📌 Topic
Method code ka ek reusable block hota hai jo ek specific kaam karta hai. Ek baar likho, kai baar use karo.

## 🎯 What You Will Learn

- Method kya hota hai aur kyu use karte hain
- Method declare aur call karna
- `static` aur non-static method ka basic idea
- `void` method

## 💻 Code

```java
public class MethodsBasics {

    static void greet() {
        System.out.println("Hello, welcome to Java!");
    }

    static void printLine() {
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        printLine();
        greet();
        printLine();
        greet();
    }
}
```

## 🧠 Explanation

### `static void greet()`
`static` = bina object banaye call ho sakta hai, `void` = kuch return nahi karta, `greet` = method ka naam.

### `greet();`
Method call karna. Yahan control method ke andar jata hai, kaam karta hai aur wapas aa jata hai.

### `main()`
Ye bhi ek method hai jisko JVM sabse pehle call karta hai.

## ▶️ Output

```text
--------------------
Hello, welcome to Java!
--------------------
Hello, welcome to Java!
```

## 🔑 Important Points

- Method ko class ke andar, par kisi dusre method ke bahar likhte hain.
- Same code baar-baar likhne se behtar hai method banana (DRY principle).
- Method ka naam verb se start karo: `calculateSum`, `printReport`.
- Method tab tak nahi chalta jab tak use call na kiya jaye.

## 📝 Practice

1. Apna naam print karne wala method banao aur 3 baar call karo.
2. Ek method banao jo 1 se 10 tak numbers print kare.
3. Menu print karne ka method banao.
4. Ek method ke andar se doosra method call karo.

## 🚀 Challenge

Ek `drawStars()` method banao jo 5 stars (`*****`) print kare, aur use 3 baar call karo.

```text
*****
*****
*****
```
