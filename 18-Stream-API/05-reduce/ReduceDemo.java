import java.util.List;
import java.util.Optional;

public class ReduceDemo {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // reduce() combines all elements into a SINGLE result
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);

        int product = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);

        // reduce() without an initial value returns an Optional
        // (because the stream might be empty, with no result to return)
        Optional<Integer> max = numbers.stream().reduce((a, b) -> a > b ? a : b);
        System.out.println("Max: " + max.orElse(-1));

        // Using a method reference instead of a lambda
        int sumViaMethodRef = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum (method ref): " + sumViaMethodRef);

        // Reducing strings
        List<String> words = List.of("Java", "is", "fun");
        String sentence = words.stream().reduce("", (a, b) -> a.isEmpty() ? b : a + " " + b);
        System.out.println("Sentence: " + sentence);

        // For simple sum/max/min, built-in methods are often cleaner than reduce:
        System.out.println("sum() built-in: " + numbers.stream().mapToInt(Integer::intValue).sum());
        System.out.println("max() built-in: " + numbers.stream().mapToInt(Integer::intValue).max().getAsInt());
    }
}
