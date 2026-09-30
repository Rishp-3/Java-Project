import java.util.*;
import java.util.stream.Collectors;

public class CollectDemo {
    public static void main(String[] args) {

        List<String> names = List.of("Rishabh", "Aman", "Priya", "Rahul", "Anjali");

        // Collecting into a List
        List<String> upper = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("As List: " + upper);

        // Collecting into a Set (removes duplicates)
        Set<Integer> lengths = names.stream().map(String::length).collect(Collectors.toSet());
        System.out.println("Unique lengths: " + lengths);

        // Joining into a single String
        String joined = names.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Joined: " + joined);

        // Grouping by a property
        Map<Integer, List<String>> byLength = names.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + byLength);

        // Counting elements in each group
        Map<Integer, Long> countByLength = names.stream()
            .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("Count by length: " + countByLength);

        // Partitioning into two groups (true/false)
        Map<Boolean, List<String>> partitioned = names.stream()
            .collect(Collectors.partitioningBy(name -> name.length() > 5));
        System.out.println("Longer than 5 chars: " + partitioned.get(true));
        System.out.println("5 chars or fewer: " + partitioned.get(false));

        // Collecting summary statistics
        IntSummaryStatistics stats = names.stream()
            .collect(Collectors.summarizingInt(String::length));
        System.out.println("Stats -> min: " + stats.getMin() + ", max: " + stats.getMax() +
            ", avg: " + stats.getAverage());
    }
}
