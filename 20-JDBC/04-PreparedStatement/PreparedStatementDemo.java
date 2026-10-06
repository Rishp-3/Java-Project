import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) {

        String url = "jdbc:h2:mem:mydatabase;DB_CLOSE_DELAY=-1";

        // PreparedStatement precompiles the SQL with '?' placeholders for parameters.
        // It is SAFER (prevents SQL injection) and FASTER (reused execution plan)
        // than building raw SQL strings with Statement.
        String insertSql = "INSERT INTO students (id, name, marks) VALUES (?, ?, ?)";
        String selectSql = "SELECT * FROM students WHERE marks > ?";

        try (Connection conn = DriverManager.getConnection(url, "sa", "")) {

            try (Statement ddl = conn.createStatement()) {
                ddl.execute("CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, name VARCHAR(50), marks INT)");
            }

            try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                insertStmt.setInt(1, 2);
                insertStmt.setString(2, "Aman");
                insertStmt.setInt(3, 85);
                insertStmt.executeUpdate();
                System.out.println("Inserted student safely with PreparedStatement.");
            }

            try (PreparedStatement selectStmt = conn.prepareStatement(selectSql)) {
                selectStmt.setInt(1, 80);
                try (ResultSet rs = selectStmt.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(rs.getString("name") + " scored " + rs.getInt("marks"));
                    }
                }
            }

            // Even if "name" contained something like: Robert'); DROP TABLE students; --
            // PreparedStatement treats it as plain data, not executable SQL.
            String dangerousInput = "Robert'); DROP TABLE students; --";
            try (PreparedStatement safeStmt = conn.prepareStatement(insertSql)) {
                safeStmt.setInt(1, 3);
                safeStmt.setString(2, dangerousInput); // safely stored as literal text
                safeStmt.setInt(3, 70);
                safeStmt.executeUpdate();
                System.out.println("SQL injection attempt safely neutralized.");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
