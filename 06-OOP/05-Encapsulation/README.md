# Encapsulation in Java

## 📌 Topic
Encapsulation me data (fields) ko `private` karke use methods (getters/setters) ke through access karwate hain. Isse data safe rehta hai.

## 🎯 What You Will Learn

- Encapsulation kya hai
- `private` fields aur `public` getters/setters
- Setter me validation lagana
- Data hiding ke fayde

## 💻 Code

```java
class BankAccount {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.deposit(5000);
        acc.withdraw(2000);
        acc.withdraw(9000);
        acc.deposit(-10);
        System.out.println("Balance: " + acc.getBalance());
    }
}
```

## 🧠 Explanation

### `private double balance`
Bahar se seedha `acc.balance` access nahi ho sakta.

### `getBalance()`
Getter: value padhne ka controlled tarika.

### `deposit() / withdraw()`
Setter jaise methods: yahan validation lagake galat data rok sakte hain.

## ▶️ Output

```text
Insufficient balance
Invalid amount
Balance: 3000.0
```

## 🔑 Important Points

- Fields `private`, methods `public` rakhna standard practice hai.
- Getter/setter naming: `getName()`, `setName()`; boolean ke liye `isActive()`.
- Encapsulation se code maintain karna aur badalna aasan hota hai.
- Read-only class ke liye sirf getter do, setter nahi.

## 📝 Practice

1. `Student` class me `private` fields aur getters/setters banao.
2. `setAge()` me validation lagao (0 se 120).
3. Read-only `id` field banao.
4. Direct private field access karke compile error dekho.

## 🚀 Challenge

`Person` class banao jisme `age` negative set na ho sake. Galat age par message print ho.
