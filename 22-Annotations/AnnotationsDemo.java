import java.lang.annotation.*;
import java.lang.reflect.Method;

public class AnnotationsDemo {

    // A custom annotation, using meta-annotations to control its behavior:
    // @Retention -> how long it's kept (SOURCE, CLASS, or RUNTIME)
    // @Target    -> where it can be applied (methods, classes, fields, etc.)
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Test {
        String description() default "No description";
    }

    static class Calculator {
        @Test(description = "Tests addition")
        void testAdd() {
            System.out.println("2 + 2 = " + (2 + 2));
        }

        @Test(description = "Tests subtraction")
        void testSubtract() {
            System.out.println("5 - 3 = " + (5 - 3));
        }

        void notATest() {
            System.out.println("This method is not annotated.");
        }
    }

    public static void main(String[] args) throws Exception {

        // Built-in annotations you already use constantly:
        // @Override  - marks a method as overriding a parent method
        // @Deprecated - marks something as outdated
        // @SuppressWarnings - tells the compiler to ignore specific warnings
        demoBuiltIns();

        // Reading custom annotations at runtime using Reflection
        Calculator calc = new Calculator();
        for (Method method : Calculator.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                System.out.println("Running test: " + test.description());
                method.invoke(calc);
            }
        }
    }

    @Deprecated
    static void oldMethod() {
        System.out.println("This method is deprecated, avoid using it.");
    }

    @SuppressWarnings("unchecked")
    static void demoBuiltIns() {
        oldMethod();
        java.util.List list = new java.util.ArrayList(); // raw type, warning suppressed
        list.add("no generic type checking here");
        System.out.println(list);
    }
}
