public class FinallyDemo {

    static int divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Error: division by zero.");
            return -1;
        } finally {
            // finally ALWAYS runs, whether an exception occurred or not,
            // and even if the try/catch block returns a value.
            System.out.println("finally block executed for divide(" + a + ", " + b + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println("Result: " + divide(10, 2));
        System.out.println("Result: " + divide(10, 0));

        // finally is commonly used to release resources (files, connections, etc.)
        java.util.Scanner sc = null;
        try {
            sc = new java.util.Scanner(System.in);
            System.out.println("Resource opened.");
            // simulate some work that might throw
            throw new RuntimeException("Something went wrong!");
        } catch (RuntimeException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
                System.out.println("Resource closed in finally block.");
            }
        }
    }
}
