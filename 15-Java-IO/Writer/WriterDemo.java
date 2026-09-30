import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class WriterDemo {
    public static void main(String[] args) {

        // Writer is the abstract base class for writing CHARACTER streams (text).
        // FileWriter, StringWriter, BufferedWriter all extend Writer.

        // 1. Writing to an in-memory buffer
        try (StringWriter stringWriter = new StringWriter()) {
            stringWriter.write("Building text in memory. ");
            stringWriter.append("Appended more text.");
            System.out.println(stringWriter.toString());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 2. Writing to a file using a generic Writer reference
        String fileName = "writer_demo.txt";
        try (Writer writer = new FileWriter(fileName)) {
            writer.write("Line written through the Writer class.\n");
            writer.write("Writer works with characters, not raw bytes.");
        } catch (IOException e) {
            System.out.println("Error writing: " + e.getMessage());
        }

        try {
            System.out.println("\nFile content:");
            System.out.println(java.nio.file.Files.readString(java.nio.file.Paths.get(fileName)));
        } catch (IOException e) {
            System.out.println("Error reading back: " + e.getMessage());
        }

        new java.io.File(fileName).delete();
    }
}
