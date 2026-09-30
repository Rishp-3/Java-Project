public class FactoryPatternDemo {

    interface Shape {
        void draw();
    }

    static class Circle implements Shape {
        public void draw() { System.out.println("Drawing a Circle"); }
    }

    static class Square implements Shape {
        public void draw() { System.out.println("Drawing a Square"); }
    }

    static class Triangle implements Shape {
        public void draw() { System.out.println("Drawing a Triangle"); }
    }

    // Factory: centralizes object creation logic so callers don't need to
    // know which concrete class to instantiate - they just ask the factory.
    static class ShapeFactory {
        static Shape createShape(String type) {
            return switch (type.toLowerCase()) {
                case "circle" -> new Circle();
                case "square" -> new Square();
                case "triangle" -> new Triangle();
                default -> throw new IllegalArgumentException("Unknown shape: " + type);
            };
        }
    }

    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.createShape("circle");
        Shape shape2 = ShapeFactory.createShape("square");
        Shape shape3 = ShapeFactory.createShape("triangle");

        shape1.draw();
        shape2.draw();
        shape3.draw();

        // The calling code never used 'new Circle()' directly - the factory decided
    }
}
