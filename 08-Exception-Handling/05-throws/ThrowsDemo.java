import java.io.IOException;

public class ThrowsDemo {

    // 'throws' declares that a method MIGHT throw a checked exception,
    // passing the responsibility of handling it to the caller.
    static void readFile(String filename) throws IOException {
        if (!filename.endsWith(".txt")) {
            throw new IOException("Only .txt files are supported: " + filename);
        }
        System.out.println("Reading file: " + filename);
    }

    // A method can declare multiple exceptions
    static void process(int value) throws IOException, ArithmeticException {
        if (value == 0) {
            throw new ArithmeticException("Value cannot be zero.");
        }
        readFile("data" + value + ".txt");
    }

    public static void main(String[] args) {
        try {
            readFile("report.txt");
            readFile("image.png"); // will throw
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }

        try {
            process(0);
        } catch (IOException | ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
