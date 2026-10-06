package practice.oop;

/** Problem 2: encapsulation - the balance can only change through validated methods. */
public class BankAccount {
    private final String owner;
    private double balance;

    public BankAccount(String owner, double openingBalance) {
        if (owner == null || owner.isBlank()) throw new IllegalArgumentException("owner required");
        if (openingBalance < 0) throw new IllegalArgumentException("opening balance cannot be negative");
        this.owner = owner;
        this.balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("deposit must be positive");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("withdrawal must be positive");
        if (amount > balance) throw new IllegalStateException("insufficient funds");
        balance -= amount;
    }

    public String getOwner() { return owner; }
    public double getBalance() { return balance; }
}
