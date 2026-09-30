public class GenericMethodDemo {

    // A generic method - the <T> before the return type makes this method generic,
    // independent of whether the class itself is generic.
    static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    // Generic method with a bounded type - T must extend Comparable
    static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];
        for (T item : array) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    // Generic method with two type parameters
    static <K, V> void printPair(K key, V value) {
        System.out.println(key + " -> " + value);
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4};
        String[] words = {"apple", "banana", "cherry"};

        printArray(numbers);
        printArray(words);

        System.out.println("Max number: " + findMax(numbers));
        System.out.println("Max word (alphabetically): " + findMax(words));

        printPair("id", 101);
        printPair("active", true);
    }
}
