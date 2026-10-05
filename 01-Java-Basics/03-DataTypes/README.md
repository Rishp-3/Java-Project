# Data Types in Java

## 📌 Topic
Data type batata hai ki variable me kis type ka data store hoga aur kitni memory lagegi. Java me 2 type hote hain: Primitive aur Non-Primitive.

## 🎯 What You Will Learn

- 8 primitive data types (`byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`)
- Non-primitive type `String`
- Har type ki range aur size
- `long` ke liye `L` aur `float` ke liye `f` kyun lagate hain

## 💻 Code

```java
public class Datatypes {
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

## 🧠 Explanation

### `byte / short / int / long`
Whole numbers ke liye. Size: 1, 2, 4, 8 bytes. Bahut bade number ke liye `long` use hota hai aur value ke end me `L` lagta hai.

### `float / double`
Decimal numbers ke liye. `float` me value ke end me `f` lagta hai. `double` default decimal type hai.

### `char`
Ek single character store karta hai, single quotes me: `'A'`.

### `boolean`
Sirf `true` ya `false` store karta hai.

### `String`
Text store karta hai. Ye primitive nahi, ek class hai.

## ▶️ Output

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

## 🔑 Important Points

- `int` ki range: -2,147,483,648 se 2,147,483,647.
- `10000000000` jaisi badi value `int` me nahi aati, `long` aur `L` use karo.
- `char` single quotes me, `String` double quotes me likhte hain.
- `boolean` ki default value `false` hoti hai (fields me).

## 📝 Practice

1. Har primitive type ka ek variable banao aur print karo.
2. `byte b = 200;` likh ke error dekho aur samjho kyu aaya.
3. `Integer.MAX_VALUE` aur `Integer.MIN_VALUE` print karo.
4. Apni height `double` me aur grade `char` me store karo.

## 🚀 Challenge

`Integer.MAX_VALUE` me `1` add karke print karo. Result negative kyu aaya? (Overflow concept samjho)
