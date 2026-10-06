package practice.enums;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumMap;
import org.junit.jupiter.api.Test;

class EnumProblemsTest {
    @Test void days() {
        assertTrue(Day.SUNDAY.isWeekend());
        assertFalse(Day.FRIDAY.isWeekend());
        assertEquals(Day.MONDAY, Day.SUNDAY.next());
        assertEquals(Day.TUESDAY, Day.valueOf("MONDAY").next());
        assertThrows(IllegalArgumentException.class, () -> Day.valueOf("Funday"));
    }
    @Test void trafficLightCycle() {
        assertEquals(TrafficLight.GREEN, TrafficLight.RED.next());
        assertEquals(TrafficLight.YELLOW, TrafficLight.GREEN.next());
        assertEquals(TrafficLight.RED, TrafficLight.YELLOW.next());
        assertEquals(60, TrafficLight.cycleSeconds());
    }
    @Test void operations() {
        assertEquals(7, Operation.ADD.apply(3, 4), 1e-9);
        assertEquals(12, Operation.fromSymbol("*").apply(3, 4), 1e-9);
        assertThrows(ArithmeticException.class, () -> Operation.DIVIDE.apply(1, 0));
        assertThrows(IllegalArgumentException.class, () -> Operation.fromSymbol("%"));
    }
    @Test void enumMapKeepsDeclarationOrder() {
        EnumMap<Day, Integer> hours = new EnumMap<>(Day.class);
        hours.put(Day.FRIDAY, 6);
        hours.put(Day.MONDAY, 8);
        assertEquals(Day.MONDAY, hours.keySet().iterator().next());
    }
}
