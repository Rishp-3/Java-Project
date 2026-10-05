# Regex in Java

## 📌 Topic
Regex (Regular Expression) text me pattern dhoondhne, match karne aur badalne ka tarika hai. Java me ye `Pattern` aur `Matcher` classes se hota hai.

## 🎯 What You Will Learn

- Regex ke basic symbols
- `Pattern` aur `Matcher`
- `matches()`, `find()`, `group()`
- `replaceAll()` aur `split()` me regex
- Email/phone validation

## 💻 Code

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        System.out.println("12345".matches("\\d+"));
        System.out.println("abc123".matches("\\d+"));

        String phone = "[6-9]\\d{9}";
        System.out.println("9876543210".matches(phone));
        System.out.println("1234567890".matches(phone));

        String email = "[\\w.]+@[\\w]+\\.[a-z]{2,}";
        System.out.println("rishabh@gmail.com".matches(email));
        System.out.println("rishabh@com".matches(email));

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("Order 45 has 3 items costing 200");
        while (m.find()) {
            System.out.println("Found: " + m.group());
        }

        System.out.println("a1b2c3".replaceAll("[0-9]", "#"));
        System.out.println(String.join("|", "one, two,three".split("\\s*,\\s*")));
    }
}
```

## 🧠 Explanation

### `\d  \w  \s`
`\d` = digit, `\w` = letter/digit/underscore, `\s` = space. Java string me inhe `\\d` (backslash do baar) likhna padta hai.

### `+  *  ?  {n}`
`+` = 1 ya zyada, `*` = 0 ya zyada, `?` = 0 ya 1, `{10}` = exactly 10 baar.

### `[6-9]`
Character class: 6 se 9 ke beech ka koi ek character.

### `find() / group()`
`find()` agla match dhoondhta hai, `group()` matched text deta hai.

## ▶️ Output

```text
true
false
true
false
true
false
Found: 45
Found: 3
Found: 200
a#b#c#
one|two|three
```

## 🔑 Important Points

- `matches()` poori string par match karta hai, `find()` string ke andar kahin bhi.
- `^` start aur `$` end ko dikhata hai.
- Same pattern baar-baar use ho to `Pattern.compile()` ek baar karo.
- Complex regex ko pehle regex101.com par test karo.

## 📝 Practice

1. Check karo ki string sirf letters ki hai.
2. Text me se saare numbers nikalo.
3. PAN card format validate karo (`ABCDE1234F`).
4. String me multiple spaces ko ek space me badlo.

## 🚀 Challenge

Strong password validate karo: kam se kam 8 characters, 1 capital, 1 small, 1 digit, 1 special character.
