import java.util.ArrayList;
import java.util.List;

public class PolymorphismRealWorld {

    // A payment processing system - a real-world use of polymorphism.
    interface PaymentMethod {
        void pay(double amount);
    }

    static class CreditCardPayment implements PaymentMethod {
        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Credit Card.");
        }
    }

    static class UpiPayment implements PaymentMethod {
        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " using UPI.");
        }
    }

    static class CashPayment implements PaymentMethod {
        @Override
        public void pay(double amount) {
            System.out.println("Paid ₹" + amount + " in cash.");
        }
    }

    // This method doesn't care WHICH payment method it gets -
    // it just calls pay(). This is the power of polymorphism.
    static void checkout(PaymentMethod method, double amount) {
        method.pay(amount);
    }

    public static void main(String[] args) {
        List<PaymentMethod> methods = new ArrayList<>();
        methods.add(new CreditCardPayment());
        methods.add(new UpiPayment());
        methods.add(new CashPayment());

        double amount = 1500.0;
        for (PaymentMethod method : methods) {
            checkout(method, amount);
        }
    }
}
