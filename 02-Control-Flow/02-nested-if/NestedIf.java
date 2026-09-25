import java.util.Scanner;

public class NestedIf {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        if (age >= 18) {

            System.out.print("Are you a citizen? (true/false): ");
            boolean citizen = sc.nextBoolean();

            if (citizen) {

                System.out.print("Do you have valid ID? (true/false): ");
                boolean hasId = sc.nextBoolean();

                if (hasId) {
                    System.out.println("You are eligible.");
                } else {
                    System.out.println("Valid ID required.");
                }

            } else {
                System.out.println("Citizenship requirement not met.");
            }

        } else {
            System.out.println("You are underage.");
        }

        sc.close();
    }
}
