package practice.exceptions;

import java.util.ArrayList;
import java.util.List;

/** Module 08 - Exception Handling: try/catch/finally, throw/throws, try-with-resources. */
public final class ExceptionProblems {
    private ExceptionProblems() {}

    /** Problem 2: parse an int, falling back to a default when the text is not a number. */
    public static int parseIntOrDefault(String text, int fallback) {
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException | NullPointerException e) {
            return fallback;
        }
    }

    /** Problem 3: validate input with an unchecked exception. */
    public static int requireAge(int age) {
        if (age < 0 || age > 150) throw new IllegalArgumentException("age out of range: " + age);
        return age;
    }

    /** Problem 4: finally always runs - this records the order in which things happen. */
    public static List<String> finallyOrder(boolean fail) {
        List<String> log = new ArrayList<>();
        try {
            log.add("try");
            if (fail) throw new IllegalStateException("boom");
            log.add("after-risk");
        } catch (IllegalStateException e) {
            log.add("catch");
        } finally {
            log.add("finally");
        }
        return log;
    }

    /** Problem 5: try-with-resources closes resources in REVERSE order of opening. */
    @SuppressWarnings("try") // a and b are deliberately never used - we only care about open/close order
    public static List<String> resourceCloseOrder() {
        List<String> log = new ArrayList<>();
        try (Res a = new Res("A", log); Res b = new Res("B", log)) {
            log.add("body");
        }
        return log;
    }

    private record Res(String name, List<String> log) implements AutoCloseable {
        Res {
            log.add("open " + name);
        }
        @Override public void close() { log.add("close " + name); }
    }

    /** Problem 6: wrap a low-level exception in a meaningful one, keeping the cause. */
    public static String firstWord(String text) {
        try {
            return text.trim().split("\\s+")[0];
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("text must not be null", e);
        }
    }
}
