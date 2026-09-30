import java.lang.reflect.*;

// Reflection lets a program inspect and manipulate classes, methods, and fields
// AT RUNTIME - even private ones. Used heavily by frameworks (Spring, JUnit, Jackson, etc.)
public class ReflectionDemo {

    static class Person {
        private String name = "Rishabh";
        private int age = 22;

        public Person() {}

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        private void greet() {
            System.out.println("Hello, I'm " + name);
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) throws Exception {

        Class<?> clazz = Person.class; // obtaining the Class object

        System.out.println("Class name: " + clazz.getName());
        System.out.println("Simple name: " + clazz.getSimpleName());

        System.out.println("\nConstructors:");
        for (Constructor<?> c : clazz.getDeclaredConstructors()) {
            System.out.println("  " + c);
        }

        System.out.println("\nFields:");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println("  " + f.getType().getSimpleName() + " " + f.getName());
        }

        System.out.println("\nMethods:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println("  " + m.getName());
        }

        // Creating an object dynamically and calling a private method via reflection
        Object person = clazz.getDeclaredConstructor(String.class, int.class)
            .newInstance("Aman", 25);

        Method greetMethod = clazz.getDeclaredMethod("greet");
        greetMethod.setAccessible(true); // bypasses the 'private' access check
        greetMethod.invoke(person);

        // Reading a private field's value directly
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println("Private field value read via reflection: " + nameField.get(person));
    }
}
