package practice.dsa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import practice.dsa.DsaProblems.ListNode;
import practice.dsa.DsaProblems.TreeNode;

class DsaClassicsTest {
    @Test void twoSum() {
        assertArrayEquals(new int[] {0, 1}, DsaClassics.twoSum(new int[] {2, 7, 11, 15}, 9));
        assertArrayEquals(new int[] {1, 2}, DsaClassics.twoSum(new int[] {3, 2, 4}, 6));
        assertArrayEquals(new int[] {0, 1}, DsaClassics.twoSum(new int[] {3, 3}, 6));
        assertEquals(0, DsaClassics.twoSum(new int[] {1, 2}, 10).length);
    }

    @Test void productExceptSelf() {
        assertArrayEquals(new int[] {24, 12, 8, 6}, DsaClassics.productExceptSelf(new int[] {1, 2, 3, 4}));
        assertArrayEquals(new int[] {0, 0, 9, 0, 0}, DsaClassics.productExceptSelf(new int[] {-1, 1, 0, -3, 3}));
    }

    @Test void stockProfit() {
        assertEquals(5, DsaClassics.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        assertEquals(0, DsaClassics.maxProfit(new int[] {7, 6, 4, 3, 1}));
        assertEquals(0, DsaClassics.maxProfit(new int[0]));
    }

    @Test void topKFrequent() {
        assertArrayEquals(new int[] {1, 2}, DsaClassics.topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2));
        assertArrayEquals(new int[] {1}, DsaClassics.topKFrequent(new int[] {1}, 1));
        // tie on frequency -> smaller value first
        assertArrayEquals(new int[] {4, 5}, DsaClassics.topKFrequent(new int[] {5, 4, 5, 4, 9}, 2));
    }

    @Test void mergeIntervals() {
        int[][] in = {{8, 10}, {1, 3}, {2, 6}, {15, 18}};
        assertArrayEquals(new int[][] {{1, 6}, {8, 10}, {15, 18}}, DsaClassics.mergeIntervals(in));
        assertArrayEquals(new int[][] {{1, 5}}, DsaClassics.mergeIntervals(new int[][] {{1, 4}, {4, 5}}));
        assertEquals(0, DsaClassics.mergeIntervals(new int[0][]).length);
        assertArrayEquals(new int[] {8, 10}, in[0], "input must not be reordered or mutated");
    }

    @Test void validParentheses() {
        assertTrue(DsaClassics.isValidParentheses("()[]{}"));
        assertTrue(DsaClassics.isValidParentheses("{[()]}"));
        assertTrue(DsaClassics.isValidParentheses(""));
        assertFalse(DsaClassics.isValidParentheses("(]"));
        assertFalse(DsaClassics.isValidParentheses("([)]"));
        assertFalse(DsaClassics.isValidParentheses("(("));
        assertFalse(DsaClassics.isValidParentheses("]"));
    }

    @Test void longestSubstring() {
        assertEquals(3, DsaClassics.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, DsaClassics.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, DsaClassics.lengthOfLongestSubstring("pwwkew"));
        assertEquals(2, DsaClassics.lengthOfLongestSubstring("abba"));
        assertEquals(0, DsaClassics.lengthOfLongestSubstring(""));
    }

    @Test void mergeSortedLists() {
        ListNode merged = DsaClassics.mergeTwoLists(DsaProblems.fromArray(1, 2, 4), DsaProblems.fromArray(1, 3, 4));
        assertEquals(List.of(1, 1, 2, 3, 4, 4), DsaProblems.toList(merged));
        assertEquals(List.of(1, 2), DsaProblems.toList(DsaClassics.mergeTwoLists(null, DsaProblems.fromArray(1, 2))));
        assertNull(DsaClassics.mergeTwoLists(null, null));
    }

    @Test void lowestCommonAncestor() {
        //        6
        //      /   \
        //     2     8
        //    / \   / \
        //   0   4 7   9
        TreeNode root = new TreeNode(6,
                new TreeNode(2, new TreeNode(0), new TreeNode(4)),
                new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        assertEquals(6, DsaClassics.lowestCommonAncestorBst(root, 2, 8).val);
        assertEquals(2, DsaClassics.lowestCommonAncestorBst(root, 2, 4).val);
        assertEquals(8, DsaClassics.lowestCommonAncestorBst(root, 7, 9).val);
        assertNull(DsaClassics.lowestCommonAncestorBst(null, 1, 2));
    }

    @Test void numIslands() {
        int[][] grid = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}};
        assertEquals(3, DsaClassics.numIslands(grid));
        assertEquals(1, grid[0][0], "input grid must not be modified");
        assertEquals(0, DsaClassics.numIslands(new int[0][]));
        assertEquals(0, DsaClassics.numIslands(new int[][] {{0, 0}, {0, 0}}));
    }

    @Test void climbStairs() {
        assertEquals(1, DsaClassics.climbStairs(0));
        assertEquals(1, DsaClassics.climbStairs(1));
        assertEquals(2, DsaClassics.climbStairs(2));
        assertEquals(8, DsaClassics.climbStairs(5));
        assertThrows(IllegalArgumentException.class, () -> DsaClassics.climbStairs(-1));
    }

    @Test void editDistance() {
        assertEquals(3, DsaClassics.editDistance("horse", "ros"));
        assertEquals(5, DsaClassics.editDistance("intention", "execution"));
        assertEquals(0, DsaClassics.editDistance("same", "same"));
        assertEquals(4, DsaClassics.editDistance("", "abcd"));
    }

    @Test void containsDuplicate() {
        assertTrue(DsaClassics.containsDuplicate(new int[] {1, 2, 3, 1}));
        assertFalse(DsaClassics.containsDuplicate(new int[] {1, 2, 3, 4}));
        assertFalse(DsaClassics.containsDuplicate(new int[0]));
    }
}
