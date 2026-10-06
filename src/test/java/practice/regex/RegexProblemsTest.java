package practice.regex;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RegexProblemsTest {
    @ParameterizedTest
    @ValueSource(strings = {"a@b.com", "first.last+tag@mail.example.org", "x_y@sub-domain.co.in"})
    void validEmails(String e) { assertTrue(RegexProblems.isValidEmail(e), e); }

    @ParameterizedTest
    @ValueSource(strings = {"", "plain", "@no-user.com", "a@b", "a b@c.com", "a@b..com"})
    void invalidEmails(String e) { assertFalse(RegexProblems.isValidEmail(e), e); }

    @Test void nullEmail() { assertFalse(RegexProblems.isValidEmail(null)); }

    @Test void numbers() {
        assertEquals(List.of(3.0, -2.5, 10.0), RegexProblems.extractNumbers("Got 3 apples, -2.5 kg and 10 units"));
        assertTrue(RegexProblems.extractNumbers("none here").isEmpty());
    }
    @Test void hashtags() {
        assertEquals(List.of("java", "Learning_2026"), RegexProblems.hashtags("Loving #java and #Learning_2026! issue#12 ##x"));
    }
    @Test void mobiles() {
        assertTrue(RegexProblems.isIndianMobile("9876543210"));
        assertTrue(RegexProblems.isIndianMobile("+91 9876543210"));
        assertFalse(RegexProblems.isIndianMobile("1234567890"));
        assertFalse(RegexProblems.isIndianMobile("98765"));
    }
    @Test void passwords() {
        assertTrue(RegexProblems.isStrongPassword("Abcdef1!"));
        assertFalse(RegexProblems.isStrongPassword("abcdef1!"));
        assertFalse(RegexProblems.isStrongPassword("Abcdefg1"));
        assertFalse(RegexProblems.isStrongPassword("Ab1!"));
    }
    @Test void masking() {
        assertEquals("****-****-****-3456", RegexProblems.maskDigits("1234-5678-9012-3456"));
        assertEquals("12", RegexProblems.maskDigits("12"));
    }
    @Test void dateReformat() {
        assertEquals("Due 05/10/2026 and 01/01/2027", RegexProblems.isoToDayFirst("Due 2026-10-05 and 2027-01-01"));
    }
}
