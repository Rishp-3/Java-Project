package practice.oop;

public record Rectangle(double width, double height) implements Shape {
    public Rectangle {
        if (width <= 0 || height <= 0) throw new IllegalArgumentException("sides must be positive");
    }
    @Override public double area() { return width * height; }
    @Override public double perimeter() { return 2 * (width + height); }
}
