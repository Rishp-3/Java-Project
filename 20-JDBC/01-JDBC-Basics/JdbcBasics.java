import java.sql.*;

// JDBC (Java Database Connectivity) lets Java programs talk to relational databases.
// The 4 basic steps are always: 1) load driver (usually automatic now),
// 2) get a Connection, 3) run a Statement/Query, 4) process results, 5) close resources.
//
// NOTE: this uses H2, an embedded in-memory database, so there is nothing to install.
// Just put the H2 jar on the classpath: java -cp .:h2.jar JdbcBasics
// (With Maven the dependency is already in pom.xml.) To use MySQL instead, change the URL,
// user and password and add mysql-connector-j to the classpath.
public class JdbcBasics {
    public static void main(String[] args) {

        String url = "jdbc:h2:mem:mydatabase;DB_CLOSE_DELAY=-1";
        String user = "sa";
        String password = "";

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
            System.out.println("Could not connect to the database (is the H2 jar on the classpath?): " + e.getMessage());
        }
    }
}
