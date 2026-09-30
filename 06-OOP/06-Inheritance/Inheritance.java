public class Inheritance {

    static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
        }

        void eat() {
            System.out.println(name + " is eating.");
        }

        void makeSound() {
            System.out.println(name + " makes a sound.");
        }
    }

    // Dog inherits fields and methods from Animal using 'extends'
    static class Dog extends Animal {
        Dog(String name) {
            super(name); // calls the parent class constructor
        }

        // Overriding the parent method with Dog-specific behavior
        @Override
        void makeSound() {
            System.out.println(name + " barks: Woof!");
        }

        void fetch() {
            System.out.println(name + " fetches the ball.");
        }
    }

    static class Puppy extends Dog {
        Puppy(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            super.makeSound(); // reuse the parent's (Dog's) behavior
            System.out.println(name + " also yips excitedly.");
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Rex");
        dog.eat();        // inherited from Animal
        dog.makeSound();  // overridden in Dog
        dog.fetch();      // defined in Dog

        Puppy puppy = new Puppy("Buddy");
        puppy.eat();
        puppy.makeSound(); // uses both Dog's and Puppy's behavior via super
    }
}
