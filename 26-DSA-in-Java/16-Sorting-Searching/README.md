# Sorting and Searching in DSA

## 📌 Topic
DSA me efficient sorting (Merge Sort, Quick Sort) aur searching (Binary Search) algorithms bahut important hain. Ye O(n log n) aur O(log n) me kaam karte hain.

## 🎯 What You Will Learn

- Merge Sort (divide and conquer)
- Quick Sort (partition)
- Binary Search aur uske variations
- Stable aur in-place ka matlab

## 💻 Code

```java
import java.util.Arrays;

public class SortingSearching {

    static void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        int[] tmp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        System.arraycopy(tmp, 0, a, l, tmp.length);
    }

    static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = a[hi], i = lo;
        for (int j = lo; j < hi; j++) {
            if (a[j] < pivot) {
                int t = a[i]; a[i] = a[j]; a[j] = t;
                i++;
            }
        }
        int t = a[i]; a[i] = a[hi]; a[hi] = t;
        quickSort(a, lo, i - 1);
        quickSort(a, i + 1, hi);
    }

    static int firstOccurrence(int[] a, int key) {
        int lo = 0, hi = a.length - 1, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == key) { ans = mid; hi = mid - 1; }
            else if (a[mid] < key) lo = mid + 1;
            else hi = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(a, 0, a.length - 1);
        System.out.println("Merge sort: " + Arrays.toString(a));

        int[] b = {64, 25, 12, 22, 11, 90};
        quickSort(b, 0, b.length - 1);
        System.out.println("Quick sort: " + Arrays.toString(b));

        int[] sorted = {1, 2, 2, 2, 3, 4, 5};
        System.out.println("First index of 2: " + firstOccurrence(sorted, 2));
        System.out.println("Missing 9: " + firstOccurrence(sorted, 9));
    }
}
```

## 🧠 Explanation

### `mergeSort`
Array ko aadhe me todo, dono ko sort karo, phir merge karo. Hamesha O(n log n), extra memory O(n), stable.

### `quickSort`
Pivot chuno, chhote elements ek taraf aur bade doosri taraf karo (partition), phir dono parts ko sort karo. Average O(n log n), worst O(n^2), in-place.

### `firstOccurrence`
Binary search ka variation: element milne par bhi left me aur dhoondhte raho.

## ▶️ Output

```text
Merge sort: [3, 9, 10, 27, 38, 43, 82]
Quick sort: [11, 12, 22, 25, 64, 90]
First index of 2: 1
Missing 9: -1
```

## 🔑 Important Points

- Java `Arrays.sort()` primitives ke liye Dual-Pivot Quick Sort aur objects ke liye TimSort (stable) use karta hai.
- Bubble/Selection/Insertion sort O(n^2) hain, chhote ya almost-sorted data par theek hain.
- Binary search ke liye array sorted hona zaroori hai.
- Binary search on answer ek powerful technique hai (jaise square root, minimum capacity).

## 📝 Practice

1. Merge sort me inversions count karo.
2. Binary search se `sqrt(x)` nikalo.
3. Rotated sorted array me search karo.
4. Quick select se k-th smallest nikalo.

## 🚀 Challenge

Sorted array me kisi element ki pehli aur aakhri position ek saath nikalo.
