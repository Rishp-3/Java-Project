package practice.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/** Module 17 - Lambda: lambda syntax, functional interfaces, method references, closures. */
public final class LambdaProblems {
    private LambdaProblems() {}

    /** A custom functional interface (exactly one abstract method). */
    @FunctionalInterface
    public interface Validator<T> {
        boolean isValid(T value);
        default Validator<T> and(Validator<T> other) { return v -> isValid(v) && other.isValid(v); }
    }

    /** Problem 1: apply a function twice. */
    public static int applyTwice(IntUnaryOperator f, int x) {
        return f.applyAsInt(f.applyAsInt(x));
    }

    /** Problem 2: sort by length, then alphabetically (Comparator chaining). */
    public static List<String> sortByLengthThenAlpha(List<String> words) {
        List<String> copy = new ArrayList<>(words);
        copy.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        return copy;
    }

    /** Problem 3: closures - return a function that remembers 'amount'. */
    public static IntUnaryOperator makeAdder(int amount) {
        return x -> x + amount;
    }

    /** Problem 4: fold a list with any binary operator. */
    public static int reduce(List<Integer> values, int identity, IntBinaryOperator op) {
        int acc = identity;
        for (int v : values) acc = op.applyAsInt(acc, v);
        return acc;
    }

    /** Problem 5: a Validator built from lambdas and combined with and(). */
    public static Validator<String> usernameRules() {
        Validator<String> longEnough = s -> s.length() >= 3;
        Validator<String> lettersOnly = s -> s.chars().allMatch(Character::isLetter);
        return longEnough.and(lettersOnly);
    }

    /** Problem 6: method references - convert strings with String::trim then String::length. */
    public static List<Integer> trimmedLengths(List<String> raw) {
        Function<String, String> trim = String::trim;
        return raw.stream().map(trim.andThen(String::length)).toList();
    }
}
