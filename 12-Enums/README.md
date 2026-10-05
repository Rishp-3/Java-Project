# Enums in Java

## 📌 Topic
Enum ek special class hai jo fixed constants (jaise din, directions, status) ka group banane ke kaam aati hai.

## 🎯 What You Will Learn

- Enum kya hai aur kyu use karte hain
- Enum constants ko access karna
- `values()`, `ordinal()`, `valueOf()`
- Enum me fields, constructor aur methods
- `switch` ke saath enum

## 💻 Code

```java
enum Day {
    MONDAY, TUESDAY, WEDNESDAY
}

enum Level {
    LOW(1), MEDIUM(5), HIGH(10);

    private final int value;

    Level(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}

public class Enums {
    public static void main(String[] args) {
        Day d = Day.TUESDAY;
        System.out.println(d);
        System.out.println(d.ordinal());

        for (Day x : Day.values()) {
            System.out.println(x);
        }

        System.out.println(Day.valueOf("MONDAY"));

        for (Level l : Level.values()) {
            System.out.println(l + " = " + l.getValue());
        }

        switch (d) {
            case MONDAY:
                System.out.println("Start of week");
                break;
            case TUESDAY:
                System.out.println("Second day");
                break;
            default:
                System.out.println("Other day");
        }
    }
}
```

## 🧠 Explanation

### `enum Day { ... }`
Constants ka fixed set. Convention: naam UPPERCASE me.

### `values()`
Saare enum constants ka array deta hai.

### `ordinal()`
Constant ki position (0 se start) batata hai.

### `Level(int value)`
Enum me constructor, fields aur methods ho sakte hain. Constructor hamesha `private` hota hai.

## ▶️ Output

```text
TUESDAY
1
MONDAY
TUESDAY
WEDNESDAY
MONDAY
LOW = 1
MEDIUM = 5
HIGH = 10
Second day
```

## 🔑 Important Points

- Enum ka object `new` se nahi banta.
- Enum constants `==` se safely compare ho sakte hain.
- Enum `Comparable` aur `Serializable` hota hai, par kisi class ko extend nahi kar sakta (interface implement kar sakta hai).
- `valueOf()` me galat naam dene par `IllegalArgumentException` aata hai.

## 📝 Practice

1. `Season` enum banao aur saare seasons print karo.
2. `Planet` enum banao jisme mass aur radius ho.
3. Enum ko `switch` me use karo.
4. `Size` enum (S, M, L) banao jisme price bhi ho.

## 🚀 Challenge

`OrderStatus` enum banao (PLACED, SHIPPED, DELIVERED, CANCELLED) aur har status ke liye ek message print karo.
