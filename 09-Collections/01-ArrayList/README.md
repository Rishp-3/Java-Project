# ArrayList in Java

## 📌 Topic
`ArrayList` ek resizable (dynamic) array hai. Normal array ki tarah fixed size nahi hota, elements add/remove karne par size apne aap badal jati hai.

## 🎯 What You Will Learn

- ArrayList banana aur elements add karna
- `get()`, `set()`, `remove()`, `size()`, `contains()`
- Loop se traverse karna
- ArrayList ko sort karna

## 💻 Code

```java
import java.util.ArrayList;
import java.util.Collections;

public class Arraylist {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Rishabh");
        names.add("Amit");
        names.add("Neha");
        names.add(1, "Rahul");

        System.out.println(names);
        System.out.println("Size: " + names.size());
        System.out.println("Index 2: " + names.get(2));

        names.set(0, "Rishabh Kumar");
        names.remove("Amit");
        System.out.println("Contains Neha? " + names.contains("Neha"));

        Collections.sort(names);
        for (String n : names) {
            System.out.println(n);
        }
    }
}
```

## 🧠 Explanation

### `ArrayList<String>`
`<String>` generics hai, matlab list me sirf `String` aa sakte hain.

### `add(1, "Rahul")`
Given index par element insert karta hai, baaki aage shift ho jate hain.

### `remove("Amit")`
Value se element hata deta hai. `remove(int index)` index se hatata hai.

### `Collections.sort()`
List ko ascending order me sort karta hai.

## ▶️ Output

```text
[Rishabh, Rahul, Amit, Neha]
Size: 4
Index 2: Amit
Contains Neha? true
Neha
Rahul
Rishabh Kumar
```

## 🔑 Important Points

- ArrayList duplicates allow karta hai aur insertion order maintain karta hai.
- Primitive (`int`) nahi, wrapper (`Integer`) store hota hai.
- Random access (`get(i)`) fast hai: O(1). Beech me insert/delete slow hai: O(n).
- `List<String> list = new ArrayList<>();` likhna behtar practice hai.

## 📝 Practice

1. `ArrayList<Integer>` me 5 numbers daalo aur sum nikalo.
2. List se duplicate elements hatao.
3. List me sabse bada element nikalo.
4. `ArrayList` ko reverse karo.

## 🚀 Challenge

`ArrayList<Integer>` me 1 se 10 numbers daalo aur sirf even numbers print karo.

```text
2 4 6 8 10
```
