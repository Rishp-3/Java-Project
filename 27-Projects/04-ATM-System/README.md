# ATM System

## 📌 Topic
ATM machine ka simulation jisme PIN verification, balance check, withdraw aur 3 galat PIN par card block hota hai.

## 🎯 What You Will Learn

- State management (blocked, balance)
- PIN attempts limit
- Custom exceptions
- Cash denominations

## 💻 Code

```java
class InvalidPinException extends Exception {
    InvalidPinException(String msg) { super(msg); }
}

class CardBlockedException extends RuntimeException {
    CardBlockedException(String msg) { super(msg); }
}

class ATM {
    private final int pin = 4321;
    private double balance = 15000;
    private int attempts = 0;
    private boolean blocked = false;

    void verifyPin(int entered) throws InvalidPinException {
        if (blocked) throw new CardBlockedException("Card is blocked. Contact bank.");
        if (entered != pin) {
            attempts++;
            if (attempts == 3) {
                blocked = true;
                throw new CardBlockedException("3 wrong attempts. Card blocked.");
            }
            throw new InvalidPinException("Wrong PIN. Attempts left: " + (3 - attempts));
        }
        attempts = 0;
        System.out.println("PIN verified");
    }

    void withdraw(int amount) {
        if (amount % 100 != 0) {
            System.out.println("Enter amount in multiples of 100");
        } else if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            int notes500 = amount / 500;
            int notes100 = (amount % 500) / 100;
            System.out.println("Dispensed " + amount + " (500 x " + notes500 + ", 100 x " + notes100 + ")");
        }
    }

    void checkBalance() {
        System.out.println("Balance: " + balance);
    }
}

public class AtmSystem {
    public static void main(String[] args) {
        ATM atm = new ATM();
        int[] tries = {1111, 4321};

        for (int p : tries) {
            try {
                atm.verifyPin(p);
            } catch (InvalidPinException e) {
                System.out.println(e.getMessage());
            }
        }

        atm.checkBalance();
        atm.withdraw(2300);
        atm.withdraw(2750);
        atm.withdraw(50000);
        atm.checkBalance();

        ATM atm2 = new ATM();
        try {
            for (int p : new int[]{1, 2, 3, 4321}) {
                try {
                    atm2.verifyPin(p);
                } catch (InvalidPinException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (CardBlockedException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

> 💡 Note: Is project me demo ke liye values code me hi di gayi hain taaki output hamesha same aaye. Project ko aage `Scanner` se menu-driven banana tumhara practice task hai.

## 🧠 Explanation

### `verifyPin()`
Galat PIN par attempts badhte hain. 3rd galat attempt par card block ho jata hai.

### `withdraw()`
Amount 100 ke multiple me hona chahiye. Notes 500 aur 100 me tod ke dikhaye gaye hain.

### `CardBlockedException`
Unchecked exception. Card block hone ke baad sahi PIN dene par bhi nahi chalta.

## ▶️ Output

```text
Wrong PIN. Attempts left: 2
PIN verified
Balance: 15000.0
Dispensed 2300 (500 x 4, 100 x 3)
Enter amount in multiples of 100
Insufficient balance
Balance: 12700.0
Wrong PIN. Attempts left: 2
Wrong PIN. Attempts left: 1
3 wrong attempts. Card blocked.
```

## 🔑 Important Points

- Real ATM me PIN hash karke store hota hai, plain number nahi.
- State ko object ke andar private rakho (`blocked`, `attempts`).
- Daily limit aur mini statement natural extensions hain.

## 📝 Practice

1. Daily withdrawal limit jodo.
2. Mini statement (last 5 transactions) jodo.
3. PIN change ka option jodo.
4. Deposit option jodo.

## 🚀 Challenge

ATM me denominations 2000, 500, 200, 100 ke notes ka greedy breakdown banao.
