import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {

        String fileName = "sample.txt";

        // Write something first so we have content to read
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello from FileWriter!\nThis is line two.");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }

        // FileReader reads a file CHARACTER BY CHARACTER - simple but slow for large files
        try (FileReader reader = new FileReader(fileName)) {
            int character;
            StringBuilder content = new StringBuilder();
            while ((character = reader.read()) != -1) {
                content.append((char) character);
            }
            System.out.println("File content:");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Cleanup
        new java.io.File(fileName).delete();
    }
}
