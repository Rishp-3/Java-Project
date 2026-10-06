package practice.patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/** Module 25 - Design Patterns: Singleton, Factory, Builder, Observer, Strategy (small, testable versions). */
public final class DesignPatterns {
    private DesignPatterns() {}

    // ---- Problem 1: Singleton (enum-based: thread-safe and serialisation-safe by design) ----
    public enum AppConfig {
        INSTANCE;
        private int counter;
        public synchronized int nextId() { return ++counter; }
    }

    // ---- Problem 2: Factory - callers ask for a kind of notifier by name, never call 'new' themselves ----
    public interface Notifier { String send(String message); }

    public static Notifier notifier(String kind) {
        return switch (kind.toLowerCase()) {
            case "email" -> msg -> "EMAIL: " + msg;
            case "sms" -> msg -> "SMS: " + msg;
            case "push" -> msg -> "PUSH: " + msg;
            default -> throw new IllegalArgumentException("unknown notifier: " + kind);
        };
    }

    // ---- Problem 3: Builder - readable construction of an object with many optional parts ----
    public static final class Pizza {
        private final String size;
        private final List<String> toppings;
        private final boolean extraCheese;

        private Pizza(Builder b) {
            this.size = b.size;
            this.toppings = List.copyOf(b.toppings);
            this.extraCheese = b.extraCheese;
        }

        public String size() { return size; }
        public List<String> toppings() { return toppings; }
        public boolean extraCheese() { return extraCheese; }

        public static Builder builder(String size) { return new Builder(size); }

        public static final class Builder {
            private final String size;
            private final List<String> toppings = new ArrayList<>();
            private boolean extraCheese;

            private Builder(String size) {
                if (size == null || size.isBlank()) throw new IllegalArgumentException("size required");
                this.size = size;
            }

            public Builder topping(String t) { toppings.add(t); return this; }
            public Builder extraCheese() { this.extraCheese = true; return this; }
            public Pizza build() { return new Pizza(this); }
        }
    }

    // ---- Problem 4: Observer - subscribers are notified whenever a value is published ----
    public static class EventBus<T> {
        private final List<Consumer<T>> subscribers = new ArrayList<>();

        /** Returns a Runnable that unsubscribes this listener. */
        public Runnable subscribe(Consumer<T> listener) {
            subscribers.add(listener);
            return () -> subscribers.remove(listener);
        }

        public void publish(T event) {
            for (Consumer<T> s : List.copyOf(subscribers)) s.accept(event);
        }

        public int subscriberCount() { return subscribers.size(); }
    }

    // ---- Problem 5: Strategy - swap the pricing algorithm without touching the cart ----
    public interface DiscountStrategy { double apply(double total); }

    public static final DiscountStrategy NO_DISCOUNT = total -> total;
    public static DiscountStrategy percentOff(double percent) { return total -> total * (1 - percent / 100.0); }
    public static DiscountStrategy flatOff(double amount) { return total -> Math.max(0, total - amount); }

    public static double checkout(double total, DiscountStrategy strategy) {
        return strategy.apply(total);
    }
}
