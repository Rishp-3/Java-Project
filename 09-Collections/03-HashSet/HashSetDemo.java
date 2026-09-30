import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {

        // HashSet: stores UNIQUE elements, no guaranteed order
        Set<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Red"); // duplicate - ignored

        System.out.println("Colors: " + colors);
        System.out.println("Size (duplicate ignored): " + colors.size());

        System.out.println("Contains 'Green': " + colors.contains("Green"));
        colors.remove("Blue");
        System.out.println("After remove: " + colors);

        // Set operations: union, intersection, difference
        Set<Integer> set1 = new HashSet<>(java.util.List.of(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(java.util.List.of(3, 4, 5, 6));

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Intersection: " + intersection);

        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        System.out.println("Difference (set1 - set2): " + difference);
    }
}
