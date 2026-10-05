# Input and Output in Java

## 📌 Topic
Java me user se input lene ke liye `Scanner` class use hoti hai, aur output dikhane ke liye `System.out` use hota hai.

## 🎯 What You Will Learn

- `Scanner` class ka use
- `nextInt()`, `nextDouble()`, `nextLine()`, `next()`, `nextBoolean()`
- `print()`, `println()` aur `printf()` ka difference
- Scanner ko close kaise karte hain

## 💻 Code

```java
import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter your height: ");
        double height = sc.nextDouble();

        System.out.print("Enter your grade: ");
        char grade = sc.next().charAt(0);

        System.out.print("Are you a student? ");
        boolean isStudent = sc.nextBoolean();

        System.out.println("\n----- Details -----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Grade: " + grade);
        System.out.println("Student: " + isStudent);

        sc.close();
    }
}
```

## 🧠 Explanation

### `import java.util.Scanner;`
Scanner class `java.util` package me hai, isliye import karna padta hai.

### `new Scanner(System.in)`
Keyboard se input padhne ke liye Scanner object banata hai.

### `sc.nextLine()`
Poori line (spaces ke saath) padhta hai.

### `sc.next().charAt(0)`
Ek word padhta hai aur uska pehla character leta hai. `char` input ka yahi tarika hai.

### `sc.close()`
Scanner band karta hai taaki resource free ho jaye.

## ⌨️ Sample Input

```text
Rishabh
20
5.8
A
true
```

## ▶️ Output

```text
Enter your name: Enter your age: Enter your height: Enter your grade: Are you a student? 
----- Details -----
Name: Rishabh
Age: 20
Height: 5.8
Grade: A
Student: true
```

## 🔑 Important Points

- `nextInt()` ke baad `nextLine()` use karoge to wo empty line padh leta hai. Pehle ek extra `sc.nextLine()` laga do.
- Java me `nextChar()` nahi hota.
- `println()` cursor agli line me le jata hai, `print()` nahi.
- `printf("%d", x)` se formatted output milta hai.

## 📝 Practice

1. Do numbers lekar unka sum print karo.
2. Apna full name (spaces ke saath) `nextLine()` se lo aur print karo.
3. Radius lekar circle ka area nikalo.
4. `printf` se price ko 2 decimal places me print karo.

## 🚀 Challenge

User se naam aur age lo, aur print karo: `Hello <name>, next year you will be <age+1>`.
