package practice.lambda;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LambdaProblemsTest {
    @Test void applyTwice() {
        assertEquals(20, LambdaProblems.applyTwice(x -> x * 2, 5));
        assertEquals(7, LambdaProblems.applyTwice(x -> x + 1, 5));
    }
    @Test void sortChain() {
        assertEquals(List.of("fig", "kiwi", "pear", "apple"),
                LambdaProblems.sortByLengthThenAlpha(List.of("pear", "apple", "kiwi", "fig")));
    }
    @Test void closures() {
        var add5 = LambdaProblems.makeAdder(5);
        var add10 = LambdaProblems.makeAdder(10);
        assertEquals(8, add5.applyAsInt(3));
        assertEquals(13, add10.applyAsInt(3));
    }
    @Test void reduce() {
        assertEquals(10, LambdaProblems.reduce(List.of(1, 2, 3, 4), 0, Integer::sum));
        assertEquals(24, LambdaProblems.reduce(List.of(1, 2, 3, 4), 1, (a, b) -> a * b));
        assertEquals(7, LambdaProblems.reduce(List.of(3, 7, 2), Integer.MIN_VALUE, Math::max));
    }
    @Test void validators() {
        var rules = LambdaProblems.usernameRules();
        assertTrue(rules.isValid("rishabh"));
        assertFalse(rules.isValid("ab"));
        assertFalse(rules.isValid("rish123"));
    }
    @Test void methodReferences() {
        assertEquals(List.of(3, 0, 5), LambdaProblems.trimmedLengths(List.of("  abc ", "   ", "hello")));
    }
}
