public class MethodOverloading {

    // Same method name "add", different parameter lists (compile-time polymorphism)

    static int add(int a, int b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    static double add(double a, double b) {
        return a + b;
    }

    static String add(String a, String b) {
        return a + b; // string concatenation
    }

    public static void main(String[] args) {
        System.out.println(add(2, 3));            // calls add(int, int)
        System.out.println(add(2, 3, 4));          // calls add(int, int, int)
        System.out.println(add(2.5, 3.5));         // calls add(double, double)
        System.out.println(add("Hello, ", "Java")); // calls add(String, String)
    }
}
