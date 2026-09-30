public class Encapsulation {

    // Encapsulation: keep fields private and expose controlled access via getters/setters
    static class BankAccount {
        private String owner;
        private double balance; // cannot be accessed directly from outside the class

        BankAccount(String owner, double balance) {
            this.owner = owner;
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Deposit amount must be positive.");
                return;
            }
            balance += amount;
        }

        public void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Insufficient funds!");
                return;
            }
            balance -= amount;
        }

        public String getOwner() {
            return owner;
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Rishabh", 1000);

        // account.balance = 999999; // not allowed - balance is private, this line would not compile

        account.deposit(500);
        System.out.println(account.getOwner() + "'s balance: " + account.getBalance());

        account.withdraw(2000); // rejected - not enough funds
        account.withdraw(300);
        System.out.println("Balance after withdrawal: " + account.getBalance());
    }
}
