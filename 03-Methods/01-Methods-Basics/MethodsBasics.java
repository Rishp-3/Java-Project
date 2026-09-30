public class MethodsBasics {

    // A method with no parameters and no return value
    static void greet() {
        System.out.println("Hello! Welcome to Java methods.");
    }

    // A method that takes a parameter but returns nothing
    static void greetByName(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // A method that returns a value
    static int square(int number) {
        return number * number;
    }

    public static void main(String[] args) {
        greet();
        greetByName("Rishabh");

        int result = square(5);
        System.out.println("Square of 5 = " + result);

        // Methods can be called as many times as needed
        System.out.println("Square of 9 = " + square(9));
    }
}
