package practice.projects.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/** Console Student Management System with persistence. Data is stored in ./data/students.mv.db and survives restarts. */
public class StudentApp {
    public static void main(String[] args) throws SQLException {
        String url = args.length > 0 ? args[0] : "jdbc:h2:file:./data/students";
        try (Connection conn = DriverManager.getConnection(url, "sa", "");
             Scanner in = new Scanner(System.in)) {
            run(new JdbcStudentRepository(conn), in);
        }
    }

    static void run(StudentRepository repo, Scanner in) {
        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add  2. View all  3. Update marks  4. Delete  5. Search  6. Exit");
            System.out.print("Choose: ");
            if (!in.hasNextLine()) return;
            try {
                switch (in.nextLine().trim()) {
                    case "1" -> {
                        System.out.print("Name: "); String name = in.nextLine();
                        System.out.print("Age: "); int age = Integer.parseInt(in.nextLine().trim());
                        System.out.print("Marks: "); double marks = Double.parseDouble(in.nextLine().trim());
                        System.out.println("Added: " + repo.add(name, age, marks));
                    }
                    case "2" -> {
                        var all = repo.findAll();
                        if (all.isEmpty()) System.out.println("No students yet.");
                        all.forEach(System.out::println);
                    }
                    case "3" -> {
                        System.out.print("ID: "); int id = Integer.parseInt(in.nextLine().trim());
                        System.out.print("New marks: "); double marks = Double.parseDouble(in.nextLine().trim());
                        System.out.println(repo.updateMarks(id, marks) ? "Updated." : "Student not found.");
                    }
                    case "4" -> {
                        System.out.print("ID: "); int id = Integer.parseInt(in.nextLine().trim());
                        System.out.println(repo.delete(id) ? "Deleted." : "Student not found.");
                    }
                    case "5" -> {
                        System.out.print("Name contains: ");
                        repo.searchByName(in.nextLine().trim()).forEach(System.out::println);
                    }
                    case "6" -> { System.out.println("Bye!"); return; }
                    default -> System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
