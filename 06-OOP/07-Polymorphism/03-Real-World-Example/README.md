# Polymorphism Real World Example

## 📌 Topic
Real project me polymorphism se ek hi code alag-alag objects par kaam karta hai. Yahan payment system ka example hai.

## 🎯 What You Will Learn

- Polymorphism ka practical use
- Parent reference se kai child objects handle karna
- Naya type add karne par purana code na badalna

## 💻 Code

```java
abstract class Payment {
    abstract void pay(double amount);
}

class CreditCard extends Payment {
    void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UPI extends Payment {
    void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class Cash extends Payment {
    void pay(double amount) {
        System.out.println("Paid " + amount + " in Cash");
    }
}

public class RealWorldExample {

    static void checkout(Payment method, double amount) {
        method.pay(amount);
    }

    public static void main(String[] args) {
        checkout(new CreditCard(), 1500);
        checkout(new UPI(), 300.50);
        checkout(new Cash(), 99);
    }
}
```

## 🧠 Explanation

### `abstract class Payment`
Common type jisme `pay()` ka rule diya gaya hai.

### `checkout(Payment method, ...)`
Ye method nahi jaanta ki kaun sa payment type aayega, bas `pay()` call karta hai.

### `Naya type`
Kal `NetBanking` add karna ho to sirf nayi class banao, `checkout()` me koi change nahi.

## ▶️ Output

```text
Paid 1500.0 using Credit Card
Paid 300.5 using UPI
Paid 99.0 in Cash
```

## 🔑 Important Points

- Is design ko Open/Closed Principle kehte hain: extend karo, modify nahi.
- Interface ya abstract class ke saath polymorphism sabse achha kaam karta hai.
- `if-else` chains ki jagah polymorphism code ko clean banata hai.

## 📝 Practice

1. `NetBanking` payment type add karo.
2. `Notification` -> `Email`, `SMS`, `WhatsApp` banao.
3. `Shape` array banake sabka area print karo.
4. `instanceof` ka use try karo.

## 🚀 Challenge

`Vehicle` -> `Car`, `Bike`, `Truck` banao jisme `fuelCost(int km)` override ho aur ek array me sabki cost print karo.
