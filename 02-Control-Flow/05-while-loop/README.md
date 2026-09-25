# While Loop in Java

## 📌 Topic

**While Loop**

While loop ka use tab hota hai jab hume kisi block of code ko **jab tak ek condition true hai tab tak repeatedly execute** karna ho.

---

## 🎯 What You Will Learn

Is topic ke baad aap:

* `while` loop ka syntax samjhoge
* `while` loop kaise work karta hai
* Counter-based loops
* Reverse loops
* Even/Odd numbers
* Sum aur multiplication table
* User input ke saath loop
* Sentinel-controlled loop
* `while(true)` aur `break`
* Nested `while` loop
* Number ke digits count karna
* Digit sum
* Number reverse karna
* Palindrome check
* Factorial
* Prime number check
* Infinite loop aur common mistakes

---

# 1. What is While Loop?

`while` loop ek condition ko repeatedly check karta hai.

Agar condition `true` hai → loop chalega.

Agar condition `false` hai → loop stop ho jayega.

### Syntax

```java
while (condition) {
    // code
}
```

---

# 2. Basic Example

```java
public class Main {
    public static void main(String[] args) {

        int i = 1;

        while (i <= 5) {
            System.out.println(i);
            i++;
        }
    }
}
```

### Output

```text
1
2
3
4
5
```

### Kaise work karta hai?

```text
i = 1
  ↓
i <= 5 ? → Yes
  ↓
Print i
  ↓
i++
  ↓
Condition again
```

Jab `i = 6` hoga:

```text
6 <= 5 → false
```

Loop stop ho jayega.

---

# 3. Important Point

`while` loop mein **condition pehle check hoti hai**.

```java
int i = 10;

while (i < 5) {
    System.out.println(i);
}
```

### Output

```text
No output
```

Kyuki:

```text
10 < 5 → false
```

Isliye loop ek baar bhi execute nahi hua.

---

# 4. Print 1 to 10

```java
public class Main {
    public static void main(String[] args) {

        int i = 1;

        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }
}
```

### Output

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

# 5. Print 10 to 1

```java
public class Main {
    public static void main(String[] args) {

        int i = 10;

        while (i >= 1) {
            System.out.println(i);
            i--;
        }
    }
}
```

### Output

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

# 6. Print Even Numbers

1 se 20 tak even numbers:

```java
public class Main {
    public static void main(String[] args) {

        int i = 2;

        while (i <= 20) {
            System.out.println(i);
            i += 2;
        }
    }
}
```

### Output

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
public class Main {
    public static void main(String[] args) {

        int i = 1;

        while (i <= 20) {
            System.out.println(i);
            i += 2;
        }
    }
}
```

### Output

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

# 8. Sum of 1 to 10

```java
public class Main {
    public static void main(String[] args) {

        int i = 1;
        int sum = 0;

        while (i <= 10) {
            sum += i;
            i++;
        }

        System.out.println("Sum = " + sum);
    }
}
```

### Output

```text
Sum = 55
```

---

# 9. Multiplication Table

5 ka table:

```java
public class Main {
    public static void main(String[] args) {

        int number = 5;
        int i = 1;

        while (i <= 10) {
            System.out.println(number + " x " + i + " = " + (number * i));
            i++;
        }
    }
}
```

### Output

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

# 10. User Input with While Loop

User se number lekar 1 se us number tak print karna:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        int i = 1;

        while (i <= n) {
            System.out.println(i);
            i++;
        }

        sc.close();
    }
}
```

### Input

```text
5
```

### Output

```text
1
2
3
4
5
```

---

# 11. Print Numbers Until User Enters 0

Is type ke loop ko **sentinel-controlled loop** kaha ja sakta hai.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number;

        while (true) {

            System.out.print("Enter number (0 to stop): ");
            number = sc.nextInt();

            if (number == 0) {
                break;
            }

            System.out.println("You entered: " + number);
        }

        sc.close();
    }
}
```

### Example Input

```text
10
25
50
0
```

### Output

```text
Enter number (0 to stop): 10
You entered: 10

Enter number (0 to stop): 25
You entered: 25

Enter number (0 to stop): 50
You entered: 50

Enter number (0 to stop): 0
```

---

# 12. While with `break`

`break` loop ko immediately stop karta hai.

```java
int i = 1;

while (i <= 10) {

    if (i == 6) {
        break;
    }

    System.out.println(i);
    i++;
}
```

### Output

```text
1
2
3
4
5
```

---

# 13. While with `continue`

`continue` current iteration ko skip karta hai.

```java
int i = 0;

while (i < 10) {

    i++;

    if (i == 5) {
        continue;
    }

    System.out.println(i);
}
```

### Output

```text
1
2
3
4
6
7
8
9
10
```

---

# 14. Count Digits of a Number

```java
public class Main {
    public static void main(String[] args) {

        int number = 12345;
        int count = 0;

        while (number != 0) {
            number = number / 10;
            count++;
        }

        System.out.println("Digits = " + count);
    }
}
```

### Output

```text
Digits = 5
```

### Logic

```text
12345 / 10 = 1234
1234 / 10  = 123
123 / 10   = 12
12 / 10    = 1
1 / 10     = 0
```

Total:

```text
5 digits
```

> Note: `0` ke digits count ke liye separately handle karna padta hai.

---

# 15. Sum of Digits

Example:

```text
12345
```

Result:

```text
1 + 2 + 3 + 4 + 5 = 15
```

### Code

```java
public class Main {
    public static void main(String[] args) {

        int number = 12345;
        int sum = 0;

        while (number != 0) {

            int digit = number % 10;

            sum += digit;

            number = number / 10;
        }

        System.out.println("Digit Sum = " + sum);
    }
}
```

### Output

```text
Digit Sum = 15
```

---

# 16. Reverse a Number

Example:

```text
Original = 12345
Reverse  = 54321
```

### Code

```java
public class Main {
    public static void main(String[] args) {

        int number = 12345;
        int reverse = 0;

        while (number != 0) {

            int digit = number % 10;

            reverse = reverse * 10 + digit;

            number = number / 10;
        }

        System.out.println("Reverse = " + reverse);
    }
}
```

### Output

```text
Reverse = 54321
```

---

# 17. Palindrome Number

Palindrome number woh hota hai jo reverse karne par same rahe.

Example:

```text
121 → 121
```

### Code

```java
public class Main {
    public static void main(String[] args) {

        int number = 121;
        int original = number;
        int reverse = 0;

        while (number != 0) {

            int digit = number % 10;

            reverse = reverse * 10 + digit;

            number = number / 10;
        }

        if (original == reverse) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
```

### Output

```text
Palindrome
```

---

# 18. Factorial Using While Loop

Example:

```text
5! = 5 × 4 × 3 × 2 × 1
```

Result:

```text
120
```

### Code

```java
public class Main {
    public static void main(String[] args) {

        int n = 5;
        int factorial = 1;

        while (n >= 1) {
            factorial *= n;
            n--;
        }

        System.out.println("Factorial = " + factorial);
    }
}
```

### Output

```text
Factorial = 120
```

---

# 19. Check Prime Number

```java
public class Main {
    public static void main(String[] args) {

        int number = 17;
        int i = 2;
        boolean isPrime = true;

        if (number < 2) {
            isPrime = false;
        }

        while (i < number && isPrime) {

            if (number % i == 0) {
                isPrime = false;
            }

            i++;
        }

        if (isPrime) {
            System.out.println("Prime Number");
        } else {
            System.out.println("Not a Prime Number");
        }
    }
}
```

### Output

```text
Prime Number
```

---

# 20. Nested While Loop

Ek `while` loop ke andar doosra `while` loop.

```java
public class Main {
    public static void main(String[] args) {

        int i = 1;

        while (i <= 3) {

            int j = 1;

            while (j <= 3) {
                System.out.println("i = " + i + ", j = " + j);
                j++;
            }

            i++;
        }
    }
}
```

### Output

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

# 21. Star Pattern Using While

```java
public class Main {
    public static void main(String[] args) {

        int i = 1;

        while (i <= 5) {

            int j = 1;

            while (j <= i) {
                System.out.print("* ");
                j++;
            }

            System.out.println();
            i++;
        }
    }
}
```

### Output

```text
*
* *
* * *
* * * *
* * * * *
```

---

# 22. Infinite While Loop

Agar condition kabhi `false` nahi hoti, loop continuously chalta rahega.

```java
while (true) {
    System.out.println("Hello");
}
```

Ye ek **infinite loop** hai.

Isko `break` se stop kiya ja sakta hai:

```java
int i = 1;

while (true) {

    System.out.println(i);

    if (i == 5) {
        break;
    }

    i++;
}
```

### Output

```text
1
2
3
4
5
```

---

# 23. Common Infinite Loop Mistake

❌ Wrong:

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
}
```

Yahan `i` ki value change hi nahi ho rahi.

Isliye:

```text
1 <= 5 → true
```

hamesha true rahega.

### Correct:

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

---

# 24. While Loop vs For Loop

| While Loop                                    | For Loop                                    |
| --------------------------------------------- | ------------------------------------------- |
| Condition-based repetition ke liye useful     | Counter-based repetition ke liye convenient |
| Initialization usually loop se pehle hoti hai | Initialization loop ke andar hoti hai       |
| Update body mein hota hai                     | Update header mein hota hai                 |
| Syntax simple for condition-driven loops      | Fixed iteration ke liye compact             |

### For Loop

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

### While Loop

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

Dono ka output:

```text
1
2
3
4
5
```

---

# 25. Complete Example

User se positive number lena aur uske digits ka sum calculate karna:

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

### Input

```text
Enter a positive number: 4567
```

### Output

```text
Sum of digits = 22
```

Because:

```text
4 + 5 + 6 + 7 = 22
```

---

# 🧪 Practice Questions

## Beginner

### Q1

`while` loop ka use karke 1 se 20 tak numbers print karo.

### Q2

20 se 1 tak reverse numbers print karo.

### Q3

1 se 50 tak even numbers print karo.

### Q4

1 se 50 tak odd numbers print karo.

### Q5

1 se 100 tak numbers ka sum calculate karo.

---

## Intermediate

### Q6

User se number lo aur uska multiplication table print karo.

### Q7

Number ke total digits count karo.

Example:

```text
Input: 98765
Output: 5
```

### Q8

Number ke digits ka sum calculate karo.

Example:

```text
Input: 1234
Output: 10
```

### Q9

Number ko reverse karo.

Example:

```text
Input: 1234
Output: 4321
```

### Q10

Check karo number palindrome hai ya nahi.

Example:

```text
Input: 1221
Output: Palindrome
```

---

# 🔥 Challenge Questions

### Challenge 1 — Count Even Digits

```text
Input: 123456
Output: 3
```

---

### Challenge 2 — Count Odd Digits

```text
Input: 123456
Output: 3
```

---

### Challenge 3 — Find Largest Digit

```text
Input: 58329
Output: 9
```

---

### Challenge 4 — Find Smallest Digit

```text
Input: 58329
Output: 2
```

---

### Challenge 5 — Armstrong Number

Check karo number Armstrong number hai ya nahi.

Example:

```text
153
```

Because:

```text
1³ + 5³ + 3³ = 153
```

---

### Challenge 6 — Guessing Game

Ek fixed number rakho aur user ko repeatedly guess karne do jab tak correct answer na mile.

Example:

```text
Guess: 10
Too Low

Guess: 90
Too High

Guess: 50
Correct!
```

---

# ⚠️ Common Mistakes

## Mistake 1 — Update bhool jana

❌

```java
int i = 1;

while (i <= 10) {
    System.out.println(i);
}
```

✅

```java
int i = 1;

while (i <= 10) {
    System.out.println(i);
    i++;
}
```

---

## Mistake 2 — Wrong condition

```java
int i = 1;

while (i >= 10) {
    System.out.println(i);
    i++;
}
```

Condition initially false hai, isliye output nahi aayega.

---

## Mistake 3 — Infinite Loop

```java
while (true) {
    System.out.println("Hello");
}
```

Ye intentionally infinite loop hai.

Normal loop mein condition eventually false honi chahiye.

---

## Mistake 4 — Extra Semicolon

❌

```java
while (i <= 5);
{
    System.out.println(i);
}
```

`while` ke baad unnecessary `;` problem create kar sakta hai.

---

## Mistake 5 — `i++` ki jagah wrong update

Agar reverse loop kar rahe ho:

```java
int i = 10;

while (i >= 1) {
    System.out.println(i);
    i--;
}
```

Yahan `i++` use karoge to loop terminate nahi hoga.

---

# 📝 Quick Syntax Reference

### Basic

```java
while (condition) {
    // code
}
```

### Counter

```java
int i = 1;

while (i <= 10) {
    System.out.println(i);
    i++;
}
```

### Reverse

```java
int i = 10;

while (i >= 1) {
    System.out.println(i);
    i--;
}
```

### Break

```java
while (condition) {

    if (someCondition) {
        break;
    }
}
```

### Continue

```java
while (condition) {

    if (someCondition) {
        continue;
    }
}
```

### Infinite Loop

```java
while (true) {
    // code
}
```

---

# 🧠 Key Takeaways

* `while` loop condition ko **pehle check** karta hai.
* Condition `true` hone par loop execute hota hai.
* Condition `false` hone par loop stop hota hai.
* `while` loop **zero or more times** execute ho sakta hai.
* Loop variable ko update karna important hai.
* `break` loop ko immediately stop karta hai.
* `continue` current iteration skip karta hai.
* `while(true)` infinite loop create kar sakta hai.
* `while` loop number-based problems aur condition-driven repetition mein bahut useful hai.
* `do-while` loop mein body kam se kam **ek baar** execute hoti hai.

---

# 🚀 Next Topic

**02-Control-Flow → 06-do-while**

Next topic mein hum seekhenge:

* `do-while` loop
* Syntax
* `while` vs `do-while`
* Menu-driven programs
* User input validation
* `break`
* `continue`
* Real-world examples
* Practice questions
* Challenges
