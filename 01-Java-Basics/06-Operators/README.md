# Operators in Java

## 📌 Topic
Operators special symbols hote hain jo variables aur values par operations karte hain.

## 🎯 What You Will Learn

- Arithmetic operators: `+ - * / %`
- Relational operators: `== != > < >= <=`
- Logical operators: `&& || !`
- Ternary operator `? :`
- Assignment aur increment/decrement operators

## 💻 Code

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

## 🧠 Explanation

### `a / b`
Dono `int` hain, isliye result bhi `int` hota hai: `10 / 3 = 3`.

### `a % b`
Remainder deta hai: `10 % 3 = 1`.

### `&& aur ||`
`&&` tab `true` deta hai jab dono conditions true hon; `||` tab jab koi ek true ho.

### `a > b ? "a is greater" : "b is greater"`
Ternary operator if-else ka short form hai: `condition ? valueIfTrue : valueIfFalse`.

## ▶️ Output

```text
Addition: 13
Subtraction: 7
Multiplication: 30
Division: 3
Remainder: 1
a == b: false
a > b: true
AND: true
OR: true
a is greater
```

## 🔑 Important Points

- Integer division me decimal part hat jata hai.
- `==` comparison hai, `=` assignment hai.
- `i++` pehle value use karta hai phir badhata hai; `++i` pehle badhata hai.
- Operator precedence: `*` `/` `%` pehle, `+` `-` baad me. Brackets sabse pehle.

## 📝 Practice

1. Do numbers lekar sabhi arithmetic operations karo.
2. Number even hai ya odd, ternary operator se check karo.
3. `i++` aur `++i` ka difference `int i = 5;` se samjho.
4. `x += 5`, `x -= 2`, `x *= 3` try karo.

## 🚀 Challenge

Teen numbers me se sabse bada number ternary operator se nikalo.
