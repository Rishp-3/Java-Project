# Dynamic Programming in DSA

## 📌 Topic
Dynamic Programming (DP) me badi problem ko overlapping chhoti problems me todte hain aur unke answers store (memoization/tabulation) karte hain taaki dobara calculate na karna pade.

## 🎯 What You Will Learn

- Overlapping subproblems aur optimal substructure
- Memoization (top-down)
- Tabulation (bottom-up)
- Fibonacci, Climbing Stairs, Knapsack, LCS

## 💻 Code

```java
import java.util.*;

public class DynamicProgramming {

    static long[] memo = new long[60];

    static long fibMemo(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        return memo[n] = fibMemo(n - 1) + fibMemo(n - 2);
    }

    static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    static int knapsack(int[] w, int[] v, int cap) {
        int[][] dp = new int[w.length + 1][cap + 1];
        for (int i = 1; i <= w.length; i++) {
            for (int c = 0; c <= cap; c++) {
                dp[i][c] = dp[i - 1][c];
                if (w[i - 1] <= c) {
                    dp[i][c] = Math.max(dp[i][c], v[i - 1] + dp[i - 1][c - w[i - 1]]);
                }
            }
        }
        return dp[w.length][cap];
    }

    static int lcs(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[a.length()][b.length()];
    }

    static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int a = 1; a <= amount; a++)
            for (int c : coins)
                if (c <= a) dp[a] = Math.min(dp[a], dp[a - c] + 1);
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println("fib(50) = " + fibMemo(50));
        System.out.println("Climb 10 stairs = " + climbStairs(10));
        System.out.println("0/1 Knapsack = " + knapsack(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 7));
        System.out.println("LCS(ABCBDAB, BDCABA) = " + lcs("ABCBDAB", "BDCABA"));
        System.out.println("Coin change {1,3,4} for 6 = " + coinChange(new int[]{1, 3, 4}, 6));
    }
}
```

## 🧠 Explanation

### `fibMemo`
Normal recursion O(2^n) hota hai. Memo se har `n` ek hi baar calculate hota hai: O(n).

### `climbStairs`
`dp[i] = dp[i-1] + dp[i-2]` (pichle step se ya usse pichle step se aao).

### `knapsack`
`dp[i][c]` = pehle `i` items aur capacity `c` me best value. Har item ya to lo ya chhodo.

### `lcs / coinChange`
2D/1D table bharke answer nikalte hain. Coin change me greedy fail hota hai par DP sahi answer (`3 + 3 = 2` coins) deta hai.

## ▶️ Output

```text
fib(50) = 12586269025
Climb 10 stairs = 89
0/1 Knapsack = 9
LCS(ABCBDAB, BDCABA) = 4
Coin change {1,3,4} for 6 = 2
```

## 🔑 Important Points

- DP ke steps: state define karo, transition likho, base case, order of computation.
- Space optimize ho sakti hai (jaise Fibonacci me sirf 2 variables).
- Greedy se fail hone wale problems aksar DP se solve hote hain.
- Memoization = recursion + cache, Tabulation = loops + table.

## 📝 Practice

1. House Robber solve karo.
2. Longest Increasing Subsequence nikalo.
3. Edit Distance solve karo.
4. Unique Paths in grid solve karo.

## 🚀 Challenge

0/1 Knapsack ka space optimized (1D array) version likho.
