# LocalDate in Java

## 📌 Topic
`LocalDate` sirf date (saal-mahina-din) ko represent karti hai, time ke bina. Ye `java.time` package (Java 8+) ka hissa hai.

## 🎯 What You Will Learn

- `LocalDate.now()` aur `LocalDate.of()`
- Din, mahina, saal nikalna
- Date me days add/subtract karna
- Do dates ko compare karna aur gap nikalna

## 💻 Code

```java
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Localdate {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today has year: " + (today.getYear() > 2000));

        LocalDate d = LocalDate.of(2025, 8, 15);
        System.out.println(d);
        System.out.println(d.getDayOfMonth() + "/" + d.getMonthValue() + "/" + d.getYear());
        System.out.println(d.getDayOfWeek());
        System.out.println(d.plusDays(20));
        System.out.println(d.minusMonths(2));
        System.out.println("Leap year? " + d.isLeapYear());

        LocalDate birth = LocalDate.of(2000, 1, 1);
        Period p = Period.between(birth, d);
        System.out.println(p.getYears() + " years " + p.getMonths() + " months");
        System.out.println(ChronoUnit.DAYS.between(birth, d) + " days");
        System.out.println(d.isAfter(birth));
        System.out.println(d.getDayOfWeek() == DayOfWeek.FRIDAY);
    }
}
```

## 🧠 Explanation

### `LocalDate.now()`
System ki aaj ki date deta hai.

### `LocalDate.of(2025, 8, 15)`
Given saal, mahina, din se date banata hai.

### `plusDays / minusMonths`
Nayi date return karte hain. Original `LocalDate` immutable hai, badalta nahi.

### `Period / ChronoUnit`
Do dates ke beech ka gap saal-mahine-din me ya sirf din/mahine me nikalne ke liye.

## ▶️ Output

```text
Today has year: true
2025-08-15
15/8/2025
FRIDAY
2025-09-04
2025-06-15
Leap year? false
25 years 7 months
9358 days
true
true
```

## 🔑 Important Points

- `LocalDate`, `LocalTime`, `LocalDateTime` immutable aur thread-safe hain.
- Mahina 1 se 12 tak hota hai (purane `Date` me 0 se tha).
- Purani `Date` aur `Calendar` classes ki jagah `java.time` use karo.
- Galat date (`2025-02-30`) par `DateTimeException` aata hai.

## 📝 Practice

1. Aaj ki date print karo.
2. Apni age saal, mahine aur din me nikalo.
3. Aaj se 100 din baad ki date nikalo.
4. Check karo ki koi saal leap year hai ya nahi.

## 🚀 Challenge

Do dates lo aur batao kaun si pehle hai aur dono me kitne din ka antar hai.
