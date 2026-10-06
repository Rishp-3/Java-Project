package practice.enums;

import java.util.function.DoubleBinaryOperator;

/** Problem 3: enum holding behaviour (a lambda) and a safe lookup from user text. */
public enum Operation {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) throw new ArithmeticException("division by zero");
        return a / b;
    });

    private final String symbol;
    private final DoubleBinaryOperator fn;

    Operation(String symbol, DoubleBinaryOperator fn) {
        this.symbol = symbol;
        this.fn = fn;
    }

    public double apply(double a, double b) { return fn.applyAsDouble(a, b); }

    public String symbol() { return symbol; }

    public static Operation fromSymbol(String symbol) {
        for (Operation op : values()) {
            if (op.symbol.equals(symbol)) return op;
        }
        throw new IllegalArgumentException("unknown operator: " + symbol);
    }
}
