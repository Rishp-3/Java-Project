import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {

        // The File class represents a path to a file or directory on disk
        // (it doesn't read/write content by itself - other classes do that).
        File file = new File("demo.txt");

        if (!file.exists()) {
            boolean created = file.createNewFile();
            System.out.println("File created: " + created);
        } else {
            System.out.println("File already exists.");
        }

        System.out.println("Name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Is file: " + file.isFile());
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("Can read: " + file.canRead());
        System.out.println("Can write: " + file.canWrite());
        System.out.println("Length (bytes): " + file.length());

        // Creating and listing a directory
        File dir = new File("demo_folder");
        if (dir.mkdir()) {
            System.out.println("\nDirectory created: " + dir.getName());
        }

        File currentDir = new File(".");
        System.out.println("\nFiles in current directory (first 5):");
        File[] files = currentDir.listFiles();
        if (files != null) {
            for (int i = 0; i < Math.min(5, files.length); i++) {
                System.out.println("  " + files[i].getName());
            }
        }

        // Cleanup
        file.delete();
        dir.delete();
    }
}
