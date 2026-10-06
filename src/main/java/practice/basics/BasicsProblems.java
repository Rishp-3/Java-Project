package practice.basics;

/** Module 01 - Java Basics: variables, operators, type casting. */
public final class BasicsProblems {
    private BasicsProblems() {}

    /** Problem 1: convert Celsius to Fahrenheit. */
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9.0 / 5.0 + 32;
    }

    /** Problem 2: leap year rule (divisible by 4, not by 100 unless also by 400). */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    /** Problem 3: simple interest = principal * rate% * years / 100. */
    public static double simpleInterest(double principal, double ratePercent, double years) {
        return principal * ratePercent * years / 100.0;
    }

    /** Problem 4: even check with a bitwise operator instead of %. */
    public static boolean isEvenBitwise(int n) {
        return (n & 1) == 0;
    }

    /** Problem 5: average of two ints without losing the fraction (watch integer division!). */
    public static double average(int a, int b) {
        return ((long) a + b) / 2.0;
    }
}
