package practice.dsa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import practice.dsa.DsaProblems.ListNode;
import practice.dsa.DsaProblems.TreeNode;

/**
 * Module 26 - DSA in Java: classic interview problems (LeetCode-style) that complement {@link DsaProblems}.
 * Every method documents its time (T) and space (S) complexity and the core idea.
 */
public final class DsaClassics {
    private DsaClassics() {}

    // ---------- Arrays + Hashing ----------

    /**
     * Two Sum: indices of two numbers adding up to target, or an empty array.
     * Idea: remember value -> index; for each x look up (target - x). T: O(n), S: O(n).
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = seen.get(target - nums[i]);
            if (j != null) return new int[] {j, i};
            seen.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * Product of Array Except Self, without division.
     * Idea: result[i] = (product of everything left of i) * (product of everything right of i). T: O(n), S: O(1) extra.
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] out = new int[n];
        int left = 1;
        for (int i = 0; i < n; i++) { out[i] = left; left *= nums[i]; }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) { out[i] *= right; right *= nums[i]; }
        return out;
    }

    /**
     * Best Time to Buy and Sell Stock (one transaction): maximum profit, 0 if none.
     * Idea: track the cheapest price so far and the best sell-today profit. T: O(n), S: O(1).
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, best = 0;
        for (int p : prices) {
            minPrice = Math.min(minPrice, p);
            best = Math.max(best, p - minPrice);
        }
        return best;
    }

    /**
     * Top K Frequent Elements, ordered by frequency (desc) then value (asc) so the result is deterministic.
     * Idea: count, then keep a min-heap of size k. T: O(n log k), S: O(n).
     */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.merge(x, 1, Integer::sum);
        Comparator<Map.Entry<Integer, Integer>> weakestFirst = Map.Entry.<Integer, Integer>comparingByValue()
                .thenComparing(Map.Entry.<Integer, Integer>comparingByKey().reversed());
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(weakestFirst);
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            heap.offer(e);
            if (heap.size() > k) heap.poll();
        }
        int[] out = new int[heap.size()];
        for (int i = out.length - 1; i >= 0; i--) out[i] = heap.poll().getKey();
        return out;
    }

    /**
     * Merge Intervals: merge all overlapping [start, end] intervals.
     * Idea: sort by start, then extend the last merged interval while the next one overlaps. T: O(n log n), S: O(n).
     */
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        int[] cur = sorted[0].clone();
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i][0] <= cur[1]) cur[1] = Math.max(cur[1], sorted[i][1]);
            else { merged.add(cur); cur = sorted[i].clone(); }
        }
        merged.add(cur);
        return merged.toArray(new int[0][]);
    }

    // ---------- Strings + Stack ----------

    /**
     * Valid Parentheses: are (), [], {} balanced and correctly nested?
     * Idea: push openers, pop and match on closers. T: O(n), S: O(n).
     */
    public static boolean isValidParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(', '[', '{' -> stack.push(c);
                case ')' -> { if (stack.isEmpty() || stack.pop() != '(') return false; }
                case ']' -> { if (stack.isEmpty() || stack.pop() != '[') return false; }
                case '}' -> { if (stack.isEmpty() || stack.pop() != '{') return false; }
                default -> { /* ignore other characters */ }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Longest Substring Without Repeating Characters (length).
     * Idea: sliding window; when a char repeats, move the left edge past its previous position. T: O(n), S: O(min(n, charset)).
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int best = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            Integer prev = lastSeen.get(c);
            if (prev != null && prev >= left) left = prev + 1;
            lastSeen.put(c, right);
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    // ---------- Linked list ----------

    /**
     * Merge Two Sorted Lists into one sorted list (reuses the existing nodes).
     * Idea: dummy head + two pointers, always take the smaller front node. T: O(n + m), S: O(1).
     */
    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0, null), tail = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) { tail.next = a; a = a.next; }
            else { tail.next = b; b = b.next; }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    // ---------- Trees ----------

    /**
     * Lowest Common Ancestor in a BST (p and q must exist in the tree).
     * Idea: if both values are smaller go left, if both are larger go right, otherwise this node splits them.
     * T: O(h), S: O(1).
     */
    public static TreeNode lowestCommonAncestorBst(TreeNode root, int p, int q) {
        TreeNode node = root;
        while (node != null) {
            if (p < node.val && q < node.val) node = node.left;
            else if (p > node.val && q > node.val) node = node.right;
            else return node;
        }
        return null;
    }

    // ---------- Graphs (grid DFS) ----------

    /**
     * Number of Islands: count connected groups of 1s (4-directional) in a grid. The input grid is not modified.
     * Idea: each unvisited 1 starts a new island; flood-fill it. T: O(R*C), S: O(R*C).
     */
    public static int numIslands(int[][] grid) {
        if (grid.length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    islands++;
                    floodFill(grid, visited, r, c);
                }
            }
        }
        return islands;
    }

    private static void floodFill(int[][] grid, boolean[][] visited, int startR, int startC) {
        // Iterative DFS so very large islands cannot overflow the call stack.
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[] {startR, startC});
        visited[startR][startC] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            for (int[] d : dirs) {
                int r = cell[0] + d[0], c = cell[1] + d[1];
                if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1 && !visited[r][c]) {
                    visited[r][c] = true;
                    stack.push(new int[] {r, c});
                }
            }
        }
    }

    // ---------- Dynamic programming ----------

    /**
     * Climbing Stairs: number of distinct ways to climb n steps taking 1 or 2 at a time (fits in long up to n = 90).
     * Idea: ways(n) = ways(n-1) + ways(n-2), i.e. Fibonacci. T: O(n), S: O(1).
     */
    public static long climbStairs(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        long prev = 1, cur = 1;
        for (int i = 2; i <= n; i++) { long next = prev + cur; prev = cur; cur = next; }
        return cur;
    }

    /**
     * Edit Distance (Levenshtein): minimum insert / delete / replace operations to turn a into b.
     * Idea: dp[i][j] = answer for the first i chars of a and first j chars of b. T: O(n*m), S: O(n*m).
     */
    public static int editDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= b.length(); j++) dp[0][j] = j;
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[a.length()][b.length()];
    }

    /**
     * Contains Duplicate: does any value appear at least twice? T: O(n), S: O(n).
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) if (!seen.add(x)) return true;
        return false;
    }
}
