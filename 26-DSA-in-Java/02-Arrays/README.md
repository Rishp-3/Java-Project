# Arrays in DSA

## 📌 Topic
Array DSA ka sabse basic data structure hai. Yahan do important techniques dekhte hain: Two Pointers aur Prefix Sum.

## 🎯 What You Will Learn

- Two Pointers technique
- Prefix Sum technique
- Kadane's Algorithm (max subarray sum)
- In-place operations

## 💻 Code

```java
import java.util.Arrays;

public class Arrays1 {

    static boolean hasPairWithSum(int[] sorted, int target) {
        int i = 0, j = sorted.length - 1;
        while (i < j) {
            int sum = sorted[i] + sorted[j];
            if (sum == target) return true;
            if (sum < target) i++;
            else j--;
        }
        return false;
    }

    static int maxSubarray(int[] a) {
        int best = a[0], cur = a[0];
        for (int i = 1; i < a.length; i++) {
            cur = Math.max(a[i], cur + a[i]);
            best = Math.max(best, cur);
        }
        return best;
    }

    public static void main(String[] args) {
        int[] sorted = {1, 3, 4, 6, 8, 11};
        System.out.println("Pair sum 10: " + hasPairWithSum(sorted, 10));
        System.out.println("Pair sum 100: " + hasPairWithSum(sorted, 100));

        int[] nums = {2, 4, 6, 8, 10};
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) prefix[i + 1] = prefix[i] + nums[i];
        System.out.println("Prefix: " + Arrays.toString(prefix));
        System.out.println("Sum of index 1..3: " + (prefix[4] - prefix[1]));

        System.out.println("Max subarray: " + maxSubarray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
```

## 🧠 Explanation

### `Two Pointers`
Sorted array me ek pointer shuru se aur ek end se chalta hai. O(n) me pair dhoond leta hai (brute force O(n^2) hota).

### `Prefix Sum`
`prefix[i]` = pehle `i` elements ka sum. Range sum `prefix[r+1] - prefix[l]` se O(1) me milta hai.

### `Kadane`
Har step par decide karta hai: pichla subarray aage badhao ya naya shuru karo. O(n).

## ▶️ Output

```text
Pair sum 10: true
Pair sum 100: false
Prefix: [0, 2, 6, 12, 20, 30]
Sum of index 1..3: 18
Max subarray: 6
```

## 🔑 Important Points

- Array me random access O(1) hai, par beech me insert/delete O(n).
- Pehle brute force sochho, phir optimize karo.
- Prefix sum bahut saari range queries ke liye best hai.

## 📝 Practice

1. Array me 2 numbers nikalo jinka sum target ho (unsorted, HashMap se).
2. Array ko ek jagah (in-place) reverse karo.
3. Prefix sum se subarray sum queries banao.
4. Maximum product subarray sochho.

## 🚀 Challenge

Array me `0`s ko end me le jao, baaki elements ka order wahi rakho (in-place).
