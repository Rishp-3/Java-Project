package practice.controlflow;

import java.util.ArrayList;
import java.util.List;

/** Module 02 - Control Flow: if/else, switch, loops. */
public final class ControlFlowProblems {
    private ControlFlowProblems() {}

    /** Problem 1: FizzBuzz from 1..n. */
    public static List<String> fizzBuzz(int n) {
        List<String> out = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) out.add("FizzBuzz");
            else if (i % 3 == 0) out.add("Fizz");
            else if (i % 5 == 0) out.add("Buzz");
            else out.add(String.valueOf(i));
        }
        return out;
    }

    /** Problem 2: primality test (trial division up to sqrt). */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /** Problem 3: letter grade for a 0-100 mark (switch on tens digit). */
    public static char gradeFor(int marks) {
        if (marks < 0 || marks > 100) throw new IllegalArgumentException("marks must be 0..100");
        return switch (marks / 10) {
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            default -> 'F';
        };
    }

    /** Problem 4: number of Collatz steps needed to reach 1. */
    public static int collatzSteps(int n) {
        if (n < 1) throw new IllegalArgumentException("n must be >= 1");
        long x = n;
        int steps = 0;
        while (x != 1) {
            x = (x % 2 == 0) ? x / 2 : 3 * x + 1;
            steps++;
        }
        return steps;
    }

    /** Problem 5: first n rows of a right-aligned star triangle. */
    public static List<String> starTriangle(int n) {
        List<String> rows = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            rows.add(" ".repeat(n - i) + "*".repeat(i));
        }
        return rows;
    }
}
