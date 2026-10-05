# Array Sorting in Java

## 📌 Topic
Sorting ka matlab array ke elements ko ascending ya descending order me arrange karna hai.

## 🎯 What You Will Learn

- Bubble Sort
- Selection Sort
- `Arrays.sort()` built-in method
- Descending order me sort karna

## 💻 Code

```java
import java.util.Arrays;
import java.util.Collections;

public class ArraySorting {

    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 7};
        bubbleSort(a);
        System.out.println("Bubble: " + Arrays.toString(a));

        int[] b = {8, 3, 6, 4};
        Arrays.sort(b);
        System.out.println("Arrays.sort: " + Arrays.toString(b));

        Integer[] c = {8, 3, 6, 4};
        Arrays.sort(c, Collections.reverseOrder());
        System.out.println("Descending: " + Arrays.toString(c));
    }
}
```

## 🧠 Explanation

### `bubbleSort`
Padosi elements ko compare karke swap karta hai. Har pass me sabse bada element end me pahunch jata hai. Time: O(n^2).

### `Arrays.sort(b)`
Java ka fast built-in sort. Primitive arrays ke liye Dual-Pivot Quicksort use hota hai.

### `Collections.reverseOrder()`
Descending order ke liye. Ye sirf object arrays (`Integer[]`) par kaam karta hai, `int[]` par nahi.

## ▶️ Output

```text
Bubble: [1, 2, 5, 7, 9]
Arrays.sort: [3, 4, 6, 8]
Descending: [8, 6, 4, 3]
```

## 🔑 Important Points

- Bubble aur Selection sort seekhne ke liye achhe hain, bade data par slow hain.
- Real programs me `Arrays.sort()` use karo.
- Sort in-place hota hai: original array badal jata hai.
- Strings ko sort karna ho to `Arrays.sort(String[])` use karo.

## 📝 Practice

1. Selection sort khud likho.
2. Array ko descending me sort karo (bina `Collections` ke).
3. Sirf even index ke elements sort karo.
4. Array me second largest element sort karke nikalo.

## 🚀 Challenge

Insertion Sort implement karo aur `{9, 5, 1, 4, 3}` ko sort karke print karo.

```text
[1, 3, 4, 5, 9]
```
