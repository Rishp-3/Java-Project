import java.util.*;

// A console-based Employee Management System: add, view, update salary, delete, and department report.
public class EmployeeManagementSystem {

    static class Employee {
        int id;
        String name;
        String department;
        double salary;

        Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "ID: " + id + " | " + name + " | " + department + " | Salary: " + salary;
        }
    }

    static List<Employee> employees = new ArrayList<>();
    static int nextId = 1;
    static Scanner sc = new Scanner(System.in);

    static void addEmployee() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter department: ");
        String dept = sc.nextLine();
        System.out.print("Enter salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        employees.add(new Employee(nextId++, name, dept, salary));
        System.out.println("Employee added.");
    }

    static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        employees.forEach(System.out::println);
    }

    static void updateSalary() {
        System.out.print("Enter employee ID: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Employee e : employees) {
            if (e.id == id) {
                System.out.print("Enter new salary: ");
                e.salary = Double.parseDouble(sc.nextLine());
                System.out.println("Salary updated.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    static void deleteEmployee() {
        System.out.print("Enter employee ID: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean removed = employees.removeIf(e -> e.id == id);
        System.out.println(removed ? "Employee removed." : "Employee not found.");
    }

    static void departmentReport() {
        Map<String, List<Employee>> byDept = new HashMap<>();
        for (Employee e : employees) {
            byDept.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }
        for (var entry : byDept.entrySet()) {
            double avgSalary = entry.getValue().stream().mapToDouble(e -> e.salary).average().orElse(0);
            System.out.println(entry.getKey() + ": " + entry.getValue().size() +
                " employees, avg salary = " + avgSalary);
        }
    }

    public static void main(String[] args) {
        employees.add(new Employee(nextId++, "Rishabh", "Engineering", 75000));
        employees.add(new Employee(nextId++, "Priya", "Marketing", 62000));
        employees.add(new Employee(nextId++, "Aman", "Engineering", 68000));

        boolean running = true;
        while (running) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee\n2. View All\n3. Update Salary\n4. Delete Employee\n5. Department Report\n6. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1" -> addEmployee();
                case "2" -> viewEmployees();
                case "3" -> updateSalary();
                case "4" -> deleteEmployee();
                case "5" -> departmentReport();
                case "6" -> { running = false; System.out.println("Goodbye!"); }
                default -> System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
