public class Main {
    public static void main(String[] args) {

        int number = 24;

        for (int i = 2; i <= number; i++) {

            if (number % i == 0) {
                System.out.println("First divisor: " + i);
                break;
            }
        }
    }
}
