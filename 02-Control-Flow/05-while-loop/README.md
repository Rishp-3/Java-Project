# while Loop in Java

## 📌 Topic
`while` loop tab use hota hai jab repeat karne ki sankhya pehle se pata na ho, bas condition true rahe tab tak chalna ho.

## 🎯 What You Will Learn

- `while` loop ka syntax
- Digits ka sum nikalna
- Infinite loop se kaise bachein

## 💻 Code

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int number = sc.nextInt();

        int sum = 0;

        while (number != 0) {

            int digit = number % 10;

            sum += digit;

            number /= 10;
        }

        System.out.println("Sum of digits = " + sum);

        sc.close();
    }
}
```

## 🧠 Explanation

### `while (number != 0)`
Condition loop se pehle check hoti hai. Shuru me hi false ho to loop ek baar bhi nahi chalta.

### `number % 10`
Last digit nikalta hai.

### `number /= 10`
Last digit hata deta hai (`1234` -> `123`).

### `sum += digit`
Har digit ko sum me add karta hai.

## ⌨️ Sample Input

```text
1234
```

## ▶️ Output

```text
Enter a positive number: Sum of digits = 10
```

## 🔑 Important Points

- Loop ke andar variable update karna zaroori hai, warna infinite loop ban jata hai.
- `while(true)` ko `break` se rok sakte ho.
- Jab iteration count pata ho to `for` behtar hai.

## 📝 Practice

1. Number ke digits count karo.
2. Number ka reverse nikalo.
3. Number palindrome hai ya nahi check karo.
4. Number ke 1 se 10 tak ka table print karo.

## 🚀 Challenge

Armstrong number check karo. (Example: `153 = 1^3 + 5^3 + 3^3`)
