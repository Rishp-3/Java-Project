# LocalTime in Java

## 📌 Topic
`LocalTime` sirf time (ghanta:minute:second) ko represent karta hai, date ke bina.

## 🎯 What You Will Learn

- `LocalTime.now()` aur `LocalTime.of()`
- Hour, minute, second nikalna
- Time me add/subtract karna
- Do times ko compare karna

## 💻 Code

```java
import java.time.Duration;
import java.time.LocalTime;

public class Localtime {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println("Now has hour: " + (now.getHour() >= 0));

        LocalTime t = LocalTime.of(14, 30, 15);
        System.out.println(t);
        System.out.println(t.getHour() + ":" + t.getMinute() + ":" + t.getSecond());
        System.out.println(t.plusHours(3));
        System.out.println(t.minusMinutes(45));
        System.out.println(t.withSecond(0));

        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(17, 30);
        System.out.println(start.isBefore(end));
        Duration dur = Duration.between(start, end);
        System.out.println(dur.toHours() + "h " + dur.toMinutesPart() + "m");
    }
}
```

## 🧠 Explanation

### `LocalTime.of(14, 30, 15)`
24-hour format me time banata hai (14 = 2 PM).

### `plusHours / minusMinutes`
Naya `LocalTime` return karte hain.

### `Duration.between()`
Do times ke beech ka time-gap deta hai.

## ▶️ Output

```text
Now has hour: true
14:30:15
14:30:15
17:30:15
13:45:15
14:30
true
8h 30m
```

## 🔑 Important Points

- `LocalTime` me timezone nahi hota.
- Format `HH:mm:ss.nnn` hota hai, seconds 0 hon to print nahi hote.
- Din badalne par time 23:59 ke baad 00:00 par wrap ho jata hai.

## 📝 Practice

1. Abhi ka time print karo.
2. Time me 90 minute add karo.
3. Do times ke beech ka duration nikalo.
4. Check karo ki abhi ka time subah (12 baje se pehle) hai ya nahi.

## 🚀 Challenge

Office timing 9:00 se 17:30 hai. Koi time dene par batao ki office khula hai ya band.
