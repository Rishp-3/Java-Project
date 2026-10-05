# try-catch in Java

## 📌 Topic
Exception ek runtime error hai jo program ko beech me crash kar deta hai. `try-catch` se hum use handle karke program ko chalu rakh sakte hain.

## 🎯 What You Will Learn

- Exception kya hota hai
- `try` aur `catch` block
- Exception ka message print karna
- Exception ke baad bhi program chalana

## 💻 Code

```java
public class TryCatch {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            int result = a / b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues...");
    }
}
```

## 🧠 Explanation

### `try { ... }`
Risky code yahan likhte hain.

### `catch (ArithmeticException e)`
Exception aane par ye block chalta hai. `e` me exception ki details hoti hain.

### `e.getMessage()`
Exception ka short message deta hai.

## ▶️ Output

```text
Error: / by zero
Program continues...
```

## 🔑 Important Points

- Exception aate hi `try` ka baaki code skip ho jata hai.
- Bina handle kiye exception aaye to program crash ho jata hai.
- `try` ke saath kam se kam ek `catch` ya `finally` hona zaroori hai.
- `e.printStackTrace()` poori detail print karta hai (debugging ke liye).

## 📝 Practice

1. Array ka galat index access karke `ArrayIndexOutOfBoundsException` pakdo.
2. `Integer.parseInt("abc")` ka exception pakdo.
3. `null` string par `length()` call karke exception pakdo.
4. User se divisor lo aur zero hone par safe message do.

## 🚀 Challenge

User se do numbers lo aur divide karo. Divisor 0 ho to `Cannot divide by zero` print karo.
