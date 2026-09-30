public class Recursion {

    // Factorial: n! = n * (n-1)!, with base case 0! = 1
    static long factorial(int n) {
        if (n <= 1) {
            return 1; // base case - stops the recursion
        }
        return n * factorial(n - 1); // recursive call
    }

    // Fibonacci: fib(n) = fib(n-1) + fib(n-2)
    static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Sum of digits using recursion
    static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        System.out.println("5! = " + factorial(5));

        System.out.print("First 10 Fibonacci numbers: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        System.out.println("Sum of digits of 12345 = " + sumOfDigits(12345));
    }
}
