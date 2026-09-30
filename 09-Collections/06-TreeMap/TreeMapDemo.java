import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {

        // TreeMap: keys are stored in SORTED order (natural ordering by default)
        TreeMap<String, Integer> scores = new TreeMap<>();
        scores.put("Charlie", 85);
        scores.put("Alice", 92);
        scores.put("Bob", 78);

        System.out.println("Sorted by key: " + scores); // Alice, Bob, Charlie

        System.out.println("First key: " + scores.firstKey());
        System.out.println("Last key: " + scores.lastKey());
        System.out.println("Higher key than 'Bob': " + scores.higherKey("Bob"));
        System.out.println("Lower key than 'Bob': " + scores.lowerKey("Bob"));

        // Sub-map views
        TreeMap<Integer, String> ranks = new TreeMap<>();
        ranks.put(1, "Gold");
        ranks.put(2, "Silver");
        ranks.put(3, "Bronze");
        ranks.put(4, "Participant");

        System.out.println("headMap(3): " + ranks.headMap(3)); // keys < 3
        System.out.println("tailMap(2): " + ranks.tailMap(2)); // keys >= 2

        for (var entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " scored " + entry.getValue());
        }
    }
}
