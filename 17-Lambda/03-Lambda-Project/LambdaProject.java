import java.util.*;
import java.util.function.*;

// Mini project: a simple event-driven task runner built entirely around lambdas.
public class LambdaProject {

    static class EventBus {
        private final Map<String, List<Consumer<String>>> listeners = new HashMap<>();

        void on(String event, Consumer<String> listener) {
            listeners.computeIfAbsent(event, k -> new ArrayList<>()).add(listener);
        }

        void emit(String event, String data) {
            listeners.getOrDefault(event, List.of()).forEach(listener -> listener.accept(data));
        }
    }

    public static void main(String[] args) {
        EventBus bus = new EventBus();

        // Registering behaviour purely with lambdas - no separate classes needed
        bus.on("order.placed", data -> System.out.println("[Email] Order confirmation sent for: " + data));
        bus.on("order.placed", data -> System.out.println("[Inventory] Stock reduced for: " + data));
        bus.on("order.cancelled", data -> System.out.println("[Refund] Processing refund for: " + data));

        bus.emit("order.placed", "Order #1001");
        bus.emit("order.cancelled", "Order #1002");

        // A small validation pipeline built from composed lambdas
        Predicate<String> notEmpty = s -> s != null && !s.isBlank();
        Predicate<String> minLength = s -> s.length() >= 3;
        Predicate<String> validName = notEmpty.and(minLength);

        Function<String, String> processOrder = name ->
            validName.test(name) ? "Order accepted for " + name : "Order rejected: invalid name";

        System.out.println(processOrder.apply("Al"));
        System.out.println(processOrder.apply("Rishabh"));
    }
}
