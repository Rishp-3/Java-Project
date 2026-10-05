# continue Statement in Java

## 📌 Topic
`continue` statement loop ki current iteration ko skip karke seedha agli iteration par chala jata hai.

## 🎯 What You Will Learn

- `continue` ka use
- `break` aur `continue` me difference
- Specific values ko skip karna

## 💻 Code

```java
public class ContinueDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.println("Odd: " + i);
        }
    }
}
```

## 🧠 Explanation

### `if (i % 2 == 0)`
Even number check karta hai.

### `continue;`
Even number par neeche ka `println` skip ho jata hai aur loop agli value par chala jata hai.

## ▶️ Output

```text
Odd: 1
Odd: 3
Odd: 5
Odd: 7
Odd: 9
```

## 🔑 Important Points

- `continue` loop ko todta nahi, sirf current iteration skip karta hai.
- `while` loop me `continue` se pehle counter update karna na bhoolo, warna infinite loop ban sakta hai.
- `break` = loop khatam, `continue` = sirf ek round skip.

## 📝 Practice

1. 1 se 20 tak ke numbers print karo, 5 ke multiples skip karke.
2. Array me negative numbers skip karke sum nikalo.
3. String ke vowels skip karke baaki letters print karo.
4. 1 se 50 me se 3 aur 5 dono se divisible numbers skip karo.

## 🚀 Challenge

1 se 15 tak print karo, par jo number 3 se divisible ho use skip karo.

```text
1
2
4
5
7
8
10
11
13
14
```
