# Strings in DSA

## 📌 Topic
String problems me aksar frequency array/HashMap, two pointers aur sliding window use hota hai.

## 🎯 What You Will Learn

- Palindrome (two pointers)
- Character frequency se anagram check
- Sliding Window (longest substring without repeat)
- `StringBuilder` ka use

## 💻 Code

```java
import java.util.HashSet;

public class Strings1 {

    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] freq = new int[26];
        for (int i = 0; i < a.length(); i++) {
            freq[a.charAt(i) - 'a']++;
            freq[b.charAt(i) - 'a']--;
        }
        for (int f : freq) if (f != 0) return false;
        return true;
    }

    static int longestUnique(String s) {
        HashSet<Character> window = new HashSet<>();
        int left = 0, best = 0;
        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left++));
            }
            window.add(s.charAt(right));
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(longestUnique("abcabcbb"));
        System.out.println(new StringBuilder("hello").reverse());
    }
}
```

## 🧠 Explanation

### `isAnagram`
Ek hi array me ek string ke letters `+1` aur doosri ke `-1`. Sab zero ho to anagram. O(n) time, O(1) space.

### `Sliding window`
`left` aur `right` se ek window banti hai. Repeat aate hi `left` aage badhta hai. O(n).

### `StringBuilder`
Baar-baar string badalni ho to `String +=` se behtar (O(n) me kaam).

## ▶️ Output

```text
true
true
3
olleh
```

## 🔑 Important Points

- String immutable hai, har change naya object banata hai.
- 26 letters ke liye `int[26]` array HashMap se fast hota hai.
- Sliding window me har element max 2 baar visit hota hai.

## 📝 Practice

1. Longest palindromic substring (expand around center).
2. Pehla non-repeating character nikalo.
3. Do strings ka longest common prefix nikalo.
4. String compression (`aaabb` -> `a3b2`) banao.

## 🚀 Challenge

Check karo ki do strings rotation hain ya nahi (`abcd` aur `cdab`) ek hi `contains` call se.
