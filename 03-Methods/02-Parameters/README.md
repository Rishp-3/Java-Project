# Method Parameters in Java

## 📌 Topic
Parameters ke through hum method ko data bhej sakte hain, taaki wo alag-alag values par kaam kar sake.

## 🎯 What You Will Learn

- Parameters aur Arguments me difference
- Single aur multiple parameters
- Pass by value ka concept

## 💻 Code

```java
public class Parameters {

    static void greet(String name) {
        System.out.println("Hello, " + name);
    }

    static void add(int a, int b) {
        System.out.println("Sum = " + (a + b));
    }

    static void change(int x) {
        x = 100;
        System.out.println("Inside method: " + x);
    }

    public static void main(String[] args) {
        greet("Rishabh");
        greet("Amit");
        add(10, 20);

        int num = 5;
        change(num);
        System.out.println("Outside method: " + num);
    }
}
```

## 🧠 Explanation

### `String name`
Ye parameter hai: method ke bracket me likha hua variable.

### `greet("Rishabh")`
`"Rishabh"` argument hai: call karte waqt bheji gayi asli value.

### `change(num)`
Java me primitive values copy hoke jati hain (pass by value). Isliye method ke andar badalne se bahar ki `num` nahi badalti.

## ▶️ Output

```text
Hello, Rishabh
Hello, Amit
Sum = 30
Inside method: 100
Outside method: 5
```

## 🔑 Important Points

- Arguments ki sankhya, type aur order parameters se match hona chahiye.
- Java hamesha pass by value hai.
- Objects/arrays me reference ki copy jati hai, isliye unka content badal sakta hai.
- Parameter ka scope sirf us method ke andar hota hai.

## 📝 Practice

1. Do numbers ka product print karne wala method banao.
2. Name aur age lekar introduction print karo.
3. Array parameter me bhejo aur uska sum print karo.
4. Method me array ka ek element badlo aur bahar print karke dekho.

## 🚀 Challenge

`printTable(int n)` method banao jo `n` ka 1 se 10 tak table print kare.
