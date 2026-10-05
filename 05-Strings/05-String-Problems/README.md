# String Problems in Java

## 📌 Topic
Interview me aane wale common string problems: palindrome, anagram, vowel count, character frequency aur reverse words.

## 🎯 What You Will Learn

- Palindrome check
- Anagram check
- Character frequency count karna
- Words ko reverse karna

## 💻 Code

```java
import java.util.Arrays;

public class StringProblems {

    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    static boolean isAnagram(String a, String b) {
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        return Arrays.equals(x, y);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("level"));
        System.out.println(isPalindrome("java"));
        System.out.println(isAnagram("listen", "silent"));

        String text = "programming";
        int[] freq = new int[26];
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 1) System.out.println((char) ('a' + i) + " -> " + freq[i]);
        }

        String[] words = "I love Java".split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }
        System.out.println();
    }
}
```

## 🧠 Explanation

### `isPalindrome`
Do pointers shuru aur end se beech ki taraf aate hain aur characters compare karte hain.

### `isAnagram`
Dono strings sort karke compare karte hain. Anagram me same letters alag order me hote hain.

### `freq[c - 'a']++`
Character ko index me badalne ki trick: `'a' - 'a' = 0`, `'b' - 'a' = 1`.

## ▶️ Output

```text
true
false
true
g -> 2
m -> 2
r -> 2
Java love I 
```

## 🔑 Important Points

- Pehle case aur spaces handle karo (`toLowerCase()`, `replaceAll(" ", "")`).
- Frequency problems me array ya `HashMap` use hota hai.
- `toCharArray()` string ko char array banata hai.

## 📝 Practice

1. String me sabse zyada aane wala character nikalo.
2. String me duplicate characters print karo.
3. String me vowels aur consonants count karo.
4. Do strings rotation hain ya nahi check karo.

## 🚀 Challenge

String ke saare words reverse karo par har word ke letters waise hi rakho. `I love Java` -> `Java love I`.

```text
Java love I
```
