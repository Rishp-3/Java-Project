package practice.exceptions;

public class Wallet {
    private double balance;

    public Wallet(double balance) { this.balance = balance; }

    public void spend(double amount) throws InsufficientBalanceException {
        if (amount > balance) throw new InsufficientBalanceException(amount - balance);
        balance -= amount;
    }

    public double getBalance() { return balance; }
}
