import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {

        // HashMap: key-value pairs, keys are unique, no guaranteed order
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Rishabh", 22);
        ages.put("Aman", 25);
        ages.put("Priya", 23);
        ages.put("Rishabh", 23); // overwrites the previous value for "Rishabh"

        System.out.println("Map: " + ages);
        System.out.println("Rishabh's age: " + ages.get("Rishabh"));
        System.out.println("Unknown key: " + ages.get("Unknown")); // null
        System.out.println("getOrDefault: " + ages.getOrDefault("Unknown", 0));

        System.out.println("Contains key 'Aman': " + ages.containsKey("Aman"));
        System.out.println("Contains value 25: " + ages.containsValue(25));

        ages.remove("Priya");
        System.out.println("After remove: " + ages);

        // Iterating over a map
        System.out.println("Iterating with entrySet:");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        // Counting word frequency - a very common HashMap use case
        String[] words = {"apple", "banana", "apple", "cherry", "banana", "apple"};
        Map<String, Integer> frequency = new HashMap<>();
        for (String word : words) {
            frequency.merge(word, 1, Integer::sum);
        }
        System.out.println("Word frequency: " + frequency);
    }
}
