public class Operators {
    public static void main(String[] args) {

        int a = 10;
        int b = 3;

        // Arithmetic
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Remainder: " + (a % b));

        // Relational
        System.out.println("a == b: " + (a == b));
        System.out.println("a > b: " + (a > b));

        // Logical
        System.out.println("AND: " + (a > 5 && b < 5));
        System.out.println("OR: " + (a > 20 || b < 5));

        // Ternary
        String result = a > b ? "a is greater" : "b is greater";
        System.out.println(result);
    }
}
