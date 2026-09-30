import java.util.*;

// A console-based Bank Management System: create accounts, deposit, withdraw, transfer, view history.
public class BankManagementSystem {

    static class Account {
        int accountNumber;
        String holderName;
        double balance;
        List<String> transactionHistory = new ArrayList<>();

        Account(int accountNumber, String holderName, double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
            transactionHistory.add("Account opened with balance " + balance);
        }
    }

    static Map<Integer, Account> accounts = new HashMap<>();
    static int nextAccountNumber = 1001;
    static Scanner sc = new Scanner(System.in);

    static void openAccount() {
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter initial deposit: ");
        double amount = Double.parseDouble(sc.nextLine());

        Account account = new Account(nextAccountNumber, name, amount);
        accounts.put(nextAccountNumber, account);
        System.out.println("Account created! Your account number is " + nextAccountNumber);
        nextAccountNumber++;
    }

    static Account findAccount() {
        System.out.print("Enter account number: ");
        int accNo = Integer.parseInt(sc.nextLine());
        Account account = accounts.get(accNo);
        if (account == null) {
            System.out.println("Account not found.");
        }
        return account;
    }

    static void deposit() {
        Account account = findAccount();
        if (account == null) return;
        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(sc.nextLine());
        if (amount <= 0) { System.out.println("Amount must be positive."); return; }
        account.balance += amount;
        account.transactionHistory.add("Deposited " + amount);
        System.out.println("New balance: " + account.balance);
    }

    static void withdraw() {
        Account account = findAccount();
        if (account == null) return;
        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(sc.nextLine());
        if (amount > account.balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        account.balance -= amount;
        account.transactionHistory.add("Withdrew " + amount);
        System.out.println("New balance: " + account.balance);
    }

    static void transfer() {
        System.out.print("Enter your account number: ");
        int fromNo = Integer.parseInt(sc.nextLine());
        Account from = accounts.get(fromNo);
        if (from == null) { System.out.println("Sender account not found."); return; }

        System.out.print("Enter recipient account number: ");
        int toNo = Integer.parseInt(sc.nextLine());
        Account to = accounts.get(toNo);
        if (to == null) { System.out.println("Recipient account not found."); return; }

        System.out.print("Enter amount to transfer: ");
        double amount = Double.parseDouble(sc.nextLine());

        if (amount > from.balance) {
            System.out.println("Insufficient balance.");
            return;
        }

        from.balance -= amount;
        to.balance += amount;
        from.transactionHistory.add("Transferred " + amount + " to account " + toNo);
        to.transactionHistory.add("Received " + amount + " from account " + fromNo);
        System.out.println("Transfer successful.");
    }

    static void viewHistory() {
        Account account = findAccount();
        if (account == null) return;
        System.out.println("Transaction history for " + account.holderName + ":");
        account.transactionHistory.forEach(t -> System.out.println("  " + t));
        System.out.println("Current balance: " + account.balance);
    }

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Bank Management System ===");
            System.out.println("1. Open Account\n2. Deposit\n3. Withdraw\n4. Transfer\n5. View History\n6. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> openAccount();
                case "2" -> deposit();
                case "3" -> withdraw();
                case "4" -> transfer();
                case "5" -> viewHistory();
                case "6" -> { running = false; System.out.println("Thank you for banking with us!"); }
                default -> System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
