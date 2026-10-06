package practice.exceptions;

/** Problem 1: a custom CHECKED exception - callers are forced to handle or declare it. */
public class InsufficientBalanceException extends Exception {
    private static final long serialVersionUID = 1L;

    private final double shortBy;

    public InsufficientBalanceException(double shortBy) {
        super("Insufficient balance, short by " + shortBy);
        this.shortBy = shortBy;
    }

    public double getShortBy() { return shortBy; }
}
