public class Parameters {

    // Multiple parameters
    static int add(int a, int b) {
        return a + b;
    }

    // Java is pass-by-value: changing a primitive parameter inside
    // the method does NOT change the caller's original variable.
    static void tryToDouble(int number) {
        number = number * 2;
        System.out.println("Inside method, number = " + number);
    }

    // Varargs - a method that accepts a variable number of arguments
    static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("add(3, 4) = " + add(3, 4));

        int value = 10;
        System.out.println("Before method call, value = " + value);
        tryToDouble(value);
        System.out.println("After method call, value = " + value); // still 10

        System.out.println("sum() = " + sum());
        System.out.println("sum(1, 2, 3) = " + sum(1, 2, 3));
        System.out.println("sum(1, 2, 3, 4, 5) = " + sum(1, 2, 3, 4, 5));
    }
}
