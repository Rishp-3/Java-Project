package practice.basics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BasicsProblemsTest {
    @Test void celsius() {
        assertEquals(32.0, BasicsProblems.celsiusToFahrenheit(0), 1e-9);
        assertEquals(212.0, BasicsProblems.celsiusToFahrenheit(100), 1e-9);
        assertEquals(-40.0, BasicsProblems.celsiusToFahrenheit(-40), 1e-9);
    }
    @Test void leapYears() {
        assertTrue(BasicsProblems.isLeapYear(2024));
        assertTrue(BasicsProblems.isLeapYear(2000));
        assertFalse(BasicsProblems.isLeapYear(1900));
        assertFalse(BasicsProblems.isLeapYear(2023));
    }
    @Test void interest() {
        assertEquals(150.0, BasicsProblems.simpleInterest(1000, 5, 3), 1e-9);
    }
    @Test void evenBitwise() {
        assertTrue(BasicsProblems.isEvenBitwise(0));
        assertTrue(BasicsProblems.isEvenBitwise(-4));
        assertFalse(BasicsProblems.isEvenBitwise(7));
    }
    @Test void averageKeepsFractionAndAvoidsOverflow() {
        assertEquals(2.5, BasicsProblems.average(2, 3), 1e-9);
        assertEquals(Integer.MAX_VALUE, BasicsProblems.average(Integer.MAX_VALUE, Integer.MAX_VALUE), 1e-9);
    }
}
