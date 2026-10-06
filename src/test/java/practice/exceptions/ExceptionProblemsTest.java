package practice.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ExceptionProblemsTest {
    @Test void customCheckedException() throws Exception {
        Wallet w = new Wallet(50);
        w.spend(20);
        InsufficientBalanceException e = assertThrows(InsufficientBalanceException.class, () -> w.spend(100));
        assertEquals(70, e.getShortBy(), 1e-9);
        assertEquals(30, w.getBalance(), 1e-9);
    }
    @Test void parseWithFallback() {
        assertEquals(42, ExceptionProblems.parseIntOrDefault(" 42 ", -1));
        assertEquals(-1, ExceptionProblems.parseIntOrDefault("abc", -1));
        assertEquals(-1, ExceptionProblems.parseIntOrDefault(null, -1));
    }
    @Test void requireAge() {
        assertEquals(30, ExceptionProblems.requireAge(30));
        assertThrows(IllegalArgumentException.class, () -> ExceptionProblems.requireAge(-1));
        assertThrows(IllegalArgumentException.class, () -> ExceptionProblems.requireAge(200));
    }
    @Test void finallyRunsEitherWay() {
        assertEquals(List.of("try", "after-risk", "finally"), ExceptionProblems.finallyOrder(false));
        assertEquals(List.of("try", "catch", "finally"), ExceptionProblems.finallyOrder(true));
    }
    @Test void resourcesCloseInReverse() {
        assertEquals(List.of("open A", "open B", "body", "close B", "close A"), ExceptionProblems.resourceCloseOrder());
    }
    @Test void wrappingKeepsCause() {
        assertEquals("hello", ExceptionProblems.firstWord("  hello world"));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> ExceptionProblems.firstWord(null));
        assertInstanceOf(NullPointerException.class, e.getCause());
    }
}
