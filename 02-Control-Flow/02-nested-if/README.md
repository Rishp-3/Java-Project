# Nested If in Java

## 📌 Topic

Jab ek `if` statement ke andar doosra `if` statement likha jata hai, use **Nested If** kehte hain.

Simple structure:

```java
if (condition1) {

    if (condition2) {
        // code
    }

}
```

Nested `if` ka use tab hota hai jab **second condition ko check karne se pehle first condition ka true hona zaroori ho**.

---

# 🎯 What You Will Learn

* Nested `if` kya hota hai
* Nested `if` ka syntax
* Nested `if-else`
* Multiple nested conditions
* Nested `if` with `&&`
* User input ke saath nested `if`
* Real-world examples
* Nested `if` ko simplify karna
* Common mistakes

---

# 1. Basic Nested If

```java
int age = 20;

if (age >= 18) {

    if (age <= 60) {
        System.out.println("Eligible");
    }

}
```

Output:

```text
Eligible
```

### Flow

```text
age >= 18 ?
    ↓
   YES
    ↓
age <= 60 ?
    ↓
   YES
    ↓
Eligible
```

Agar first condition `false` ho jaye, inner `if` execute nahi hoga.

---

# 2. Nested If-Else

```java
int age = 20;

if (age >= 18) {

    if (age >= 21) {
        System.out.println("Age is 21 or above");
    } else {
        System.out.println("Age is between 18 and 20");
    }

} else {
    System.out.println("Below 18");
}
```

Output:

```text
Age is between 18 and 20
```

---

# 3. Nested If with Boolean

```java
int age = 25;
boolean hasLicense = true;

if (age >= 18) {

    if (hasLicense) {
        System.out.println("You can drive");
    } else {
        System.out.println("You need a driving license");
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

# 4. Nested If with Multiple Conditions

```java
int marks = 85;

if (marks >= 40) {

    if (marks >= 80) {
        System.out.println("Excellent");
    } else {
        System.out.println("Passed");
    }

} else {
    System.out.println("Failed");
}
```

Output:

```text
Excellent
```

---

# 5. Nested If vs &&

Ye dono kai situations me same result de sakte hain.

### Nested If

```java
int age = 25;

if (age >= 18) {

    if (age <= 60) {
        System.out.println("Valid age");
    }

}
```

### Logical AND

```java
int age = 25;

if (age >= 18 && age <= 60) {
    System.out.println("Valid age");
}
```

Dono ka output:

```text
Valid age
```

### Difference

Nested `if` tab useful hai jab conditions ke beech **step-by-step dependency** ho ya inner logic alag ho.

Simple independent conditions ke liye `&&` often code ko shorter aur readable bana sakta hai.

---

# 6. User Input with Nested If

```java
import java.util.Scanner;

public class NestedIf {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        if (age >= 18) {

            System.out.print("Do you have a license? (true/false): ");
            boolean hasLicense = sc.nextBoolean();

            if (hasLicense) {
                System.out.println("You can drive.");
            } else {
                System.out.println("You need a license.");
            }

        } else {
            System.out.println("You are underage.");
        }

        sc.close();
    }
}
```

### Input

```text
Enter your age: 22
Do you have a license? (true/false): true
```

### Output

```text
You can drive.
```

---

# 7. Nested If — Student Result

```java
int marks = 75;

if (marks >= 40) {

    if (marks >= 80) {
        System.out.println("Grade A");
    } else if (marks >= 60) {
        System.out.println("Grade B");
    } else {
        System.out.println("Grade C");
    }

} else {
    System.out.println("Fail");
}
```

Output:

```text
Grade B
```

---

# 8. Nested If — Login System

```java
String username = "admin";
String password = "1234";

if (username.equals("admin")) {

    if (password.equals("1234")) {
        System.out.println("Login Successful");
    } else {
        System.out.println("Wrong Password");
    }

} else {
    System.out.println("Wrong Username");
}
```

Output:

```text
Login Successful
```

### Flow

```text
Username correct?
       ↓
      YES
       ↓
Password correct?
       ↓
      YES
       ↓
Login Successful
```

---

# 9. Nested If — ATM Example

```java
int pin = 1234;
double balance = 5000;
int enteredPin = 1234;
double withdraw = 2000;

if (enteredPin == pin) {

    if (withdraw <= balance) {
        System.out.println("Withdrawal Successful");
        System.out.println("Remaining Balance: " + (balance - withdraw));
    } else {
        System.out.println("Insufficient Balance");
    }

} else {
    System.out.println("Incorrect PIN");
}
```

Output:

```text
Withdrawal Successful
Remaining Balance: 3000.0
```

---

# 10. Nested If — Largest of Three

```java
int a = 30;
int b = 20;
int c = 10;

if (a > b) {

    if (a > c) {
        System.out.println("A is largest");
    } else {
        System.out.println("C is largest");
    }

} else {

    if (b > c) {
        System.out.println("B is largest");
    } else {
        System.out.println("C is largest");
    }

}
```

Output:

```text
A is largest
```

---

# 11. Three-Level Nested If

Nested `if` ko multiple levels tak use kar sakte hain.

```java
int age = 25;
boolean hasId = true;
boolean hasTicket = true;

if (age >= 18) {

    if (hasId) {

        if (hasTicket) {
            System.out.println("Entry Allowed");
        } else {
            System.out.println("Ticket Required");
        }

    } else {
        System.out.println("ID Required");
    }

} else {
    System.out.println("Age Requirement Not Met");
}
```

Output:

```text
Entry Allowed
```

⚠️ Bahut zyada nesting code ko difficult bana sakti hai. Real projects me complex logic ko methods ya clearer conditions me divide karna better hota hai.

---

# 12. Nested If with String

```java
String role = "admin";
String username = "Rishabh";

if (role.equals("admin")) {

    if (username.equals("Rishabh")) {
        System.out.println("Welcome Admin");
    } else {
        System.out.println("Unknown Admin");
    }

} else {
    System.out.println("Access Denied");
}
```

Output:

```text
Welcome Admin
```

---

# 13. Complete Example

```java
import java.util.Scanner;

public class NestedIf {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        if (age >= 18) {

            System.out.print("Are you a citizen? (true/false): ");
            boolean citizen = sc.nextBoolean();

            if (citizen) {

                System.out.print("Do you have valid ID? (true/false): ");
                boolean hasId = sc.nextBoolean();

                if (hasId) {
                    System.out.println("You are eligible.");
                } else {
                    System.out.println("Valid ID required.");
                }

            } else {
                System.out.println("Citizenship requirement not met.");
            }

        } else {
            System.out.println("You are underage.");
        }

        sc.close();
    }
}
```

### Example Input

```text
Enter your age: 25
Are you a citizen? (true/false): true
Do you have valid ID? (true/false): true
```

### Output

```text
You are eligible.
```

---

# 📝 Practice Questions

## Beginner

1. Check karo age 18+ hai. Agar hai to check karo age 60 se kam hai.
2. Check karo number positive hai. Agar positive hai to check karo even hai ya odd.
3. Check karo student pass hai. Agar pass hai to grade check karo.
4. Check karo user adult hai. Agar adult hai to license check karo.

---

## Intermediate

5. Username correct hone ke baad password check karo.
6. ATM me pehle PIN check karo, phir balance check karo.
7. Teen numbers me largest number nested `if` se find karo.
8. Check karo employee eligible hai, phir experience check karo.
9. Check karo product available hai, phir stock quantity check karo.

---

## Advanced

10. Login system banao:

* Username check
* Password check
* Account status check

11. ATM system banao:

* PIN verification
* Balance verification
* Withdrawal amount verification

12. Student result system banao:

* Marks valid hain ya nahi
* Pass/fail
* Grade
* Division

---

# 🚀 Challenge 1 — Login System

Input:

```text
Enter username: admin
Enter password: 1234
```

Expected:

```text
Login Successful
Welcome Admin!
```

Wrong username:

```text
Invalid Username
```

Correct username but wrong password:

```text
Invalid Password
```

---

# 🚀 Challenge 2 — ATM

User se input lo:

```text
Enter PIN:
Enter withdrawal amount:
```

Rules:

1. PIN correct hona chahiye.
2. Balance sufficient hona chahiye.
3. Withdrawal amount positive hona chahiye.

Example:

```text
Enter PIN: 1234
Enter withdrawal amount: 2000
```

Output:

```text
Withdrawal Successful
Remaining Balance: 3000
```

---

# 🚀 Challenge 3 — Student Result

User se marks input lo.

Rules:

```text
0-100 → Valid
40+   → Pass
80+   → Grade A
60-79 → Grade B
40-59 → Grade C
<40   → Fail
```

Example:

```text
Enter marks: 85
```

Output:

```text
Valid Marks
Result: Pass
Grade: A
```

---

# ⚠️ Common Mistakes

## 1. Braces `{}` bhoolna

❌ Avoid:

```java
if (age >= 18)
    if (hasLicense)
        System.out.println("Can Drive");
    else
        System.out.println("No License");
```

Multiple nested conditions me braces use karna readability aur correctness ke liye better hai.

✅ Better:

```java
if (age >= 18) {

    if (hasLicense) {
        System.out.println("Can Drive");
    } else {
        System.out.println("No License");
    }

}
```

---

## 2. Wrong `else` Association

`else` nearest unmatched `if` ke saath associate hota hai.

Isliye nested `if` me `{}` use karna important hai.

---

## 3. String Comparison

❌ Avoid:

```java
if (username == "admin")
```

✅ Use:

```java
if (username.equals("admin"))
```

---

# 🔑 Key Takeaways

* `if` ke andar `if` = **Nested If**
* Inner `if` tabhi check hota hai jab outer condition allow kare.
* Nested `if` dependent/step-by-step decisions ke liye useful hai.
* Simple combined conditions ke liye `&&` bhi use kiya ja sakta hai.
* Multiple nesting code ko complex bana sakti hai.
* Nested conditions me `{}` use karna good practice hai.
* String comparison ke liye `.equals()` use karo.

## 🚀 Next Topic

**02-Control-Flow → 03-switch**

Isme hum `switch`, `case`, `break`, `default` aur modern switch expressions practice karenge.
