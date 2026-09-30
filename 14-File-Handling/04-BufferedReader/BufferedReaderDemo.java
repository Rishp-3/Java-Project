import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[] args) {

        String fileName = "buffered_sample.txt";

        // BufferedWriter wraps a FileWriter and buffers output for efficiency
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Line 1: Buffered writing is faster for large files.");
            writer.newLine();
            writer.write("Line 2: It reduces the number of actual disk writes.");
            writer.newLine();
            writer.write("Line 3: readLine() reads a whole line at once.");
        } catch (IOException e) {
            System.out.println("Error writing: " + e.getMessage());
        }

        // BufferedReader wraps a FileReader and lets us read LINE BY LINE, which is
        // much more convenient (and faster) than reading character by character.
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber++ + ": " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading: " + e.getMessage());
        }

        // Cleanup
        new java.io.File(fileName).delete();
    }
}
