public class OverloadingDemo {

    // Compile-time (static) polymorphism: same method name, different parameter lists.
    // The compiler decides which method to call based on the arguments, at compile time.

    static void display(int a) {
        System.out.println("int: " + a);
    }

    static void display(double a) {
        System.out.println("double: " + a);
    }

    static void display(String a) {
        System.out.println("String: " + a);
    }

    static void display(int a, int b) {
        System.out.println("two ints: " + a + ", " + b);
    }

    public static void main(String[] args) {
        display(10);
        display(10.5);
        display("Hello");
        display(1, 2);
    }
}
