package practice.controlflow;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ControlFlowProblemsTest {
    @Test void fizzBuzz() {
        assertEquals(List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"),
                ControlFlowProblems.fizzBuzz(15));
        assertTrue(ControlFlowProblems.fizzBuzz(0).isEmpty());
    }
    @Test void primes() {
        assertFalse(ControlFlowProblems.isPrime(1));
        assertTrue(ControlFlowProblems.isPrime(2));
        assertTrue(ControlFlowProblems.isPrime(97));
        assertFalse(ControlFlowProblems.isPrime(100));
        assertTrue(ControlFlowProblems.isPrime(2147483647));
    }
    @Test void grades() {
        assertEquals('A', ControlFlowProblems.gradeFor(100));
        assertEquals('A', ControlFlowProblems.gradeFor(90));
        assertEquals('B', ControlFlowProblems.gradeFor(85));
        assertEquals('F', ControlFlowProblems.gradeFor(12));
        assertThrows(IllegalArgumentException.class, () -> ControlFlowProblems.gradeFor(101));
    }
    @Test void collatz() {
        assertEquals(0, ControlFlowProblems.collatzSteps(1));
        assertEquals(8, ControlFlowProblems.collatzSteps(6));
        assertEquals(111, ControlFlowProblems.collatzSteps(27));
        assertThrows(IllegalArgumentException.class, () -> ControlFlowProblems.collatzSteps(0));
    }
    @Test void triangle() {
        assertEquals(List.of("  *", " **", "***"), ControlFlowProblems.starTriangle(3));
    }
}
