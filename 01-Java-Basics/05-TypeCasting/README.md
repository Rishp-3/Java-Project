# Type Casting in Java

## 📌 Topic
Ek data type ki value ko dusre data type me convert karna Type Casting kehlata hai.

## 🎯 What You Will Learn

- Widening (automatic) casting
- Narrowing (manual) casting
- `char` aur `int` ke beech conversion
- Casting me data loss kab hota hai

## 💻 Code

```java
public class Typecasting {
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

## 🧠 Explanation

### `Widening`
Chhote type se bade type me conversion automatic hota hai: `byte → short → int → long → float → double`.

### `Narrowing: (int) price`
Bade type se chhote type me manually cast karna padta hai. `99.99` ka `(int)` banega `99` (decimal part cut ho jata hai, round nahi hota).

### `char to int`
`char` ko `int` me daalne par uska Unicode/ASCII value milti hai. `'A'` = 65.

## ▶️ Output

```text
Widening:
int: 100
double: 100.0

Narrowing:
double: 99.99
int: 99

Character:
Character: A
Unicode: 65
```

## 🔑 Important Points

- Widening me data loss nahi hota.
- Narrowing me data loss ho sakta hai.
- `(int) 9.99` = 9, rounding ke liye `Math.round()` use karo.
- `boolean` ko kisi aur type me cast nahi kar sakte.

## 📝 Practice

1. `double d = 45.78;` ko `int` me cast karke print karo.
2. `int` 65 ko `char` me cast karo aur print karo.
3. `(byte) 130` print karo aur result samjho.
4. `10 / 4` aur `10 / 4.0` ka output compare karo.

## 🚀 Challenge

Do `int` marks (e.g. 450 aur 600) se percentage `double` me nikalo. Dhyan rakho integer division se result 0 na aaye.
