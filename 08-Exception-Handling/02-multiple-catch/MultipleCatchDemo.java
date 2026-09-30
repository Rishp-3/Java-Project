public class MultipleCatchDemo {
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30};

        for (int i = 0; i <= 3; i++) {
            try {
                System.out.println("100 / " + numbers[i] + " = " + (100 / numbers[i]));
            } catch (ArrayIndexOutOfBoundsException e) {
                // handle out-of-bounds specifically
                System.out.println("Index " + i + " is out of bounds.");
            } catch (ArithmeticException e) {
                // handle divide-by-zero specifically
                System.out.println("Cannot divide by zero at index " + i);
            }
        }

        // Multi-catch: handle two exception types with one block using '|'
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException | ArithmeticException e) {
            System.out.println("Caught either NPE or Arithmetic: " + e.getClass().getSimpleName());
        }

        // A general catch(Exception e) can catch anything - keep specific catches first
        try {
            Object obj = "text";
            Integer number = (Integer) obj; // throws ClassCastException
        } catch (ClassCastException e) {
            System.out.println("Caught class cast exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Caught general exception: " + e);
        }
    }
}
