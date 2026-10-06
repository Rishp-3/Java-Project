package practice.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

/** Module 20 - JDBC practice on an embedded H2 database: DDL, batch insert, queries, transactions. */
public final class JdbcProblems {
    private JdbcProblems() {}

    public record Student(int id, String name, int marks) {}

    /** Problem 1: create the table (safe to call twice). */
    public static void createSchema(Connection conn) throws SQLException {
        try (Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, name VARCHAR(50) NOT NULL, marks INT NOT NULL)");
        }
    }

    /** Problem 2: insert many rows efficiently with a PreparedStatement batch; returns rows inserted. */
    public static int insertAll(Connection conn, List<Student> students) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO students (id, name, marks) VALUES (?, ?, ?)")) {
            for (Student s : students) {
                ps.setInt(1, s.id());
                ps.setString(2, s.name());
                ps.setInt(3, s.marks());
                ps.addBatch();
            }
            int total = 0;
            for (int n : ps.executeBatch()) total += n;
            return total;
        }
    }

    /** Problem 3: top N students by marks (ties broken by name). */
    public static List<Student> topScorers(Connection conn, int n) throws SQLException {
        String sql = "SELECT id, name, marks FROM students ORDER BY marks DESC, name ASC LIMIT ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, n);
            try (ResultSet rs = ps.executeQuery()) {
                List<Student> out = new ArrayList<>();
                while (rs.next()) out.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("marks")));
                return out;
            }
        }
    }

    /** Problem 4: aggregate - average marks, empty when the table has no rows. */
    public static OptionalDouble averageMarks(Connection conn) throws SQLException {
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery("SELECT AVG(CAST(marks AS DOUBLE)) FROM students")) {
            rs.next();
            double avg = rs.getDouble(1);
            return rs.wasNull() ? OptionalDouble.empty() : OptionalDouble.of(avg);
        }
    }

    /** Problem 5: lookup by name using a parameter - never string concatenation (SQL injection!). */
    public static List<Student> findByName(Connection conn, String name) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT id, name, marks FROM students WHERE name = ?")) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                List<Student> out = new ArrayList<>();
                while (rs.next()) out.add(new Student(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                return out;
            }
        }
    }

    /** Problem 6: add bonus marks to several students atomically - all updates or none (transaction). */
    public static void applyBonuses(Connection conn, Map<Integer, Integer> bonusById) throws SQLException {
        boolean previous = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try (PreparedStatement ps = conn.prepareStatement("UPDATE students SET marks = marks + ? WHERE id = ?")) {
            for (Map.Entry<Integer, Integer> e : bonusById.entrySet()) {
                ps.setInt(1, e.getValue());
                ps.setInt(2, e.getKey());
                if (ps.executeUpdate() != 1) throw new SQLException("no such student: " + e.getKey());
            }
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            conn.setAutoCommit(previous);
        }
    }
}
