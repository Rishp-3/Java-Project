# Array Problems in Java

## 📌 Topic
Interview aur practice me aane wale common array problems: reverse, second largest, duplicates, rotate aur merge.

## 🎯 What You Will Learn

- Array reverse karna
- Second largest element nikalna
- Duplicate elements dhoondhna
- Array rotate karna

## 💻 Code

```java
import java.util.Arrays;
import java.util.HashSet;

public class ArrayProblems {
    public static void main(String[] args) {
        int[] arr = {4, 9, 2, 9, 7, 4};

        // 1. Reverse
        int[] rev = arr.clone();
        for (int i = 0, j = rev.length - 1; i < j; i++, j--) {
            int t = rev[i]; rev[i] = rev[j]; rev[j] = t;
        }
        System.out.println("Reverse: " + Arrays.toString(rev));

        // 2. Second largest
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int n : arr) {
            if (n > first) { second = first; first = n; }
            else if (n > second && n != first) { second = n; }
        }
        System.out.println("Second largest: " + second);

        // 3. Duplicates
        HashSet<Integer> seen = new HashSet<>();
        for (int n : arr) {
            if (!seen.add(n)) System.out.println("Duplicate: " + n);
        }

        // 4. Rotate left by 1
        int[] rot = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            rot[i] = arr[(i + 1) % arr.length];
        }
        System.out.println("Rotated: " + Arrays.toString(rot));
    }
}
```

## 🧠 Explanation

### `Two pointers`
Reverse me ek pointer shuru se aur ek end se chalta hai aur dono swap karte hain.

### `first / second`
Ek hi pass me do sabse bade elements track kiye jate hain.

### `HashSet.add()`
Element pehle se ho to `false` return karta hai, isse duplicate pakad lete hain.

### `(i + 1) % length`
Modulo se index wrap-around ho jata hai.

## ▶️ Output

```text
Reverse: [4, 7, 9, 2, 9, 4]
Second largest: 7
Duplicate: 9
Duplicate: 4
Rotated: [9, 2, 9, 7, 4, 4]
```

## 🔑 Important Points

- Pehle brute force sochho, phir optimize karo.
- `clone()` se array ki copy banti hai, `=` se sirf reference copy hota hai.
- Edge cases check karo: empty array, ek element, sab same elements.

## 📝 Practice

1. Array me missing number nikalo (1 se n tak).
2. Do sorted arrays ko merge karo.
3. Array ko k positions se rotate karo.
4. Sabhi zero ko end me le jao.

## 🚀 Challenge

Kadane's Algorithm se maximum subarray sum nikalo. Array: `{-2, 1, -3, 4, -1, 2, 1, -5, 4}`

```text
6
```
