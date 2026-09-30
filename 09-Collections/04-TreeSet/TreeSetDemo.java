import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {

        // TreeSet: stores unique elements in SORTED (natural) order
        TreeSet<Integer> numbers = new TreeSet<>();
        numbers.add(50);
        numbers.add(10);
        numbers.add(30);
        numbers.add(20);
        numbers.add(10); // duplicate ignored

        System.out.println("Sorted set: " + numbers); // automatically sorted

        System.out.println("First (smallest): " + numbers.first());
        System.out.println("Last (largest): " + numbers.last());
        System.out.println("Higher than 20: " + numbers.higher(20)); // smallest element > 20
        System.out.println("Lower than 20: " + numbers.lower(20));   // largest element < 20
        System.out.println("Ceiling(25): " + numbers.ceiling(25));   // smallest element >= 25
        System.out.println("Floor(25): " + numbers.floor(25));       // largest element <= 25

        // TreeSet of Strings - sorted alphabetically
        TreeSet<String> names = new TreeSet<>(java.util.List.of("Charlie", "Alice", "Bob"));
        System.out.println("Sorted names: " + names);

        // Custom sort order using a Comparator (descending)
        TreeSet<Integer> descending = new TreeSet<>((a, b) -> b - a);
        descending.addAll(numbers);
        System.out.println("Descending order: " + descending);
    }
}
