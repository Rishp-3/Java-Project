public class StaticDemo {

    static class Counter {
        static int count = 0; // shared across ALL instances of Counter

        Counter() {
            count++; // every new object increments the shared counter
        }

        // static method - belongs to the class, not to any single object
        static int getCount() {
            return count;
        }
    }

    // static block - runs once when the class is first loaded
    static int staticValue;
    static {
        staticValue = 100;
        System.out.println("Static block executed. staticValue = " + staticValue);
    }

    public static void main(String[] args) {
        new Counter();
        new Counter();
        new Counter();

        System.out.println("Number of Counter objects created: " + Counter.getCount());
        // Note: Counter.count is accessed via the class, not through an object,
        // because it belongs to the class itself.

        System.out.println("staticValue: " + staticValue);
    }
}
