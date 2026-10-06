package practice.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringProblemsTest {
    @Test void palindromes() {
        assertTrue(StringProblems.isPalindrome("A man, a plan, a canal: Panama"));
        assertTrue(StringProblems.isPalindrome(""));
        assertFalse(StringProblems.isPalindrome("hello"));
    }
    @Test void reverseWords() {
        assertEquals("blue is sky the", StringProblems.reverseWords("the sky is blue"));
        assertEquals("b a", StringProblems.reverseWords("  a   b  "));
    }
    @Test void vowels() {
        assertEquals(5, StringProblems.countVowels("Education"));
        assertEquals(0, StringProblems.countVowels("rhythm"));
    }
    @Test void anagrams() {
        assertTrue(StringProblems.isAnagram("Listen", "Silent"));
        assertTrue(StringProblems.isAnagram("dormitory", "dirty room"));
        assertFalse(StringProblems.isAnagram("abc", "abd"));
    }
    @Test void firstUnique() {
        assertEquals(0, StringProblems.firstUniqueChar("leetcode"));
        assertEquals(2, StringProblems.firstUniqueChar("loveleetcode"));
        assertEquals(-1, StringProblems.firstUniqueChar("aabb"));
    }
    @ParameterizedTest
    @CsvSource({"aaabcc,a3b1c2", "a,a1", "abc,a1b1c1", "zzzzzzzzzzzz,z12"})
    void compress(String in, String expected) {
        assertEquals(expected, StringProblems.compress(in));
    }
    @Test void compressEmpty() {
        assertEquals("", StringProblems.compress(""));
    }
}
