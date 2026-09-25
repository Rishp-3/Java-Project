import java.util.Scanner;

public class Switch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== MENU =====");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Addition selected");
                break;

            case 2:
                System.out.println("Subtraction selected");
                break;

            case 3:
                System.out.println("Multiplication selected");
                break;

            case 4:
                System.out.println("Division selected");
                break;

            case 5:
                System.out.println("Goodbye!");
                break;

            default:
                System.out.println("Invalid choice");
        }

        sc.close();
    }
}
