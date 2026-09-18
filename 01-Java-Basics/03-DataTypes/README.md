# Data Types in Java

## 📌 Topic

Data Type batata hai ki kisi variable me **kis type ka data** store kiya ja sakta hai.

Example:

```java
int age = 20;
```

Yahan `int` data type hai aur `20` integer value hai.

---

## 🎯 What You Will Learn

* Data Type kya hota hai
* Primitive Data Types
* Non-Primitive Data Types
* `byte`
* `short`
* `int`
* `long`
* `float`
* `double`
* `char`
* `boolean`
* String ka basic concept
* Data types ka memory usage
* Correct data type choose karna

---

# 1. Primitive Data Types

Java me **8 primitive data types** hote hain:

| Data Type |          Size | Example          |
| --------- | ------------: | ---------------- |
| `byte`    |        1 byte | `100`            |
| `short`   |       2 bytes | `10000`          |
| `int`     |       4 bytes | `100000`         |
| `long`    |       8 bytes | `100000L`        |
| `float`   |       4 bytes | `10.5f`          |
| `double`  |       8 bytes | `10.5`           |
| `char`    |       2 bytes | `'A'`            |
| `boolean` | JVM-dependent | `true` / `false` |

---

# 2. Integer Data Types

## byte

`byte` small integer values store karta hai.

```java
byte age = 20;
System.out.println(age);
```

Range:

```text
-128 to 127
```

---

## short

`short` `byte` se larger integer values store kar sakta hai.

```java
short population = 30000;
System.out.println(population);
```

Range:

```text
-32,768 to 32,767
```

---

## int

`int` Java me commonly used integer data type hai.

```java
int salary = 50000;
System.out.println(salary);
```

Range:

```text
-2,147,483,648 to 2,147,483,647
```

---

## long

Bahut large integer values ke liye `long` use karte hain.

```java
long population = 1400000000L;
System.out.println(population);
```

`long` value ke end me `L` lagana recommended hai.

---

# 3. Decimal Data Types

## float

`float` decimal values store karta hai.

```java
float price = 99.99f;
System.out.println(price);
```

`float` value ke end me `f` lagana hota hai.

---

## double

`double` decimal values ke liye commonly used data type hai.

```java
double percentage = 85.75;
System.out.println(percentage);
```

`double` ko decimal numbers ke liye generally prefer kiya jata hai jab `float` ki specific need na ho.

---

# 4. Character Data Type

## char

`char` ek single character store karta hai.

```java
char grade = 'A';
System.out.println(grade);
```

Character ke liye **single quotes** use hote hain:

```java
char letter = 'R';
```

❌ Incorrect:

```java
char letter = "R";
```

---

# 5. Boolean Data Type

`boolean` sirf do values store karta hai:

```text
true
false
```

Example:

```java
boolean isStudent = true;

System.out.println(isStudent);
```

---

# 6. Non-Primitive Data Types

Primitive ke alawa Java me non-primitive/reference types bhi hote hain.

Examples:

```text
String
Array
Class
Object
Interface
Enum
```

Example:

```java
String name = "Rishabh";

System.out.println(name);
```

---

# 7. Complete Example

```java
public class DataTypes {
    public static void main(String[] args) {

        byte byteValue = 100;
        short shortValue = 10000;
        int intValue = 50000;
        long longValue = 10000000000L;

        float floatValue = 10.5f;
        double doubleValue = 99.99;

        char grade = 'A';
        boolean isPassed = true;

        String name = "Rishabh";

        System.out.println("byte: " + byteValue);
        System.out.println("short: " + shortValue);
        System.out.println("int: " + intValue);
        System.out.println("long: " + longValue);
        System.out.println("float: " + floatValue);
        System.out.println("double: " + doubleValue);
        System.out.println("char: " + grade);
        System.out.println("boolean: " + isPassed);
        System.out.println("String: " + name);
    }
}
```

---

# 🖥️ Output

```text
byte: 100
short: 10000
int: 50000
long: 10000000000
float: 10.5
double: 99.99
char: A
boolean: true
String: Rishabh
```

---

# 🧠 Important Difference

### `int`

```java
int age = 20;
```

Whole number ke liye.

### `double`

```java
double marks = 85.75;
```

Decimal number ke liye.

### `char`

```java
char grade = 'A';
```

Single character ke liye.

### `boolean`

```java
boolean passed = true;
```

True/false ke liye.

### `String`

```java
String name = "Rishabh";
```

Text ke liye.

---

# 📝 Practice Questions

### Beginner

1. `byte` variable create karke apni age store karo.
2. `short` variable me koi value store karo.
3. `int` variable me apna roll number store karo.
4. `long` variable me large number store karo.
5. `float` variable me apni height store karo.
6. `double` variable me percentage store karo.
7. `char` me apna grade store karo.
8. `boolean` me `isStudent` store karo.

### Intermediate

9. Har primitive data type ka ek variable banao aur print karo.
10. Integer aur decimal variables ka difference observe karo.
11. `char` me different characters store karke print karo.
12. `boolean` ko `true` aur `false` dono values ke saath test karo.

### Challenge

Ek student ka complete data different data types ka use karke store karo:

```text
Name
Age
Roll Number
Height
Percentage
Grade
Passed
```

Aur output:

```text
Name: Rishabh
Age: 20
Roll Number: 101
Height: 5.8
Percentage: 85.75
Grade: A
Passed: true
```

---

# 🔑 Key Takeaways

* Java me **8 primitive data types** hote hain.
* `byte`, `short`, `int`, `long` → whole numbers.
* `float`, `double` → decimal numbers.
* `char` → single character.
* `boolean` → `true` ya `false`.
* `String` → text store karne ke liye.
* Data type choose karte waqt required value/range ko dhyan me rakhna chahiye.
