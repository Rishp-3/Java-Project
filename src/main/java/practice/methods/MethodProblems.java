package practice.methods;

/** Module 03 - Methods: parameters, return types, overloading, recursion. */
public final class MethodProblems {
    private MethodProblems() {}

    /** Problem 1: factorial using recursion. */
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n > 20) throw new ArithmeticException("overflow: " + n + "! does not fit in a long");
        return n <= 1 ? 1 : n * factorial(n - 1);
    }

    /** Problem 2: greatest common divisor (Euclid, recursive). */
    public static int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    /** Problem 3: n-th Fibonacci number (iterative), fib(0)=0, fib(1)=1. */
    public static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            long next = a + b;
            a = b;
            b = next;
        }
        return a;
    }

    /** Problem 4: sum of the digits of a number, using recursion. */
    public static int digitSum(int n) {
        n = Math.abs(n);
        return n < 10 ? n : (n % 10) + digitSum(n / 10);
    }

    // Problem 5: method overloading - three different max() methods.
    public static int max(int a, int b) { return Math.max(a, b); }
    public static int max(int a, int b, int c) { return max(max(a, b), c); }
    public static double max(double a, double b) { return a >= b ? a : b; }

    /** Problem 6: variable arguments - sum of any number of ints. */
    public static int sum(int... values) {
        int total = 0;
        for (int v : values) total += v;
        return total;
    }
}
