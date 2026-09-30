import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {

        // Consumer<T>: takes an argument, returns NOTHING - used for side effects (printing, saving, etc.)
        Consumer<String> printer = s -> System.out.println("Consumed: " + s);
        printer.accept("Hello");

        // andThen() chains multiple consumers to run one after another
        Consumer<String> upperPrinter = s -> System.out.println("Upper: " + s.toUpperCase());
        Consumer<String> combined = printer.andThen(upperPrinter);
        combined.accept("java");

        // Very common use: forEach() on a collection takes a Consumer
        List<String> names = List.of("Rishabh", "Aman", "Priya");
        names.forEach(name -> System.out.println("Hi, " + name));

        // BiConsumer<T, U>: takes TWO arguments, returns nothing
        BiConsumer<String, Integer> printPair = (name, age) ->
            System.out.println(name + " is " + age + " years old");
        printPair.accept("Rishabh", 22);

        // Using BiConsumer with a Map
        java.util.Map<String, Integer> ages = java.util.Map.of("Aman", 25, "Priya", 23);
        ages.forEach(printPair::accept);
    }
}
