# Variables in Java

## 📌 Topic
Variable Java me data/value ko temporarily store karne ke liye use hota hai. Ye memory me ek named box ki tarah hota hai.

## 🎯 What You Will Learn

- Variable kya hota hai
- Variable declare aur initialize kaise karte hain
- Variable naming rules
- Variable ki value change (update) karna
- `final` keyword se constant banana

## 💻 Code

```java
public class Variables {
    public static void main(String[] args) {

        int age = 20;
        String name = "Rishabh";
        double height = 5.8;
        boolean isStudent = true;

        System.out.println(name);
        System.out.println(age);    
        System.out.println(height);
        System.out.println(isStudent);
    }
}
```

## 🧠 Explanation

### `int age = 20;`
`int` = data type, `age` = variable ka naam, `20` = value. Ye ek hi line me declaration aur initialization hai.

### `String name = "Rishabh";`
`String` text store karta hai. Text hamesha double quotes `" "` me likhte hain.

### `System.out.println(age);`
Variable ka naam likhne par uski value print hoti hai (quotes ke bina).

## ▶️ Output

```text
Rishabh
20
5.8
true
```

## 🔑 Important Points

- Variable use karne se pehle declare karna zaroori hai.
- Naam letter, `_` ya `$` se start ho sakta hai, number se nahi.
- Java case-sensitive hai: `age` aur `Age` alag variables hain.
- Value change nahi karni ho to `final int MAX = 100;` use karo.

## 📝 Practice

1. Apna naam, age, city aur percentage variables me store karke print karo.
2. `age` ki value badal ke dobara print karo.
3. `final` variable banao aur uski value change karne ki koshish karke error dekho.
4. Ek hi line me 3 `int` variables declare karo: `int a = 1, b = 2, c = 3;`

## 🚀 Challenge

Do variables `a` aur `b` banao aur teesra variable (temp) use kiye bina unki values swap karo. Phir dono print karo.
