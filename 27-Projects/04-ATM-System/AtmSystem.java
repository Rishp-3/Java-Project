import java.util.Scanner;

// A console-based ATM simulation: PIN authentication, balance check, deposit, withdraw.
public class AtmSystem {

    static double balance = 5000.0;
    static final String CORRECT_PIN = "1234";
    static Scanner sc = new Scanner(System.in);

    static boolean authenticate() {
        System.out.print("Enter your 4-digit PIN: ");
        String pin = sc.nextLine().trim();
        if (!pin.equals(CORRECT_PIN)) {
            System.out.println("Incorrect PIN.");
            return false;
        }
        return true;
    }

    static void checkBalance() {
        System.out.println("Your current balance: " + balance);
    }

    static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(sc.nextLine());
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(sc.nextLine());
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }
        if (amount % 100 != 0) {
            System.out.println("Please withdraw in multiples of 100.");
            return;
        }
        balance -= amount;
        System.out.println("Please collect your cash. New balance: " + balance);
    }

    public static void main(String[] args) {
        System.out.println("=== Welcome to the ATM ===");

        int attempts = 3;
        boolean authenticated = false;
        while (attempts > 0 && !authenticated) {
            authenticated = authenticate();
            if (!authenticated) {
                attempts--;
                System.out.println("Attempts remaining: " + attempts);
            }
        }

        if (!authenticated) {
            System.out.println("Too many failed attempts. Card blocked.");
            sc.close();
            return;
        }

        System.out.println("Authentication successful!");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> checkBalance();
                case "2" -> deposit();
                case "3" -> withdraw();
                case "4" -> { running = false; System.out.println("Thank you for using the ATM. Goodbye!"); }
                default -> System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
