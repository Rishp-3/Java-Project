public class OneDimensional {
    public static void main(String[] args) {

        // Declaration + initialization
        int[] numbers = {10, 20, 30, 40, 50};

        // Accessing elements by index (0-based)
        System.out.println("First element: " + numbers[0]);
        System.out.println("Last element: " + numbers[numbers.length - 1]);

        // Modifying an element
        numbers[2] = 99;

        // Looping with a normal for loop
        System.out.print("Using for loop: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        // Looping with a for-each loop
        System.out.print("Using for-each loop: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Declaring an empty array of fixed size
        int[] scores = new int[5];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = i * 10;
        }
        System.out.println("Generated scores: " + java.util.Arrays.toString(scores));

        // Sum and average
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        System.out.println("Sum = " + sum + ", Average = " + (sum / (double) numbers.length));
    }
}
