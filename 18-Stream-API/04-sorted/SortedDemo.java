import java.util.Comparator;
import java.util.List;

public class SortedDemo {
    public static void main(String[] args) {

        List<String> names = List.of("Charlie", "alice", "Bob", "dave");

        // sorted() with natural ordering
        List<String> naturalSort = names.stream().sorted().toList();
        System.out.println("Natural sort: " + naturalSort); // uppercase letters sort before lowercase

        // sorted() with a custom Comparator
        List<String> caseInsensitive = names.stream()
            .sorted(String.CASE_INSENSITIVE_ORDER)
            .toList();
        System.out.println("Case-insensitive: " + caseInsensitive);

        List<String> byLength = names.stream()
            .sorted(Comparator.comparing(String::length))
            .toList();
        System.out.println("By length: " + byLength);

        // Reversed order
        List<Integer> numbers = List.of(5, 2, 8, 1, 9);
        List<Integer> descending = numbers.stream()
            .sorted(Comparator.reverseOrder())
            .toList();
        System.out.println("Descending: " + descending);

        // Sorting objects by multiple fields
        record Person(String name, int age) {}
        List<Person> people = List.of(
            new Person("Aman", 25),
            new Person("Priya", 25),
            new Person("Rishabh", 22)
        );

        List<Person> sortedPeople = people.stream()
            .sorted(Comparator.comparingInt(Person::age).thenComparing(Person::name))
            .toList();

        System.out.println("Sorted by age, then name:");
        sortedPeople.forEach(p -> System.out.println("  " + p.name() + " - " + p.age()));
    }
}
