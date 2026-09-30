import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class ReaderDemo {
    public static void main(String[] args) {

        // Reader is the abstract base class for reading CHARACTER streams (text).
        // FileReader, StringReader, BufferedReader all extend Reader.

        // 1. Reading from a String directly (useful for testing/parsing text in memory)
        try (Reader stringReader = new StringReader("Hello, Reader class!")) {
            int c;
            while ((c = stringReader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 2. Reading from a file using a generic Reader reference
        String fileName = "reader_demo.txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Text file content read via a Reader.");
        } catch (IOException e) {
            System.out.println("Error writing: " + e.getMessage());
        }

        try (Reader reader = new FileReader(fileName)) {
            char[] buffer = new char[1024];
            int charsRead = reader.read(buffer);
            System.out.println("Read " + charsRead + " characters:");
            System.out.println(new String(buffer, 0, charsRead));
        } catch (IOException e) {
            System.out.println("Error reading: " + e.getMessage());
        }

        new java.io.File(fileName).delete();
    }
}
