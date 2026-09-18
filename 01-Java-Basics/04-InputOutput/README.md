# Input and Output in Java

## 📌 Topic

Java program me **Output** ka matlab hai program se result display karna, aur **Input** ka matlab hai user se data lena.

Java me console input lene ke liye commonly `Scanner` class ka use kiya jata hai.

---

## 🎯 What You Will Learn

* Output kya hota hai
* `System.out.print()`
* `System.out.println()`
* `System.out.printf()`
* Input kya hota hai
* `Scanner` class
* Integer input
* Decimal input
* String input
* Character input
* Boolean input
* Multiple inputs lena

---

# 1. Output in Java

Java me output display karne ke liye `System.out` ka use hota hai.

## `System.out.println()`

Ye output print karta hai aur uske baad **new line** me chala jata hai.

```java
System.out.println("Hello World");
System.out.println("I am learning Java");
```

### Output

```text
Hello World
I am learning Java
```

---

# 2. System.out.print()

`print()` output print karta hai lekin new line me nahi jata.

```java
System.out.print("Hello ");
System.out.print("World");
```

### Output

```text
Hello World
```

---

# 3. print() vs println()

```java
System.out.print("Hello");
System.out.print("World");
```

Output:

```text
HelloWorld
```

Lekin:

```java
System.out.println("Hello");
System.out.println("World");
```

Output:

```text
Hello
World
```

---

# 4. printf()

`printf()` ka use formatted output ke liye hota hai.

```java
String name = "Rishabh";
int age = 20;

System.out.printf("Name: %s, Age: %d", name, age);
```

Output:

```text
Name: Rishabh, Age: 20
```

Common format specifiers:

| Specifier | Use       |
| --------- | --------- |
| `%d`      | Integer   |
| `%f`      | Decimal   |
| `%s`      | String    |
| `%c`      | Character |
| `%b`      | Boolean   |

Example:

```java
int age = 20;
double marks = 85.5;
char grade = 'A';

System.out.printf("Age: %d%n", age);
System.out.printf("Marks: %.2f%n", marks);
System.out.printf("Grade: %c%n", grade);
```

---

# 5. Input in Java

User se input lene ke liye `Scanner` class use kar sakte hain.

Sabse pehle import karo:

```java
import java.util.Scanner;
```

Scanner object:

```java
Scanner sc = new Scanner(System.in);
```

---

# 6. Integer Input

```java
import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.println("Your age is: " + age);

        sc.close();
    }
}
```

Example:

```text
Enter your age: 20
Your age is: 20
```

---

# 7. String Input

## `next()`

Ek word read karta hai.

```java
System.out.print("Enter your name: ");
String name = sc.next();

System.out.println("Name: " + name);
```

Agar input:

```text
Rishabh Pal
```

to `next()` sirf:

```text
Rishabh
```

read karega.

---

# 8. Full Line Input

Multiple words ya complete line ke liye `nextLine()` use karo.

```java
System.out.print("Enter your full name: ");
String name = sc.nextLine();

System.out.println("Name: " + name);
```

Input:

```text
Rishabh Pal
```

Output:

```text
Name: Rishabh Pal
```

---

# 9. Decimal Input

`double` ke liye:

```java
System.out.print("Enter your percentage: ");
double percentage = sc.nextDouble();

System.out.println("Percentage: " + percentage);
```

---

# 10. Float Input

```java
System.out.print("Enter your height: ");
float height = sc.nextFloat();

System.out.println("Height: " + height);
```

---

# 11. Character Input

Scanner me direct `nextChar()` method nahi hota.

Isliye:

```java
System.out.print("Enter your grade: ");
char grade = sc.next().charAt(0);

System.out.println("Grade: " + grade);
```

Input:

```text
A
```

Output:

```text
Grade: A
```

---

# 12. Boolean Input

```java
System.out.print("Are you a student? ");
boolean isStudent = sc.nextBoolean();

System.out.println("Student: " + isStudent);
```

Input:

```text
true
```

Output:

```text
Student: true
```

---

# 13. Multiple Inputs

```java
import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter your percentage: ");
        double percentage = sc.nextDouble();

        System.out.print("Enter your grade: ");
        char grade = sc.next().charAt(0);

        System.out.println();
        System.out.println("----- Student Details -----");

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Percentage: " + percentage);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
```

---

# ⚠️ Important: nextInt() + nextLine()

Ye Java beginners ke liye important problem hai.

Example:

```java
int age = sc.nextInt();
String name = sc.nextLine();
```

`nextInt()` ke baad `nextLine()` unexpected empty input le sakta hai.

Solution:

```java
int age = sc.nextInt();
sc.nextLine();

String name = sc.nextLine();
```

---

# 🧠 Common Scanner Methods

| Method             | Input         |
| ------------------ | ------------- |
| `nextInt()`        | Integer       |
| `nextLong()`       | Long          |
| `nextFloat()`      | Float         |
| `nextDouble()`     | Double        |
| `nextBoolean()`    | Boolean       |
| `next()`           | One word      |
| `nextLine()`       | Complete line |
| `next().charAt(0)` | Character     |

---

# 💻 Complete Example

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

---

# 📝 Practice Questions

### Beginner

1. User se naam input lekar print karo.
2. User se age input lekar print karo.
3. User se do numbers lekar unka sum print karo.
4. User se height lekar print karo.
5. User se grade lekar print karo.

### Intermediate

6. User se do numbers lekar:

   * Sum
   * Difference
   * Multiplication
   * Division

   calculate karo.

7. User se naam aur age lekar formatted output print karo.

8. User se 3 subjects ke marks input lekar total aur percentage calculate karo.

---

# 🚀 Mini Challenge

User se following information input lo:

```text
Name
Age
Roll Number
Height
Percentage
Grade
Is Student
```

Aur output:

```text
===== Student Details =====

Name: Rishabh
Age: 20
Roll Number: 101
Height: 5.8
Percentage: 85.75
Grade: A
Student: true
```

---

# 🔑 Key Takeaways

* `System.out.println()` → output + new line
* `System.out.print()` → output without new line
* `System.out.printf()` → formatted output
* `Scanner` → user input ke liye
* `nextInt()` → integer
* `nextDouble()` → decimal
* `next()` → single word
* `nextLine()` → complete line
* `next().charAt(0)` → character
* Input complete hone ke baad `sc.close()` karna good practice hai.