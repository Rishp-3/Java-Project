public class AccessModifiers {

    static class Demo {
        public int publicVar = 1;       // accessible from anywhere
        protected int protectedVar = 2; // accessible in same package + subclasses
        int defaultVar = 3;             // (package-private) accessible only within the same package
        private int privateVar = 4;     // accessible only within this class

        public void showAll() {
            // all four are visible from INSIDE the class
            System.out.println(publicVar + " " + protectedVar + " " + defaultVar + " " + privateVar);
        }

        private void privateMethod() {
            System.out.println("This method can only be called from inside Demo.");
        }

        public void callPrivateMethod() {
            privateMethod(); // fine - we're still inside the class
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        System.out.println("public: " + demo.publicVar);
        System.out.println("protected: " + demo.protectedVar); // OK here, same file/package
        System.out.println("default: " + demo.defaultVar);     // OK here, same package

        // demo.privateVar is NOT accessible here - it would not compile:
        // System.out.println(demo.privateVar);

        demo.callPrivateMethod();

        System.out.println("\nSummary:");
        System.out.println("public    -> accessible everywhere");
        System.out.println("protected -> same package + subclasses (even in other packages)");
        System.out.println("default   -> same package only (no modifier written)");
        System.out.println("private   -> same class only");
    }
}
