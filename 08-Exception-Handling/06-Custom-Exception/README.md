# Custom Exception in Java

## 📌 Topic
Jab built-in exceptions kaafi na hon, hum apni khud ki exception class bana sakte hain jo business rules ko represent kare.

## 🎯 What You Will Learn

- Custom exception class banana
- `Exception` ya `RuntimeException` extend karna
- Custom exception throw aur catch karna

## 💻 Code

```java
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class Account {
    private double balance;

    Account(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Balance is only " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }
}

public class CustomException {
    public static void main(String[] args) {
        Account acc = new Account(1000);
        try {
            acc.withdraw(400);
            acc.withdraw(900);
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

## 🧠 Explanation

### `extends Exception`
Checked custom exception banata hai. Handle karna compulsory hota hai.

### `extends RuntimeException`
Unchecked custom exception banata hai. `throws` likhna zaroori nahi.

### `super(message)`
Message parent class tak pahunchata hai, taaki `getMessage()` use kar sake.

## ▶️ Output

```text
Withdrawn: 400.0
Error: Balance is only 600.0
```

## 🔑 Important Points

- Naam ke end me `Exception` lagao: `InvalidAgeException`.
- Business rule todne par custom exception banao.
- Constructor me message pass karna achhi practice hai.
- Checked ya unchecked ka decision sochke lo.

## 📝 Practice

1. `InvalidAgeException` banao (age < 18).
2. `UserNotFoundException` ko `RuntimeException` se banao.
3. Custom exception me extra field (error code) jodo.
4. Custom exception ko chain karo (`cause` ke saath).

## 🚀 Challenge

`InvalidMarksException` banao aur marks 0-100 ke bahar hone par throw karo.
