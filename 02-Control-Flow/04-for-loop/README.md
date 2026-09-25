# For Loop in Java

## 📌 Topic

`for` loop ka use kisi code ko **multiple times repeat** karne ke liye hota hai.

Jab hume pehle se pata ho ki code ko kitni baar repeat karna hai, `for` loop bahut useful hota hai.

Example:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Output:

```text
1
2
3
4
5
```

---

# 🎯 What You Will Learn

* Loop kya hota hai
* `for` loop ka syntax
* Initialization
* Condition
* Update
* Increment
* Decrement
* Reverse loop
* Multiple variables
* Nested `for` loop
* Infinite loop
* `for` loop with arrays
* `for` loop with user input
* Tables
* Patterns
* Common mistakes

---

# 1. Basic For Loop

### Syntax

```java
for (initialization; condition; update) {
    // code
}
```

Example:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Output:

```text
1
2
3
4
5
```

---

# 2. For Loop ke 3 Main Parts

```java
for (int i = 1; i <= 5; i++)
```

### 1. Initialization

```java
int i = 1
```

Loop start hone se pehle execute hota hai.

### 2. Condition

```java
i <= 5
```

Jab tak condition `true` hai, loop chalega.

### 3. Update

```java
i++
```

Har iteration ke baad `i` ki value increase hoti hai.

---

# 3. Loop Execution

Code:

```java
for (int i = 1; i <= 3; i++) {
    System.out.println(i);
}
```

Execution:

```text
i = 1 → condition true → print 1 → i++
i = 2 → condition true → print 2 → i++
i = 3 → condition true → print 3 → i++
i = 4 → condition false → stop
```

Output:

```text
1
2
3
```

---

# 4. Print 1 to 10

```java
for (int i = 1; i <= 10; i++) {
    System.out.println(i);
}
```

Output:

```text
1
2
3
4
5
6
7
8
9
10
```

---

# 5. Print 1 to 100

```java
for (int i = 1; i <= 100; i++) {
    System.out.println(i);
}
```

---

# 6. Print Even Numbers

```java
for (int i = 2; i <= 20; i += 2) {
    System.out.println(i);
}
```

Output:

```text
2
4
6
8
10
12
14
16
18
20
```

---

# 7. Print Odd Numbers

```java
for (int i = 1; i <= 20; i += 2) {
    System.out.println(i);
}
```

Output:

```text
1
3
5
7
9
11
13
15
17
19
```

---

# 8. Reverse Loop

Loop ko reverse direction me bhi chala sakte hain.

```java
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}
```

Output:

```text
10
9
8
7
6
5
4
3
2
1
```

---

# 9. Decrement by 2

```java
for (int i = 10; i >= 0; i -= 2) {
    System.out.println(i);
}
```

Output:

```text
10
8
6
4
2
0
```

---

# 10. Sum of Numbers

1 se 10 tak numbers ka sum:

```java
int sum = 0;

for (int i = 1; i <= 10; i++) {
    sum += i;
}

System.out.println("Sum: " + sum);
```

Output:

```text
Sum: 55
```

---

# 11. Sum of Even Numbers

```java
int sum = 0;

for (int i = 2; i <= 20; i += 2) {
    sum += i;
}

System.out.println("Sum: " + sum);
```

Output:

```text
Sum: 110
```

---

# 12. Multiplication Table

```java
int number = 5;

for (int i = 1; i <= 10; i++) {
    System.out.println(number + " x " + i + " = " + (number * i));
}
```

Output:

```text
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

---

# 13. User Input ke Saath For Loop

User se number lekar uski table:

```java
import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }

        sc.close();
    }
}
```

Input:

```text
Enter number: 7
```

Output:

```text
7 x 1 = 7
7 x 2 = 14
7 x 3 = 21
7 x 4 = 28
7 x 5 = 35
7 x 6 = 42
7 x 7 = 49
7 x 8 = 56
7 x 9 = 63
7 x 10 = 70
```

---

# 14. Factorial

Example:

```java
int number = 5;
int factorial = 1;

for (int i = 1; i <= number; i++) {
    factorial *= i;
}

System.out.println("Factorial: " + factorial);
```

Output:

```text
Factorial: 120
```

Because:

```text
5 × 4 × 3 × 2 × 1 = 120
```

---

# 15. Count Digits

Number ke digits count karne ke liye loop ka use:

```java
int number = 12345;
int count = 0;

for (int n = number; n != 0; n /= 10) {
    count++;
}

System.out.println("Digits: " + count);
```

Output:

```text
Digits: 5
```

---

# 16. Nested For Loop

Ek `for` loop ke andar doosra `for` loop ho to **Nested For Loop** kehte hain.

Example:

```java
for (int i = 1; i <= 3; i++) {

    for (int j = 1; j <= 3; j++) {
        System.out.println("i = " + i + ", j = " + j);
    }

}
```

Output:

```text
i = 1, j = 1
i = 1, j = 2
i = 1, j = 3
i = 2, j = 1
i = 2, j = 2
i = 2, j = 3
i = 3, j = 1
i = 3, j = 2
i = 3, j = 3
```

---

# 17. Star Pattern

Nested loop ka common use patterns me hota hai.

```java
for (int i = 1; i <= 5; i++) {

    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }

    System.out.println();
}
```

Output:

```text
* 
* * 
* * * 
* * * * 
* * * * * 
```

---

# 18. Square Pattern

```java
for (int i = 1; i <= 4; i++) {

    for (int j = 1; j <= 4; j++) {
        System.out.print("* ");
    }

    System.out.println();
}
```

Output:

```text
* * * *
* * * *
* * * *
* * * *
```

---

# 19. Number Pattern

```java
for (int i = 1; i <= 5; i++) {

    for (int j = 1; j <= i; j++) {
        System.out.print(j + " ");
    }

    System.out.println();
}
```

Output:

```text
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
```

---

# 20. Multiple Variables

`for` loop me multiple variables use kar sakte hain.

```java
for (int i = 1, j = 10; i <= 5; i++, j--) {
    System.out.println(i + " " + j);
}
```

Output:

```text
1 10
2 9
3 8
4 7
5 6
```

---

# 21. Infinite For Loop

Agar condition hamesha `true` hai to loop infinite ho sakta hai.

```java
for (;;) {
    System.out.println("Hello");
}
```

⚠️ Ye loop continuously execute karega jab tak program stop nahi hota.

Another example:

```java
for (int i = 1; i <= 10; i--) {
    System.out.println(i);
}
```

Yahan condition kabhi false nahi hogi, isliye infinite loop ban sakta hai.

---

# 22. For Loop Without Parts

Java me `for` ke parts technically optional hain.

```java
int i = 1;

for (; i <= 5; ) {
    System.out.println(i);
    i++;
}
```

Output:

```text
1
2
3
4
5
```

Lekin normal cases me standard syntax use karna zyada readable hai.

---

# 23. For Loop with Array

Array ke elements print karne ke liye:

```java
int[] numbers = {10, 20, 30, 40, 50};

for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

Output:

```text
10
20
30
40
50
```

---

# 24. Find Largest Number

```java
int[] numbers = {10, 50, 20, 80, 30};

int largest = numbers[0];

for (int i = 1; i < numbers.length; i++) {

    if (numbers[i] > largest) {
        largest = numbers[i];
    }
}

System.out.println("Largest: " + largest);
```

Output:

```text
Largest: 80
```

---

# 25. Count Even Numbers in Array

```java
int[] numbers = {10, 15, 20, 25, 30};

int count = 0;

for (int i = 0; i < numbers.length; i++) {

    if (numbers[i] % 2 == 0) {
        count++;
    }
}

System.out.println("Even numbers: " + count);
```

Output:

```text
Even numbers: 3
```

---

# 26. For Loop with String

String ke characters access kar sakte hain.

```java
String name = "Java";

for (int i = 0; i < name.length(); i++) {
    System.out.println(name.charAt(i));
}
```

Output:

```text
J
a
v
a
```

---

# 27. Reverse a String

```java
String name = "Java";

for (int i = name.length() - 1; i >= 0; i--) {
    System.out.print(name.charAt(i));
}
```

Output:

```text
avaJ
```

---

# 28. Check Prime Number

```java
int number = 17;
boolean isPrime = true;

if (number < 2) {
    isPrime = false;
} else {

    for (int i = 2; i < number; i++) {

        if (number % i == 0) {
            isPrime = false;
            break;
        }
    }
}

if (isPrime) {
    System.out.println("Prime");
} else {
    System.out.println("Not Prime");
}
```

Output:

```text
Prime
```

---

# 💻 Complete Example

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

Input:

```text
Enter a number: 5
```

Output:

```text
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

---

# 📝 Practice Questions

## Beginner

1. `1` se `10` tak numbers print karo.
2. `10` se `1` tak reverse numbers print karo.
3. `1` se `100` tak even numbers print karo.
4. `1` se `100` tak odd numbers print karo.
5. Kisi number ki multiplication table print karo.
6. `1` se `100` tak numbers ka sum find karo.

## Intermediate

7. Number ka factorial find karo.
8. Number ke digits count karo.
9. Number ke digits ka sum find karo.
10. Number reverse karo.
11. Prime number check karo.
12. `1` se `100` tak prime numbers print karo.
13. Fibonacci series ke first `n` terms print karo.
14. Array ka largest element find karo.
15. Array ka smallest element find karo.
16. Array me even aur odd elements count karo.

## Advanced

17. Nested loops se star patterns banao.
18. Number pyramid banao.
19. Reverse pyramid banao.
20. String ko reverse karo.
21. String me vowels count karo.
22. Array me duplicate elements find karo.
23. Two arrays ke common elements find karo.
24. Matrix ke elements nested `for` loop se print karo.

---

# 🚀 Challenge 1 — Multiplication Tables

User se starting aur ending number lo.

Example:

```text
Start: 2
End: 5
```

Output:

```text
===== TABLE OF 2 =====
2 x 1 = 2
...
2 x 10 = 20

===== TABLE OF 3 =====
3 x 1 = 3
...
3 x 10 = 30
```

---

# 🚀 Challenge 2 — Number Analysis

User se number input lo aur find karo:

```text
Number
Digit Count
Digit Sum
Reverse
Even/Odd
Prime/Not Prime
```

Example:

```text
Enter number: 123
```

Output:

```text
Number: 123
Digit Count: 3
Digit Sum: 6
Reverse: 321
Even/Odd: Odd
Prime: No
```

---

# 🚀 Challenge 3 — Pattern

Ye pattern print karo:

```text
*
* *
* * *
* * * *
* * * * *
```

Phir:

```text
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
```

Aur:

```text
1
2 2
3 3 3
4 4 4 4
5 5 5 5 5
```

---

# ⚠️ Common Mistakes

## 1. Condition galat likhna

```java
for (int i = 1; i < 5; i++)
```

Output:

```text
1
2
3
4
```

Lekin:

```java
for (int i = 1; i <= 5; i++)
```

Output:

```text
1
2
3
4
5
```

`<` aur `<=` ka difference important hai.

---

## 2. Update bhool jana

❌:

```java
for (int i = 1; i <= 5;) {
    System.out.println(i);
}
```

`i` change nahi hoga, isliye infinite loop ban sakta hai.

---

## 3. Semicolon lagana

❌:

```java
for (int i = 1; i <= 5; i++);
{
    System.out.println("Hello");
}
```

Ye loop ko empty statement ke saath run karega aur braces wala block loop ke bahar execute hoga.

---

## 4. Array Index

Array ke liye:

```java
for (int i = 0; i < numbers.length; i++)
```

Use karo.

`i <= numbers.length` generally wrong hai kyunki last valid index `length - 1` hota hai.

---

# 🔑 Key Takeaways

* `for` loop repetitive tasks ke liye use hota hai.
* Syntax:

```java
for (initialization; condition; update) {
    // code
}
```

* `i++` → value 1 se increase.
* `i--` → value 1 se decrease.
* `i += 2` → value 2 se increase.
* Nested `for` loops patterns aur 2D data ke liye useful hain.
* Arrays aur Strings ke saath `for` loop bahut commonly use hota hai.
* Infinite loops se bachne ke liye initialization, condition aur update carefully check karo.

## 🚀 Next Topic

**02-Control-Flow → 05-while-loop**

Isme hum condition-based repetition, infinite loops, user input loops aur practical problems karenge.
