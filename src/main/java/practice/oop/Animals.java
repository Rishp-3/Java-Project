package practice.oop;

import java.util.List;

/** Problem 3: inheritance + method overriding + super calls. */
public final class Animals {
    private Animals() {}

    public static class Animal {
        protected final String name;
        public Animal(String name) { this.name = name; }
        public String sound() { return "..."; }
        public String describe() { return name + " says " + sound(); }
    }

    public static class Dog extends Animal {
        public Dog(String name) { super(name); }
        @Override public String sound() { return "Woof"; }
    }

    public static class Puppy extends Dog {
        public Puppy(String name) { super(name); }
        @Override public String sound() { return super.sound().toLowerCase() + "!"; }
    }

    public static class Cat extends Animal {
        public Cat(String name) { super(name); }
        @Override public String sound() { return "Meow"; }
    }

    /** Problem 4: dynamic dispatch - the runtime type decides which sound() runs. */
    public static List<String> chorus(List<? extends Animal> animals) {
        return animals.stream().map(Animal::describe).toList();
    }
}
