import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class FunctionDemo {
    public static void main(String[] args) {

        // Function<T, R>: takes one argument of type T, returns a result of type R
        Function<Integer, Integer> square = n -> n * n;
        Function<String, Integer> length = String::length;

        System.out.println("Square of 5: " + square.apply(5));
        System.out.println("Length of 'Java': " + length.apply("Java"));

        // compose() runs the argument function FIRST, then this one
        Function<Integer, Integer> addTwo = n -> n + 2;
        Function<Integer, Integer> squareThenAddTwo = square.andThen(addTwo);
        Function<Integer, Integer> addTwoThenSquare = square.compose(addTwo);

        System.out.println("square.andThen(addTwo) on 3: " + squareThenAddTwo.apply(3)); // (3*3)+2 = 11
        System.out.println("square.compose(addTwo) on 3: " + addTwoThenSquare.apply(3)); // (3+2)^2 = 25

        // BiFunction<T, U, R>: takes TWO arguments, returns a result
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        System.out.println("multiply(4, 5): " + multiply.apply(4, 5));

        // UnaryOperator<T>: a Function<T, T> - input and output are the same type
        UnaryOperator<String> shout = s -> s.toUpperCase() + "!";
        System.out.println(shout.apply("java is fun"));
    }
}
