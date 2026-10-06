package practice.functional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

class FunctionalProblemsTest {
    @Test void filterAll() {
        Predicate<Integer> even = n -> n % 2 == 0;
        Predicate<Integer> big = n -> n > 10;
        assertEquals(List.of(12, 14), FunctionalProblems.filterAll(List.of(3, 12, 8, 14, 15), even, big));
        assertEquals(List.of(1, 2), FunctionalProblems.filterAll(List.of(1, 2)));
    }
    @Test void pipeline() {
        Function<String, String> p = FunctionalProblems.pipeline(List.of(String::trim, String::toUpperCase, s -> s + "!"));
        assertEquals("HI!", p.apply("  hi "));
    }
    @Test void memoizeRunsOncePerKey() {
        AtomicInteger calls = new AtomicInteger();
        Function<Integer, Integer> slowSquare = FunctionalProblems.memoize(n -> { calls.incrementAndGet(); return n * n; });
        assertEquals(49, slowSquare.apply(7));
        assertEquals(49, slowSquare.apply(7));
        assertEquals(9, slowSquare.apply(3));
        assertEquals(2, calls.get());
    }
    @Test void lazyIsComputedOnce() {
        AtomicInteger calls = new AtomicInteger();
        var v = FunctionalProblems.lazy(() -> "value-" + calls.incrementAndGet());
        assertEquals(0, calls.get());
        assertEquals("value-1", v.get());
        assertEquals("value-1", v.get());
        assertEquals(1, calls.get());
    }
    @Test void curry() {
        assertEquals(12, FunctionalProblems.<Integer, Integer, Integer>curry((a, b) -> a * b).apply(3).apply(4));
    }
    @Test void consumers() {
        List<String> seen = new ArrayList<>();
        AtomicInteger count = new AtomicInteger();
        FunctionalProblems.forEachThen(List.of("a", "b", "c"), seen::add, count::set);
        assertEquals(List.of("a", "b", "c"), seen);
        assertEquals(3, count.get());
    }
}
