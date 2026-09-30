public class EnumsDemo {

    // A basic enum - a fixed set of named constants
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    // An enum with fields, a constructor, and methods
    enum Planet {
        MERCURY(3.3e23, 2.4e6),
        EARTH(5.9e24, 6.3e6),
        JUPITER(1.9e27, 7.1e7);

        final double mass;   // in kg
        final double radius; // in meters

        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
        }

        double surfaceGravity() {
            final double G = 6.67300E-11;
            return G * mass / (radius * radius);
        }
    }

    // An enum can even have abstract methods, implemented differently per constant
    enum Operation {
        ADD {
            public int apply(int a, int b) { return a + b; }
        },
        SUBTRACT {
            public int apply(int a, int b) { return a - b; }
        };

        public abstract int apply(int a, int b);
    }

    public static void main(String[] args) {
        Day today = Day.WEDNESDAY;
        System.out.println("Today is: " + today);

        // switch works naturally with enums
        switch (today) {
            case SATURDAY, SUNDAY -> System.out.println("It's the weekend!");
            default -> System.out.println("It's a weekday.");
        }

        System.out.println("\nAll days:");
        for (Day day : Day.values()) {
            System.out.println(day.ordinal() + ": " + day);
        }

        System.out.println("\nSurface gravity on Earth: " + Planet.EARTH.surfaceGravity());
        System.out.println("Surface gravity on Jupiter: " + Planet.JUPITER.surfaceGravity());

        System.out.println("\n5 + 3 = " + Operation.ADD.apply(5, 3));
        System.out.println("5 - 3 = " + Operation.SUBTRACT.apply(5, 3));
    }
}
