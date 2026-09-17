# Variables in Java

## 📌 Topic

Variable Java me data/value ko temporarily store karne ke liye use hota hai.

Example:

```java
int age = 20;
```

Yahan:

* `int` → Data Type
* `age` → Variable Name
* `20` → Value

---

## 🎯 What You Will Learn

* Variable kya hota hai
* Variable declare kaise karte hain
* Variable initialize kaise karte hain
* Variable ko update kaise karte hain
* Multiple variables kaise banate hain
* Variable naming rules
* `final` variable
* Local variables ka basic concept

---

## 💻 Basic Example

```java
public class Variables {
    public static void main(String[] args) {

        int age = 20;
        String name = "Rishabh";
        double height = 5.8;
        boolean isStudent = true;

        System.out.println(name);
        System.out.println(age);
        System.out.println(height);
        System.out.println(isStudent);
    }
}
```

## 🧠 Explanation

### 1. Variable Declaration

Variable ko declare karne ka syntax:

```text
dataType variableName;
```

Example:

```java
int age;
```

---

### 2. Variable Initialization

Variable ko value dena initialization kehlata hai.

```java
int age = 20;
```

---

### 3. Variable Update

Variable ki value baad me change kar sakte hain.

```java
int age = 20;

age = 21;

System.out.println(age);
```

Output:

```text
21
```

---

## 📦 Multiple Variables

Ek hi program me multiple variables bana sakte hain:

```java
String name = "Rishabh";
int age = 20;
double marks = 85.5;
char grade = 'A';
boolean passed = true;
```

---

## 🔒 Final Variable

Agar kisi variable ki value change nahi karni hai to `final` use kar sakte hain.

```java
final double PI = 3.14159;
```

Ab:

```java
PI = 4.5;
```

❌ Ye allowed nahi hai.

---

## 📏 Variable Naming Rules

### ✅ Valid

```java
int age;
int studentAge;
int student_age;
int age2;
```

### ❌ Invalid

```java
int 2age;
int student-age;
int class;
```

### Important Rules

* Variable name number se start nahi ho sakta.
* Space allowed nahi hai.
* Special characters generally allowed nahi hain, except `_` and `$`.
* Java keywords ko variable name ke roop me use nahi kar sakte.
* Java variable names case-sensitive hote hain.

Example:

```java
int age = 20;
int Age = 25;
```

`age` aur `Age` **different variables** hain.

---

## 🖥️ Output

Example program ka output:

```text
Rishabh
20
5.8
true
```

---

## 📝 Practice Questions

### Beginner

1. Apna naam ek variable me store karo.
2. Apni age ek variable me store karo.
3. Apni height `double` me store karo.
4. Apne naam, age aur city ko variables me store karke print karo.

### Intermediate

5. Ek `marks` variable banao aur uski value update karo.
6. Do integer variables banao aur unka sum print karo.
7. `final` variable create karke print karo.
8. `age` aur `Age` variables bana kar difference observe karo.

### Challenge

Ek student ki following information variables me store karo:

```text
Name
Age
Roll Number
Percentage
Grade
Is Passed
```

Aur output ko properly format karke print karo.

Example:

```text
Name: Rishabh
Age: 20
Roll Number: 101
Percentage: 85.5
Grade: A
Passed: true
```

---

## 🔑 Key Takeaways

* Variable data/value store karta hai.
* Har variable ka ek data type hota hai.
* Variable ki value change ki ja sakti hai.
* `final` variable ki value change nahi ki ja sakti.
* Variable names Java ke naming rules follow karte hain.
* Java variables case-sensitive hote hain.
