# switch in Java

## 📌 Topic
`switch` ek variable ki value ko multiple cases se compare karta hai. Jab bahut saari fixed options hon to if-else se behtar hota hai.

## 🎯 What You Will Learn

- `switch`, `case`, `break`, `default` ka use
- Menu-driven program banana
- `break` bhoolne par kya hota hai (fall-through)

## 💻 Code

```java
import java.util.Scanner;

public class Switch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== MENU =====");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Addition selected");
                break;

            case 2:
                System.out.println("Subtraction selected");
                break;

            case 3:
                System.out.println("Multiplication selected");
                break;

            case 4:
                System.out.println("Division selected");
                break;

            case 5:
                System.out.println("Goodbye!");
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}
```

## 🧠 Explanation

### `switch (choice)`
`choice` ki value ko har `case` se match kiya jata hai.

### `case 1:`
Value match hone par ye block chalta hai.

### `break;`
Switch se bahar nikalta hai. Iske bina agle cases bhi chal jate hain.

### `default:`
Koi bhi case match na ho to chalta hai.

## ⌨️ Sample Input

```text
3
```

## ▶️ Output

```text
===== MENU =====
1. Add
2. Subtract
3. Multiply
4. Divide
5. Exit
Enter your choice: Multiplication selected
```

## 🔑 Important Points

- `switch` me `int`, `char`, `String` aur `enum` use kar sakte ho.
- `long`, `double`, `boolean` allowed nahi hain.
- `break` na lagao to fall-through hota hai.
- Java 14+ me `case 1 -> ...` (arrow syntax) bhi hai.

## 📝 Practice

1. Number (1-7) se din ka naam print karo.
2. Char lekar vowel/consonant switch se check karo.
3. Month number se days batao.
4. `break` hata kar fall-through ka output dekho.

## 🚀 Challenge

Calculator banao: do numbers aur operator (`+ - * /`) lo, aur `switch` se result print karo.
