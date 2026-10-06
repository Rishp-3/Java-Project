package practice.oop;

/** Abstraction + polymorphism: every shape knows its own area and perimeter. */
public interface Shape {
    double area();
    double perimeter();

    /** Problem 1: total area of a mixed list of shapes (polymorphism in action). */
    static double totalArea(java.util.List<? extends Shape> shapes) {
        double total = 0;
        for (Shape s : shapes) total += s.area();
        return total;
    }
}
