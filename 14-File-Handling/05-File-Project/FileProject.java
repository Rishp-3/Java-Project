import java.io.*;
import java.util.*;

// Mini project: a simple note-taking app that saves/loads notes from a text file.
public class FileProject {

    static final String FILE_NAME = "notes.txt";

    static void addNote(String note) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(note);
            writer.newLine();
            System.out.println("Note added.");
        } catch (IOException e) {
            System.out.println("Failed to add note: " + e.getMessage());
        }
    }

    static List<String> readNotes() {
        List<String> notes = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return notes;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                notes.add(line);
            }
        } catch (IOException e) {
            System.out.println("Failed to read notes: " + e.getMessage());
        }
        return notes;
    }

    static void printNotes() {
        List<String> notes = readNotes();
        if (notes.isEmpty()) {
            System.out.println("No notes yet.");
            return;
        }
        System.out.println("Your notes:");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }
    }

    public static void main(String[] args) {
        // Start clean for this demo run
        new File(FILE_NAME).delete();

        addNote("Buy groceries");
        addNote("Finish Java project");
        addNote("Call mom");

        printNotes();

        System.out.println("\nTotal notes: " + readNotes().size());

        // Cleanup
        new File(FILE_NAME).delete();
    }
}
