# Import in Java

## 📌 Topic
`import` statement dusre package ki classes ko apne code me use karne ke liye hota hai, taaki poora naam na likhna pade.

## 🎯 What You Will Learn

- Single class import
- Wildcard import (`*`)
- Static import
- `java.lang` me import kyu nahi lagta

## 💻 Code

```java
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.sqrt;
import static java.lang.Math.PI;

public class ImportDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Rishabh");
        names.add("Amit");
        System.out.println(names);

        System.out.println(sqrt(49));
        System.out.println(PI);

        java.util.Date d = null;
        System.out.println("Full name use: " + d);
    }
}
```

## 🧠 Explanation

### `import java.util.ArrayList;`
Sirf ek class import hoti hai.

### `import java.util.*;`
Package ki saari classes import hoti hain (sub-packages nahi).

### `import static`
Static methods/variables ko class naam ke bina use karne dete hain (`sqrt(49)` ki jagah `Math.sqrt(49)` nahi likhna padta).

### `java.util.Date`
Fully qualified name: import ke bina bhi class use kar sakte ho.

## ▶️ Output

```text
[Rishabh, Amit]
7.0
3.141592653589793
Full name use: null
```

## 🔑 Important Points

- `java.lang` package (`String`, `Math`, `System`) automatically import hota hai.
- Import compile time ka concept hai, memory ya speed par asar nahi padta.
- Do packages me same naam ki class ho (`java.util.Date` aur `java.sql.Date`) to ek ko fully qualified naam se likho.
- Unused imports hata do, code clean rehta hai.

## 📝 Practice

1. `Scanner` ko import karke use karo.
2. `java.util.*` use karo aur `List`, `Map` dono banao.
3. `Math.max` ko static import karke use karo.
4. `java.util.Date` aur `java.sql.Date` dono ek program me use karo.

## 🚀 Challenge

`LocalDate.now()` use karo. Kaun sa package import karna padega?
