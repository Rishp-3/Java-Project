# Break Statement in Java

## 📌 Topic

**Break Statement**

Java mein `break` statement ka use kisi **loop ya switch statement ko immediately terminate** karne ke liye hota hai.

---

## 🎯 Learning Objective

Is topic ka main objective hai ki aap `break` statement ko correctly use karke **loop ko required condition par immediately stop** kar sako.

Topic complete karne ke baad aap:

* `break` statement ka purpose samajh paoge.
* `for`, `while` aur `do-while` mein `break` use kar paoge.
* Kisi specific condition par loop terminate kar paoge.
* `break` aur `continue` ke difference ko samajh paoge.
* Nested loops mein `break` ka behavior samajh paoge.
* Search problems mein `break` ka practical use kar paoge.
* `switch` statement mein `break` ka role samajh paoge.
* Infinite loops ko `break` ke through safely stop kar paoge.

### ✅ Learning Goal

By the end of this topic, you should be able to identify **when a loop should stop before its normal condition becomes false** and implement that behavior using `break`.

---

## 📚 What You Will Learn

* `break` kya hai
* Syntax
* `for` loop mein `break`
* `while` loop mein `break`
* `do-while` mein `break`
* `if` + `break`
* Search problems
* `switch` + `break`
* Nested loops + `break`
* Infinite loop + `break`
* `break` vs `continue`
* Common mistakes
* Practice questions
* Challenges

---

# 1. What is Break?

`break` statement current loop ko **immediately stop** kar deta hai.

### Syntax

```java
break;
```

Example:

```java
for (int i = 1; i <= 10; i++) {

    if (i == 5) {
        break;
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
```

Jab `i == 5` hua:

```text
break
```

execute hua aur loop terminate ho gaya.

---

# 2. How Break Works?

Example:

```java
for (int i = 1; i <= 10; i++) {

    if (i == 6) {
        break;
    }

    System.out.println(i);
}
```

Execution:

```text
i = 1 → print
i = 2 → print
i = 3 → print
i = 4 → print
i = 5 → print
i = 6 → break
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

# 3. Break with For Loop

```java
public class Main {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {

            if (i == 7) {
                break;
            }

            System.out.println(i);
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
```

---

# 4. Break with While Loop

```java
public class Main {
    public static void main(String[] args) {

        int i = 1;

        while (i <= 10) {

            if (i == 6) {
                break;
            }

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

---

# 5. Break with Do-While

```java
public class Main {
    public static void main(String[] args) {

        int i = 1;

        do {

            if (i == 5) {
                break;
            }

            System.out.println(i);

            i++;

        } while (i <= 10);
    }
}
```

### Output

```text
1
2
3
4
```

---

# 6. Break with If Statement

`break` generally loop ya `switch` ke context mein use hota hai.

Example:

```java
for (int i = 1; i <= 10; i++) {

    if (i == 5) {
        break;
    }

    System.out.println(i);
}
```

Yahan `if` condition decide kar rahi hai ki `break` kab execute hoga.

---

# 7. Find a Number

Suppose array mein number search karna hai.

```java
public class Main {
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        int target = 30;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == target) {
                System.out.println("Number found at index: " + i);
                break;
            }
        }
    }
}
```

### Output

```text
Number found at index: 2
```

`30` milte hi search stop ho gaya.

---

# 8. Search Without Break

Without `break`, loop unnecessarily continue kar sakta hai.

```java
for (int i = 0; i < numbers.length; i++) {

    if (numbers[i] == target) {
        System.out.println("Found");
    }
}
```

Agar target multiple times present hai, multiple matches mil sakte hain.

Agar hume **first match milte hi search stop** karna hai, `break` useful hai.

---

# 9. Find First Even Number

```java
public class Main {
    public static void main(String[] args) {

        int[] numbers = {7, 9, 13, 18, 25, 30};

        for (int number : numbers) {

            if (number % 2 == 0) {
                System.out.println("First even number: " + number);
                break;
            }
        }
    }
}
```

### Output

```text
First even number: 18
```

---

# 10. Find First Number Greater Than 50

```java
public class Main {
    public static void main(String[] args) {

        int[] numbers = {10, 25, 40, 65, 80};

        for (int number : numbers) {

            if (number > 50) {
                System.out.println("Found: " + number);
                break;
            }
        }
    }
}
```

### Output

```text
Found: 65
```

---

# 11. Break with User Input

User se numbers continuously lena aur `0` par stop karna:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.print("Enter number: ");
            int number = sc.nextInt();

            if (number == 0) {
                break;
            }

            System.out.println("You entered: " + number);
        }

        System.out.println("Program stopped.");

        sc.close();
    }
}
```

### Example

```text
Enter number: 10
You entered: 10

Enter number: 25
You entered: 25

Enter number: 50
You entered: 50

Enter number: 0
Program stopped.
```

---

# 12. Break with Infinite Loop

`while(true)` ek infinite loop create karta hai.

```java
while (true) {

    System.out.println("Running...");

    break;
}
```

### Output

```text
Running...
```

`break` ne loop ko immediately stop kar diya.

---

# 13. Menu Program with Break

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Hello");
            System.out.println("2. Java");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Hello!");
            } 
            else if (choice == 2) {
                System.out.println("Welcome to Java!");
            } 
            else if (choice == 3) {
                break;
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }

        System.out.println("Program ended.");

        sc.close();
    }
}
```

---

# 14. Break in Switch

`switch` mein `break` ka use current case ko stop karne ke liye hota hai.

```java
int day = 2;

switch (day) {

    case 1:
        System.out.println("Monday");
        break;

    case 2:
        System.out.println("Tuesday");
        break;

    case 3:
        System.out.println("Wednesday");
        break;

    default:
        System.out.println("Invalid day");
}
```

### Output

```text
Tuesday
```

---

# 15. What Happens Without Break in Switch?

```java
int number = 1;

switch (number) {

    case 1:
        System.out.println("One");

    case 2:
        System.out.println("Two");

    case 3:
        System.out.println("Three");
}
```

### Output

```text
One
Two
Three
```

Ye **fall-through** behavior hai.

Traditional `switch` mein `break` na hone par next cases execute ho sakte hain.

---

# 16. Nested Loops with Break

Nested loops mein `break` generally **sirf nearest/current loop** ko terminate karta hai.

```java
public class Main {
    public static void main(String[] args) {

        for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 5; j++) {

                if (j == 3) {
                    break;
                }

                System.out.println("i = " + i + ", j = " + j);
            }
        }
    }
}
```

### Output

```text
i = 1, j = 1
i = 1, j = 2
i = 2, j = 1
i = 2, j = 2
i = 3, j = 1
i = 3, j = 2
```

Inner loop `j == 3` par stop hota hai.

Outer loop continue karta hai.

---

# 17. Break in Nested Loop

Important:

```text
Outer Loop
    ↓
Inner Loop
    ↓
break
```

Normal `break`:

```text
Inner Loop → Stop
Outer Loop → Continue
```

---

# 18. Labeled Break

Java mein labeled `break` se outer loop ko bhi terminate kar sakte ho.

### Syntax

```java
break label;
```

Example:

```java
public class Main {
    public static void main(String[] args) {

        outer:
        for (int i = 1; i <= 3; i++) {

            for (int j = 1; j <= 3; j++) {

                if (i == 2 && j == 2) {
                    break outer;
                }

                System.out.println("i = " + i + ", j = " + j);
            }
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
```

Jab:

```text
i = 2
j = 2
```

hua, `break outer;` ne outer loop ko bhi stop kar diya.

> Labeled `break` beginner programs mein rarely required hota hai. Pehle normal `break` ko properly master karo.

---

# 19. Break with Prime Checking

Prime check mein divisor milte hi loop stop kiya ja sakta hai.

```java
public class Main {
    public static void main(String[] args) {

        int number = 17;
        boolean isPrime = true;

        for (int i = 2; i < number; i++) {

            if (number % i == 0) {
                isPrime = false;
                break;
            }
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

Agar divisor mil jaye, further checking ki zarurat nahi.

---

# 20. Find First Divisor

```java
public class Main {
    public static void main(String[] args) {

        int number = 24;

        for (int i = 2; i <= number; i++) {

            if (number % i == 0) {
                System.out.println("First divisor: " + i);
                break;
            }
        }
    }
}
```

### Output

```text
First divisor: 2
```

---

# 21. Break vs Continue

Ye dono statements different hain.

### `break`

Loop ko completely stop karta hai.

```java
for (int i = 1; i <= 10; i++) {

    if (i == 5) {
        break;
    }

    System.out.println(i);
}
```

Output:

```text
1
2
3
4
```

---

### `continue`

Current iteration ko skip karta hai, loop continue rehta hai.

```java
for (int i = 1; i <= 5; i++) {

    if (i == 3) {
        continue;
    }

    System.out.println(i);
}
```

Output:

```text
1
2
4
5
```

### Remember

```text
break    → Stop Loop
continue → Skip Iteration
```

---

# 22. Real-World Uses of Break

`break` useful ho sakta hai:

* Search operations
* First match find karna
* User input stop karna
* Menu exit
* Game exit
* Validation
* Prime checking
* Array searching
* Infinite loop control
* File/data processing mein early termination

---

# 23. Complete Example — Search in Array

```java
public class Main {
    public static void main(String[] args) {

        int[] numbers = {15, 27, 32, 45, 60, 75};

        int target = 45;

        boolean found = false;

        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == target) {

                System.out.println(
                    "Number found at index: " + i
                );

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Number not found");
        }
    }
}
```

### Output

```text
Number found at index: 3
```

---

# 🧪 Practice Questions

## Beginner

### Q1

1 se 100 tak numbers print karo, lekin `50` par loop stop karo.

### Q2

1 se 20 tak numbers print karo aur `10` par `break` karo.

### Q3

1 se 100 tak numbers mein first number find karo jo `25` se divisible ho.

### Q4

Array mein target element search karo aur milte hi `break` karo.

### Q5

User se numbers input lo aur `0` enter hone par program stop karo.

---

# 🧪 Intermediate Questions

### Q6 — First Even Number

Array:

```text
{7, 13, 19, 22, 35, 40}
```

First even number find karo.

Expected output:

```text
First even number: 22
```

---

### Q7 — First Number Greater Than 100

```text
{20, 40, 80, 120, 150}
```

Expected output:

```text
First number greater than 100: 120
```

---

### Q8 — Search Character

String:

```text
"programming"
```

First `'g'` character milte hi loop stop karo.

---

### Q9 — Prime Check

`break` ka use karke check karo ki number prime hai ya nahi.

---

### Q10 — Menu Exit

Menu:

```text
1. Start
2. Settings
3. Help
4. Exit
```

`4` select karne par `break` se menu stop karo.

---

# 🔥 Challenge Questions

## Challenge 1 — First Duplicate

Array:

```text
{10, 20, 30, 20, 40}
```

First duplicate element find karo.

Expected:

```text
Duplicate found: 20
```

---

## Challenge 2 — Search Until Negative

User se numbers continuously input lo.

Agar negative number enter ho:

```text
Stop
```

Example:

```text
10
20
30
-5
```

Output:

```text
Negative number found. Program stopped.
```

---

## Challenge 3 — Guessing Game

Secret number:

```text
50
```

User ko repeatedly guess karne do.

Correct answer milte hi:

```java
break;
```

use karke game stop karo.

---

## Challenge 4 — First Divisible Number

1 se 100 ke beech first number find karo jo:

```text
7
```

se divisible ho.

Expected:

```text
7
```

---

## Challenge 5 — ATM Exit

ATM menu banao:

```text
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
```

`4` par `break` use karke program exit karo.

---

# ⚠️ Common Mistakes

## Mistake 1 — Break ko loop ke bahar use karna

❌

```java
if (x == 5) {
    break;
}
```

Agar ye kisi loop ya switch ke context mein nahi hai, compile error milega.

---

## Mistake 2 — Break ko Continue samajhna

`break`:

```text
Loop completely stop
```

`continue`:

```text
Current iteration skip
```

---

## Mistake 3 — Nested Loop mein galat expectation

```java
for (...) {

    for (...) {

        break;
    }
}
```

Yahan normal `break` **inner loop** ko stop karega, outer loop ko nahi.

---

## Mistake 4 — Search ke baad unnecessary iterations

Agar target mil gaya hai aur further searching ki zarurat nahi hai, `break` useful ho sakta hai.

---

## Mistake 5 — Switch mein Break bhool jana

Traditional `switch` mein `break` na hone par fall-through ho sakta hai.

---

# 📝 Quick Syntax Reference

### Basic

```java
break;
```

### For Loop

```java
for (int i = 1; i <= 10; i++) {

    if (condition) {
        break;
    }
}
```

### While Loop

```java
while (condition) {

    if (condition2) {
        break;
    }
}
```

### Do-While

```java
do {

    if (condition) {
        break;
    }

} while (condition);
```

### Switch

```java
switch (choice) {

    case 1:
        // code
        break;

    case 2:
        // code
        break;
}
```

### Labeled Break

```java
outer:
for (...) {

    for (...) {

        if (condition) {
            break outer;
        }
    }
}
```

---

# 🧠 Key Takeaways

* `break` loop ko **immediately terminate** karta hai.
* `break` `for`, `while`, `do-while` aur `switch` mein use hota hai.
* Search problems mein target milte hi `break` useful hota hai.
* `break` aur `continue` different hain.
* Normal `break` nested loops mein **nearest loop** ko terminate karta hai.
* Labeled `break` outer loop ko terminate kar sakta hai.
* Infinite loops ko controlled way mein stop karne ke liye `break` useful hai.
* Traditional `switch` mein `break` fall-through prevent karne ke liye important hai.

---

# 🚀 Next Topic

**02-Control-Flow → 08-continue**

Next topic mein hum seekhenge:

* `continue` statement
* Current iteration skip karna
* `for` + `continue`
* `while` + `continue`
* `do-while` + `continue`
* Even/Odd filtering
* Nested loops
* `break` vs `continue`
* Common mistakes
* Practice questions
* Challenges
