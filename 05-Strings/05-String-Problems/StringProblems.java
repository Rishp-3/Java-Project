public class StringProblems {

    // Check if a string is a palindrome (reads the same forwards and backwards)
    static boolean isPalindrome(String s) {
        String cleaned = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Reverse a string
    static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // Check if two strings are anagrams of each other
    static boolean isAnagram(String a, String b) {
        char[] arr1 = a.toLowerCase().replace(" ", "").toCharArray();
        char[] arr2 = b.toLowerCase().replace(" ", "").toCharArray();
        java.util.Arrays.sort(arr1);
        java.util.Arrays.sort(arr2);
        return java.util.Arrays.equals(arr1, arr2);
    }

    // Count occurrences of each character
    static void countCharacters(String s) {
        java.util.Map<Character, Integer> counts = new java.util.LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        System.out.println(counts);
    }

    public static void main(String[] args) {
        System.out.println("'madam' is palindrome: " + isPalindrome("madam"));
        System.out.println("'A man a plan a canal Panama' is palindrome: " + isPalindrome("A man a plan a canal Panama"));

        System.out.println("Reverse of 'Java': " + reverse("Java"));

        System.out.println("'listen' and 'silent' are anagrams: " + isAnagram("listen", "silent"));
        System.out.println("'hello' and 'world' are anagrams: " + isAnagram("hello", "world"));

        System.out.print("Character counts in 'programming': ");
        countCharacters("programming");
    }
}
