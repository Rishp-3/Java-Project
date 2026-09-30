import java.util.HashMap;
import java.util.Map;

public class StringsDemo {

    // Find the first non-repeating character in a string
    static char firstNonRepeatingChar(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.merge(c, 1, Integer::sum);
        }
        for (char c : s.toCharArray()) {
            if (counts.get(c) == 1) return c;
        }
        return '\0';
    }

    // Check if two strings are anagrams using character frequency counting
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] freq = new int[26];
        for (char c : a.toLowerCase().toCharArray()) freq[c - 'a']++;
        for (char c : b.toLowerCase().toCharArray()) freq[c - 'a']--;
        for (int f : freq) if (f != 0) return false;
        return true;
    }

    // Find the longest substring without repeating characters
    static int longestUniqueSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lastSeen.containsKey(c) && lastSeen.get(c) >= start) {
                start = lastSeen.get(c) + 1;
            }
            lastSeen.put(c, i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("First non-repeating char in 'swiss': " + firstNonRepeatingChar("swiss"));
        System.out.println("'listen' and 'silent' are anagrams: " + isAnagram("listen", "silent"));
        System.out.println("Longest unique substring in 'abcabcbb': " + longestUniqueSubstring("abcabcbb"));
    }
}
