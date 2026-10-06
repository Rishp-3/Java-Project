package practice.oop;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class OopProblemsTest {
    @Test void shapesPolymorphism() {
        List<Shape> shapes = List.of(new Rectangle(2, 3), new Circle(1));
        assertEquals(6 + Math.PI, Shape.totalArea(shapes), 1e-9);
        assertEquals(10, new Rectangle(2, 3).perimeter(), 1e-9);
        assertThrows(IllegalArgumentException.class, () -> new Circle(0));
        assertEquals(new Rectangle(1, 2), new Rectangle(1, 2));
    }
    @Test void accountEncapsulation() {
        BankAccount acc = new BankAccount("Rishabh", 100);
        acc.deposit(50);
        acc.withdraw(30);
        assertEquals(120, acc.getBalance(), 1e-9);
        assertThrows(IllegalStateException.class, () -> acc.withdraw(1000));
        assertThrows(IllegalArgumentException.class, () -> acc.deposit(-5));
        assertEquals(120, acc.getBalance(), 1e-9);
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(" ", 0));
    }
    @Test void inheritanceAndDispatch() {
        List<Animals.Animal> zoo = List.of(new Animals.Animal("Thing"), new Animals.Dog("Rex"),
                new Animals.Puppy("Bit"), new Animals.Cat("Tom"));
        assertEquals(List.of("Thing says ...", "Rex says Woof", "Bit says woof!", "Tom says Meow"), Animals.chorus(zoo));
    }
}
