package practice.methods;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MethodProblemsTest {
    @Test void factorial() {
        assertEquals(1, MethodProblems.factorial(0));
        assertEquals(120, MethodProblems.factorial(5));
        assertEquals(2432902008176640000L, MethodProblems.factorial(20));
        assertThrows(ArithmeticException.class, () -> MethodProblems.factorial(21));
        assertThrows(IllegalArgumentException.class, () -> MethodProblems.factorial(-1));
    }
    @Test void gcd() {
        assertEquals(6, MethodProblems.gcd(48, 18));
        assertEquals(5, MethodProblems.gcd(5, 0));
        assertEquals(1, MethodProblems.gcd(17, 13));
    }
    @Test void fibonacci() {
        assertEquals(0, MethodProblems.fibonacci(0));
        assertEquals(1, MethodProblems.fibonacci(1));
        assertEquals(55, MethodProblems.fibonacci(10));
        assertEquals(7540113804746346429L, MethodProblems.fibonacci(92));
    }
    @Test void digitSum() {
        assertEquals(0, MethodProblems.digitSum(0));
        assertEquals(15, MethodProblems.digitSum(12345));
        assertEquals(6, MethodProblems.digitSum(-123));
    }
    @Test void overloads() {
        assertEquals(9, MethodProblems.max(4, 9));
        assertEquals(9, MethodProblems.max(4, 9, 2));
        assertEquals(2.5, MethodProblems.max(2.5, 1.5), 1e-9);
    }
    @Test void varargs() {
        assertEquals(0, MethodProblems.sum());
        assertEquals(10, MethodProblems.sum(1, 2, 3, 4));
    }
}
