import java.util.*;

// Mini project: a simple student gradebook combining several Collections types.
public class CollectionsProject {

    record Student(String name, List<Integer> marks) {
        double average() {
            return marks.stream().mapToInt(Integer::intValue).average().orElse(0);
        }
    }

    public static void main(String[] args) {
        // Using an ArrayList to store all students
        List<Student> students = new ArrayList<>();
        students.add(new Student("Rishabh", List.of(85, 90, 78)));
        students.add(new Student("Aman", List.of(60, 55, 70)));
        students.add(new Student("Priya", List.of(95, 92, 98)));

        // Using a TreeMap to keep a sorted name -> average lookup
        TreeMap<String, Double> averages = new TreeMap<>();
        for (Student s : students) {
            averages.put(s.name(), s.average());
        }
        System.out.println("Averages (sorted by name): " + averages);

        // Using a HashSet to find all unique marks across every student
        Set<Integer> uniqueMarks = new HashSet<>();
        for (Student s : students) {
            uniqueMarks.addAll(s.marks());
        }
        System.out.println("Unique marks: " + uniqueMarks);

        // Using a PriorityQueue to rank students by average (highest first)
        PriorityQueue<Student> ranking = new PriorityQueue<>(
            (a, b) -> Double.compare(b.average(), a.average())
        );
        ranking.addAll(students);

        System.out.println("\nRanking (highest average first):");
        int rank = 1;
        while (!ranking.isEmpty()) {
            Student s = ranking.poll();
            System.out.printf("%d. %s - avg %.2f%n", rank++, s.name(), s.average());
        }
    }
}
