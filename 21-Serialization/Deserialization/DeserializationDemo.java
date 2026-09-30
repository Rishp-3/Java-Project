import java.io.*;

// Deserialization: converting a byte stream back into a Java object.
public class DeserializationDemo {

    static class Student implements Serializable {
        private static final long serialVersionUID = 1L;

        String name;
        int age;
        transient String password; // this field will come back as null after deserialization

        Student(String name, int age, String password) {
            this.name = name;
            this.age = age;
            this.password = password;
        }

        @Override
        public String toString() {
            return "Student{name=" + name + ", age=" + age + ", password=" + password + "}";
        }
    }

    public static void main(String[] args) {
        String fileName = "student_data.ser";
        Student original = new Student("Rishabh", 22, "secret123");

        // First, serialize the object
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(original);
        } catch (IOException e) {
            System.out.println("Error writing: " + e.getMessage());
            return;
        }

        // Now, deserialize it back into a new object
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Student restored = (Student) in.readObject();
            System.out.println("Original:  " + original);
            System.out.println("Restored:  " + restored);
            System.out.println("Note: password is null after restoring, because it was 'transient'.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading: " + e.getMessage());
        }

        new File(fileName).delete();
    }
}
