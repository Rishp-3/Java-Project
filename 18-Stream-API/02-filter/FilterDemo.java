import java.util.List;

public class FilterDemo {
    public static void main(String[] args) {

        List<String> names = List.of("Rishabh", "Aman", "Priya", "Rahul", "Anjali", "Bob");

        // filter() keeps only elements matching a condition (a Predicate)
        List<String> namesStartingWithA = names.stream()
            .filter(name -> name.startsWith("A"))
            .toList();
        System.out.println("Names starting with A: " + namesStartingWithA);

        List<String> longNames = names.stream()
            .filter(name -> name.length() > 4)
            .toList();
        System.out.println("Names longer than 4 chars: " + longNames);

        // Chaining multiple filters
        List<String> result = names.stream()
            .filter(name -> name.length() > 3)
            .filter(name -> !name.startsWith("B"))
            .toList();
        System.out.println("Length > 3 and not starting with B: " + result);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> divisibleBy3 = numbers.stream()
            .filter(n -> n % 3 == 0)
            .toList();
        System.out.println("Divisible by 3: " + divisibleBy3);
    }
}
