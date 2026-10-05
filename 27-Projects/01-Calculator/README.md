# Calculator Project

## 📌 Topic
Ek simple console Calculator jisme methods, switch aur exception handling ka use hota hai.

## 🎯 What You Will Learn

- Methods se logic alag karna
- `switch` se operation chunna
- Divide by zero handle karna
- Reusable `calculate()` method

## 💻 Code

```java
public class Calculator {

    static double calculate(double a, double b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new ArithmeticException("Cannot divide by zero");
                return a / b;
            case '%': return a % b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }

    public static void main(String[] args) {
        double[][] inputs = {{10, 5}, {7, 2}, {9, 0}, {20, 3}};
        char[] ops = {'+', '*', '/', '%'};

        for (int i = 0; i < inputs.length; i++) {
            double a = inputs[i][0], b = inputs[i][1];
            try {
                System.out.println(a + " " + ops[i] + " " + b + " = " + calculate(a, b, ops[i]));
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        try {
            calculate(1, 2, '^');
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

> 💡 Note: Is project me demo ke liye values code me hi di gayi hain taaki output hamesha same aaye. Project ko aage `Scanner` se menu-driven banana tumhara practice task hai.

## 🧠 Explanation

### `calculate()`
Saara logic ek jagah. UI (input/output) aur logic alag rehte hain.

### `throw`
Galat situation (zero se divide, galat operator) par exception throw hoti hai.

### `try-catch in main`
Exception pakadkar program crash hone se bachaya gaya hai.

## ▶️ Output

```text
10.0 + 5.0 = 15.0
7.0 * 2.0 = 14.0
Error: Cannot divide by zero
20.0 % 3.0 = 2.0
Error: Invalid operator: ^
```

## 🔑 Important Points

- Logic aur input/output ko alag rakhna achhi practice hai.
- `%` double par bhi chalta hai.
- Real calculator me `BigDecimal` precision ke liye use hota hai.

## 📝 Practice

1. `Scanner` se input lekar menu-driven banao.
2. Power (`^`) aur square root jodo.
3. History (`ArrayList`) rakho.
4. Loop me chalao jab tak user exit na kare.

## 🚀 Challenge

Calculator me `Scanner` se continuous input lo aur `exit` likhne par band karo.
