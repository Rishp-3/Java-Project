package practice.generics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class GenericProblemsTest {
    @Test void pairSwap() {
        GenericProblems.Pair<String, Integer> p = new GenericProblems.Pair<>("a", 1);
        GenericProblems.Pair<Integer, String> s = p.swap();
        assertEquals(1, s.first());
        assertEquals("a", s.second());
    }
    @Test void maxOf() {
        assertEquals(9, GenericProblems.maxOf(List.of(3, 9, 2)));
        assertEquals("pear", GenericProblems.maxOf(List.of("apple", "pear", "fig")));
        assertThrows(IllegalArgumentException.class, () -> GenericProblems.maxOf(List.<Integer>of()));
    }
    @Test void sumWildcard() {
        assertEquals(6.5, GenericProblems.sum(List.of(1, 2.5, 3L)), 1e-9);
    }
    @Test void fillSuperWildcard() {
        List<Number> numbers = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        GenericProblems.fillWithRange(numbers, 3);
        GenericProblems.fillWithRange(objects, 2);
        assertEquals(List.of(1, 2, 3), numbers);
        assertEquals(List.of(1, 2), objects);
    }
    @Test void genericStack() {
        GenericProblems.Stack<String> st = new GenericProblems.Stack<>();
        st.push("x");
        st.push("y");
        assertEquals("y", st.pop());
        assertEquals(1, st.size());
        st.pop();
        assertTrue(st.isEmpty());
        assertThrows(NoSuchElementException.class, st::pop);
    }
}
