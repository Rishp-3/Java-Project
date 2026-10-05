# DateTimeFormatter in Java

## 📌 Topic
`DateTimeFormatter` date/time ko custom format me dikhane (format) aur string se date/time banane (parse) ke kaam aata hai.

## 🎯 What You Will Learn

- `ofPattern()` se custom format banana
- Date/time ko string me convert karna (`format`)
- String se date/time banana (`parse`)
- Common pattern letters

## 💻 Code

```java
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Datetimeformatter {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2025, 8, 15, 14, 5, 9);

        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");
        DateTimeFormatter f3 = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
        DateTimeFormatter f4 = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println(dt.format(f1));
        System.out.println(dt.format(f2));
        System.out.println(dt.format(f3));
        System.out.println(dt.format(f4));

        LocalDate d = LocalDate.parse("25-12-2025", f1);
        System.out.println(d);

        LocalDate iso = LocalDate.parse("2025-03-10");
        System.out.println(iso.getMonth());
    }
}
```

## 🧠 Explanation

### `ofPattern("dd-MM-yyyy")`
`dd` = din, `MM` = mahina (number), `yyyy` = saal.

### `MMM / MMMM / EEEE`
`MMM` = Aug, `MMMM` = August, `EEEE` = Friday.

### `HH / hh / a`
`HH` = 24 ghanta, `hh` = 12 ghanta, `a` = AM/PM.

### `LocalDate.parse(text, formatter)`
String ko diye gaye format ke hisab se `LocalDate` me badalta hai.

## ▶️ Output

```text
15-08-2025
15 Aug 2025, 02:05 PM
Friday, 15 August 2025
14:05:09
2025-12-25
MARCH
```

## 🔑 Important Points

- `MM` = mahina, `mm` = minute. Dono ko confuse mat karo.
- Pattern galat ho to `DateTimeParseException` aata hai.
- `DateTimeFormatter` thread-safe hai, purane `SimpleDateFormat` se behtar.
- Bina formatter ke `parse()` sirf ISO format (`yyyy-MM-dd`) samajhta hai.

## 📝 Practice

1. Aaj ki date `dd/MM/yyyy` format me print karo.
2. User se string date lekar `LocalDate` banao.
3. Time ko 12-hour AM/PM me print karo.
4. Galat format dekar `DateTimeParseException` pakdo.

## 🚀 Challenge

`2025-08-15` ko `15th August 2025` jaise format me convert karke print karo.
