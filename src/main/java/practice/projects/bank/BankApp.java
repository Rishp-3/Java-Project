package practice.projects.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/** Console bank backed by an H2 file (./data/bank.mv.db): accounts and history persist between runs. */
public class BankApp {
    public static void main(String[] args) throws SQLException {
        String url = args.length > 0 ? args[0] : "jdbc:h2:file:./data/bank";
        try (Connection conn = DriverManager.getConnection(url, "sa", ""); Scanner in = new Scanner(System.in)) {
            run(new Bank(conn), in);
        }
    }

    static void run(Bank bank, Scanner in) throws SQLException {
        while (true) {
            System.out.println("\n=== Bank ===");
            System.out.println("1. Open account  2. Deposit  3. Withdraw  4. Transfer  5. Balance  6. History  7. Exit");
            System.out.print("Choose: ");
            if (!in.hasNextLine()) return;
            try {
                switch (in.nextLine().trim()) {
                    case "1" -> {
                        System.out.print("Holder name: "); String name = in.nextLine();
                        System.out.print("Initial deposit: "); double amt = Double.parseDouble(in.nextLine().trim());
                        System.out.println("Account created. Number: " + bank.openAccount(name, amt));
                    }
                    case "2" -> {
                        System.out.print("Account: "); int no = Integer.parseInt(in.nextLine().trim());
                        System.out.print("Amount: "); bank.deposit(no, Double.parseDouble(in.nextLine().trim()));
                        System.out.println("New balance: " + bank.balance(no));
                    }
                    case "3" -> {
                        System.out.print("Account: "); int no = Integer.parseInt(in.nextLine().trim());
                        System.out.print("Amount: "); bank.withdraw(no, Double.parseDouble(in.nextLine().trim()));
                        System.out.println("New balance: " + bank.balance(no));
                    }
                    case "4" -> {
                        System.out.print("From account: "); int from = Integer.parseInt(in.nextLine().trim());
                        System.out.print("To account: "); int to = Integer.parseInt(in.nextLine().trim());
                        System.out.print("Amount: "); bank.transfer(from, to, Double.parseDouble(in.nextLine().trim()));
                        System.out.println("Transfer complete.");
                    }
                    case "5" -> {
                        System.out.print("Account: ");
                        System.out.println("Balance: " + bank.balance(Integer.parseInt(in.nextLine().trim())));
                    }
                    case "6" -> {
                        System.out.print("Account: ");
                        bank.history(Integer.parseInt(in.nextLine().trim())).forEach(System.out::println);
                    }
                    case "7" -> { System.out.println("Bye!"); return; }
                    default -> System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (InsufficientFundsException | IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
