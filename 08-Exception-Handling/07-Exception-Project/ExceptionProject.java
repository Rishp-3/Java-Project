import java.util.Scanner;

// Mini project: a simple ATM-style console app that puts try/catch/throw/throws/
// finally and a custom exception together in one realistic flow.
public class ExceptionProject {

    static class InsufficientBalanceException extends Exception {
        InsufficientBalanceException(String message) {
            super(message);
        }
    }

    static class ATM {
        private double balance;

        ATM(double balance) {
            this.balance = balance;
        }

        void withdraw(double amount) throws InsufficientBalanceException {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be positive.");
            }
            if (amount > balance) {
                throw new InsufficientBalanceException("Insufficient balance! Available: " + balance);
            }
            balance -= amount;
        }

        void deposit(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount must be positive.");
            }
            balance += amount;
        }

        double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM(5000);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Starting balance: " + atm.getBalance());

            try {
                atm.withdraw(2000);
                System.out.println("Withdrew 2000. Balance: " + atm.getBalance());

                atm.withdraw(10000); // triggers InsufficientBalanceException
            } catch (InsufficientBalanceException e) {
                System.out.println("Transaction failed: " + e.getMessage());
            }

            try {
                atm.deposit(-100); // triggers IllegalArgumentException
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid deposit: " + e.getMessage());
            }

            atm.deposit(1500);
            System.out.println("Final balance: " + atm.getBalance());

        } finally {
            sc.close();
            System.out.println("ATM session closed.");
        }
    }
}
