import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {
    public static void main(String[] args) {

        // InputStream reads raw BYTES - used for binary data (images, audio, any file type)
        // as opposed to Reader classes which are meant for text/characters.

        // 1. Reading bytes from an in-memory source
        byte[] data = {72, 101, 108, 108, 111}; // "Hello" in ASCII
        try (InputStream byteStream = new ByteArrayInputStream(data)) {
            int b;
            System.out.print("Bytes as characters: ");
            while ((b = byteStream.read()) != -1) {
                System.out.print((char) b);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 2. Reading a file as a stream of bytes
        String fileName = "binary_demo.dat";
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(new byte[] {1, 2, 3, 4, 5});
        } catch (IOException e) {
            System.out.println("Error writing: " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(fileName)) {
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            System.out.print("File bytes: ");
            for (byte b : buffer) {
                System.out.print(b + " ");
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error reading: " + e.getMessage());
        }

        new java.io.File(fileName).delete();
    }
}
