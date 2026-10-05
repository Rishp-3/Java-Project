# HashSet in Java

## 📌 Topic
`HashSet` aisa collection hai jisme duplicate elements allowed nahi hote. Ye internally hashing use karta hai aur order guarantee nahi karta.

## 🎯 What You Will Learn

- Set kya hota hai
- `add()`, `remove()`, `contains()`
- Duplicates apne aap hat jana
- Set operations: union, intersection

## 💻 Code

```java
import java.util.HashSet;

public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        System.out.println(set.add(10));
        System.out.println(set.add(20));
        System.out.println(set.add(10));
        System.out.println("Size: " + set.size());
        System.out.println("Contains 20? " + set.contains(20));

        set.remove(20);
        System.out.println(set);

        HashSet<Integer> a = new HashSet<>();
        a.add(1); a.add(2); a.add(3);
        HashSet<Integer> b = new HashSet<>();
        b.add(2); b.add(3); b.add(4);

        HashSet<Integer> union = new HashSet<>(a);
        union.addAll(b);
        HashSet<Integer> inter = new HashSet<>(a);
        inter.retainAll(b);
        System.out.println("Union: " + union);
        System.out.println("Intersection: " + inter);
    }
}
```

## 🧠 Explanation

### `add()`
Naya element ho to `true`, duplicate ho to `false` return karta hai.

### `contains()`
Average O(1) time me check karta hai.

### `addAll / retainAll`
Union (sab) aur intersection (common) nikalne ke liye.

## ▶️ Output

```text
true
true
false
Size: 2
Contains 20? true
[10]
Union: [1, 2, 3, 4]
Intersection: [2, 3]
```

## 🔑 Important Points

- `HashSet` me order guarantee nahi hota.
- `null` ek baar allow hota hai.
- Custom objects ke liye `equals()` aur `hashCode()` override karna zaroori hai.
- Insertion order chahiye to `LinkedHashSet` use karo.

## 📝 Practice

1. Array me se duplicates `HashSet` se hatao.
2. Do sets ka difference nikalo (`removeAll`).
3. String ke unique characters print karo.
4. `Student` object `HashSet` me daalo aur `equals/hashCode` ka effect dekho.

## 🚀 Challenge

Ek sentence me unique words kitne hain `HashSet` se count karo.
