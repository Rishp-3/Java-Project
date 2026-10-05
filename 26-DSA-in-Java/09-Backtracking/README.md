# Backtracking in DSA

## 📌 Topic
Backtracking me hum ek choice try karte hain, aur agar wo galat nikle to wapas lautke dusri choice try karte hain. Subsets, permutations aur N-Queens iske examples hain.

## 🎯 What You Will Learn

- Choose, Explore, Un-choose pattern
- Subsets generate karna
- Permutations
- N-Queens

## 💻 Code

```java
import java.util.*;

public class Backtracking {

    static void subsets(int[] nums, int idx, List<Integer> cur, List<List<Integer>> out) {
        if (idx == nums.length) {
            out.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[idx]);
        subsets(nums, idx + 1, cur, out);
        cur.remove(cur.size() - 1);
        subsets(nums, idx + 1, cur, out);
    }

    static void permute(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> out) {
        if (cur.size() == nums.length) {
            out.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            cur.add(nums[i]);
            permute(nums, used, cur, out);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }

    static int nQueens(int n, int row, boolean[] cols, boolean[] d1, boolean[] d2) {
        if (row == n) return 1;
        int count = 0;
        for (int c = 0; c < n; c++) {
            if (cols[c] || d1[row - c + n] || d2[row + c]) continue;
            cols[c] = d1[row - c + n] = d2[row + c] = true;
            count += nQueens(n, row + 1, cols, d1, d2);
            cols[c] = d1[row - c + n] = d2[row + c] = false;
        }
        return count;
    }

    public static void main(String[] args) {
        List<List<Integer>> s = new ArrayList<>();
        subsets(new int[]{1, 2, 3}, 0, new ArrayList<>(), s);
        System.out.println("Subsets: " + s);

        List<List<Integer>> p = new ArrayList<>();
        permute(new int[]{1, 2, 3}, new boolean[3], new ArrayList<>(), p);
        System.out.println("Permutations: " + p);

        System.out.println("6-Queens solutions: " +
            nQueens(6, 0, new boolean[6], new boolean[13], new boolean[12]));
    }
}
```

## 🧠 Explanation

### `cur.add(...) / cur.remove(...)`
Choose (add), Explore (recursion), Un-choose (remove): ye backtracking ka core pattern hai.

### `new ArrayList<>(cur)`
Answer me copy daalni padti hai, warna aage `cur` badalne se answer bhi badal jata hai.

### `nQueens`
Har row me ek queen rakhte hain. Column ya diagonal conflict ho to us choice ko chhod dete hain (pruning).

## ▶️ Output

```text
Subsets: [[1, 2, 3], [1, 2], [1, 3], [1], [2, 3], [2], [3], []]
Permutations: [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
6-Queens solutions: 4
```

## 🔑 Important Points

- Backtracking brute force hai, par galat raste jaldi kaat deta hai (pruning).
- Complexity aksar exponential hoti hai: subsets O(2^n), permutations O(n!).
- Classic problems: Sudoku, N-Queens, Rat in Maze, Combination Sum.

## 📝 Practice

1. Combination Sum solve karo.
2. Rat in a Maze banao.
3. String ke saare permutations nikalo.
4. Sudoku solver likho.

## 🚀 Challenge

Parentheses generate karo: `n = 3` ke liye saare valid combinations print karo.
