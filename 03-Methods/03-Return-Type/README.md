# Return Type in Java

## 📌 Topic
Method kaam karke koi value wapas bhej sakta hai. Is value ka type method ke return type se decide hota hai.

## 🎯 What You Will Learn

- `return` keyword ka use
- `int`, `double`, `boolean`, `String` return karna
- `void` aur non-void method me difference

## 💻 Code

```java
public class ReturnType {

    static int add(int a, int b) {
        return a + b;
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static String getGrade(int marks) {
        if (marks >= 90) return "A";
        if (marks >= 60) return "B";
        return "C";
    }

    public static void main(String[] args) {
        int sum = add(10, 5);
        System.out.println("Sum: " + sum);
        System.out.println("Is 7 even? " + isEven(7));
        System.out.println("Grade: " + getGrade(75));
    }
}
```

## 🧠 Explanation

### `static int add(int a, int b)`
`int` return type batata hai ki method ek `int` value wapas dega.

### `return a + b;`
Value wapas bhejta hai aur method turant khatam ho jata hai.

### `boolean isEven(int n)`
Condition check karne wale methods ke naam aksar `is` / `has` se start karte hain.

## ▶️ Output

```text
Sum: 15
Is 7 even? false
Grade: B
```

## 🔑 Important Points

- `return` ke baad likha code kabhi nahi chalta.
- Non-void method me har path se value return honi chahiye.
- `void` method me `return;` sirf method rokne ke liye use hota hai.
- Return value ko variable me store ya seedha print kar sakte ho.

## 📝 Practice

1. Do numbers me bada return karne wala method banao.
2. Number prime hai ya nahi return karo (`boolean`).
3. Circle ka area `double` me return karo.
4. String ki length return karne wala method banao.

## 🚀 Challenge

`factorial(int n)` method banao jo `long` return kare. `factorial(5)` ka output `120` aana chahiye.

```text
120
```
