# Do-While Loop in Java

## 📌 Topic

**Do-While Loop**

`do-while` loop ka use tab hota hai jab hume code ko **kam se kam ek baar execute** karna ho, aur uske baad condition check karni ho.

---

## 🎯 What You Will Learn

Is topic ke baad aap:

* `do-while` loop kya hai
* Syntax samjhoge
* `while` aur `do-while` ka difference
* Basic counting
* Reverse counting
* User input
* Menu-driven programs
* `break`
* `continue`
* Input validation
* Number problems
* Nested `do-while`
* Infinite loop
* Practice questions
* Challenges

---

# 1. What is Do-While Loop?

`do-while` loop mein **pehle code execute hota hai**, uske baad condition check hoti hai.

### Syntax

```java
do {
    // code
} while (condition);
```

⚠️ `while(condition);` ke end mein **semicolon `;` required** hai.

---

# 2. Basic Example

```java
public class Main {
    public static void main(String[] args) {

        int i = 1;

        do {
            System.out.println(i);
            i++;
        } while (i <= 5);
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

# 3. How Do-While Works?

Suppose:

```java
int i = 1;
```

Flow:

```text
Execute do block
      ↓
Print 1
      ↓
i++
      ↓
Condition check
      ↓
i <= 5 ?
      ↓
Yes → Repeat
      ↓
No → Stop
```

---

# 4. Important Feature

`do-while` loop **at least one time execute hota hai**.

Example:

```java
int i = 10;

do {
    System.out.println(i);
} while (i < 5);
```

Condition:

```text
10 < 5 → false
```

Lekin output phir bhi aayega.

### Output

```text
10
```

---

# 5. While vs Do-While

### While Loop

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

Condition pehle check hoti hai.

---

### Do-While Loop

```java
int i = 10;

do {
    System.out.println(i);
} while (i < 5);
```

### Output

```text
10
```

Condition baad mein check hoti hai.

---

# 6. Main Difference

| while                            | do-while                           |
| -------------------------------- | ---------------------------------- |
| Condition pehle check hoti hai   | Condition baad mein check hoti hai |
| 0 times execute ho sakta hai     | Minimum 1 time execute hota hai    |
| `while(condition)`               | `do { } while(condition);`         |
| Semicolon condition ke baad nahi | Semicolon required                 |
| Pre-test loop                    | Post-test loop                     |

---

# 7. Print 1 to 10

```java
public class Main {
    public static void main(String[] args) {

        int i = 1;

        do {
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
5
6
7
8
9
10
```

---

# 8. Print 10 to 1

```java
public class Main {
    public static void main(String[] args) {

        int i = 10;

        do {
            System.out.println(i);
            i--;
        } while (i >= 1);
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

# 9. Print Even Numbers

```java
public class Main {
    public static void main(String[] args) {

        int i = 2;

        do {
            System.out.println(i);
            i += 2;
        } while (i <= 20);
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

# 10. Print Odd Numbers

```java
public class Main {
    public static void main(String[] args) {

        int i = 1;

        do {
            System.out.println(i);
            i += 2;
        } while (i <= 20);
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

# 11. Sum of Numbers

1 se 10 tak sum:

```java
public class Main {
    public static void main(String[] args) {

        int i = 1;
        int sum = 0;

        do {
            sum += i;
            i++;
        } while (i <= 10);

        System.out.println("Sum = " + sum);
    }
}
```

### Output

```text
Sum = 55
```

---

# 12. Multiplication Table

```java
public class Main {
    public static void main(String[] args) {

        int number = 7;
        int i = 1;

        do {
            System.out.println(number + " x " + i + " = " + (number * i));
            i++;
        } while (i <= 10);
    }
}
```

### Output

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

# 13. User Input with Do-While

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number;

        do {
            System.out.print("Enter a positive number: ");
            number = sc.nextInt();
        } while (number <= 0);

        System.out.println("You entered: " + number);

        sc.close();
    }
}
```

### Input

```text
Enter a positive number: -5
Enter a positive number: 0
Enter a positive number: 25
```

### Output

```text
You entered: 25
```

Yahan `do-while` useful hai kyunki user se input **at least once** lena hi hai.

---

# 14. Menu-Driven Program

`do-while` ka ek important real-world use hai **menu-driven programs**.

Example:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Hello");
            System.out.println("2. Java");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Hello!");
                    break;

                case 2:
                    System.out.println("Welcome to Java!");
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}
```

### Example Output

```text
--- MENU ---
1. Hello
2. Java
3. Exit
Enter choice: 1

Hello!

--- MENU ---
1. Hello
2. Java
3. Exit
Enter choice: 2

Welcome to Java!

--- MENU ---
1. Hello
2. Java
3. Exit
Enter choice: 3

Exiting...
```

---

# 15. Calculator Using Do-While

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

---

# 16. Do-While with Break

`break` loop ko immediately stop karta hai.

```java
public class Main {
    public static void main(String[] args) {

        int i = 1;

        do {

            System.out.println(i);

            if (i == 5) {
                break;
            }

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
5
```

---

# 17. Do-While with Continue

`continue` current iteration ko skip karta hai.

```java
public class Main {
    public static void main(String[] args) {

        int i = 0;

        do {

            i++;

            if (i == 3) {
                continue;
            }

            System.out.println(i);

        } while (i < 5);
    }
}
```

### Output

```text
1
2
4
5
```

⚠️ `continue` ke saath loop variable ka update carefully handle karo, warna infinite loop ho sakta hai.

---

# 18. Password Validation

Demo purpose ke liye:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String password;

        do {
            System.out.print("Enter password: ");
            password = sc.nextLine();

            if (!password.equals("java123")) {
                System.out.println("Wrong password!");
            }

        } while (!password.equals("java123"));

        System.out.println("Login successful!");

        sc.close();
    }
}
```

### Example

```text
Enter password: hello
Wrong password!

Enter password: java123
Login successful!
```

> Real applications mein passwords ko source code mein hard-code nahi karna chahiye. Ye example sirf loop practice ke liye hai.

---

# 19. Number Reverse Using Do-While

```java
public class Main {
    public static void main(String[] args) {

        int number = 12345;
        int reverse = 0;

        do {

            int digit = number % 10;

            reverse = reverse * 10 + digit;

            number /= 10;

        } while (number != 0);

        System.out.println("Reverse = " + reverse);
    }
}
```

### Output

```text
Reverse = 54321
```

---

# 20. Sum of Digits

```java
public class Main {
    public static void main(String[] args) {

        int number = 12345;
        int sum = 0;

        do {

            int digit = number % 10;

            sum += digit;

            number /= 10;

        } while (number != 0);

        System.out.println("Sum = " + sum);
    }
}
```

### Output

```text
Sum = 15
```

---

# 21. Factorial Using Do-While

```java
public class Main {
    public static void main(String[] args) {

        int n = 5;
        int factorial = 1;

        do {
            factorial *= n;
            n--;
        } while (n >= 1);

        System.out.println("Factorial = " + factorial);
    }
}
```

### Output

```text
Factorial = 120
```

---

# 22. Nested Do-While

Ek `do-while` ke andar doosra `do-while`.

```java
public class Main {
    public static void main(String[] args) {

        int i = 1;

        do {

            int j = 1;

            do {
                System.out.println("i = " + i + ", j = " + j);
                j++;
            } while (j <= 3);

            i++;

        } while (i <= 3);
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

# 23. Infinite Do-While Loop

```java
do {
    System.out.println("Hello");
} while (true);
```

Ye infinite loop hai.

Agar stop karna ho:

```java
int i = 1;

do {

    System.out.println(i);

    if (i == 5) {
        break;
    }

    i++;

} while (true);
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

# 24. Real-World Uses

`do-while` ka use commonly in situations mein ho sakta hai:

* Menu-driven applications
* Calculator menu
* User input validation
* Retry operations
* Login attempts
* Game loops
* Console applications
* "Do you want to continue?" type programs

Example:

```text
Do you want to continue?
1. Yes
2. No
```

Aise cases mein pehle action perform karna aur phir continue karne ka decision lena natural hota hai.

---

# 25. While vs Do-While Example

### While

```java
int number = 0;

while (number > 0) {
    System.out.println(number);
}
```

Output:

```text
No output
```

---

### Do-While

```java
int number = 0;

do {
    System.out.println(number);
} while (number > 0);
```

Output:

```text
0
```

### Reason

`while`:

```text
Condition → Execute
```

`do-while`:

```text
Execute → Condition
```

---

# 🧪 Practice Questions

## Beginner

### Q1

`do-while` ka use karke 1 se 10 tak numbers print karo.

### Q2

10 se 1 tak reverse numbers print karo.

### Q3

1 se 50 tak even numbers print karo.

### Q4

1 se 50 tak odd numbers print karo.

### Q5

1 se 100 tak sum calculate karo.

---

## Intermediate

### Q6

User se number lekar multiplication table print karo.

### Q7

Number ke digits count karo.

Example:

```text
Input: 123456
Output: 6
```

### Q8

Number reverse karo.

```text
Input: 9876
Output: 6789
```

### Q9

Check karo number palindrome hai ya nahi.

```text
Input: 1221
Output: Palindrome
```

### Q10

Number ke digits ka sum calculate karo.

```text
Input: 456
Output: 15
```

---

# 🔥 Challenge Questions

## Challenge 1 — Menu Program

Program mein menu banao:

```text
1. Add
2. Subtract
3. Multiply
4. Divide
5. Exit
```

User jab tak `5` select na kare, menu repeat hona chahiye.

---

## Challenge 2 — Continue Playing

Program repeatedly pooche:

```text
Do you want to continue?
1. Yes
2. No
```

`2` select hone par program stop karo.

---

## Challenge 3 — Number Guessing Game

Ek secret number rakho.

User ko repeatedly guess karne do.

Example:

```text
Enter guess: 20
Too Low

Enter guess: 80
Too High

Enter guess: 50
Correct!
```

---

## Challenge 4 — Valid Age

User se age input lo.

Agar age:

```text
< 0
```

ya

```text
> 120
```

ho, to dobara input lo.

Valid age milne par program stop karo.

---

## Challenge 5 — ATM Menu

Menu:

```text
1. Check Balance
2. Deposit
3. Withdraw
4. Exit
```

User ke exit karne tak menu repeat karo.

---

# ⚠️ Common Mistakes

## Mistake 1 — Semicolon bhool jana

❌

```java
do {
    System.out.println("Hello");
} while (true)
```

✅

```java
do {
    System.out.println("Hello");
} while (true);
```

---

## Mistake 2 — Condition wrong hona

```java
int i = 1;

do {
    System.out.println(i);
    i++;
} while (i >= 5);
```

Yahan first execution ke baad:

```text
i = 2
2 >= 5 → false
```

Isliye loop stop ho jayega.

---

## Mistake 3 — Update bhool jana

❌

```java
int i = 1;

do {
    System.out.println(i);
} while (i <= 5);
```

`i` change nahi ho raha, isliye infinite loop ban sakta hai.

---

## Mistake 4 — `continue` ke saath update miss karna

Loop variable ko update karna carefully handle karo.

---

## Mistake 5 — `while` aur `do-while` ko same samajhna

Yaad rakho:

```text
while:
Condition → Code

do-while:
Code → Condition
```

---

# 📝 Quick Syntax Reference

### Basic

```java
do {
    // code
} while (condition);
```

### Counter

```java
int i = 1;

do {
    System.out.println(i);
    i++;
} while (i <= 10);
```

### Reverse

```java
int i = 10;

do {
    System.out.println(i);
    i--;
} while (i >= 1);
```

### Break

```java
do {

    if (condition) {
        break;
    }

} while (condition);
```

### Continue

```java
do {

    if (condition) {
        continue;
    }

} while (condition);
```

---

# 🧠 Key Takeaways

* `do-while` ek **post-test loop** hai.
* Isme code **at least one time execute** hota hai.
* Condition body ke baad check hoti hai.
* `do-while` ke end mein `;` required hai.
* User input validation ke liye useful hai.
* Menu-driven programs mein commonly useful hai.
* `break` loop ko stop karta hai.
* `continue` current iteration skip karta hai.
* Loop variable ko correctly update karna important hai.
* Infinite loops se bachne ke liye termination condition check karo.

---

# 🚀 Next Topic

**02-Control-Flow → 07-break**

Next topic mein hum detail mein seekhenge:

* `break` statement
* Loop se immediately exit
* `for` loop + `break`
* `while` + `break`
* `do-while` + `break`
* Nested loops mein `break`
* Search problems
* Real-world examples
* Practice questions
* Challenges
