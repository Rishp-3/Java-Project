import java.util.Scanner;

public class ForLoop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        System.out.println("\nNumbers from 1 to " + number + ":");

        for (int i = 1; i <= number; i++) {
            System.out.println(i);
        }

        System.out.println("\nEven numbers:");

        for (int i = 2; i <= number; i += 2) {
            System.out.println(i);
        }

        System.out.println("\nMultiplication Table:");

        for (int i = 1; i <= 10; i++) {
            System.out.println(
                number + " x " + i + " = " + (number * i)
            );
        }

        sc.close();
    }
}
