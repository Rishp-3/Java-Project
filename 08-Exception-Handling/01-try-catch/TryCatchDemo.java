public class TryCatchDemo {
    public static void main(String[] args) {

        // try-catch: code that might fail goes in try, error handling goes in catch
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]); // this line throws an exception
            System.out.println("This line will never run.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        System.out.println("Program continues normally after the catch block.");

        // Another example: dividing by zero
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught arithmetic exception: " + e.getMessage());
        }

        // Parsing an invalid number
        try {
            int value = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Caught number format exception: " + e.getMessage());
        }
    }
}
