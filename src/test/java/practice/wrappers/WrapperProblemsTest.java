package practice.wrappers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WrapperProblemsTest {
    @Test void sumSkipsNulls() {
        assertEquals(6, WrapperProblems.sumIgnoringNulls(Arrays.asList(1, null, 2, null, 3)));
        assertEquals(0, WrapperProblems.sumIgnoringNulls(Arrays.asList()));
    }
    @Test void orDefault() {
        assertEquals(5, WrapperProblems.orDefault(5, 0));
        assertEquals(0, WrapperProblems.orDefault(null, 0));
    }
    @Test void valueComparisonBeatsIdentity() {
        Integer a = 1000, b = 1000;
        assertNotSame(a, b);                       // the classic trap: == would be false here
        assertTrue(WrapperProblems.sameValue(a, b));
        assertTrue(WrapperProblems.sameValue(null, null));
        assertFalse(WrapperProblems.sameValue(null, 1));
    }
    @Test void hex() {
        assertEquals(255, WrapperProblems.parseHex("ff"));
        assertEquals(-26, WrapperProblems.parseHex(" -1A "));
        assertThrows(NumberFormatException.class, () -> WrapperProblems.parseHex("xyz"));
    }
    @Test void overflowDetection() {
        assertTrue(WrapperProblems.addOverflows(Integer.MAX_VALUE, 1));
        assertFalse(WrapperProblems.addOverflows(1, 2));
        assertEquals(Integer.MIN_VALUE, Integer.MAX_VALUE + 1);   // what silent overflow looks like
    }
    @Test void binary() {
        assertEquals("1010", WrapperProblems.toBinary(10));
    }
}
