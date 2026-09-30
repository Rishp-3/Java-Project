public class LambdaBasics {

    interface Greeting {
        void greet(String name);
    }

    interface Calculator {
        int calculate(int a, int b);
    }

    public static void main(String[] args) {

        // Old way: anonymous inner class
        Greeting oldWay = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("Hello (old way), " + name);
            }
        };
        oldWay.greet("Rishabh");

        // Lambda expression: a short way to implement a functional interface
        // (an interface with exactly ONE abstract method)
        Greeting lambdaWay = (name) -> System.out.println("Hello (lambda), " + name);
        lambdaWay.greet("Aman");

        // Lambda syntax variations
        Calculator add = (a, b) -> a + b;                 // expression body
        Calculator subtract = (a, b) -> { return a - b; }; // block body
        Calculator multiply = (int a, int b) -> a * b;     // explicit parameter types

        System.out.println("5 + 3 = " + add.calculate(5, 3));
        System.out.println("5 - 3 = " + subtract.calculate(5, 3));
        System.out.println("5 * 3 = " + multiply.calculate(5, 3));

        // Lambdas are commonly used with built-in functional interfaces like Runnable
        Runnable task = () -> System.out.println("Running a task via lambda!");
        task.run();
    }
}
