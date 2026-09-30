import java.util.ArrayList;
import java.util.List;

public class UnboxingDemo {
    public static void main(String[] args) {

        // Unboxing: automatic conversion of a wrapper object back into a primitive
        Integer boxedInt = 100;
        int primitiveInt = boxedInt; // unboxing happens automatically here

        System.out.println("Boxed: " + boxedInt);
        System.out.println("Unboxed: " + primitiveInt);

        // Unboxing lets you use wrapper objects directly in arithmetic
        Integer a = 5;
        Integer b = 10;
        int sum = a + b; // both are unboxed automatically before adding
        System.out.println("Sum: " + sum);

        // Common in loops when reading values out of a collection
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30));
        int total = 0;
        for (Integer n : numbers) {
            total += n; // unboxed automatically on each addition
        }
        System.out.println("Total: " + total);

        // Danger: unboxing a null throws a NullPointerException
        Integer nullValue = null;
        try {
            int result = nullValue; // attempts to unbox null -> NPE
        } catch (NullPointerException e) {
            System.out.println("Caught NPE while unboxing a null Integer!");
        }
    }
}
