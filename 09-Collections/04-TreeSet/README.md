# TreeSet in Java

## 📌 Topic
`TreeSet` bhi duplicates allow nahi karta, par ye elements ko hamesha sorted (ascending) order me rakhta hai.

## 🎯 What You Will Learn

- TreeSet kya hai
- Sorted order me elements
- `first()`, `last()`, `floor()`, `ceiling()`
- Custom order ke liye Comparator

## 💻 Code

```java
import java.util.Collections;
import java.util.TreeSet;

public class Treeset {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(50);
        set.add(10);
        set.add(40);
        set.add(20);
        set.add(10);

        System.out.println(set);
        System.out.println("First: " + set.first());
        System.out.println("Last: " + set.last());
        System.out.println("Floor(35): " + set.floor(35));
        System.out.println("Ceiling(35): " + set.ceiling(35));
        System.out.println("Head(<40): " + set.headSet(40));
        System.out.println("Desc: " + set.descendingSet());

        TreeSet<String> names = new TreeSet<>(Collections.reverseOrder());
        names.add("Amit");
        names.add("Neha");
        names.add("Rishabh");
        System.out.println(names);
    }
}
```

## 🧠 Explanation

### `TreeSet`
Internally Red-Black Tree use karta hai. `add`, `remove`, `contains` O(log n) me hote hain.

### `floor(x) / ceiling(x)`
`floor` = x se chhota ya barabar sabse bada, `ceiling` = x se bada ya barabar sabse chhota.

### `Comparator`
`new TreeSet<>(Collections.reverseOrder())` se custom/descending order milta hai.

## ▶️ Output

```text
[10, 20, 40, 50]
First: 10
Last: 50
Floor(35): 20
Ceiling(35): 40
Head(<40): [10, 20]
Desc: [50, 40, 20, 10]
[Rishabh, Neha, Amit]
```

## 🔑 Important Points

- `TreeSet` me `null` allowed nahi hai.
- Custom objects ke liye `Comparable` ya `Comparator` zaroori hai.
- Sorted unique data chahiye to `TreeSet`, speed chahiye to `HashSet`.

## 📝 Practice

1. Random numbers `TreeSet` me daal ke sorted print karo.
2. `TreeSet<String>` me naam daalo aur alphabetical print karo.
3. `pollFirst()` aur `pollLast()` try karo.
4. `Student` objects ko marks se sort karo.

## 🚀 Challenge

`TreeSet` me numbers daalo aur kisi number ke sabse nazdeeki chhote aur bade number print karo.
