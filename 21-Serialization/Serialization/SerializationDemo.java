import java.io.*;

// Serialization: converting a Java object into a byte stream so it can be
// saved to a file, sent over a network, etc.
public class SerializationDemo {

    // A class must implement Serializable (a marker interface, no methods) to be serializable
    static class Student implements Serializable {
        private static final long serialVersionUID = 1L; // version control for the class shape

        String name;
        int age;
        transient String password; // 'transient' fields are SKIPPED during serialization

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
        Student student = new Student("Rishabh", 22, "secret123");
        String fileName = "student.ser";

        // Writing (serializing) the object to a file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(student);
            System.out.println("Object serialized: " + student);
        } catch (IOException e) {
            System.out.println("Error serializing: " + e.getMessage());
        }

        new File(fileName).delete();
    }
}
