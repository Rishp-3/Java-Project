# Exception Handling Mini Project

## 📌 Topic
Is mini project me ATM jaisa withdraw system banaya hai jisme invalid input, low balance aur daily limit teeno custom exceptions se handle hote hain.

## 🎯 What You Will Learn

- Custom exceptions ka real use
- Multiple catch aur finally ko saath use karna
- Clean error messages dena

## 💻 Code

```java
class InvalidAmountException extends RuntimeException {
    InvalidAmountException(String msg) { super(msg); }
}

class InsufficientFundsException extends Exception {
    InsufficientFundsException(String msg) { super(msg); }
}

class LimitExceededException extends Exception {
    LimitExceededException(String msg) { super(msg); }
}

class ATM {
    private double balance = 10000;
    private final double limit = 5000;

    void withdraw(double amount) throws InsufficientFundsException, LimitExceededException {
        if (amount <= 0) throw new InvalidAmountException("Amount must be positive");
        if (amount > limit) throw new LimitExceededException("Limit per transaction is " + limit);
        if (amount > balance) throw new InsufficientFundsException("Balance is " + balance);
        balance -= amount;
        System.out.println("Please collect cash: " + amount + " | Balance: " + balance);
    }
}

public class ExceptionProject {
    public static void main(String[] args) {
        ATM atm = new ATM();
        double[] requests = {2000, -50, 7000, 4000, 4000};

        for (double r : requests) {
            try {
                atm.withdraw(r);
            } catch (InvalidAmountException | LimitExceededException e) {
                System.out.println("Rejected: " + e.getMessage());
            } catch (InsufficientFundsException e) {
                System.out.println("Failed: " + e.getMessage());
            } finally {
                System.out.println("-- transaction over --");
            }
        }
    }
}
```

## 🧠 Explanation

### `Custom exceptions`
Har business rule ke liye alag exception hai, isse error ka reason clear rehta hai.

### `Multi-catch`
Do exceptions ka same handling ek hi block me ho gaya.

### `finally`
Har transaction ke baad ek message print hota hai, chahe success ho ya fail.

## ▶️ Output

```text
Please collect cash: 2000.0 | Balance: 8000.0
-- transaction over --
Rejected: Amount must be positive
-- transaction over --
Rejected: Limit per transaction is 5000.0
-- transaction over --
Please collect cash: 4000.0 | Balance: 4000.0
-- transaction over --
Please collect cash: 4000.0 | Balance: 0.0
-- transaction over --
```

## 🔑 Important Points

- Exceptions control flow ke liye nahi, asaadharan situations ke liye use karo.
- User ko technical stack trace nahi, saaf message dikhao.
- Cleanup code (`finally`) hamesha rakho jahan resource close karna ho.

## 📝 Practice

1. `InvalidPinException` jodo.
2. Transaction history `ArrayList` me store karo.
3. User se input lo (`Scanner`) aur loop me chalao.
4. Log file me errors likho.

## 🚀 Challenge

Project me `deposit()` method aur `InvalidAmountException` jodo, aur menu-driven bana do.
