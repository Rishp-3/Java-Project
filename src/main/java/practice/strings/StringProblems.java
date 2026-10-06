package practice.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/** Module 05 - Strings: String methods, StringBuilder, classic string problems. */
public final class StringProblems {
    private StringProblems() {}

    /** Problem 1: palindrome check ignoring case and non-alphanumeric characters. */
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) return false;
        }
        return true;
    }

    /** Problem 2: reverse the order of words ("the sky is blue" -> "blue is sky the"). */
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    /** Problem 3: count vowels (a, e, i, o, u - case-insensitive). */
    public static int countVowels(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) count++;
        }
        return count;
    }

    /** Problem 4: are two strings anagrams (ignoring case and spaces)? */
    public static boolean isAnagram(String a, String b) {
        char[] x = a.replace(" ", "").toLowerCase().toCharArray();
        char[] y = b.replace(" ", "").toLowerCase().toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        return Arrays.equals(x, y);
    }

    /** Problem 5: index of the first character that appears only once, or -1. */
    public static int firstUniqueChar(String s) {
        Map<Character, Integer> counts = new LinkedHashMap<>();
        for (char c : s.toCharArray()) counts.merge(c, 1, Integer::sum);
        for (int i = 0; i < s.length(); i++) {
            if (counts.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    /** Problem 6: run-length encoding ("aaabcc" -> "a3b1c2"). */
    public static String compress(String s) {
        if (s.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int run = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                run++;
            } else {
                sb.append(s.charAt(i - 1)).append(run);
                run = 1;
            }
        }
        return sb.toString();
    }
}
