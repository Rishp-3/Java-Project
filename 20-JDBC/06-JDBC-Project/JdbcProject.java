import java.sql.*;
import java.util.*;

// Mini project: a simple Student record management console app using JDBC + a DAO pattern.
// (Requires a real database connection to actually run against.)
public class JdbcProject {

    record Student(int id, String name, int marks) {}

    static class StudentDao {
        private final Connection connection;

        StudentDao(Connection connection) {
            this.connection = connection;
        }

        void createTable() throws SQLException {
            try (Statement st = connection.createStatement()) {
                st.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, name VARCHAR(50), marks INT)");
            }
        }

        void add(Student student) throws SQLException {
            String sql = "INSERT INTO students VALUES (?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, student.id());
                ps.setString(2, student.name());
                ps.setInt(3, student.marks());
                ps.executeUpdate();
            }
        }

        List<Student> findAll() throws SQLException {
            List<Student> students = new ArrayList<>();
            String sql = "SELECT * FROM students";
            try (Statement st = connection.createStatement(); ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {
                    students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("marks")));
                }
            }
            return students;
        }

        Optional<Student> findById(int id) throws SQLException {
            String sql = "SELECT * FROM students WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return Optional.of(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("marks")));
                    }
                }
            }
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:h2:mem:mydatabase;DB_CLOSE_DELAY=-1";

        try (Connection conn = DriverManager.getConnection(url, "sa", "")) {
            StudentDao dao = new StudentDao(conn);

            dao.createTable();
            dao.add(new Student(1, "Rishabh", 90));
            dao.add(new Student(2, "Aman", 78));

            System.out.println("All students: " + dao.findAll());
            System.out.println("Student with id 1: " + dao.findById(1));

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
