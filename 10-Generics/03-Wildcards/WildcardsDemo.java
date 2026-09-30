import java.util.List;
import java.util.ArrayList;

public class WildcardsDemo {

    // Unbounded wildcard: accepts a List of ANY type - use when you only need to READ generically
    static void printList(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Upper bounded wildcard: accepts List<Integer>, List<Double>, etc. - anything extending Number
    static double sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    // Lower bounded wildcard: accepts List<Integer> or any supertype of Integer (e.g. List<Number>)
    static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3);
        List<String> strings = List.of("a", "b", "c");

        printList(ints);
        printList(strings);

        System.out.println("Sum of ints: " + sumOfList(ints));
        System.out.println("Sum of doubles: " + sumOfList(List.of(1.5, 2.5, 3.0)));

        List<Number> numberList = new ArrayList<>();
        addNumbers(numberList); // works because Number is a supertype of Integer
        System.out.println("After addNumbers: " + numberList);
    }
}
