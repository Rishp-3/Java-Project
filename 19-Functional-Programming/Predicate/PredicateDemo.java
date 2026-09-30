import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {

        // Predicate<T>: takes an argument, returns a boolean - used for tests/filters
        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;

        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is -3 positive? " + isPositive.test(-3));

        // Combining predicates: and(), or(), negate()
        Predicate<Integer> isPositiveAndEven = isPositive.and(isEven);
        Predicate<Integer> isPositiveOrEven = isPositive.or(isEven);
        Predicate<Integer> isOdd = isEven.negate();

        System.out.println("6 is positive AND even: " + isPositiveAndEven.test(6));
        System.out.println("-4 is positive OR even: " + isPositiveOrEven.test(-4));
        System.out.println("7 is odd: " + isOdd.test(7));

        // Very common use: filter() on a stream takes a Predicate
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> result = numbers.stream()
            .filter(isPositiveAndEven)
            .toList();
        System.out.println("Positive even numbers: " + result);

        Predicate<String> isLongName = name -> name.length() > 5;
        System.out.println("'Rishabh' is a long name: " + isLongName.test("Rishabh"));
    }
}
