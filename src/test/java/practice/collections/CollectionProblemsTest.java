package practice.collections;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class CollectionProblemsTest {
    @Test void wordFrequency() {
        Map<String, Integer> f = CollectionProblems.wordFrequency("The cat and the hat. THE end!");
        assertEquals(Map.of("the", 3, "cat", 1, "and", 1, "hat", 1, "end", 1), f);
        assertEquals("and", f.keySet().iterator().next());
    }
    @Test void dedupeKeepsOrder() {
        assertEquals(List.of(3, 1, 2), CollectionProblems.dedupe(List.of(3, 1, 3, 2, 1)));
    }
    @Test void balancedBrackets() {
        assertTrue(CollectionProblems.isBalanced("{[()]}"));
        assertTrue(CollectionProblems.isBalanced("a(b)c"));
        assertFalse(CollectionProblems.isBalanced("(]"));
        assertFalse(CollectionProblems.isBalanced("(("));
        assertFalse(CollectionProblems.isBalanced(")"));
    }
    @Test void groupByLength() {
        Map<Integer, List<String>> g = CollectionProblems.groupByLength(List.of("bb", "a", "cc", "ddd", "e"));
        assertEquals(List.of("a", "e"), g.get(1));
        assertEquals(List.of("bb", "cc"), g.get(2));
        assertEquals(List.of(1, 2, 3), List.copyOf(g.keySet()));
    }
    @Test void kthLargest() {
        assertEquals(5, CollectionProblems.kthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, CollectionProblems.kthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        assertThrows(IllegalArgumentException.class, () -> CollectionProblems.kthLargest(new int[] {1}, 2));
    }
    @Test void intersection() {
        assertEquals(List.of(2, 3), CollectionProblems.intersection(List.of(1, 2, 2, 3), List.of(3, 2, 9)));
    }
}
