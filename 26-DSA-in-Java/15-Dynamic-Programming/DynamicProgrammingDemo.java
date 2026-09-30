import java.util.Arrays;

public class DynamicProgrammingDemo {

    // DP = break a problem into overlapping subproblems, solve each ONCE, and reuse results.

    // Fibonacci with memoization (top-down DP) - avoids the exponential blowup of naive recursion
    static long[] memo = new long[100];
    static long fibonacci(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n]; // reuse a previously computed result
        return memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }

    // 0/1 Knapsack (bottom-up DP) - each item can be taken fully or not at all
    static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], values[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }

    // Longest Common Subsequence between two strings
    static int longestCommonSubsequence(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    // Coin change: minimum number of coins to make an amount (works for ANY coin system)
    static int minCoinsDP(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // "infinity" sentinel
        dp[0] = 0;
        for (int a = 1; a <= amount; a++) {
            for (int coin : coins) {
                if (coin <= a) {
                    dp[a] = Math.min(dp[a], dp[a - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci(40) with memoization: " + fibonacci(40));

        int[] weights = {1, 3, 4, 5};
        int[] values = {1, 4, 5, 7};
        System.out.println("Max knapsack value (capacity 7): " + knapsack(weights, values, 7));

        System.out.println("LCS of 'ABCBDAB' and 'BDCABA': " + longestCommonSubsequence("ABCBDAB", "BDCABA"));

        System.out.println("Min coins for 11 (using [1,2,5]): " + minCoinsDP(new int[]{1, 2, 5}, 11));
    }
}
