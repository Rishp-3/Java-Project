package practice.projects.student;

import java.util.List;
import java.util.Optional;

/** What the app needs from storage - the console UI never sees SQL. */
public interface StudentRepository {
    Student add(String name, int age, double marks);
    List<Student> findAll();
    Optional<Student> findById(int id);
    List<Student> searchByName(String fragment);
    boolean updateMarks(int id, double marks);
    boolean delete(int id);
}
