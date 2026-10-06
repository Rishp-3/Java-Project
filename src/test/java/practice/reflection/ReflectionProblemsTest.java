package practice.reflection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import practice.reflection.ReflectionProblems.Person;

class ReflectionProblemsTest {
    @Test void listsPublicMethods() {
        assertEquals(List.of("birthday", "greet"), ReflectionProblems.publicMethodNames(Person.class));
    }
    @Test void createsByName() throws Exception {
        Object o = ReflectionProblems.newInstance(Person.class.getName());
        assertInstanceOf(Person.class, o);
        assertEquals("unknown", ReflectionProblems.readField(o, "name"));
        assertThrows(ClassNotFoundException.class, () -> ReflectionProblems.newInstance("no.such.Type"));
    }
    @Test void createsWithSpecificConstructor() throws Exception {
        Person p = ReflectionProblems.newPerson("Rishabh", 22);
        assertEquals("Hi, I'm Rishabh", p.greet());
        assertEquals(22, ReflectionProblems.readField(p, "age"));
    }
    @Test void writesPrivateField() throws Exception {
        Person p = new Person();
        ReflectionProblems.writeField(p, "name", "Aman");
        assertEquals("Hi, I'm Aman", p.greet());
        assertThrows(NoSuchFieldException.class, () -> ReflectionProblems.writeField(p, "missing", 1));
    }
    @Test void invokesPrivateAndPublicMethods() throws Exception {
        Person p = new Person("Aman", 30);
        assertEquals("hidden:Aman", ReflectionProblems.invoke(p, "secret"));
        assertEquals(31, ReflectionProblems.invoke(p, "birthday"));
    }
}
