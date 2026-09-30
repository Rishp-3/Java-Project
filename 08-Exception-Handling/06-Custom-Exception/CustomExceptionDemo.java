public class CustomExceptionDemo {

    // A custom checked exception - extends Exception
    static class InsufficientFundsException extends Exception {
        InsufficientFundsException(String message) {
            super(message);
        }
    }

    // A custom unchecked exception - extends RuntimeException
    static class InvalidAmountException extends RuntimeException {
        InvalidAmountException(String message) {
            super(message);
        }
    }

    static class Account {
        double balance;

        Account(double balance) {
            this.balance = balance;
        }

        void withdraw(double amount) throws InsufficientFundsException {
            if (amount <= 0) {
                throw new InvalidAmountException("Withdrawal amount must be positive.");
            }
            if (amount > balance) {
                throw new InsufficientFundsException(
                    "Cannot withdraw " + amount + ", balance is only " + balance);
            }
            balance -= amount;
            System.out.println("Withdrew " + amount + ". New balance: " + balance);
        }
    }

    public static void main(String[] args) {
        Account account = new Account(1000);

        try {
            account.withdraw(500);
            account.withdraw(800); // throws InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Custom checked exception caught: " + e.getMessage());
        }

        try {
            account.withdraw(-50); // throws InvalidAmountException
        } catch (InvalidAmountException e) {
            System.out.println("Custom unchecked exception caught: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Unexpected: " + e.getMessage());
        }
    }
}
