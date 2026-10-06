package practice.patterns;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import practice.patterns.DesignPatterns.*;

class DesignPatternsTest {
    @Test void singletonIsTheSameObjectEverywhere() {
        assertSame(AppConfig.INSTANCE, AppConfig.valueOf("INSTANCE"));
        int a = AppConfig.INSTANCE.nextId();
        int b = AppConfig.INSTANCE.nextId();
        assertEquals(a + 1, b);
    }
    @Test void factory() {
        assertEquals("EMAIL: hi", DesignPatterns.notifier("email").send("hi"));
        assertEquals("SMS: hi", DesignPatterns.notifier("SMS").send("hi"));
        assertThrows(IllegalArgumentException.class, () -> DesignPatterns.notifier("pigeon"));
    }
    @Test void builder() {
        Pizza p = Pizza.builder("large").topping("olives").topping("corn").extraCheese().build();
        assertEquals("large", p.size());
        assertEquals(List.of("olives", "corn"), p.toppings());
        assertTrue(p.extraCheese());
        assertFalse(Pizza.builder("small").build().extraCheese());
        assertThrows(IllegalArgumentException.class, () -> Pizza.builder(" "));
        assertThrows(UnsupportedOperationException.class, () -> p.toppings().add("x"));
    }
    @Test void observer() {
        EventBus<String> bus = new EventBus<>();
        List<String> a = new ArrayList<>(), b = new ArrayList<>();
        Runnable unsubA = bus.subscribe(a::add);
        bus.subscribe(b::add);
        bus.publish("one");
        unsubA.run();
        bus.publish("two");
        assertEquals(List.of("one"), a);
        assertEquals(List.of("one", "two"), b);
        assertEquals(1, bus.subscriberCount());
    }
    @Test void strategy() {
        assertEquals(100, DesignPatterns.checkout(100, DesignPatterns.NO_DISCOUNT), 1e-9);
        assertEquals(90, DesignPatterns.checkout(100, DesignPatterns.percentOff(10)), 1e-9);
        assertEquals(0, DesignPatterns.checkout(30, DesignPatterns.flatOff(50)), 1e-9);
    }
}
