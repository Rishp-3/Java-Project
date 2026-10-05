# throw in Java

## 📌 Topic
`throw` keyword se hum khud se exception object banake throw kar sakte hain, jab koi galat condition ho.

## 🎯 What You Will Learn

- `throw` ka use
- Built-in exception throw karna
- `throw` aur `throws` me difference
- Validation me exception ka use

## 💻 Code

```java
public class Throw {

    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }
        System.out.println("Access granted");
    }

    public static void main(String[] args) {
        try {
            checkAge(25);
            checkAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
```

## 🧠 Explanation

### `throw new IllegalArgumentException(...)`
Exception ka naya object banake use turant throw karta hai. Method wahin ruk jata hai.

### `catch`
Throw ki gayi exception ko caller me `catch` se pakadte hain.

## ▶️ Output

```text
Access granted
Caught: Age must be 18 or above
```

## 🔑 Important Points

- `throw` method ke andar hota hai, `throws` method ke signature me.
- `throw` ek time par ek hi exception throw karta hai.
- `throw` ke baad ka code unreachable hota hai.
- Unchecked exceptions (`RuntimeException`) ko `throws` likhna zaroori nahi.

## 📝 Practice

1. Negative amount par `IllegalArgumentException` throw karo.
2. Empty string par exception throw karo.
3. Balance kam hone par `RuntimeException` throw karo.
4. `throw` ko `finally` ke saath use karo.

## 🚀 Challenge

`withdraw(balance, amount)` method banao jo amount balance se zyada ho to exception throw kare.
