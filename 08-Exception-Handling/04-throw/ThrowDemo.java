public class ThrowDemo {

    static void validateAge(int age) {
        if (age < 18) {
            // 'throw' manually raises an exception when a business rule is violated
            throw new IllegalArgumentException("Age must be 18 or older. Got: " + age);
        }
        System.out.println("Age " + age + " is valid.");
    }

    static void withdraw(double balance, double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance for withdrawal.");
        }
        System.out.println("Withdrew " + amount + ", remaining balance: " + (balance - amount));
    }

    public static void main(String[] args) {
        try {
            validateAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        validateAge(20); // no exception

        try {
            withdraw(500, 1000);
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
