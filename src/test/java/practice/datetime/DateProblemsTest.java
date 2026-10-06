package practice.datetime;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import org.junit.jupiter.api.Test;

class DateProblemsTest {
    @Test void daysBetween() {
        assertEquals(30, DateProblems.daysBetween(LocalDate.of(2026, 1, 1), LocalDate.of(2026, 1, 31)));
        assertEquals(-1, DateProblems.daysBetween(LocalDate.of(2026, 3, 1), LocalDate.of(2026, 2, 28)));
        assertEquals(366, DateProblems.daysBetween(LocalDate.of(2024, 1, 1), LocalDate.of(2025, 1, 1)));
    }
    @Test void age() {
        LocalDate birth = LocalDate.of(2000, 6, 15);
        assertEquals(25, DateProblems.ageOn(birth, LocalDate.of(2026, 6, 14)));
        assertEquals(26, DateProblems.ageOn(birth, LocalDate.of(2026, 6, 15)));
    }
    @Test void weekend() {
        assertTrue(DateProblems.isWeekend(LocalDate.of(2026, 10, 3)));   // Saturday
        assertFalse(DateProblems.isWeekend(LocalDate.of(2026, 10, 5)));  // Monday
    }
    @Test void businessDays() {
        // Friday + 1 business day = Monday; Monday + 5 = next Monday
        assertEquals(LocalDate.of(2026, 10, 5), DateProblems.addBusinessDays(LocalDate.of(2026, 10, 2), 1));
        assertEquals(LocalDate.of(2026, 10, 12), DateProblems.addBusinessDays(LocalDate.of(2026, 10, 5), 5));
        assertEquals(LocalDate.of(2026, 10, 5), DateProblems.addBusinessDays(LocalDate.of(2026, 10, 5), 0));
    }
    @Test void formatting() {
        assertEquals("05 Oct 2026", DateProblems.pretty(LocalDate.of(2026, 10, 5)));
    }
    @Test void strictParsing() {
        assertEquals(LocalDate.of(2026, 2, 28), DateProblems.parseDayFirst("28/02/2026"));
        assertThrows(DateTimeParseException.class, () -> DateProblems.parseDayFirst("31/02/2026"));
    }
    @Test void endOfMonth() {
        assertEquals(LocalDate.of(2024, 2, 29), DateProblems.endOfMonth(LocalDate.of(2024, 2, 10)));
        assertEquals(LocalDate.of(2026, 4, 30), DateProblems.endOfMonth(LocalDate.of(2026, 4, 1)));
    }
}
