# Strategy Pattern in Java

## 📌 Topic
Strategy pattern me ek kaam karne ke alag-alag tarike (algorithms) alag classes me rakhte hain aur runtime par chunte hain ki kaun sa use karna hai.

## 🎯 What You Will Learn

- Strategy pattern kya hai
- Interface + multiple strategies
- Runtime par strategy badalna
- if-else chain se chhutkara

## 💻 Code

```java
interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " with Credit Card");
    }
}

class UpiPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " with UPI");
    }
}

class CashPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " in Cash");
    }
}

class ShoppingCart {
    private PaymentStrategy strategy;

    void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    void checkout(double amount) {
        strategy.pay(amount);
    }
}

public class Strategy {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setStrategy(new UpiPayment());
        cart.checkout(500);

        cart.setStrategy(new CreditCardPayment());
        cart.checkout(1200);

        cart.setStrategy(amount -> System.out.println("Paid " + amount + " with Wallet"));
        cart.checkout(300);
    }
}
```

## 🧠 Explanation

### `PaymentStrategy`
Common interface jisme algorithm ka contract hai.

### `ShoppingCart`
Context class: strategy hold karti hai aur kaam use de deti hai.

### `setStrategy()`
Runtime par strategy badal sakte ho.

### `Lambda strategy`
Strategy interface functional hai, isliye lambda se bhi strategy ban sakti hai.

## ▶️ Output

```text
Paid 500.0 with UPI
Paid 1200.0 with Credit Card
Paid 300.0 with Wallet
```

## 🔑 Important Points

- Strategy aur `if-else`/`switch` chain: strategy me naya tarika add karne par purana code nahi badalna padta.
- Java me example: `Comparator` ek strategy hi hai (sort ka tarika).
- Strategy aur Factory ko saath use karna common hai.

## 📝 Practice

1. Sorting strategy banao (bubble, quick) aur runtime par chuno.
2. Discount strategy banao (festival, student, none).
3. Strategy ko enum ke saath try karo.
4. Navigation: walking, driving, cycling strategies banao.

## 🚀 Challenge

`DiscountStrategy` banao: `NoDiscount`, `TenPercent`, `Flat500`. Cart total par apply karo.
