package practice.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

/** Module 23 - Reflection: inspect and use classes at runtime. */
public final class ReflectionProblems {
    private ReflectionProblems() {}

    /** Sample target class. */
    public static class Person {
        private String name;
        private int age;
        public Person() { this("unknown", 0); }
        public Person(String name, int age) { this.name = name; this.age = age; }
        public String greet() { return "Hi, I'm " + name; }
        public int birthday() { return ++age; }
        private String secret() { return "hidden:" + name; }
    }

    /** Problem 1: sorted names of public methods declared by the class itself. */
    public static List<String> publicMethodNames(Class<?> type) {
        return Arrays.stream(type.getDeclaredMethods())
                .filter(m -> Modifier.isPublic(m.getModifiers()))
                .map(Method::getName).sorted().toList();
    }

    /** Problem 2: create an object from a class name using its no-arg constructor. */
    public static Object newInstance(String className) throws ReflectiveOperationException {
        return Class.forName(className).getDeclaredConstructor().newInstance();
    }

    /** Problem 3: create an object with a specific constructor signature. */
    public static Person newPerson(String name, int age) throws ReflectiveOperationException {
        Constructor<Person> c = Person.class.getDeclaredConstructor(String.class, int.class);
        return c.newInstance(name, age);
    }

    /** Problem 4: read a private field. */
    public static Object readField(Object target, String fieldName) throws ReflectiveOperationException {
        Field f = target.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        return f.get(target);
    }

    /** Problem 5: write a private field. */
    public static void writeField(Object target, String fieldName, Object value) throws ReflectiveOperationException {
        Field f = target.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        f.set(target, value);
    }

    /** Problem 6: call a method by name, even a private one. */
    public static Object invoke(Object target, String methodName) throws ReflectiveOperationException {
        Method m = target.getClass().getDeclaredMethod(methodName);
        m.setAccessible(true);
        return m.invoke(target);
    }
}
