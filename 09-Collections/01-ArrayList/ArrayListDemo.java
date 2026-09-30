import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {

        // ArrayList: a resizable array backed List implementation
        List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add(1, "Mango"); // insert at index 1

        System.out.println("List: " + fruits);
        System.out.println("Element at index 2: " + fruits.get(2));
        System.out.println("Size: " + fruits.size());
        System.out.println("Contains 'Cherry': " + fruits.contains("Cherry"));

        fruits.remove("Mango");       // remove by value
        fruits.remove(0);             // remove by index
        System.out.println("After removals: " + fruits);

        fruits.set(0, "Blueberry");   // update an element
        System.out.println("After set: " + fruits);

        System.out.print("Iterating: ");
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // Sorting
        List<Integer> numbers = new ArrayList<>(List.of(5, 2, 8, 1, 9));
        java.util.Collections.sort(numbers);
        System.out.println("Sorted numbers: " + numbers);

        // ArrayList grows automatically - no fixed size like a normal array
        System.out.println("isEmpty: " + fruits.isEmpty());
    }
}
