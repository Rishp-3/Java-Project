# finally in Java

## 📌 Topic
`finally` block hamesha chalta hai, chahe exception aaye ya na aaye. Isme aam taur par cleanup code (file/connection close) likhte hain.

## 🎯 What You Will Learn

- `finally` block ka use
- Exception ho ya na ho, finally chalta hai
- try-with-resources (Java 7+)

## 💻 Code

```java
public class Finally {

    static class Resource implements AutoCloseable {
        public void close() {
            System.out.println("Resource closed automatically");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Inside try");
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Inside catch");
        } finally {
            System.out.println("Inside finally");
        }

        try {
            System.out.println("No exception here");
        } finally {
            System.out.println("Finally still runs");
        }

        try (Resource r = new Resource()) {
            System.out.println("Using resource");
        }
    }
}
```

## 🧠 Explanation

### `finally`
Exception aaye ya nahi, ye block chalega hi. Sirf `System.exit()` ya JVM crash par nahi chalta.

### `try without catch`
`try` ke saath sirf `finally` bhi likh sakte ho.

### `try-with-resources`
`AutoCloseable` objects ko `try (...)` me banane par wo block ke baad automatically close ho jate hain. Alag `finally` nahi likhna padta.

## ▶️ Output

```text
Inside try
Inside catch
Inside finally
No exception here
Finally still runs
Using resource
Resource closed automatically
```

## 🔑 Important Points

- `finally` me `return` mat likho, ye exception ko chhupa deta hai.
- File, Scanner, DB connection `finally` ya try-with-resources se close karo.
- try-with-resources zyada safe aur short hai.

## 📝 Practice

1. File open karke `finally` me close karo.
2. `try` me `return` likho aur dekho `finally` chalta hai ya nahi.
3. try-with-resources se `Scanner` use karo.
4. Exception na aaye tab bhi `finally` ka output dekho.

## 🚀 Challenge

Program likho jisme `try` me `return` ho, phir bhi `finally` ka message print ho.
