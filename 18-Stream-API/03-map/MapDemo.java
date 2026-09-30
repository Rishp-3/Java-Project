import java.util.List;

public class MapDemo {
    public static void main(String[] args) {

        List<String> names = List.of("rishabh", "aman", "priya");

        // map() TRANSFORMS each element into something else (one-to-one)
        List<String> capitalized = names.stream()
            .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
            .toList();
        System.out.println("Capitalized: " + capitalized);

        List<Integer> nameLengths = names.stream()
            .map(String::length)
            .toList();
        System.out.println("Lengths: " + nameLengths);

        // Chaining map with filter
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<Integer> squaresOfEvens = numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .toList();
        System.out.println("Squares of evens: " + squaresOfEvens);

        // mapToInt / mapToObj for working with primitive streams
        int totalLength = names.stream().mapToInt(String::length).sum();
        System.out.println("Total character count: " + totalLength);
    }
}
