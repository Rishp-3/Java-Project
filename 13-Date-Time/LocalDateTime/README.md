# LocalDateTime in Java

## 📌 Topic
`LocalDateTime` date aur time dono ko ek saath represent karta hai, bina timezone ke.

## 🎯 What You Will Learn

- `LocalDateTime.now()` aur `LocalDateTime.of()`
- Date aur time alag nikalna
- `plus`/`minus` methods
- `LocalDate` aur `LocalTime` se convert karna

## 💻 Code

```java
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Localdatetime {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2025, 8, 15, 10, 30, 0);
        System.out.println(dt);

        System.out.println(dt.toLocalDate());
        System.out.println(dt.toLocalTime());
        System.out.println(dt.getDayOfWeek() + " " + dt.getHour() + "h");

        System.out.println(dt.plusDays(1).plusHours(5));
        System.out.println(dt.minusWeeks(2));

        LocalDateTime made = LocalDateTime.of(LocalDate.of(2025, 1, 1), LocalTime.of(8, 0));
        System.out.println(made);
        System.out.println(ChronoUnit.HOURS.between(made, dt) + " hours");
        System.out.println(made.isBefore(dt));
    }
}
```

## 🧠 Explanation

### `LocalDateTime.of(...)`
Saal, mahina, din, ghanta, minute, second dekar banta hai.

### `toLocalDate() / toLocalTime()`
Date aur time ko alag-alag nikalte hain.

### `ChronoUnit.HOURS.between()`
Do date-times ke beech ka gap kisi bhi unit me deta hai.

## ▶️ Output

```text
2025-08-15T10:30
2025-08-15
10:30
FRIDAY 10h
2025-08-16T15:30
2025-08-01T10:30
2025-01-01T08:00
5426 hours
true
```

## 🔑 Important Points

- Timezone chahiye to `ZonedDateTime` use karo.
- Default string format ISO-8601 hota hai: `2025-08-15T10:30`.
- Log aur booking systems me `LocalDateTime` bahut use hota hai.

## 📝 Practice

1. Abhi ka date-time print karo.
2. Event 3 din 4 ghante baad ho to kab hoga nikalo.
3. Do date-times me se pehla kaun hai check karo.
4. `LocalDate` + `LocalTime` se `LocalDateTime` banao.

## 🚀 Challenge

Ek meeting ka start aur end `LocalDateTime` lo aur uska duration minutes me print karo.
