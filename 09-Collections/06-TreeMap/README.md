# TreeMap in Java

## 📌 Topic
`TreeMap` bhi key-value store karta hai, par keys ko hamesha sorted order me rakhta hai.

## 🎯 What You Will Learn

- TreeMap kya hai
- Sorted keys
- `firstKey()`, `lastKey()`, `floorKey()`, `ceilingKey()`
- `headMap()` aur `tailMap()`

## 💻 Code

```java
import java.util.TreeMap;

public class Treemap {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(30, "Thirty");
        map.put(10, "Ten");
        map.put(20, "Twenty");
        map.put(40, "Forty");

        System.out.println(map);
        System.out.println("First key: " + map.firstKey());
        System.out.println("Last entry: " + map.lastEntry());
        System.out.println("Floor(25): " + map.floorKey(25));
        System.out.println("Ceiling(25): " + map.ceilingKey(25));
        System.out.println("Head(<30): " + map.headMap(30));
        System.out.println("Tail(>=30): " + map.tailMap(30));
        System.out.println("Desc: " + map.descendingMap());
    }
}
```

## 🧠 Explanation

### `TreeMap`
Red-Black Tree par based hai. `put`, `get`, `remove` O(log n) me hote hain.

### `headMap / tailMap`
Kisi key se pehle ya baad ka part (view) deta hai.

### `descendingMap()`
Ulta (descending) order me map deta hai.

## ▶️ Output

```text
{10=Ten, 20=Twenty, 30=Thirty, 40=Forty}
First key: 10
Last entry: 40=Forty
Floor(25): 20
Ceiling(25): 30
Head(<30): {10=Ten, 20=Twenty}
Tail(>=30): {30=Thirty, 40=Forty}
Desc: {40=Forty, 30=Thirty, 20=Twenty, 10=Ten}
```

## 🔑 Important Points

- `TreeMap` me `null` key allowed nahi hai.
- Custom key objects ke liye `Comparable`/`Comparator` chahiye.
- Sorted data aur range queries ke liye `TreeMap` best hai.

## 📝 Practice

1. Student naam ko marks ke saath sorted print karo.
2. Date ke hisab se events store karo.
3. `pollFirstEntry()` try karo.
4. `Comparator` se descending key order banao.

## 🚀 Challenge

`TreeMap` me student roll numbers aur naam daalo aur kisi roll number ke nazdeeki students nikalo.
