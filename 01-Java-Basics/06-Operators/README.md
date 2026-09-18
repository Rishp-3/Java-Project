# Operators in Java

## 📌 Topic

**Operators** special symbols hote hain jo variables aur values par different operations perform karne ke liye use hote hain.

Example:

```java
int a = 10;
int b = 5;

int result = a + b;
```

Yahan `+` ek **Arithmetic Operator** hai.

---

# 🎯 What You Will Learn

* Operators kya hote hain
* Arithmetic Operators
* Assignment Operators
* Relational Operators
* Logical Operators
* Unary Operators
* Increment & Decrement
* Ternary Operator
* Bitwise Operators
* Operator Precedence
* Short-Circuit Operators

---

# 1. Types of Operators

Java me commonly ye operators use hote hain:

```text
1. Arithmetic Operators
2. Assignment Operators
3. Relational Operators
4. Logical Operators
5. Unary Operators
6. Ternary Operator
7. Bitwise Operators
8. Shift Operators
```

---

# 2. Arithmetic Operators

Arithmetic operators mathematical calculations ke liye use hote hain.

| Operator | Meaning             |
| -------- | ------------------- |
| `+`      | Addition            |
| `-`      | Subtraction         |
| `*`      | Multiplication      |
| `/`      | Division            |
| `%`      | Modulus / Remainder |

Example:

```java
int a = 10;
int b = 3;

System.out.println(a + b);
System.out.println(a - b);
System.out.println(a * b);
System.out.println(a / b);
System.out.println(a % b);
```

Output:

```text
13
7
30
3
1
```

---

# 3. Addition `+`

```java
int a = 10;
int b = 20;

int result = a + b;

System.out.println(result);
```

Output:

```text
30
```

`+` Strings ko join karne ke liye bhi use hota hai:

```java
String firstName = "Rishabh";
String lastName = "Pal";

System.out.println(firstName + " " + lastName);
```

Output:

```text
Rishabh Pal
```

---

# 4. Modulus `%`

`%` division ka remainder return karta hai.

```java
int result = 10 % 3;

System.out.println(result);
```

Output:

```text
1
```

Example:

```java
int number = 10;

if (number % 2 == 0) {
    System.out.println("Even");
}
```

Output:

```text
Even
```

---

# 5. Assignment Operators

Assignment operators variable ko value assign/update karne ke liye use hote hain.

| Operator | Example  | Meaning     |
| -------- | -------- | ----------- |
| `=`      | `a = 10` | Assign      |
| `+=`     | `a += 5` | `a = a + 5` |
| `-=`     | `a -= 5` | `a = a - 5` |
| `*=`     | `a *= 5` | `a = a * 5` |
| `/=`     | `a /= 5` | `a = a / 5` |
| `%=`     | `a %= 5` | `a = a % 5` |

Example:

```java
int a = 10;

a += 5;

System.out.println(a);
```

Output:

```text
15
```

---

# 6. Relational Operators

Relational operators do values ko compare karte hain.

Result hamesha `true` ya `false` hota hai.

| Operator | Meaning               |
| -------- | --------------------- |
| `==`     | Equal                 |
| `!=`     | Not Equal             |
| `>`      | Greater Than          |
| `<`      | Less Than             |
| `>=`     | Greater Than or Equal |
| `<=`     | Less Than or Equal    |

Example:

```java
int a = 10;
int b = 20;

System.out.println(a == b);
System.out.println(a != b);
System.out.println(a > b);
System.out.println(a < b);
```

Output:

```text
false
true
false
true
```

---

# ⚠️ `=` vs `==`

Ye bahut important difference hai.

### `=`

Assignment ke liye:

```java
int age = 20;
```

### `==`

Comparison ke liye:

```java
age == 20
```

---

# 7. Logical Operators

Logical operators multiple conditions ko combine karne ke liye use hote hain.

| Operator | Name        |   |            |
| -------- | ----------- | - | ---------- |
| `&&`     | Logical AND |   |            |
| `        |             | ` | Logical OR |
| `!`      | Logical NOT |   |            |

---

## AND `&&`

Dono conditions `true` honi chahiye.

```java
int age = 20;

System.out.println(age >= 18 && age <= 60);
```

Output:

```text
true
```

Example:

```text
true && true   → true
true && false  → false
false && true  → false
false && false → false
```

---

# 8. OR `||`

Kam se kam ek condition true honi chahiye.

```java
int age = 16;

System.out.println(age < 18 || age > 60);
```

Output:

```text
true
```

Truth table:

```text
true || true   → true
true || false  → true
false || true  → true
false || false → false
```

---

# 9. NOT `!`

Boolean value ko reverse karta hai.

```java
boolean isStudent = true;

System.out.println(!isStudent);
```

Output:

```text
false
```

---

# 10. Unary Operators

Unary operators sirf **ek operand** par kaam karte hain.

Common unary operators:

```text
+
-
++
--
!
```

Example:

```java
int a = 10;

System.out.println(-a);
```

Output:

```text
-10
```

---

# 11. Increment `++`

Variable ki value 1 se increase karta hai.

```java
int a = 10;

a++;

System.out.println(a);
```

Output:

```text
11
```

---

# 12. Decrement `--`

Variable ki value 1 se decrease karta hai.

```java
int a = 10;

a--;

System.out.println(a);
```

Output:

```text
9
```

---

# 13. Pre-Increment

```java
int a = 10;

int result = ++a;

System.out.println(result);
System.out.println(a);
```

Output:

```text
11
11
```

Pehle value increase hoti hai, phir use hoti hai.

---

# 14. Post-Increment

```java
int a = 10;

int result = a++;

System.out.println(result);
System.out.println(a);
```

Output:

```text
10
11
```

Pehle current value use hoti hai, phir increase hoti hai.

---

# 15. Pre-Decrement

```java
int a = 10;

int result = --a;

System.out.println(result);
```

Output:

```text
9
```

---

# 16. Post-Decrement

```java
int a = 10;

int result = a--;

System.out.println(result);
```

Output:

```text
10
```

Baad me `a` ki value `9` ho jayegi.

---

# 17. Ternary Operator

Ternary operator short `if-else` ki tarah use hota hai.

Syntax:

```text
condition ? valueIfTrue : valueIfFalse;
```

Example:

```java
int age = 20;

String result = age >= 18 ? "Adult" : "Minor";

System.out.println(result);
```

Output:

```text
Adult
```

Normal `if-else`:

```java
if (age >= 18) {
    result = "Adult";
} else {
    result = "Minor";
}
```

Ternary:

```java
String result = age >= 18 ? "Adult" : "Minor";
```

---

# 18. Bitwise Operators

Bitwise operators numbers ke binary bits par kaam karte hain.

| Operator | Meaning |    |
| -------- | ------- | -- |
| `&`      | AND     |    |
| `        | `       | OR |
| `^`      | XOR     |    |
| `~`      | NOT     |    |

Example:

```java
int a = 5;
int b = 3;

System.out.println(a & b);
System.out.println(a | b);
System.out.println(a ^ b);
```

---

# 19. Binary Representation

Example:

```text
5 = 0101
3 = 0011
```

AND:

```text
0101
0011
----
0001
```

Result:

```text
1
```

OR:

```text
0101
0011
----
0111
```

Result:

```text
7
```

---

# 20. Shift Operators

Java me shift operators bits ko left/right shift karte hain.

| Operator | Meaning              |
| -------- | -------------------- |
| `<<`     | Left Shift           |
| `>>`     | Right Shift          |
| `>>>`    | Unsigned Right Shift |

Example:

```java
int a = 8;

System.out.println(a << 1);
System.out.println(a >> 1);
```

Output:

```text
16
4
```

---

# 21. Operator Precedence

Jab expression me multiple operators hote hain, Java ek specific order follow karta hai.

Example:

```java
int result = 10 + 5 * 2;
```

Result:

```text
20
```

`5 * 2` pehle calculate hota hai.

Agar parentheses use karo:

```java
int result = (10 + 5) * 2;
```

Result:

```text
30
```

### Basic Order

```text
()
++
--
*
/
%
+
-
<
>
<=
>=
==
!=
&&
||
?:
=
```

Parentheses `()` ka use karke calculation ka order clearly control karna best practice hai.

---

# 22. Short-Circuit Evaluation

`&&` aur `||` conditions ko short-circuit kar sakte hain.

Example:

```java
int age = 20;

if (age > 18 && age < 60) {
    System.out.println("Valid age");
}
```

`&&` me agar first condition `false` hai, to Java second condition evaluate nahi kar sakta/zaroori nahi hota.

Similarly, `||` me first condition `true` ho to second condition evaluate karna zaroori nahi hota.

---

# 💻 Complete Example

```java
public class Operators {
    public static void main(String[] args) {

        int a = 10;
        int b = 3;

        // Arithmetic
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Remainder: " + (a % b));

        // Relational
        System.out.println("a == b: " + (a == b));
        System.out.println("a > b: " + (a > b));

        // Logical
        System.out.println("AND: " + (a > 5 && b < 5));
        System.out.println("OR: " + (a > 20 || b < 5));

        // Ternary
        String result = a > b ? "a is greater" : "b is greater";
        System.out.println(result);
    }
}
```

---

# 📝 Practice Questions

## Beginner

1. Do numbers ka addition karo.
2. Subtraction, multiplication aur division karo.
3. Do numbers ka remainder find karo.
4. Check karo number even hai ya odd.
5. Do numbers compare karo.
6. Check karo number positive, negative ya zero hai.

## Intermediate

7. Check karo age `18` se greater/equal hai ya nahi.
8. `&&` ka use karke age range check karo.
9. `||` ka use karke condition check karo.
10. Ternary operator se even/odd check karo.
11. Pre-increment aur post-increment ka difference demonstrate karo.
12. Pre-decrement aur post-decrement ka difference demonstrate karo.

## Advanced

13. Bitwise AND, OR aur XOR implement karo.
14. Left shift aur right shift test karo.
15. Operator precedence ke 5 examples banao.
16. Multiple logical conditions ko combine karo.
17. Short-circuit evaluation ko example ke saath demonstrate karo.

---

# 🚀 Challenge

User se do integers input lo aur output print karo:

```text
Enter first number: 20
Enter second number: 6

===== Results =====

Addition: 26
Subtraction: 14
Multiplication: 120
Division: 3
Remainder: 2

First number greater: true
Numbers equal: false

Both positive: true

Maximum: 20
```

Is challenge me use karo:

* Arithmetic operators
* Relational operators
* Logical operators
* Ternary operator
* Scanner

---

# 🔑 Key Takeaways

* Operators values par operations perform karte hain.
* `+ - * / %` → Arithmetic
* `= += -= *= /= %=` → Assignment
* `== != > < >= <=` → Relational
* `&& || !` → Logical
* `++ --` → Increment/Decrement
* `?:` → Ternary
* `& | ^ ~` → Bitwise
* `<< >> >>>` → Shift
* Parentheses `()` expression ka order control karne ke liye useful hain.

## 🚀 Next Topic

**07-Comments** — Code me explanations aur notes likhna without affecting program execution.
