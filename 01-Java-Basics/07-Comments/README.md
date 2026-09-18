# Comments in Java

## 📌 Topic

**Comments** code ke andar likhe gaye notes ya explanations hote hain jo Java compiler execute nahi karta.

Comments ka main purpose code ko **understand, explain aur maintain** karna hota hai.

Example:

```java
// This is a comment
System.out.println("Hello World");
```

---

# 🎯 What You Will Learn

* Comments kya hote hain
* Single-line comments
* Multi-line comments
* Documentation comments
* Comments ka use
* Good commenting practices
* Comments ko temporarily code disable karne ke liye use karna
* Javadoc ka basic concept

---

# 1. Single-Line Comment

Single-line comment ke liye `//` use hota hai.

```java
// This is a single-line comment

System.out.println("Hello World");
```

`//` ke baad wali line compiler execute nahi karta.

---

## Example

```java
public class Comments {
    public static void main(String[] args) {

        // Store student's age
        int age = 20;

        System.out.println(age);
    }
}
```

---

# 2. Comment After Code

Comment ko same line par bhi likh sakte hain.

```java
int age = 20; // Student's age
```

Example:

```java
int a = 10; // First number
int b = 20; // Second number

System.out.println(a + b);
```

---

# 3. Multi-Line Comment

Multiple lines ka comment likhne ke liye:

```text
/*
   Comment
   Comment
   Comment
*/
```

Example:

```java
/*
 This program demonstrates
 how comments work in Java.
*/

public class Comments {
    public static void main(String[] args) {

        System.out.println("Hello World");
    }
}
```

---

# 4. Single-Line vs Multi-Line

### Single-Line

```java
// This is a comment
```

Ek line ke comment ke liye.

### Multi-Line

```java
/*
 This is a
 multi-line comment
*/
```

Multiple lines ke explanation ke liye.

---

# 5. Documentation Comment

Java me documentation ke liye `/** */` use hota hai.

Example:

```java
/**
 * This class demonstrates Java comments.
 */
public class Comments {

    /**
     * Main method of the program.
     */
    public static void main(String[] args) {

        System.out.println("Hello World");
    }
}
```

Is type ke comments ko **Javadoc comments** kaha jata hai.

---

# 6. Javadoc

Javadoc Java code ke documentation generate karne ke liye use hota hai.

Example:

```java
/**
 * Calculates the sum of two numbers.
 *
 * @param a first number
 * @param b second number
 * @return sum of a and b
 */
public static int add(int a, int b) {
    return a + b;
}
```

Yahan:

* `@param` → parameter explain karta hai
* `@return` → return value explain karta hai

---

# 7. Comments for Explanation

Comments ka use complex code explain karne ke liye kiya ja sakta hai.

```java
int marks = 85;

// Check whether the student passed
if (marks >= 40) {
    System.out.println("Passed");
}
```

Comment se immediately pata chal raha hai ki condition ka purpose kya hai.

---

# 8. Comments for Temporarily Disabling Code

Kabhi-kabhi testing ke time code ki kisi line ko temporarily disable karna hota hai.

```java
System.out.println("Line 1");

// System.out.println("Line 2");

System.out.println("Line 3");
```

Output:

```text
Line 1
Line 3
```

`Line 2` execute nahi hogi.

---

# 9. Multi-Line Code Disable Karna

```java
/*
System.out.println("Line 1");
System.out.println("Line 2");
System.out.println("Line 3");
*/

System.out.println("Program continues...");
```

Commented code execute nahi hoga.

---

# 10. Comments Do Not Affect Execution

Example:

```java
public class Comments {
    public static void main(String[] args) {

        // This line is ignored
        // int number = 100;

        int number = 50;

        System.out.println(number);
    }
}
```

Output:

```text
50
```

---

# 11. Good Comments

Good comment code ka **reason/purpose** explain karta hai.

```java
// Calculate final price after applying discount
double finalPrice = price - discount;
```

Ye useful comment hai.

---

# 12. Bad Comments

Aisa comment avoid karo jo code ko hi repeat kare.

```java
// Add 10 to number
number = number + 10;
```

Agar code already obvious hai, unnecessary comment ki zarurat nahi.

---

# 13. Comments vs Code

Comments:

```java
// Store user age
int age = 20;
```

Code:

```java
int age = 20;
```

Java sirf code execute karega.

Comment documentation/readability ke liye hai.

---

# 💻 Complete Example

```java
/**
 * Demonstrates different types of comments in Java.
 */
public class Comments {

    public static void main(String[] args) {

        // Student information
        String name = "Rishabh";
        int age = 20;

        /*
         * Calculate whether the student
         * is an adult or minor.
         */

        boolean isAdult = age >= 18;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Adult: " + isAdult);
    }
}
```

Output:

```text
Name: Rishabh
Age: 20
Adult: true
```

---

# 📝 Practice Questions

## Beginner

1. Ek single-line comment likho.
2. Ek multi-line comment likho.
3. Apne program ki har important line ko explain karo.
4. Kisi ek statement ko comment karke output observe karo.

## Intermediate

5. Ek program banao jo student ki details print kare aur useful comments add karo.
6. Ek calculator program me har operation ka purpose comment karo.
7. Kuch code ko multi-line comment ke andar rakh kar execute karo.

## Advanced

8. Ek method banao aur uske liye Javadoc comment likho.
9. `@param` aur `@return` ka use karo.
10. Apne kisi existing Java program ko properly document karo.

---

# 🚀 Challenge

Ek program banao jo student ki information calculate kare.

Program me:

* Single-line comments
* Multi-line comments
* Javadoc comments

teeno ka use karo.

Example:

```java
/**
 * Student result calculation program.
 */
public class StudentResult {

    public static void main(String[] args) {

        // Student marks
        int marks = 85;

        /*
         * Check whether the student
         * has passed the examination.
         */

        boolean passed = marks >= 40;

        System.out.println("Marks: " + marks);
        System.out.println("Passed: " + passed);
    }
}
```

---

# ⚠️ Common Mistakes

### 1. Comment close na karna

❌ Incorrect:

```java
/*
This is a comment
```

✅ Correct:

```java
/*
This is a comment
*/
```

### 2. Important code ko unnecessary comments se fill karna

Har obvious line par comment likhne ki zarurat nahi hoti.

### 3. Outdated comments

Agar code change ho gaya hai to uska old comment bhi update karo.

---

# 🔑 Key Takeaways

* `//` → Single-line comment
* `/* */` → Multi-line comment
* `/** */` → Documentation/Javadoc comment
* Comments compiler execute nahi karta.
* Comments code explain aur document karne ke liye use hote hain.
* Comments ka use temporarily code disable karne ke liye bhi ho sakta hai.
* Good comments **why** explain karte hain, sirf **what** nahi.

## 🚀 Next Topic

**02-Control-Flow → 01-if-else**

Yahan se Java me **decision making** start hogi.
