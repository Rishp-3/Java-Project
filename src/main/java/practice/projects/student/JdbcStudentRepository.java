package practice.projects.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/** Student storage on top of JDBC. Works with any database; the app uses an H2 file so data survives restarts. */
public class JdbcStudentRepository implements StudentRepository {
    private final Connection conn;

    public JdbcStudentRepository(Connection conn) {
        this.conn = conn;
        try (Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS students ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100) NOT NULL, age INT NOT NULL, marks DOUBLE NOT NULL)");
        } catch (SQLException e) {
            throw new IllegalStateException("could not create schema", e);
        }
    }

    @Override public Student add(String name, int age, double marks) {
        String sql = "INSERT INTO students (name, age, marks) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setDouble(3, marks);
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                keys.next();
                return new Student(keys.getInt(1), name, age, marks);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override public List<Student> findAll() { return query("SELECT * FROM students ORDER BY id"); }

    @Override public Optional<Student> findById(int id) {
        return query("SELECT * FROM students WHERE id = ?", id).stream().findFirst();
    }

    @Override public List<Student> searchByName(String fragment) {
        return query("SELECT * FROM students WHERE LOWER(name) LIKE ? ORDER BY id", "%" + fragment.toLowerCase() + "%");
    }

    @Override public boolean updateMarks(int id, double marks) {
        return update("UPDATE students SET marks = ? WHERE id = ?", marks, id) == 1;
    }

    @Override public boolean delete(int id) {
        return update("DELETE FROM students WHERE id = ?", id) == 1;
    }

    private List<Student> query(String sql, Object... params) {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            bind(ps, params);
            try (ResultSet rs = ps.executeQuery()) {
                List<Student> out = new ArrayList<>();
                while (rs.next()) out.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getDouble("marks")));
                return out;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private int update(String sql, Object... params) {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            bind(ps, params);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private static void bind(PreparedStatement ps, Object[] params) throws SQLException {
        for (int i = 0; i < params.length; i++) ps.setObject(i + 1, params[i]);
    }
}
