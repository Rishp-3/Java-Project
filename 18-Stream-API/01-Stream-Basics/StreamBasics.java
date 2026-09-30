import java.util.List;
import java.util.stream.Stream;

public class StreamBasics {
    public static void main(String[] args) {

        // A Stream is a pipeline for processing sequences of data declaratively -
        // "what to do" instead of "how to loop through it".
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Original list: " + numbers);

        // A simple pipeline: filter -> map -> collect
        List<Integer> evenSquares = numbers.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .toList();

        System.out.println("Even squares: " + evenSquares);

        // Streams can be created several ways
        Stream<String> fromValues = Stream.of("a", "b", "c");
        Stream<Integer> fromList = numbers.stream();
        Stream<Integer> generated = Stream.iterate(1, n -> n * 2).limit(5);

        fromValues.forEach(System.out::println);
        System.out.println("Generated (powers of 2): " + generated.toList());

        // Streams are lazy and can only be consumed ONCE
        long count = numbers.stream().filter(n -> n > 5).count();
        System.out.println("Numbers greater than 5: " + count);

        // Terminal operations trigger the actual processing
        boolean anyNegative = numbers.stream().anyMatch(n -> n < 0);
        System.out.println("Any negative numbers? " + anyNegative);
    }
}
