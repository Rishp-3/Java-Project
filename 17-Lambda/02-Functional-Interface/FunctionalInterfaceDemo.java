public class FunctionalInterfaceDemo {

    // @FunctionalInterface documents (and enforces) that this interface has
    // exactly one abstract method - required for lambda expressions to work.
    @FunctionalInterface
    interface Transformer<T, R> {
        R transform(T input);

        // default methods are allowed - they don't count against the "one abstract method" rule
        default Transformer<T, R> andLog() {
            return input -> {
                R result = transform(input);
                System.out.println("Transformed " + input + " -> " + result);
                return result;
            };
        }
    }

    public static void main(String[] args) {
        Transformer<String, Integer> lengthFinder = String::length; // method reference
        Transformer<Integer, Integer> doubler = n -> n * 2;

        System.out.println("Length of 'Hello': " + lengthFinder.transform("Hello"));
        System.out.println("Double of 21: " + doubler.transform(21));

        doubler.andLog().transform(10);

        // Java's built-in functional interfaces (java.util.function) are used constantly:
        java.util.function.Function<Integer, Integer> square = n -> n * n;
        java.util.function.Predicate<Integer> isEven = n -> n % 2 == 0;
        java.util.function.Supplier<String> greeting = () -> "Hi there!";
        java.util.function.Consumer<String> printer = System.out::println;

        System.out.println("Square of 6: " + square.apply(6));
        System.out.println("Is 6 even? " + isEven.test(6));
        printer.accept(greeting.get());
    }
}
