package practice.functional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/** Module 19 - Functional Programming: Predicate, Function, Consumer, Supplier and composition. */
public final class FunctionalProblems {
    private FunctionalProblems() {}

    /** Problem 1: keep only the items matching ALL of the predicates. */
    @SafeVarargs
    public static <T> List<T> filterAll(List<T> items, Predicate<T>... rules) {
        Predicate<T> combined = x -> true;
        for (Predicate<T> r : rules) combined = combined.and(r);
        return items.stream().filter(combined).toList();
    }

    /** Problem 2: build one function out of a chain of functions (applied left to right). */
    public static <T> Function<T, T> pipeline(List<Function<T, T>> steps) {
        Function<T, T> result = Function.identity();
        for (Function<T, T> s : steps) result = result.andThen(s);
        return result;
    }

    /** Problem 3: memoize - cache results so an expensive function runs once per input. */
    public static <K, V> Function<K, V> memoize(Function<K, V> fn) {
        Map<K, V> cache = new HashMap<>();
        return key -> cache.computeIfAbsent(key, fn);
    }

    /** Problem 4: lazy value - the Supplier runs only on first get(), then is reused. */
    public static <T> Supplier<T> lazy(Supplier<T> source) {
        return new Supplier<>() {
            private T value;
            private boolean ready;
            @Override public T get() {
                if (!ready) { value = source.get(); ready = true; }
                return value;
            }
        };
    }

    /** Problem 5: currying - turn a two-argument function into a chain of one-argument functions. */
    public static <A, B, R> Function<A, Function<B, R>> curry(BiFunction<A, B, R> f) {
        return a -> b -> f.apply(a, b);
    }

    /** Problem 6: run a Consumer for each element, then a final Consumer on the count. */
    public static <T> void forEachThen(List<T> items, Consumer<T> each, Consumer<Integer> afterCount) {
        items.forEach(each);
        afterCount.accept(items.size());
    }
}
