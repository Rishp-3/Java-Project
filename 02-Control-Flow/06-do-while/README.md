# do-while Loop in Java

## 📌 Topic
`do-while` loop me code pehle ek baar chalta hai, aur condition baad me check hoti hai. Isliye ye kam se kam ek baar zaroor chalta hai.

## 🎯 What You Will Learn

- `do-while` ka syntax
- Menu-driven program banana
- `while` aur `do-while` me difference

## 💻 Code

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- Calculator ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice >= 1 && choice <= 3) {

                System.out.print("Enter first number: ");
                double a = sc.nextDouble();

                System.out.print("Enter second number: ");
                double b = sc.nextDouble();

                switch (choice) {

                    case 1:
                        System.out.println("Result = " + (a + b));
                        break;

                    case 2:
                        System.out.println("Result = " + (a - b));
                        break;

                    case 3:
                        System.out.println("Result = " + (a * b));
                        break;
                }
            }

        } while (choice != 4);

        System.out.println("Calculator closed.");

        sc.close();
    }
}
```

## 🧠 Explanation

### `do { ... }`
Block pehle chalta hai, chahe condition kuch bhi ho.

### `while (choice != 4);`
Block ke baad condition check hoti hai. Iske end me `;` lagana zaroori hai.

### `switch inside loop`
Har baar user ki choice ke hisab se operation chalta hai jab tak `4` (Exit) na chuna jaye.

## ⌨️ Sample Input

```text
1
10
5
3
2
4
4
```

## ▶️ Output

```text

--- Calculator ---
1. Addition
2. Subtraction
3. Multiplication
4. Exit
Enter choice: Enter first number: Enter second number: Result = 15.0

--- Calculator ---
1. Addition
2. Subtraction
3. Multiplication
4. Exit
Enter choice: Enter first number: Enter second number: Result = 8.0

--- Calculator ---
1. Addition
2. Subtraction
3. Multiplication
4. Exit
Enter choice: Calculator closed.
```

## 🔑 Important Points

- Menu aur input validation ke liye best loop hai.
- `while` pehle check karta hai, `do-while` baad me.
- `while (...)` ke baad semicolon na bhoolo.

## 📝 Practice

1. Jab tak user sahi password na dale, poochte raho.
2. User jab tak `0` na dale, numbers ka sum karo.
3. Number guessing game banao.
4. ATM style menu banao.

## 🚀 Challenge

User se 1 se 10 ke beech ka number maango. Galat number par dobara poochho, sahi number aane par `Valid number` print karo.
