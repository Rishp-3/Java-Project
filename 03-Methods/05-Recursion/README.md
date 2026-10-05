# Recursion in Java

## 📌 Topic
Jab koi method khud ko hi call karta hai to use Recursion kehte hain. Bade problem ko chhote problems me todne ke kaam aata hai.

## 🎯 What You Will Learn

- Recursion kya hai
- Base case aur recursive case
- Factorial aur Fibonacci recursion se
- StackOverflowError kab aata hai

## 💻 Code

```java
public class Recursion {

    static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static void countDown(int n) {
        if (n == 0) {
            System.out.println("Go!");
            return;
        }
        System.out.println(n);
        countDown(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("5! = " + factorial(5));
        System.out.println("fib(7) = " + fibonacci(7));
        countDown(3);
    }
}
```

## 🧠 Explanation

### `Base case`
Wo condition jahan recursion rukta hai (`n == 0`). Iske bina method hamesha khud ko call karta rahega.

### `Recursive case`
`n * factorial(n - 1)` me problem chhoti hoti jati hai jab tak base case na aa jaye.

### `Call stack`
Har call stack me ek frame banata hai. Bahut zyada depth par `StackOverflowError` aata hai.

## ▶️ Output

```text
5! = 120
fib(7) = 13
3
2
1
Go!
```

## 🔑 Important Points

- Har recursive method me base case hona zaroori hai.
- Har call me problem base case ke kareeb honi chahiye.
- Simple Fibonacci recursion slow hota hai (exponential time).
- Recursion ka kaam loop se bhi ho sakta hai, par trees aur backtracking me recursion natural hai.

## 📝 Practice

1. `1 + 2 + ... + n` ka sum recursion se nikalo.
2. Number ke digits ka sum recursion se nikalo.
3. String ko recursion se reverse karo.
4. `power(base, exp)` recursion se banao.

## 🚀 Challenge

Recursion se kisi number ko binary me convert karke print karo. Example: `10` ka output `1010`.

```text
1010
```
