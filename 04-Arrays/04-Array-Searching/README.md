# Array Searching in Java

## 📌 Topic
Array me kisi element ko dhoondhne ke tarike ko searching kehte hain. Do common algorithms: Linear Search aur Binary Search.

## 🎯 What You Will Learn

- Linear Search
- Binary Search (sorted array par)
- Dono ki time complexity

## 💻 Code

```java
public class ArraySearching {

    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60};
        System.out.println("Linear: " + linearSearch(arr, 40));
        System.out.println("Binary: " + binarySearch(arr, 50));
        System.out.println("Not found: " + binarySearch(arr, 99));
    }
}
```

## 🧠 Explanation

### `linearSearch`
Har element ko ek-ek karke check karta hai. Sorted hona zaroori nahi. Time: O(n).

### `binarySearch`
Beech ka element dekhta hai aur search area aadha kar deta hai. Array sorted hona zaroori hai. Time: O(log n).

### `return -1`
Element na mile to `-1` return karna common convention hai.

## ▶️ Output

```text
Linear: 3
Binary: 4
Not found: -1
```

## 🔑 Important Points

- Binary search sirf sorted array par kaam karta hai.
- `mid = low + (high - low) / 2` overflow se bachata hai.
- Bade data par binary search bahut fast hota hai.
- Java me built-in: `Arrays.binarySearch(arr, key)`.

## 📝 Practice

1. Linear search se element ki pehli aur aakhri position nikalo.
2. Binary search recursion se likho.
3. Array me element kitni baar aaya count karo.
4. `Arrays.binarySearch()` use karke dekho.

## 🚀 Challenge

Sorted array me ek number ka `floor` (us se chhota ya barabar sabse bada element) binary search se nikalo.
