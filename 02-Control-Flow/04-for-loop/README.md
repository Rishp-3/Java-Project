# for Loop in Java

## 📌 Topic
`for` loop tab use hota hai jab pata ho ki code kitni baar repeat karna hai.

## 🎯 What You Will Learn

- `for` loop ka syntax
- Counting, even numbers aur table banana
- Loop ke 3 parts: initialization, condition, update

## 💻 Code

```java
import java.util.Scanner;

public class ForLoop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("\nNumbers from 1 to " + number + ":");

        for (int i = 1; i <= number; i++) {
            System.out.println(i);
        }

        System.out.println("\nEven numbers:");

        for (int i = 2; i <= number; i += 2) {
            System.out.println(i);
        }

        System.out.println("\nMultiplication Table:");

        for (int i = 1; i <= 10; i++) {
            System.out.println(
                number + " x " + i + " = " + (number * i)
            );
        }

        sc.close();
    }
}
```

## 🧠 Explanation

### `int i = 1`
Initialization: loop shuru hone se pehle sirf ek baar chalta hai.

### `i <= number`
Condition: har iteration se pehle check hoti hai. False hote hi loop ruk jata hai.

### `i++`
Update: har iteration ke baad chalta hai.

### `i += 2`
Counter ko 2 se badhata hai, isse sirf even numbers milte hain.

## ⌨️ Sample Input

```text
5
```

## ▶️ Output

```text
Enter a number: 
Numbers from 1 to 5:
1
2
3
4
5

Even numbers:
2
4

Multiplication Table:
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
5 x 4 = 20
5 x 5 = 25
5 x 6 = 30
5 x 7 = 35
5 x 8 = 40
5 x 9 = 45
5 x 10 = 50
```

## 🔑 Important Points

- `for(;;)` infinite loop hota hai.
- Variable `i` sirf loop ke andar available hota hai (scope).
- Array traverse karne ke liye `for` best hai.
- Enhanced for: `for (int x : arr)`.

## 📝 Practice

1. 1 se 100 tak ka sum nikalo.
2. Kisi number ka factorial nikalo.
3. Number ka reverse `for`/`while` se print karo.
4. Neeche diya hua star pattern print karo: `*`, `**`, `***`.

## 🚀 Challenge

Fibonacci series ke pehle 10 numbers `for` loop se print karo.

```text
0 1 1 2 3 5 8 13 21 34
```
