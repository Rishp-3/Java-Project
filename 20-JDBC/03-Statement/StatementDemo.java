import java.sql.*;

public class StatementDemo {
    public static void main(String[] args) {

        String url = "jdbc:h2:mem:mydatabase;DB_CLOSE_DELAY=-1";

        try (Connection conn = DriverManager.getConnection(url, "sa", "");
             Statement statement = conn.createStatement()) {

            // Statement executes plain SQL - simple but vulnerable to SQL injection
            // if you ever build the SQL string from user input (use PreparedStatement instead).

            // executeUpdate() for INSERT / UPDATE / DELETE / CREATE - returns rows affected
            statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, name VARCHAR(50), marks INT)");

            int rowsInserted = statement.executeUpdate(
                "INSERT INTO students VALUES (1, 'Rishabh', 90)");
            System.out.println("Rows inserted: " + rowsInserted);

            // executeQuery() for SELECT - returns a ResultSet
            try (ResultSet rs = statement.executeQuery("SELECT * FROM students")) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " - " + rs.getString("name") +
                        " - " + rs.getInt("marks"));
                }
            }

            // execute() can run ANY kind of SQL and tells you whether it returned a ResultSet
            boolean hasResultSet = statement.execute("SELECT COUNT(*) FROM students");
            System.out.println("Query returned a ResultSet: " + hasResultSet);

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
