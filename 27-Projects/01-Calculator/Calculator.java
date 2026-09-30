import java.util.Scanner;

// A simple console calculator supporting the four basic operations, in a loop.
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Simple Calculator ===");

        while (running) {
            System.out.println("\n1. Add  2. Subtract  3. Multiply  4. Divide  5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            if (choice == 5) {
                running = false;
                System.out.println("Goodbye!");
                continue;
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Invalid option, try again.");
                continue;
            }

            double a, b;
            try {
                System.out.print("Enter first number: ");
                a = Double.parseDouble(sc.nextLine().trim());
                System.out.print("Enter second number: ");
                b = Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid numbers.");
                continue;
            }

            double result;
            switch (choice) {
                case 1 -> result = a + b;
                case 2 -> result = a - b;
                case 3 -> result = a * b;
                case 4 -> {
                    if (b == 0) {
                        System.out.println("Error: cannot divide by zero.");
                        continue;
                    }
                    result = a / b;
                }
                default -> result = 0;
            }

            System.out.println("Result: " + result);
        }

        sc.close();
    }
}
