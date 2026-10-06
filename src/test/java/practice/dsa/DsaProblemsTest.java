package practice.dsa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.Test;
import practice.dsa.DsaProblems.ListNode;
import practice.dsa.DsaProblems.TreeNode;

class DsaProblemsTest {
    @Test void kadane() {
        assertEquals(6, DsaProblems.maxSubarraySum(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(-1, DsaProblems.maxSubarraySum(new int[] {-3, -1, -2}));
        assertThrows(IllegalArgumentException.class, () -> DsaProblems.maxSubarraySum(new int[0]));
    }
    @Test void reverseList() {
        assertEquals(List.of(3, 2, 1), DsaProblems.toList(DsaProblems.reverseList(DsaProblems.fromArray(1, 2, 3))));
        assertNull(DsaProblems.reverseList(null));
    }
    @Test void cycleDetection() {
        ListNode head = DsaProblems.fromArray(1, 2, 3, 4);
        assertFalse(DsaProblems.hasCycle(head));
        head.next.next.next.next = head.next;   // 4 -> 2 closes a loop
        assertTrue(DsaProblems.hasCycle(head));
        assertFalse(DsaProblems.hasCycle(null));
    }
    private TreeNode sampleTree() {
        return new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6, null, new TreeNode(7)));
    }
    @Test void levelOrder() {
        assertEquals(List.of(List.of(4), List.of(2, 6), List.of(1, 3, 7)), DsaProblems.levelOrder(sampleTree()));
        assertTrue(DsaProblems.levelOrder(null).isEmpty());
    }
    @Test void bstValidation() {
        assertTrue(DsaProblems.isValidBst(sampleTree()));
        // 3 sits in the right subtree of 4 but is smaller than 4 -> invalid even though each parent/child pair looks fine
        TreeNode bad = new TreeNode(4, new TreeNode(2), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        assertFalse(DsaProblems.isValidBst(bad));
        assertTrue(DsaProblems.isValidBst(null));
    }
    @Test void treeHeight() {
        assertEquals(3, DsaProblems.height(sampleTree()));
        assertEquals(0, DsaProblems.height(null));
    }
    @Test void bfsShortestPath() {
        Map<Integer, List<Integer>> g = Map.of(1, List.of(2, 3), 2, List.of(4), 3, List.of(4), 4, List.of(5), 6, List.of(1));
        assertEquals(3, DsaProblems.shortestPath(g, 1, 5));
        assertEquals(0, DsaProblems.shortestPath(g, 1, 1));
        assertEquals(-1, DsaProblems.shortestPath(g, 1, 6));
    }
    @Test void coinChange() {
        assertEquals(3, DsaProblems.coinChange(new int[] {1, 2, 5}, 11));
        assertEquals(-1, DsaProblems.coinChange(new int[] {2}, 3));
        assertEquals(0, DsaProblems.coinChange(new int[] {1}, 0));
        assertEquals(2, DsaProblems.coinChange(new int[] {1, 3, 4}, 6));   // greedy would pick 4+1+1
    }
    @Test void lis() {
        assertEquals(4, DsaProblems.longestIncreasingSubsequence(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(0, DsaProblems.longestIncreasingSubsequence(new int[0]));
    }
    @Test void permutations() {
        List<List<Integer>> p = DsaProblems.permutations(new int[] {1, 2, 3});
        assertEquals(6, p.size());
        assertEquals(6, p.stream().distinct().count());
        assertEquals(List.of(1, 2, 3), p.get(0));
        assertEquals(1, DsaProblems.permutations(new int[0]).size());
    }
    @Test void mergeSortMatchesLibrarySort() {
        Random rnd = new Random(42);
        for (int trial = 0; trial < 50; trial++) {
            int[] a = rnd.ints(rnd.nextInt(40), -100, 100).toArray();
            int[] expected = a.clone();
            Arrays.sort(expected);
            assertArrayEquals(expected, DsaProblems.mergeSort(a));
        }
    }
}
