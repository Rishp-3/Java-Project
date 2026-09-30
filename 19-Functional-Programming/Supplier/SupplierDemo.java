import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {

        // Supplier<T>: takes NO argument, SUPPLIES (returns) a value.
        // Useful for lazy evaluation - the value is only computed when get() is called.
        Supplier<String> greetingSupplier = () -> "Hello from a Supplier!";
        System.out.println(greetingSupplier.get());

        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Random value: " + randomSupplier.get());

        // Lazy initialization - the expensive object is only created if actually needed
        Supplier<java.util.List<Integer>> expensiveListSupplier = () -> {
            System.out.println("Creating the expensive list now...");
            return java.util.List.of(1, 2, 3, 4, 5);
        };

        System.out.println("Supplier created, but nothing computed yet.");
        System.out.println("List: " + expensiveListSupplier.get()); // computed only now

        // Supplier is often used to provide default values
        System.out.println(getSetting("theme", () -> "light-mode (default)"));
    }

    // pretend this looks up "key" somewhere and falls back to the supplier if not found
    static String getSetting(String key, Supplier<String> defaultSupplier) {
        return defaultSupplier.get();
    }
}
