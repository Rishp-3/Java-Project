# Type Casting in Java

## 📌 Topic

**Type Casting** ka matlab hai ek data type ki value ko doosre data type me convert karna.

Example:

```java
int number = 10;
double result = number;
```

Yahan `int` ki value automatically `double` me convert ho gayi.

Java me Type Casting mainly 2 types ki hoti hai:

1. **Widening Casting**
2. **Narrowing Casting**

---

# 🎯 What You Will Learn

* Type Casting kya hota hai
* Widening Casting
* Narrowing Casting
* Implicit Casting
* Explicit Casting
* Primitive data types ko convert karna
* Data loss kya hota hai
* `char` aur numbers ke beech conversion
* Type Casting ke common mistakes

---

# 1. Widening Casting

Widening ka matlab hai **smaller data type → larger data type**.

Ye conversion Java automatically kar deta hai.

### Order

```text
byte
  ↓
short
  ↓
int
  ↓
long
  ↓
float
  ↓
double
```

Example:

```java
int number = 100;

double value = number;

System.out.println(value);
```

### Output

```text
100.0
```

Yahan `int` automatically `double` me convert ho gaya.

---

# 2. Widening Casting Example

```java
public class TypeCasting {
    public static void main(String[] args) {

        int number = 100;

        long longNumber = number;
        float floatNumber = longNumber;
        double doubleNumber = floatNumber;

        System.out.println(longNumber);
        System.out.println(floatNumber);
        System.out.println(doubleNumber);
    }
}
```

### Output

```text
100
100.0
100.0
```

---

# 3. Implicit Casting

Jab Java automatically data type conversion karta hai, use **Implicit Casting** kehte hain.

```java
int number = 50;

double result = number;
```

Java internally:

```text
int → double
```

convert karta hai.

---

# 4. Narrowing Casting

Narrowing ka matlab hai **larger data type → smaller data type**.

Is conversion ko Java automatically nahi karta.

Hume manually casting karni padti hai.

### Example

```java
double number = 10.99;

int result = (int) number;

System.out.println(result);
```

### Output

```text
10
```

Decimal part remove ho gaya.

---

# 5. Explicit Casting

Jab hum manually data type specify karke conversion karte hain, use **Explicit Casting** kehte hain.

Syntax:

```text
targetDataType variable = (targetDataType) value;
```

Example:

```java
double price = 99.99;

int result = (int) price;
```

---

# 6. Data Loss

Narrowing conversion me data loss ho sakta hai.

Example:

```java
double number = 99.99;

int result = (int) number;

System.out.println(result);
```

Output:

```text
99
```

`.99` decimal part lost ho gaya.

### Important

Type casting rounding nahi karti.

```java
double number = 99.99;
int result = (int) number;
```

Result:

```text
99
```

Ye `100` nahi hoga.

---

# 7. int to double

```java
int number = 25;

double result = number;

System.out.println(result);
```

Output:

```text
25.0
```

Ye **Widening Casting** hai.

---

# 8. double to int

```java
double number = 25.75;

int result = (int) number;

System.out.println(result);
```

Output:

```text
25
```

Ye **Narrowing Casting** hai.

---

# 9. float to int

```java
float number = 45.8f;

int result = (int) number;

System.out.println(result);
```

Output:

```text
45
```

---

# 10. long to int

```java
long number = 1000L;

int result = (int) number;

System.out.println(result);
```

Output:

```text
1000
```

⚠️ Lekin agar `long` ki value `int` ki range se bahar hai to value incorrect ho sakti hai.

---

# 11. int to byte

```java
int number = 100;

byte result = (byte) number;

System.out.println(result);
```

Output:

```text
100
```

Lekin:

```java
int number = 130;

byte result = (byte) number;

System.out.println(result);
```

Output:

```text
-126
```

Kyunki `byte` ki range:

```text
-128 to 127
```

hai.

---

# 12. char to int

Java me `char` ko integer me convert kar sakte hain.

```java
char letter = 'A';

int number = letter;

System.out.println(number);
```

Output:

```text
65
```

`A` ka Unicode value `65` hai.

Example:

```java
char letter = 'B';

int number = letter;

System.out.println(number);
```

Output:

```text
66
```

---

# 13. int to char

Integer ko `char` me cast kar sakte hain.

```java
int number = 65;

char letter = (char) number;

System.out.println(letter);
```

Output:

```text
A
```

Example:

```java
int number = 66;

char letter = (char) number;

System.out.println(letter);
```

Output:

```text
B
```

---

# 14. Arithmetic with Different Data Types

Java expressions me bhi type conversion hota hai.

Example:

```java
int a = 10;
double b = 5.5;

double result = a + b;

System.out.println(result);
```

Output:

```text
15.5
```

`int` value `double` ke saath promote ho gayi.

---

# 15. Important Example

```java
int a = 10;
int b = 3;

double result = a / b;

System.out.println(result);
```

Output:

```text
3.0
```

⚠️ Bahut important:

`a` aur `b` dono `int` hain, isliye division pehle integer division karta hai:

```text
10 / 3 = 3
```

Agar actual decimal result chahiye:

```java
double result = (double) a / b;

System.out.println(result);
```

Output:

```text
3.3333333333333335
```

---

# 16. Type Casting with Division

### Without Casting

```java
int a = 10;
int b = 3;

double result = a / b;

System.out.println(result);
```

Output:

```text
3.0
```

### With Casting

```java
int a = 10;
int b = 3;

double result = (double) a / b;

System.out.println(result);
```

Output:

```text
3.3333333333333335
```

---

# 17. Widening vs Narrowing

| Feature     | Widening             | Narrowing      |
| ----------- | -------------------- | -------------- |
| Direction   | Small → Large        | Large → Small  |
| Automatic   | Yes                  | No             |
| Manual Cast | Usually not required | Required       |
| Data Loss   | Generally no         | Possible       |
| Example     | `int → double`       | `double → int` |

---

# 18. Complete Example

```java
public class TypeCasting {
    public static void main(String[] args) {

        // Widening
        int number = 100;
        double doubleNumber = number;

        System.out.println("Widening:");
        System.out.println("int: " + number);
        System.out.println("double: " + doubleNumber);

        // Narrowing
        double price = 99.99;
        int intPrice = (int) price;

        System.out.println("\nNarrowing:");
        System.out.println("double: " + price);
        System.out.println("int: " + intPrice);

        // char to int
        char letter = 'A';
        int unicode = letter;

        System.out.println("\nCharacter:");
        System.out.println("Character: " + letter);
        System.out.println("Unicode: " + unicode);
    }
}
```

---

# 📝 Practice Questions

## Beginner

1. `int` ko `double` me convert karo.
2. `long` ko `float` me convert karo.
3. `double` ko `int` me convert karo.
4. `float` ko `int` me convert karo.
5. `char 'A'` ko `int` me convert karo.
6. `int 65` ko `char` me convert karo.

## Intermediate

7. `double price = 199.99` ko `int` me convert karo.
8. Ek `long` value ko `int` me cast karo.
9. `int` aur `double` ko add karke result print karo.
10. `10 / 3` ka decimal result type casting ka use karke nikalo.

## Advanced Practice

11. Check karo ki narrowing casting me data loss kab hota hai.
12. `int 130` ko `byte` me cast karke result observe karo.
13. Different `char` values ko integer me convert karke unki Unicode values print karo.
14. User se `int` input lekar usko `double`, `float`, aur `long` me convert karo.

---

# 🚀 Challenge

User se do integers input lo:

```text
Enter first number: 10
Enter second number: 3
```

Program ko following results print karne hain:

```text
Addition: 13
Subtraction: 7
Multiplication: 30
Integer Division: 3
Decimal Division: 3.3333333333333335
```

Decimal division ke liye **type casting** ka use karo.

---

# ⚠️ Common Mistakes

### Mistake 1

```java
int result = 10 / 3;
```

Result:

```text
3
```

### Correct

```java
double result = (double) 10 / 3;
```

Result:

```text
3.3333333333333335
```

---

### Mistake 2

Sochna ki casting decimal ko round karegi:

```java
int number = (int) 9.99;
```

Result:

```text
9
```

`10` nahi.

---

# 🔑 Key Takeaways

* Type Casting ek data type ko doosre data type me convert karta hai.
* **Widening** automatically hoti hai.
* **Narrowing** ke liye explicit casting karni padti hai.
* Narrowing me data loss ho sakta hai.
* Casting syntax:

```java
(int) value
```

* `char` ko `int` me convert karne par Unicode value milti hai.
* Integer division se decimal result chahiye to type casting useful hai.

## 🚀 Next Topic

**06-Operators** — Arithmetic, Assignment, Relational, Logical, Unary, Bitwise aur Ternary operators.
