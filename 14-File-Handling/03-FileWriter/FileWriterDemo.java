import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterDemo {
    public static void main(String[] args) {

        String fileName = "output.txt";

        // FileWriter(fileName)         -> overwrites the file if it exists
        // FileWriter(fileName, true)   -> appends to the end of the file
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("First line.\n");
            writer.write("Second line.\n");
        } catch (IOException e) {
            System.out.println("Error writing: " + e.getMessage());
        }

        // Appending more content
        try (FileWriter appender = new FileWriter(fileName, true)) {
            appender.append("Appended line.\n");
        } catch (IOException e) {
            System.out.println("Error appending: " + e.getMessage());
        }

        // Reading it back to verify (using modern NIO, just for convenience here)
        try {
            String content = Files.readString(Paths.get(fileName));
            System.out.println("Final file content:");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error reading back: " + e.getMessage());
        }

        // Cleanup
        new java.io.File(fileName).delete();
    }
}
