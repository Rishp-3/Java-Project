# static Keyword in Java

## 📌 Topic
`static` member class ka hota hai, object ka nahi. Ye sabhi objects ke beech share hota hai aur bina object banaye access ho sakta hai.

## 🎯 What You Will Learn

- `static` variable, method aur block
- Static aur instance members me difference
- Counter jaisa shared data banana

## 💻 Code

```java
class Student {
    String name;
    static String college = "ABC College";
    static int count = 0;

    static {
        System.out.println("Static block executed");
    }

    Student(String name) {
        this.name = name;
        count++;
    }

    static void showCount() {
        System.out.println("Total students: " + count);
    }
}

public class Static {
    public static void main(String[] args) {
        Student s1 = new Student("Rishabh");
        Student s2 = new Student("Amit");

        System.out.println(s1.name + " - " + Student.college);
        Student.showCount();
    }
}
```

## 🧠 Explanation

### `static String college`
Sabhi objects ke liye ek hi copy. Class naam se access karte hain: `Student.college`.

### `static void showCount()`
Bina object ke call hota hai. Isme sirf static members direct use kar sakte ho.

### `static { ... }`
Static block class load hote waqt sirf ek baar chalta hai, constructor se bhi pehle.

## ▶️ Output

```text
Static block executed
Rishabh - ABC College
Total students: 2
```

## 🔑 Important Points

- Static method ke andar `this` aur non-static members direct use nahi hote.
- `main()` static isliye hai taaki JVM bina object banaye use call kar sake.
- Static variable memory me ek hi baar banta hai.
- Static constants ke liye `static final` use karo: `static final double PI = 3.14;`

## 📝 Practice

1. Static counter se batao kitne objects bane.
2. `MathUtil` class banao jisme static methods hon.
3. Static block aur constructor ka execution order dekho.
4. Static method me non-static variable use karke error dekho.

## 🚀 Challenge

`Employee` class banao jisme auto-increment `id` static counter se generate ho. 3 employees banake ids print karo.
