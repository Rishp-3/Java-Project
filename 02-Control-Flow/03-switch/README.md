# Switch in Java

## 📌 Topic

`switch` Java me **multiple fixed choices/cases** me se ek block execute karne ke liye use hota hai.

Jab kisi ek value ke basis par multiple options check karne ho, `switch` code ko `if-else-if` se cleaner bana sakta hai.

Example:

```java
int day = 2;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;

    case 2:
        System.out.println("Tuesday");
        break;

    default:
        System.out.println("Invalid day");
}
```

Output:

```text
Tuesday
```

---

# 🎯 What You Will Learn

* `switch` statement kaise kaam karta hai
* Supported data types
* `case`, `break`, `default`
* Switch syntax
* Multiple cases
* String ke saath switch
* `char` ke saath switch
* User input ke saath switch
* Nested switch
* Fall-through
* Modern switch expression (statement vs expression)
* Arrow syntax (`->`)
* `yield`
* Common mistakes

---

# 0. Switch Kis Data Type Ke Saath Kaam Karta Hai

`switch` sab data types ke saath nahi chalta — sirf ye specific types supported hain:

* Primitive: `byte`, `short`, `int`, `char`
* Unke wrapper classes: `Byte`, `Short`, `Integer`, `Character`
* `String` (Java 7 se available)
* `enum`

⚠️ `long`, `float`, `double`, `boolean` switch me directly **supported nahi** hain.

```java
// ❌ Ye compile error dega
double price = 10.5;
switch (price) {
    case 10.5:
        System.out.println("Match");
}
```

---

# 1. Basic Switch

### Syntax

```java
switch (expression) {

    case value1:
        // code
        break;

    case value2:
        // code
        break;

    default:
        // code
}
```

Example:

```java
int number = 2;

switch (number) {

    case 1:
        System.out.println("One");
        break;

    case 2:
        System.out.println("Two");
        break;

    case 3:
        System.out.println("Three");
        break;

    default:
        System.out.println("Invalid number");
}
```

Output:

```text
Two
```

---

# 2. `case`

`case` kisi specific value ko represent karta hai.

```java
int day = 1;

switch (day) {

    case 1:
        System.out.println("Monday");
        break;

    case 2:
        System.out.println("Tuesday");
        break;
}
```

Agar `day = 1` hai to `case 1` execute hoga.

---

# 3. `break`

`break` current `switch` ko stop karta hai.

```java
int number = 2;

switch (number) {

    case 1:
        System.out.println("One");
        break;

    case 2:
        System.out.println("Two");
        break;

    case 3:
        System.out.println("Three");
        break;
}
```

Output:

```text
Two
```

Agar `break` na ho to execution next cases me continue kar sakta hai (fall-through — Section 11 me detail se cover kiya gaya hai).

---

# 4. `default`

Agar koi bhi `case` match nahi hota, to `default` execute hota hai.

```java
int day = 10;

switch (day) {

    case 1:
        System.out.println("Monday");
        break;

    case 2:
        System.out.println("Tuesday");
        break;

    default:
        System.out.println("Invalid day");
}
```

Output:

```text
Invalid day
```

`default` optional hota hai, lekin isse hamesha include karna best practice hai — isse unexpected input silently ignore nahi hota.

Note: `default` switch me kahin bhi likha ja sakta hai (upar, beech me, ya end me) — usually convention ke tor par ise **last** me rakha jata hai.

---

# 5. Switch with Days

```java
int day = 3;

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

    case 4:
        System.out.println("Thursday");
        break;

    case 5:
        System.out.println("Friday");
        break;

    case 6:
        System.out.println("Saturday");
        break;

    case 7:
        System.out.println("Sunday");
        break;

    default:
        System.out.println("Invalid day");
}
```

Output:

```text
Wednesday
```

---

# 6. Multiple Cases

Multiple cases ko same block me combine kar sakte ho.

Example:

```java
int day = 6;

switch (day) {

    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
        System.out.println("Weekday");
        break;

    case 6:
    case 7:
        System.out.println("Weekend");
        break;

    default:
        System.out.println("Invalid day");
}
```

Output:

```text
Weekend
```

---

# 7. Switch with String

Java me `String` ke saath bhi switch use kar sakte hain (Java 7+).

```java
String language = "Java";

switch (language) {

    case "Java":
        System.out.println("Java Programming");
        break;

    case "Python":
        System.out.println("Python Programming");
        break;

    case "JavaScript":
        System.out.println("JavaScript Programming");
        break;

    default:
        System.out.println("Unknown Language");
}
```

Output:

```text
Java Programming
```

⚠️ Important: `String` switch case-sensitive hota hai — `"Java"` aur `"java"` alag treat honge.

⚠️ Agar switch expression `null` hai, to `NullPointerException` aayega (traditional switch me). Isliye null-check pehle kar lena chahiye:

```java
String language = null;

if (language == null) {
    System.out.println("Language not provided");
} else {
    switch (language) {
        case "Java":
            System.out.println("Java Programming");
            break;
        default:
            System.out.println("Unknown Language");
    }
}
```

---

# 8. Switch with char

```java
char grade = 'A';

switch (grade) {

    case 'A':
        System.out.println("Excellent");
        break;

    case 'B':
        System.out.println("Good");
        break;

    case 'C':
        System.out.println("Average");
        break;

    case 'D':
        System.out.println("Needs Improvement");
        break;

    default:
        System.out.println("Invalid Grade");
}
```

Output:

```text
Excellent
```

---

# 9. Switch with User Input

```java
import java.util.Scanner;

public class SwitchExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter day number: ");
        int day = sc.nextInt();

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

            case 4:
                System.out.println("Thursday");
                break;

            case 5:
                System.out.println("Friday");
                break;

            case 6:
                System.out.println("Saturday");
                break;

            case 7:
                System.out.println("Sunday");
                break;

            default:
                System.out.println("Invalid day");
        }

        sc.close();
    }
}
```

Input:

```text
Enter day number: 5
```

Output:

```text
Friday
```

---

# 10. Calculator Using Switch

`switch` ka ek common practical use calculator hai.

```java
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        switch (operator) {

            case '+':
                System.out.println("Result: " + (a + b));
                break;

            case '-':
                System.out.println("Result: " + (a - b));
                break;

            case '*':
                System.out.println("Result: " + (a * b));
                break;

            case '/':
                if (b != 0) {
                    System.out.println("Result: " + (a / b));
                } else {
                    System.out.println("Cannot divide by zero");
                }
                break;

            default:
                System.out.println("Invalid operator");
        }

        sc.close();
    }
}
```

Input:

```text
Enter first number: 20
Enter second number: 5
Enter operator (+, -, *, /): *
```

Output:

```text
Result: 100.0
```

---

# 11. Fall-Through

Agar `case` ke andar `break` nahi hai, execution next case me continue kar sakta hai — ye tab hota hai kyunki Java switch case ke end pe automatically stop nahi hota jab tak `break` na mile.

Example:

```java
int number = 1;

switch (number) {

    case 1:
        System.out.println("One");

    case 2:
        System.out.println("Two");

    case 3:
        System.out.println("Three");

    default:
        System.out.println("Other");
}
```

Output:

```text
One
Two
Three
Other
```

⚠️ Ye behavior **fall-through** kehlata hai, aur ye most common source of bugs hai traditional switch me — isliye `break` bhoolna avoid karna zaroori hai.

📌 Note: Modern switch expressions (arrow syntax `->`, Section 15) me fall-through **automatically nahi hota** — har case apne aap break ho jata hai, `break` likhne ki zarurat nahi.

---

# 12. Intentional Fall-Through

Kabhi-kabhi fall-through intentionally use kiya jata hai — jaise multiple values ko same result dena.

```java
int month = 2;

switch (month) {

    case 12:
    case 1:
    case 2:
        System.out.println("Winter");
        break;

    case 3:
    case 4:
    case 5:
        System.out.println("Spring");
        break;

    default:
        System.out.println("Other season");
}
```

Output:

```text
Winter
```

---

# 13. Nested Switch

Ek switch ke andar doosra switch bhi use kar sakte hain.

```java
int category = 1;
int option = 2;

switch (category) {

    case 1:

        switch (option) {

            case 1:
                System.out.println("Option 1");
                break;

            case 2:
                System.out.println("Option 2");
                break;

            default:
                System.out.println("Invalid option");
        }

        break;

    default:
        System.out.println("Invalid category");
}
```

Output:

```text
Option 2
```

⚠️ Nested switch readability kam kar deta hai — agar levels 2 se zyada ho jaye, to method me todna ya `if-else` use karna better hota hai.

---

# 14. Statement vs Expression — Traditional vs Modern Switch

Ye difference samajhna zaroori hai:

| Traditional `switch` (Statement) | Modern `switch` (Expression) |
|---|---|
| Sirf actions perform karta hai | Value **return** karta hai |
| Directly variable assign nahi kar sakte | Directly assign kar sakte ho |
| `break` zaroori hai (fall-through se bachne ke liye) | `break` ki zarurat nahi, no fall-through |
| Java ke pehle version se available | Java 14+ me stable hua |

Example — Modern Switch Expression:

```java
int day = 2;

String result = switch (day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    case 3 -> "Wednesday";
    default -> "Invalid";
};

System.out.println(result);
```

Output:

```text
Tuesday
```

Isme `break` ki zarurat nahi hoti kyunki har arrow case apne aap ek value deta hai aur switch khud khatam ho jata hai.

---

# 15. Arrow Syntax

Modern switch me:

```java
case 1 -> "Monday";
```

likh sakte ho — action ke liye bhi:

```java
int number = 3;

switch (number) {

    case 1 -> System.out.println("One");
    case 2 -> System.out.println("Two");
    case 3 -> System.out.println("Three");
    default -> System.out.println("Other");
}
```

Output:

```text
Three
```

Arrow syntax ke saath multiple values ek case me comma se bhi likh sakte ho:

```java
case 1, 2, 3 -> System.out.println("Start of week");
```

---

# 16. Switch Expression with `yield`

Jab switch expression ke case me multiple statements execute karne ho aur ek value bhi return karni ho, `yield` use karte ho — `yield` ek block ke andar "ye value return karo" bolne ka tarika hai.

```java
int marks = 85;

String grade = switch (marks / 10) {

    case 10, 9 -> "A+";

    case 8 -> {
        System.out.println("Very Good");
        yield "A";
    }

    case 7 -> "B";

    case 6 -> "C";

    default -> "D";
};

System.out.println("Grade: " + grade);
```

Output:

```text
Very Good
Grade: A
```

---

# 17. Switch vs if-else

### Switch

```java
switch (day) {

    case 1:
        System.out.println("Monday");
        break;

    case 2:
        System.out.println("Tuesday");
        break;
}
```

### if-else

```java
if (day == 1) {
    System.out.println("Monday");
} else if (day == 2) {
    System.out.println("Tuesday");
}
```

### Switch useful when:

* Fixed values compare karne ho
* Menu/options ho
* Day/month selection ho
* Calculator operations ho
* User choices ho

### if-else useful when:

* Ranges compare karni ho
* Complex conditions ho
* `>`, `<`, `>=`, `<=` based decisions ho
* Multiple logical conditions ho
* `long`, `float`, `double`, `boolean` types involve ho (switch inme kaam nahi karta)

---

# 💻 Complete Example — Menu System

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

Input:

```text
Enter your choice: 3
```

Output:

```text
Multiplication selected
```

---

# 📝 Practice Questions

## Beginner

1. Number `1-7` se day print karo.
2. Number `1-12` se month print karo.
3. Character grade ke basis par message print karo.
4. String language ke basis par programming language ka message print karo.
5. `1-5` menu options create karo.

## Intermediate

6. Switch se calculator banao.
7. Weekday/weekend identify karo.
8. Month number se season identify karo.
9. Menu-driven student management options banao.
10. ATM menu banao.

## Advanced

11. Nested switch ka use karke category aur option system banao.
12. Switch expression ka use karke grade system banao.
13. `yield` ka use karke switch expression practice karo.
14. Calculator me invalid operator aur divide-by-zero handle karo.

---

# 🚀 Challenge 1 — ATM Menu

Menu:

```text
===== ATM =====

1. Check Balance
2. Deposit
3. Withdraw
4. Exit
```

User choice ke basis par correct operation perform karo.

Example:

```text
Enter choice: 1

Balance: ₹5000
```

---

# 🚀 Challenge 2 — Food Menu

Menu:

```text
===== FOOD MENU =====

1. Pizza - ₹200
2. Burger - ₹120
3. Pasta - ₹150
4. Sandwich - ₹100
5. Exit
```

User se choice aur quantity lo.

Example:

```text
Enter choice: 2
Enter quantity: 3
```

Output:

```text
Item: Burger
Price: ₹120
Quantity: 3
Total: ₹360
```

---

# 🚀 Challenge 3 — Calculator

Input:

```text
Enter first number: 20
Enter second number: 5
Enter operator: /
```

Output:

```text
Result: 4.0
```

Support:

```text
+
-
*
/
%
```

---

# ⚠️ Common Mistakes

## 1. `break` bhoolna

```java
case 1:
    System.out.println("One");

case 2:
    System.out.println("Two");
```

Isse fall-through ho sakta hai (Section 11 dekho).

---

## 2. `default` ko unnecessary case samajhna

`default` tab execute hota hai jab koi case match nahi karta. Isse hamesha include karna best practice hai, chahe koi "invalid" case abhi na bhi soch rahe ho.

---

## 3. Range check karna

Ye:

```java
case 90:
case 91:
case 92:
```

possible hai, lekin ranges ke liye `if-else` generally better hota hai.

Example:

```java
if (marks >= 90) {
    System.out.println("A");
}
```

---

## 4. String comparison

Modern `switch` String values ke saath use kar sakte ho:

```java
String day = "Monday";

switch (day) {
    case "Monday":
        System.out.println("Start");
        break;
}
```

Lekin `null` value pass karne se `NullPointerException` aayega — pehle null-check karo (Section 7 dekho).

---

## 5. Unsupported data types use karna

`switch` `long`, `float`, `double`, `boolean` ke saath directly kaam nahi karta — ye common beginner mistake hai jo compile-time error deta hai.

---

# 🔑 Key Takeaways

* `switch` multiple fixed choices handle karta hai.
* Sirf `byte`, `short`, `int`, `char` (aur wrappers), `String`, aur `enum` ke saath kaam karta hai — `long`, `float`, `double`, `boolean` supported nahi.
* `case` individual choice/value represent karta hai.
* `break` switch execution ko stop karta hai.
* `default` unmatched value handle karta hai — hamesha include karna best practice hai.
* Missing `break` se fall-through ho sakta hai (traditional switch me).
* Modern Java me `case ->` switch syntax available hai jisme fall-through nahi hota.
* Switch expressions value return kar sakti hain aur directly variable assign ho sakti hain.
* `yield` block ke andar se value return karne ke liye use hota hai.
* Complex ranges ke liye `if-else` often more suitable hai.

## 🚀 Next Topic

**02-Control-Flow → 04-for-loop**

Yahan se Java ke **loops** start honge — repetition, counting, tables, patterns aur iteration.