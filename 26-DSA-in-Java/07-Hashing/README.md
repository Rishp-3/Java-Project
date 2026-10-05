# Hashing in DSA

## 📌 Topic
Hashing me key ko ek number (hash) me badalkar array me store karte hain, taaki search/insert average O(1) me ho. Java me `HashMap` aur `HashSet` isi par bane hain.

## 🎯 What You Will Learn

- Hash function aur hash table
- Collision aur chaining
- `HashMap`/`HashSet` ke DSA problems
- Frequency count, Two Sum

## 💻 Code

```java
import java.util.*;

public class Hashing {

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (seen.containsKey(need)) return new int[]{seen.get(need), i};
            seen.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    static class SimpleHashTable {
        private final LinkedList<int[]>[] buckets;

        @SuppressWarnings("unchecked")
        SimpleHashTable(int size) {
            buckets = new LinkedList[size];
            for (int i = 0; i < size; i++) buckets[i] = new LinkedList<>();
        }

        private int hash(int key) { return key % buckets.length; }

        void put(int key, int value) {
            for (int[] e : buckets[hash(key)]) {
                if (e[0] == key) { e[1] = value; return; }
            }
            buckets[hash(key)].add(new int[]{key, value});
        }

        Integer get(int key) {
            for (int[] e : buckets[hash(key)]) {
                if (e[0] == key) return e[1];
            }
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));

        int[] arr = {1, 2, 2, 3, 3, 3};
        Map<Integer, Integer> freq = new TreeMap<>();
        for (int x : arr) freq.merge(x, 1, Integer::sum);
        System.out.println(freq);

        SimpleHashTable t = new SimpleHashTable(5);
        t.put(1, 100);
        t.put(6, 600);
        t.put(1, 111);
        System.out.println(t.get(1) + " " + t.get(6) + " " + t.get(9));
    }
}
```

## 🧠 Explanation

### `hash(key)`
Key ko bucket index me badalta hai (`key % size`).

### `Collision`
Do keys (1 aur 6) ka same bucket ban jana. Chaining me ek bucket me linked list rehti hai.

### `twoSum`
HashMap me pehle dekhe elements rakhte jao aur `target - current` ko O(1) me dhoondho. Overall O(n).

## ▶️ Output

```text
[0, 1]
{1=1, 2=2, 3=3}
111 600 null
```

## 🔑 Important Points

- Average O(1), worst case O(n) (bahut collisions).
- Java 8+ me bahut collisions par bucket tree me badal jata hai (O(log n)).
- Keys ke liye `equals()` aur `hashCode()` sahi hone chahiye.
- Common problems: frequency count, duplicates, two sum, subarray sum equals K.

## 📝 Practice

1. Array me duplicate dhoondo (`HashSet`).
2. Pehla non-repeating character nikalo.
3. Subarray with sum K dhoondo (prefix sum + HashMap).
4. Do arrays ka intersection nikalo.

## 🚀 Challenge

Group Anagrams banao: `["eat","tea","tan","ate","nat","bat"]` ko anagram groups me baanto.
