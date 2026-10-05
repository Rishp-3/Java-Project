# break Statement in Java

## 📌 Topic
`break` statement loop ya switch ko turant rok deta hai aur control uske baad wale code par chala jata hai.

## 🎯 What You Will Learn

- `break` ka loop me use
- Search karte waqt loop jaldi rokna
- Labeled `break` se nested loop todna

## 💻 Code

```java
public class BreakDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.println("i = " + i);
        }
        System.out.println("Loop ended");

        outer:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    break outer;
                }
                System.out.println(i + " " + j);
            }
        }
    }
}
```

## 🧠 Explanation

### `break;`
Jaise hi `i == 5` hota hai, loop wahi ruk jata hai. 5 print nahi hota.

### `break outer;`
Label `outer` wale bahar ke loop ko bhi ek saath tod deta hai. Normal `break` sirf andar wala loop todta hai.

## ▶️ Output

```text
i = 1
i = 2
i = 3
i = 4
Loop ended
1 1
1 2
1 3
2 1
```

## 🔑 Important Points

- `break` sirf loop aur `switch` me use hota hai.
- Normal `break` sirf sabse nazdeeki loop ko rokta hai.
- Labeled `break` se kai levels ke loop ek saath rok sakte ho.

## 📝 Practice

1. Array me kisi number ko search karo aur milte hi loop roko.
2. Pehla negative number milte hi loop roko.
3. Number prime hai ya nahi `break` se check karo.
4. Infinite `while(true)` loop ko `break` se roko.

## 🚀 Challenge

User se numbers lo, aur `0` milte hi loop roko aur ab tak ka sum print karo.
