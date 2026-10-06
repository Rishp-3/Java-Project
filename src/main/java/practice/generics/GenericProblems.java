package practice.generics;

import java.util.List;

/** Module 10 - Generics: generic classes, generic methods, bounded types, wildcards. */
public final class GenericProblems {
    private GenericProblems() {}

    /** Problem 1: a generic pair that can produce a swapped copy. */
    public record Pair<A, B>(A first, B second) {
        public Pair<B, A> swap() { return new Pair<>(second, first); }
    }

    /** Problem 2: bounded generic method - largest element of any list of Comparable things. */
    public static <T extends Comparable<? super T>> T maxOf(List<? extends T> items) {
        if (items.isEmpty()) throw new IllegalArgumentException("empty list");
        T best = items.get(0);
        for (T item : items) if (item.compareTo(best) > 0) best = item;
        return best;
    }

    /** Problem 3: upper-bounded wildcard (PECS: Producer Extends) - sum any list of numbers. */
    public static double sum(List<? extends Number> numbers) {
        double total = 0;
        for (Number n : numbers) total += n.doubleValue();
        return total;
    }

    /** Problem 4: lower-bounded wildcard (PECS: Consumer Super) - fill a list of Integer/Number/Object. */
    public static void fillWithRange(List<? super Integer> sink, int count) {
        for (int i = 1; i <= count; i++) sink.add(i);
    }

    /** Problem 5: a tiny generic stack with a type-safe API. */
    public static class Stack<T> {
        private final java.util.ArrayList<T> items = new java.util.ArrayList<>();

        public void push(T item) { items.add(item); }

        public T pop() {
            if (items.isEmpty()) throw new java.util.NoSuchElementException("stack is empty");
            return items.remove(items.size() - 1);
        }

        public boolean isEmpty() { return items.isEmpty(); }
        public int size() { return items.size(); }
    }
}
