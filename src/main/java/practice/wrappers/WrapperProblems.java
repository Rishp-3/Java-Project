package practice.wrappers;

import java.util.List;

/** Module 11 - Wrapper Classes: autoboxing, unboxing and the traps around them. */
public final class WrapperProblems {
    private WrapperProblems() {}

    /** Problem 1: sum a list that may contain nulls (unboxing null throws NullPointerException!). */
    public static int sumIgnoringNulls(List<Integer> values) {
        int total = 0;
        for (Integer v : values) {
            if (v != null) total += v;
        }
        return total;
    }

    /** Problem 2: safe unboxing with a default. */
    public static int orDefault(Integer value, int fallback) {
        return value != null ? value : fallback;
    }

    /** Problem 3: compare boxed values by VALUE. (== compares references and only "works" for -128..127.) */
    public static boolean sameValue(Integer a, Integer b) {
        return a == null ? b == null : a.equals(b);
    }

    /** Problem 4: parse a hex string such as "ff" or "-1A" into an int. */
    public static int parseHex(String hex) {
        return Integer.parseInt(hex.trim(), 16);
    }

    /** Problem 5: the largest int plus one overflows silently - detect it with the Math.*Exact methods. */
    public static boolean addOverflows(int a, int b) {
        try {
            Math.addExact(a, b);
            return false;
        } catch (ArithmeticException e) {
            return true;
        }
    }

    /** Problem 6: binary text for an int via the wrapper class helpers. */
    public static String toBinary(int n) {
        return Integer.toBinaryString(n);
    }
}
