# Bank Management System

## 📌 Topic
Console project jisme accounts banana, deposit, withdraw aur transfer jaisi banking operations custom exceptions ke saath hoti hain.

## 🎯 What You Will Learn

- Abstraction aur inheritance (Savings/Current account)
- Custom exception
- `HashMap` se account lookup
- Transfer logic

## 💻 Code

```java
import java.util.*;

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String msg) { super(msg); }
}

abstract class Account {
    private final String accNo;
    private final String owner;
    protected double balance;

    Account(String accNo, String owner, double balance) {
        this.accNo = accNo;
        this.owner = owner;
        this.balance = balance;
    }

    String getAccNo() { return accNo; }
    double getBalance() { return balance; }

    void deposit(double amt) {
        if (amt <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amt;
    }

    abstract double minBalance();

    void withdraw(double amt) throws InsufficientFundsException {
        if (balance - amt < minBalance()) {
            throw new InsufficientFundsException("Insufficient funds in " + accNo);
        }
        balance -= amt;
    }

    public String toString() {
        return accNo + " (" + owner + ") : " + balance;
    }
}

class SavingsAccount extends Account {
    SavingsAccount(String no, String owner, double bal) { super(no, owner, bal); }
    double minBalance() { return 1000; }
}

class CurrentAccount extends Account {
    CurrentAccount(String no, String owner, double bal) { super(no, owner, bal); }
    double minBalance() { return -5000; }
}

class Bank {
    private final Map<String, Account> accounts = new LinkedHashMap<>();

    void open(Account a) { accounts.put(a.getAccNo(), a); }

    void transfer(String from, String to, double amt) throws InsufficientFundsException {
        Account a = accounts.get(from), b = accounts.get(to);
        a.withdraw(amt);
        b.deposit(amt);
        System.out.println("Transferred " + amt + " from " + from + " to " + to);
    }

    void show() { accounts.values().forEach(System.out::println); }
}

public class BankManagementSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.open(new SavingsAccount("S101", "Rishabh", 10000));
        bank.open(new CurrentAccount("C201", "Amit", 2000));

        try {
            bank.transfer("S101", "C201", 3000);
            bank.transfer("C201", "S101", 9000);
            bank.transfer("S101", "C201", 8000);
        } catch (InsufficientFundsException e) {
            System.out.println("Failed: " + e.getMessage());
        }
        bank.show();
    }
}
```

> 💡 Note: Is project me demo ke liye values code me hi di gayi hain taaki output hamesha same aaye. Project ko aage `Scanner` se menu-driven banana tumhara practice task hai.

## 🧠 Explanation

### `abstract class Account`
Common fields aur methods. `minBalance()` har type ke liye alag hai (polymorphism).

### `SavingsAccount / CurrentAccount`
Savings me kam se kam 1000 rakhna padta hai, Current me 5000 tak overdraft milta hai.

### `Bank.transfer()`
`withdraw()` fail ho to `deposit()` chalta hi nahi, isliye paisa kabhi galat nahi katta.

### `InsufficientFundsException`
Custom checked exception: caller ko handle karna hi padta hai.

## ▶️ Output

```text
Transferred 3000.0 from S101 to C201
Transferred 9000.0 from C201 to S101
Transferred 8000.0 from S101 to C201
S101 (Rishabh) : 8000.0
C201 (Amit) : 4000.0
```

## 🔑 Important Points

- Paise ke liye real project me `BigDecimal` use hota hai, `double` nahi (rounding errors).
- Transactions me atomicity zaroori hai (ya dono kaam, ya koi nahi).
- Transaction history (`List<String>`) rakhna aasan extension hai.

## 📝 Practice

1. Transaction history jodo.
2. Interest calculate karne ka method jodo.
3. Account number se `AccountNotFoundException` throw karo.
4. `BigDecimal` me convert karo.

## 🚀 Challenge

Bank me `closeAccount()` aur monthly statement print karne ka feature jodo.
