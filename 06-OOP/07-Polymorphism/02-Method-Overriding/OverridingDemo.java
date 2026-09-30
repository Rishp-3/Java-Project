public class OverridingDemo {

    // Runtime (dynamic) polymorphism: a subclass provides its own implementation
    // of a method already defined in its parent. The JVM decides which version
    // to run at RUNTIME, based on the actual object type.

    static class Vehicle {
        void start() {
            System.out.println("Vehicle is starting.");
        }
    }

    static class Bike extends Vehicle {
        @Override
        void start() {
            System.out.println("Bike starts with a kick or self-start.");
        }
    }

    static class ElectricCar extends Vehicle {
        @Override
        void start() {
            System.out.println("Electric car starts silently at the press of a button.");
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Bike();         // reference type Vehicle, actual object Bike
        Vehicle v2 = new ElectricCar();  // reference type Vehicle, actual object ElectricCar

        v1.start(); // calls Bike's version
        v2.start(); // calls ElectricCar's version

        Vehicle[] vehicles = { new Vehicle(), new Bike(), new ElectricCar() };
        for (Vehicle v : vehicles) {
            v.start(); // the correct overridden method runs for each object
        }
    }
}
