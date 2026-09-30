import java.util.*;
import java.util.stream.Collectors;

// Mini project: analyze a list of employees using a Stream pipeline.
public class StreamProject {

    record Employee(String name, String department, double salary) {}

    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Rishabh", "Engineering", 75000),
            new Employee("Aman", "Engineering", 68000),
            new Employee("Priya", "Marketing", 62000),
            new Employee("Rahul", "Marketing", 58000),
            new Employee("Anjali", "HR", 55000),
            new Employee("Bob", "Engineering", 91000)
        );

        // 1. Names of employees earning more than 60000, sorted alphabetically
        List<String> highEarners = employees.stream()
            .filter(e -> e.salary() > 60000)
            .map(Employee::name)
            .sorted()
            .toList();
        System.out.println("High earners (>60000): " + highEarners);

        // 2. Group employees by department
        Map<String, List<String>> byDepartment = employees.stream()
            .collect(Collectors.groupingBy(Employee::department,
                Collectors.mapping(Employee::name, Collectors.toList())));
        System.out.println("By department: " + byDepartment);

        // 3. Average salary per department
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::department,
                Collectors.averagingDouble(Employee::salary)));
        System.out.println("Average salary by department: " + avgSalaryByDept);

        // 4. Total salary paid across the company
        double totalPayroll = employees.stream().mapToDouble(Employee::salary).sum();
        System.out.println("Total payroll: " + totalPayroll);

        // 5. The highest paid employee
        employees.stream()
            .max(Comparator.comparingDouble(Employee::salary))
            .ifPresent(e -> System.out.println("Highest paid: " + e.name() + " (" + e.salary() + ")"));

        // 6. Department with the most employees
        Map<String, Long> countByDept = employees.stream()
            .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
        System.out.println("Employee count by department: " + countByDept);
    }
}
