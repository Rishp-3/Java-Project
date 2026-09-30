public class ClassObject {

    // A simple class describing a Car - a blueprint for creating Car objects
    static class Car {
        String brand;
        String model;
        int year;

        void displayInfo() {
            System.out.println(year + " " + brand + " " + model);
        }
    }

    public static void main(String[] args) {

        // Creating objects (instances) of the Car class
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.model = "Corolla";
        car1.year = 2022;

        Car car2 = new Car();
        car2.brand = "Honda";
        car2.model = "Civic";
        car2.year = 2023;

        car1.displayInfo();
        car2.displayInfo();

        // Each object has its own copy of instance variables
        System.out.println("car1 and car2 are different objects: " + (car1 != car2));
    }
}
