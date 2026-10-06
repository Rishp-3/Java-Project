package practice.streams;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/** Module 18 - Stream API: filter, map, sorted, reduce, collect, grouping. */
public final class StreamProblems {
    private StreamProblems() {}

    public record Employee(String name, String dept, double salary) {}

    /** Problem 1: squares of the even numbers, in order. */
    public static List<Integer> evenSquares(List<Integer> nums) {
        return nums.stream().filter(n -> n % 2 == 0).map(n -> n * n).toList();
    }

    /** Problem 2: average word length (0 for an empty list). */
    public static double averageLength(List<String> words) {
        return words.stream().mapToInt(String::length).average().orElse(0);
    }

    /** Problem 3: group names by their first letter (upper-cased), keys sorted. */
    public static Map<Character, List<String>> groupByInitial(List<String> names) {
        return names.stream().collect(Collectors.groupingBy(
                n -> Character.toUpperCase(n.charAt(0)), java.util.TreeMap::new, Collectors.toList()));
    }

    /** Problem 4: the n highest-paid employees, highest first. */
    public static List<String> topEarners(List<Employee> staff, int n) {
        return staff.stream()
                .sorted((a, b) -> Double.compare(b.salary(), a.salary()))
                .limit(n)
                .map(Employee::name)
                .toList();
    }

    /** Problem 5: total salary per department. */
    public static Map<String, Double> payrollByDept(List<Employee> staff) {
        return staff.stream().collect(Collectors.groupingBy(Employee::dept, java.util.TreeMap::new,
                Collectors.summingDouble(Employee::salary)));
    }

    /** Problem 6: the longest word, if any. */
    public static Optional<String> longestWord(List<String> words) {
        return words.stream().reduce((a, b) -> b.length() > a.length() ? b : a);
    }

    /** Problem 7: how many primes are there below n? (IntStream.range + allMatch) */
    public static long countPrimesBelow(int n) {
        return IntStream.range(2, n).filter(i -> IntStream.rangeClosed(2, (int) Math.sqrt(i)).allMatch(d -> i % d != 0)).count();
    }

    /** Problem 8: join distinct, sorted names with ", ". */
    public static String distinctSortedCsv(List<String> names) {
        return names.stream().distinct().sorted().collect(Collectors.joining(", "));
    }
}
