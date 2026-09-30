import java.util.*;

public class HashingDemo {

    // Two Sum: find indices of two numbers that add up to target, using a HashMap for O(n) lookup
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); // value -> index
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }
            seen.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    // Find all duplicate elements in an array using a HashSet
    static List<Integer> findDuplicates(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();
        for (int num : arr) {
            if (!seen.add(num)) { // add() returns false if already present
                duplicates.add(num);
            }
        }
        return duplicates;
    }

    // Group anagrams together using a HashMap keyed by sorted characters
    static Map<String, List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return groups;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println("Two Sum indices for target 9: " + Arrays.toString(twoSum(nums, 9)));

        int[] arr = {1, 2, 3, 2, 4, 5, 1};
        System.out.println("Duplicates: " + findDuplicates(arr));

        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Grouped anagrams: " + groupAnagrams(words));
    }
}
