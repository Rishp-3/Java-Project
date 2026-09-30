import java.util.*;

// A console-based Student Management System: add, view, update, delete, and search students.
public class StudentManagementSystem {

    static class Student {
        int id;
        String name;
        int age;
        double marks;

        Student(int id, String name, int age, double marks) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Marks: " + marks;
        }
    }

    static List<Student> students = new ArrayList<>();
    static int nextId = 1;
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Enter marks: ");
        double marks = Double.parseDouble(sc.nextLine());

        students.add(new Student(nextId++, name, age, marks));
        System.out.println("Student added successfully.");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        students.forEach(System.out::println);
    }

    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter new marks: ");
                s.marks = Double.parseDouble(sc.nextLine());
                System.out.println("Updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean removed = students.removeIf(s -> s.id == id);
        System.out.println(removed ? "Deleted successfully." : "Student not found.");
    }

    static void searchStudent() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine().toLowerCase();
        students.stream()
            .filter(s -> s.name.toLowerCase().contains(name))
            .forEach(System.out::println);
    }

    public static void main(String[] args) {
        // seed with a couple of sample students so the demo has data immediately
        students.add(new Student(nextId++, "Rishabh", 22, 88.5));
        students.add(new Student(nextId++, "Aman", 23, 76.0));

        boolean running = true;
        while (running) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student\n2. View All\n3. Update Marks\n4. Delete Student\n5. Search by Name\n6. Exit");
            System.out.print("Choose an option: ");

            String input = sc.nextLine().trim();
            switch (input) {
                case "1" -> addStudent();
                case "2" -> viewStudents();
                case "3" -> updateStudent();
                case "4" -> deleteStudent();
                case "5" -> searchStudent();
                case "6" -> { running = false; System.out.println("Exiting..."); }
                default -> System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
