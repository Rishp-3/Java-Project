import java.sql.*;

// CRUD = Create, Read, Update, Delete - the four basic database operations.
public class CrudDemo {

    static final String URL = "jdbc:h2:mem:mydatabase;DB_CLOSE_DELAY=-1";
    static final String USER = "sa";
    static final String PASSWORD = "";

    static void create(Connection conn, int id, String name, int marks) throws SQLException {
        String sql = "INSERT INTO students (id, name, marks) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, marks);
            ps.executeUpdate();
            System.out.println("Created student: " + name);
        }
    }

    static void readAll(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getInt("marks"));
            }
        }
    }

    static void update(Connection conn, int id, int newMarks) throws SQLException {
        String sql = "UPDATE students SET marks = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, newMarks);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            System.out.println("Updated " + rows + " row(s) for id " + id);
        }
    }

    static void delete(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println("Deleted " + rows + " row(s) with id " + id);
        }
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {

            try (Statement ddl = conn.createStatement()) {
                ddl.execute("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, name VARCHAR(50), marks INT)");
            }

            create(conn, 1, "Rishabh", 90);
            create(conn, 2, "Aman", 78);

            System.out.println("\n-- All students --");
            readAll(conn);

            update(conn, 2, 88);
            delete(conn, 1);

            System.out.println("\n-- After update/delete --");
            readAll(conn);

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
