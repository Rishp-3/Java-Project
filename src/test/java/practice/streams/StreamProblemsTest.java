package practice.streams;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import practice.streams.StreamProblems.Employee;

class StreamProblemsTest {
    private final List<Employee> staff = List.of(
            new Employee("Asha", "ENG", 120), new Employee("Bo", "ENG", 100),
            new Employee("Cy", "OPS", 80), new Employee("Di", "OPS", 90), new Employee("Eli", "HR", 70));

    @Test void evenSquares() {
        assertEquals(List.of(4, 16, 36), StreamProblems.evenSquares(List.of(1, 2, 3, 4, 5, 6)));
    }
    @Test void averageLength() {
        assertEquals(3.0, StreamProblems.averageLength(List.of("a", "abc", "abcde")), 1e-9);
        assertEquals(0.0, StreamProblems.averageLength(List.of()), 1e-9);
    }
    @Test void groupByInitial() {
        Map<Character, List<String>> g = StreamProblems.groupByInitial(List.of("anna", "Adam", "bob"));
        assertEquals(List.of("anna", "Adam"), g.get('A'));
        assertEquals(List.of('A', 'B'), List.copyOf(g.keySet()));
    }
    @Test void topEarners() {
        assertEquals(List.of("Asha", "Bo"), StreamProblems.topEarners(staff, 2));
        assertEquals(5, StreamProblems.topEarners(staff, 50).size());
    }
    @Test void payroll() {
        assertEquals(Map.of("ENG", 220.0, "OPS", 170.0, "HR", 70.0), StreamProblems.payrollByDept(staff));
    }
    @Test void longestWord() {
        assertEquals("banana", StreamProblems.longestWord(List.of("fig", "banana", "kiwi")).orElseThrow());
        assertTrue(StreamProblems.longestWord(List.of()).isEmpty());
    }
    @Test void primes() {
        assertEquals(25, StreamProblems.countPrimesBelow(100));
        assertEquals(0, StreamProblems.countPrimesBelow(2));
    }
    @Test void csv() {
        assertEquals("a, b, c", StreamProblems.distinctSortedCsv(List.of("c", "a", "b", "a")));
    }
}
