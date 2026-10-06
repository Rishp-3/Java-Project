package practice.concurrency;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.Test;

class ConcurrencyProblemsTest {
    @Test void parallelSumMatchesSequential() throws Exception {
        int[] data = new int[10_001];
        for (int i = 0; i < data.length; i++) data[i] = i;
        assertEquals(50_005_000L, ConcurrencyProblems.parallelSum(data, 4));
        assertEquals(0, ConcurrencyProblems.parallelSum(new int[0], 3));
        assertEquals(6, ConcurrencyProblems.parallelSum(new int[] {1, 2, 3}, 8));
        assertThrows(IllegalArgumentException.class, () -> ConcurrencyProblems.parallelSum(data, 0));
    }
    @Test void synchronizedCounterLosesNoUpdates() throws Exception {
        ConcurrencyProblems.SafeCounter c = new ConcurrencyProblems.SafeCounter();
        ConcurrencyProblems.hammer(c::increment, 8, 5_000);
        assertEquals(40_000, c.get());
    }
    @Test void atomicCounter() throws Exception {
        assertEquals(40_000, ConcurrencyProblems.atomicCount(8, 5_000));
    }
    @Test void runAllKeepsOrder() throws Exception {
        List<Callable<String>> tasks = List.of(
                () -> { Thread.sleep(50); return "slow"; },
                () -> "fast",
                () -> "mid");
        assertEquals(List.of("slow", "fast", "mid"), ConcurrencyProblems.runAll(tasks));
    }
    @Test void failuresSurfaceAsExecutionException() {
        List<Callable<Integer>> tasks = List.of(() -> { throw new IllegalStateException("bad"); });
        ExecutionException e = assertThrows(ExecutionException.class, () -> ConcurrencyProblems.runAll(tasks));
        assertInstanceOf(IllegalStateException.class, e.getCause());
    }
}
