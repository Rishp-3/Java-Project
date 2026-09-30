public class InterfaceDemo {

    // An interface defines a contract - a set of methods a class must implement.
    // A class can implement multiple interfaces (unlike single class inheritance).
    interface Flyable {
        void fly(); // implicitly public and abstract
    }

    interface Swimmable {
        void swim();
    }

    // Interfaces can also have default methods with a body
    interface Greetable {
        default void greet() {
            System.out.println("Hello from a default interface method!");
        }
    }

    static class Duck implements Flyable, Swimmable, Greetable {
        @Override
        public void fly() {
            System.out.println("Duck is flying.");
        }

        @Override
        public void swim() {
            System.out.println("Duck is swimming.");
        }
    }

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.fly();
        duck.swim();
        duck.greet(); // uses the interface's default implementation

        // A reference of interface type can point to any implementing object
        Flyable flyable = duck;
        flyable.fly();
    }
}
