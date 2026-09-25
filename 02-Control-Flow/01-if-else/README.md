# If-Else in Java

## 📌 Topic

`if-else` Java me **decision making** ke liye use hota hai.

Program kisi condition ko check karta hai:

* Condition `true` → `if` block execute
* Condition `false` → `else` block execute

Example:

```java
int age = 20;

if (age >= 18) {
    System.out.println("Adult");
} else {
    System.out.println("Minor");
}
```

Output:

```text
Adult
```

---

# 🎯 What You Will Learn

* `if` statement
* `if-else`
* `else-if`
* Multiple conditions
* Nested `if`
* Comparison operators ke saath conditions
* Logical operators ke saath conditions
* User input ke saath `if-else`
* Ternary operator se comparison
* Common mistakes

---

# 1. if Statement

### Syntax

```java
if (condition) {
    // code
}
```

Example:

```java
int age = 20;

if (age >= 18) {
    System.out.println("You are an adult");
}
```

Output:

```text
You are an adult
```

Agar condition `false` hoti hai, to `if` ke andar ka code execute nahi hota.

---

# 2. if-else Statement

### Syntax

```java
if (condition) {
    // condition true
} else {
    // condition false
}
```

Example:

```java
int age = 16;

if (age >= 18) {
    System.out.println("Adult");
} else {
    System.out.println("Minor");
}
```

Output:

```text
Minor
```

---

# 3. Check Even or Odd

```java
int number = 10;

if (number % 2 == 0) {
    System.out.println("Even");
} else {
    System.out.println("Odd");
}
```

Output:

```text
Even
```

### Logic

```text
number % 2 == 0
```

Agar remainder `0` hai → Even.

Otherwise → Odd.

---

# 4. Positive or Negative

```java
int number = -10;

if (number >= 0) {
    System.out.println("Positive");
} else {
    System.out.println("Negative");
}
```

Output:

```text
Negative
```

⚠️ Is example me `0` ko positive treat kiya gaya hai. Zero ko separately handle karna ho to `else-if` use karo.

---

# 5. Positive, Negative or Zero

```java
int number = 0;

if (number > 0) {
    System.out.println("Positive");
} else if (number < 0) {
    System.out.println("Negative");
} else {
    System.out.println("Zero");
}
```

Output:

```text
Zero
```

---

# 6. else-if

Jab multiple conditions check karni ho tab `else-if` use hota hai.

### Syntax

```java
if (condition1) {

} else if (condition2) {

} else if (condition3) {

} else {

}
```

Example:

```java
int marks = 75;

if (marks >= 90) {
    System.out.println("A+");
} else if (marks >= 80) {
    System.out.println("A");
} else if (marks >= 70) {
    System.out.println("B");
} else if (marks >= 60) {
    System.out.println("C");
} else {
    System.out.println("Fail");
}
```

Output:

```text
B
```

---

# 7. Multiple Conditions

Logical operators ke saath multiple conditions combine kar sakte ho.

## AND `&&`

```java
int age = 25;

if (age >= 18 && age <= 60) {
    System.out.println("Eligible");
} else {
    System.out.println("Not Eligible");
}
```

Output:

```text
Eligible
```

---

## OR `||`

```java
int day = 7;

if (day == 6 || day == 7) {
    System.out.println("Weekend");
} else {
    System.out.println("Weekday");
}
```

Output:

```text
Weekend
```

---

# 8. Nested if

Ek `if` ke andar doosra `if` ho to use **Nested if** kehte hain.

Example:

```java
int age = 20;
boolean hasLicense = true;

if (age >= 18) {

    if (hasLicense) {
        System.out.println("You can drive");
    } else {
        System.out.println("You need a license");
    }

} else {
    System.out.println("You are underage");
}
```

Output:

```text
You can drive
```

---

# 9. User Input with if-else

`Scanner` ke saath `if-else` ka use:

```java
import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        if (age >= 18) {
            System.out.println("You are eligible to vote");
        } else {
            System.out.println("You are not eligible to vote");
        }

        sc.close();
    }
}
```

Input:

```text
Enter your age: 20
```

Output:

```text
You are eligible to vote
```

---

# 10. Largest of Two Numbers

```java
int a = 20;
int b = 15;

if (a > b) {
    System.out.println("A is greater");
} else if (b > a) {
    System.out.println("B is greater");
} else {
    System.out.println("Both are equal");
}
```

Output:

```text
A is greater
```

---

# 11. Largest of Three Numbers

```java
int a = 10;
int b = 25;
int c = 15;

if (a >= b && a >= c) {
    System.out.println("A is largest");
} else if (b >= a && b >= c) {
    System.out.println("B is largest");
} else {
    System.out.println("C is largest");
}
```

Output:

```text
B is largest
```

---

# 12. Check Password

```java
String password = "java123";

if (password.equals("java123")) {
    System.out.println("Login successful");
} else {
    System.out.println("Invalid password");
}
```

Output:

```text
Login successful
```

### ⚠️ String Comparison

Strings ko compare karne ke liye generally:

```java
password.equals("java123")
```

use karo.

Ye avoid karo:

```java
password == "java123"
```

---

# 13. Ternary vs if-else

Simple condition:

```java
int age = 20;

String result = age >= 18 ? "Adult" : "Minor";
```

Same logic `if-else` se:

```java
String result;

if (age >= 18) {
    result = "Adult";
} else {
    result = "Minor";
}
```

Ternary short conditions ke liye useful hai; complex logic ke liye `if-else` generally clearer hota hai.

---

# 💻 Complete Example

```java
import java.util.Scanner;

public class IfElse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your marks: ");
        int marks = sc.nextInt();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks");

        } else if (marks >= 90) {
            System.out.println("Grade: A+");

        } else if (marks >= 80) {
            System.out.println("Grade: A");

        } else if (marks >= 70) {
            System.out.println("Grade: B");

        } else if (marks >= 60) {
            System.out.println("Grade: C");

        } else if (marks >= 40) {
            System.out.println("Grade: D");

        } else {
            System.out.println("Grade: F - Fail");
        }

        sc.close();
    }
}
```

### Input

```text
Enter your marks: 85
```

### Output

```text
Grade: A
```

---

# 📝 Practice Questions

## Beginner

1. Check karo number positive hai ya negative.
2. Check karo number even hai ya odd.
3. Check karo age 18+ hai ya nahi.
4. Do numbers me larger number find karo.
5. Check karo number zero hai ya nahi.

## Intermediate

6. Three numbers me largest number find karo.
7. Marks ke basis par grade print karo.
8. Check karo year leap year hai ya nahi.
9. Check karo person voting ke liye eligible hai ya nahi.
10. Password correct hai ya nahi check karo.

## Advanced

11. Teen sides se check karo triangle valid hai ya nahi.
12. Electricity units ke basis par bill calculate karo.
13. Salary ke basis par bonus calculate karo.
14. Shopping amount ke basis par discount calculate karo.
15. Age aur license ke basis par driving eligibility check karo.

---

# 🚀 Challenge 1 — Student Grade

User se marks input lo:

```text
Enter marks: 85
```

Expected:

```text
Marks: 85
Grade: A
Result: Pass
```

Rules:

```text
90-100 → A+
80-89  → A
70-79  → B
60-69  → C
40-59  → D
0-39   → F
```

Invalid input:

```text
< 0 or > 100
```

Output:

```text
Invalid marks
```

---

# 🚀 Challenge 2 — Login System

User se username aur password input lo.

Correct credentials hone par:

```text
Login Successful
Welcome!
```

Otherwise:

```text
Invalid Username or Password
```

---

# 🚀 Challenge 3 — Calculator

User se:

```text
First number
Second number
Operator
```

input lo.

Operators:

```text
+
-
*
/
%
```

Example:

```text
Enter first number: 20
Enter second number: 5
Enter operator: *
```

Output:

```text
Result: 100
```

---

# ⚠️ Common Mistakes

### 1. Condition ke baad semicolon

❌ Wrong:

```java
if (age >= 18);
{
    System.out.println("Adult");
}
```

✅ Correct:

```java
if (age >= 18) {
    System.out.println("Adult");
}
```

---

### 2. `=` aur `==` confuse karna

Assignment:

```java
age = 18;
```

Comparison:

```java
age == 18
```

---

### 3. String ko `==` se compare karna

❌ Avoid:

```java
if (name == "Rishabh")
```

✅ Use:

```java
if (name.equals("Rishabh"))
```

---

# 🔑 Key Takeaways

* `if` → ek condition check karta hai.
* `if-else` → true/false dono cases handle karta hai.
* `else-if` → multiple conditions check karta hai.
* `nested if` → ek `if` ke andar doosra `if`.
* `&&` → AND
* `||` → OR
* `!` → NOT
* Strings compare karne ke liye `.equals()` use karo.
* Conditions ka result `true` ya `false` hota hai.

## 🚀 Next Topic

**02-Control-Flow → 02-nested-if**

Isme hum **Nested If** ko deeply practice karenge.
