public class StrategyPatternDemo {

    // Strategy: define a family of interchangeable algorithms and let the
    // client pick one at runtime, without changing the code that uses it.
    interface PaymentStrategy {
        void pay(double amount);
    }

    static class CreditCardStrategy implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using Credit Card.");
        }
    }

    static class UpiStrategy implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using UPI.");
        }
    }

    static class PayPalStrategy implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using PayPal.");
        }
    }

    static class ShoppingCart {
        private PaymentStrategy strategy;

        void setPaymentStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        void checkout(double amount) {
            if (strategy == null) {
                throw new IllegalStateException("No payment strategy selected.");
            }
            strategy.pay(amount);
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardStrategy());
        cart.checkout(1500);

        // Switch strategy at runtime, without changing ShoppingCart's code
        cart.setPaymentStrategy(new UpiStrategy());
        cart.checkout(750);

        cart.setPaymentStrategy(new PayPalStrategy());
        cart.checkout(2200);
    }
}
