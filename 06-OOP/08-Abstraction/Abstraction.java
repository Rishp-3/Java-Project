public class Abstraction {

    // An abstract class can have both abstract (unimplemented) and concrete methods.
    // It cannot be instantiated directly.
    static abstract class Shape {
        abstract double area(); // must be implemented by subclasses

        void describe() { // concrete method, shared by all shapes
            System.out.println("This shape has an area of " + area());
        }
    }

    static class Circle extends Shape {
        double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        double area() {
            return Math.PI * radius * radius;
        }
    }

    static class Square extends Shape {
        double side;

        Square(double side) {
            this.side = side;
        }

        @Override
        double area() {
            return side * side;
        }
    }

    public static void main(String[] args) {
        // Shape shape = new Shape(); // not allowed - abstract classes cannot be instantiated

        Shape circle = new Circle(5);
        Shape square = new Square(4);

        circle.describe();
        square.describe();

        // Polymorphism: we can treat both as generic Shape references
        Shape[] shapes = { circle, square };
        for (Shape s : shapes) {
            System.out.println("Area: " + s.area());
        }
    }
}
