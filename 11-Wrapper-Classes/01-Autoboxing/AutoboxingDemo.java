import java.util.ArrayList;
import java.util.List;

public class AutoboxingDemo {
    public static void main(String[] args) {

        // Autoboxing: automatic conversion of a primitive into its wrapper object
        int primitiveInt = 10;
        Integer boxedInt = primitiveInt; // autoboxing happens automatically here

        System.out.println("Primitive: " + primitiveInt);
        System.out.println("Boxed: " + boxedInt);

        // Every primitive has a corresponding wrapper class:
        // int -> Integer, double -> Double, char -> Character,
        // boolean -> Boolean, long -> Long, etc.
        double d = 3.14;
        Double boxedDouble = d;

        char c = 'A';
        Character boxedChar = c;

        System.out.println(boxedDouble + " " + boxedChar);

        // Autoboxing is especially useful with collections, which can only hold objects
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);  // int 1 is autoboxed into Integer
        numbers.add(2);
        numbers.add(3);
        System.out.println("List of boxed ints: " + numbers);

        // Wrapper classes also provide useful utility methods
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Integer.parseInt(\"42\"): " + Integer.parseInt("42"));
        System.out.println("Integer.toBinaryString(10): " + Integer.toBinaryString(10));
    }
}
