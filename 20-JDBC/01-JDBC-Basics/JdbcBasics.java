import java.sql.*;

// JDBC (Java Database Connectivity) lets Java programs talk to relational databases.
// The 4 basic steps are always: 1) load driver (usually automatic now),
// 2) get a Connection, 3) run a Statement/Query, 4) process results, 5) close resources.
//
// NOTE: running this requires a real database and its JDBC driver on the classpath
// (e.g. mysql-connector-j for MySQL, or the built-in org.sqlite.JDBC for SQLite).
// This file demonstrates the correct API usage; adjust the URL/credentials for your DB.
public class JdbcBasics {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "password";

        // try-with-resources automatically closes the Connection when done
        try (Connection connection = DriverManager.getConnection(url, user, password)) {

            System.out.println("Connected to database successfully!");
            System.out.println("Database product: " + connection.getMetaData().getDatabaseProductName());

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT 1")) {

                if (resultSet.next()) {
                    System.out.println("Test query result: " + resultSet.getInt(1));
                }
            }

        } catch (SQLException e) {
            System.out.println("Could not connect to the database (expected in this sandbox " +
                "without a real DB/driver): " + e.getMessage());
        }
    }
}
