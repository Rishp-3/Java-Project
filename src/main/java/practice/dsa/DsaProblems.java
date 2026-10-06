package practice.dsa;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Module 26 - DSA in Java: classic interview problems across arrays, lists, trees, graphs, DP and backtracking. */
public final class DsaProblems {
    private DsaProblems() {}

    // ---------- Arrays: Kadane ----------
    /** Problem 1: maximum sum of a non-empty contiguous subarray - O(n). */
    public static int maxSubarraySum(int[] a) {
        if (a.length == 0) throw new IllegalArgumentException("empty array");
        int best = a[0], current = a[0];
        for (int i = 1; i < a.length; i++) {
            current = Math.max(a[i], current + a[i]);
            best = Math.max(best, current);
        }
        return best;
    }

    // ---------- Linked list ----------
    public static final class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode fromArray(int... values) {
        ListNode head = null;
        for (int i = values.length - 1; i >= 0; i--) head = new ListNode(values[i], head);
        return head;
    }

    public static List<Integer> toList(ListNode head) {
        List<Integer> out = new ArrayList<>();
        for (ListNode n = head; n != null; n = n.next) out.add(n.val);
        return out;
    }

    /** Problem 2: reverse a singly linked list in place. */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /** Problem 3: does the list have a cycle? (Floyd's tortoise and hare) */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // ---------- Trees ----------
    public static final class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; }
    }

    /** Problem 4: level-order (BFS) traversal. */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) return levels;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                level.add(n.val);
                if (n.left != null) queue.add(n.left);
                if (n.right != null) queue.add(n.right);
            }
            levels.add(level);
        }
        return levels;
    }

    /** Problem 5: is this a valid binary SEARCH tree? (pass min/max bounds down the recursion) */
    public static boolean isValidBst(TreeNode node) {
        return isValidBst(node, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isValidBst(TreeNode n, long lo, long hi) {
        if (n == null) return true;
        if (n.val <= lo || n.val >= hi) return false;
        return isValidBst(n.left, lo, n.val) && isValidBst(n.right, n.val, hi);
    }

    /** Problem 6: height of a binary tree. */
    public static int height(TreeNode n) {
        return n == null ? 0 : 1 + Math.max(height(n.left), height(n.right));
    }

    // ---------- Graph ----------
    /** Problem 7: fewest edges from start to goal in an unweighted graph, or -1 if unreachable (BFS). */
    public static int shortestPath(Map<Integer, List<Integer>> graph, int start, int goal) {
        if (start == goal) return 0;
        Map<Integer, Integer> dist = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        dist.put(start, 0);
        queue.add(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.getOrDefault(cur, List.of())) {
                if (dist.containsKey(next)) continue;
                dist.put(next, dist.get(cur) + 1);
                if (next == goal) return dist.get(next);
                queue.add(next);
            }
        }
        return -1;
    }

    // ---------- Dynamic programming ----------
    /** Problem 8: fewest coins to make 'amount', or -1 if impossible (bottom-up DP). */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (c <= a && dp[a - c] != Integer.MAX_VALUE) dp[a] = Math.min(dp[a], dp[a - c] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /** Problem 9: length of the longest strictly increasing subsequence (O(n^2) DP). */
    public static int longestIncreasingSubsequence(int[] a) {
        if (a.length == 0) return 0;
        int[] dp = new int[a.length];
        int best = 1;
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) if (a[j] < a[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            best = Math.max(best, dp[i]);
        }
        return best;
    }

    // ---------- Backtracking ----------
    /** Problem 10: all permutations of the numbers (input has distinct values). */
    public static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        permute(nums, new boolean[nums.length], new ArrayList<>(), out);
        return out;
    }

    private static void permute(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> out) {
        if (path.size() == nums.length) { out.add(new ArrayList<>(path)); return; }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            permute(nums, used, path, out);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    // ---------- Sorting ----------
    /** Problem 11: merge sort - returns a new sorted array, stable, O(n log n). */
    public static int[] mergeSort(int[] a) {
        if (a.length <= 1) return a.clone();
        int[] left = mergeSort(Arrays.copyOfRange(a, 0, a.length / 2));
        int[] right = mergeSort(Arrays.copyOfRange(a, a.length / 2, a.length));
        int[] out = new int[a.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) out[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        while (i < left.length) out[k++] = left[i++];
        while (j < right.length) out[k++] = right[j++];
        return out;
    }
}
