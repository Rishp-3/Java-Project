# HashMap in Java

## 📌 Topic
`HashMap` data ko key-value pairs me store karta hai. Key unique hoti hai aur key se value bahut jaldi mil jati hai.

## 🎯 What You Will Learn

- Key-Value pair kya hota hai
- `put()`, `get()`, `remove()`, `containsKey()`
- Map ko traverse karna
- Word frequency count karna

## 💻 Code

```java
import java.util.HashMap;
import java.util.Map;

public class Hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> marks = new HashMap<>();

        marks.put("Rishabh", 85);
        marks.put("Amit", 70);
        marks.put("Neha", 92);
        marks.put("Amit", 75);

        System.out.println("Amit: " + marks.get("Amit"));
        System.out.println("Has Neha? " + marks.containsKey("Neha"));
        System.out.println("Missing: " + marks.getOrDefault("Rahul", 0));
        marks.remove("Rishabh");

        for (Map.Entry<String, Integer> e : marks.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        String text = "java is fun and java is fast";
        HashMap<String, Integer> freq = new HashMap<>();
        for (String w : text.split(" ")) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }
        System.out.println("java count: " + freq.get("java"));
    }
}
```

## 🧠 Explanation

### `put(key, value)`
Pair add karta hai. Key pehle se ho to purani value replace ho jati hai.

### `get(key)`
Key ki value deta hai, key na ho to `null`.

### `getOrDefault()`
Key na mile to default value deta hai, `null` ke jhanjhat se bachata hai.

### `entrySet()`
Key aur value dono ke saath traverse karne ke liye.

## ▶️ Output

```text
Amit: 75
Has Neha? true
Missing: 0
Neha -> 92
Amit -> 75
java count: 2
```

## 🔑 Important Points

- Keys unique hoti hain, values duplicate ho sakti hain.
- `HashMap` me order guarantee nahi hota.
- Ek `null` key aur multiple `null` values allowed hain.
- Thread-safe version: `ConcurrentHashMap`.

## 📝 Practice

1. Student ke naam aur marks `HashMap` me store karo.
2. String me har character ki frequency nikalo.
3. Map ko value ke hisab se sort karo.
4. Map ki saari keys aur values alag-alag print karo.

## 🚀 Challenge

Array `{1, 2, 2, 3, 3, 3}` me har number kitni baar aaya `HashMap` se count karo.
