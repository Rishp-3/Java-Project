import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDemo {
    public static void main(String[] args) {

        // OutputStream writes raw BYTES - the counterpart to InputStream.

        // 1. Writing bytes to an in-memory buffer
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            baos.write("Hello".getBytes());
            baos.write('!');
            System.out.println("In-memory bytes as text: " + baos.toString());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 2. Writing bytes directly to a file
        String fileName = "output_stream_demo.dat";
        try (OutputStream out = new FileOutputStream(fileName)) {
            out.write("Binary data example".getBytes());
            out.flush(); // ensures all buffered data is actually written out
            System.out.println("Wrote data to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing: " + e.getMessage());
        }

        // Verify
        try (var in = new java.io.FileInputStream(fileName)) {
            System.out.println("File content: " + new String(in.readAllBytes()));
        } catch (IOException e) {
            System.out.println("Error reading back: " + e.getMessage());
        }

        new java.io.File(fileName).delete();
    }
}
