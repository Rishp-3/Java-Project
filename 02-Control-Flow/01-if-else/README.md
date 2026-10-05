# if-else in Java

## 📌 Topic
`if-else` se program condition ke basis par decision leta hai ki kaun sa code chalega.

## 🎯 What You Will Learn

- `if`, `else if` aur `else` ka syntax
- Conditions banana (relational + logical operators)
- Grade calculator banana
- Invalid input handle karna

## 💻 Code

```java
import java.util.Scanner;

public class IfElse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your marks: ");
        int marks = sc.nextInt();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks");

        } else if (marks >= 90) {
            System.out.println("Grade: A+");

        } else if (marks >= 80) {
            System.out.println("Grade: A");

        } else if (marks >= 70) {
            System.out.println("Grade: B");

        } else if (marks >= 60) {
            System.out.println("Grade: C");

        } else if (marks >= 40) {
            System.out.println("Grade: D");

        } else {
            System.out.println("Grade: F - Fail");
        }

        sc.close();
    }
}
```

## 🧠 Explanation

### `if (condition)`
Condition `true` ho to uska block chalta hai.

### `else if`
Pehli condition false ho to agli condition check hoti hai. Jo pehli true mile, bas wahi block chalta hai.

### `else`
Jab upar ki koi bhi condition true na ho tab chalta hai.

### `marks < 0 || marks > 100`
Pehle invalid input check kiya gaya hai, taaki galat marks par grade na mile.

## ⌨️ Sample Input

```text
85
```

## ▶️ Output

```text
Enter your marks: Grade: A
```

## 🔑 Important Points

- Condition ka result hamesha `boolean` hona chahiye.
- Conditions upar se neeche check hoti hain, isliye order important hai.
- Ek `if` block ke liye `{}` hamesha lagao, bugs kam hote hain.
- `=` assignment hai, comparison ke liye `==` use karo.

## 📝 Practice

1. Number positive, negative ya zero hai check karo.
2. Year leap year hai ya nahi check karo.
3. Teen numbers me se largest if-else se nikalo.
4. Character vowel hai ya consonant check karo.

## 🚀 Challenge

Electricity bill calculator banao: 100 units tak Rs 5/unit, 101-200 tak Rs 7/unit, uske baad Rs 10/unit.
