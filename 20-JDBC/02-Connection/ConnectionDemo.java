import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) {

        String url = "jdbc:h2:mem:mydatabase;DB_CLOSE_DELAY=-1";
        String user = "sa";
        String password = "";

        Connection connection = null;
        try {
            // DriverManager.getConnection() opens a connection using the given URL and credentials
            connection = DriverManager.getConnection(url, user, password);

            System.out.println("Connection established: " + !connection.isClosed());
            System.out.println("Auto-commit enabled: " + connection.getAutoCommit());

            // Transactions: turn off auto-commit to group multiple statements together
            connection.setAutoCommit(false);
            // ... run multiple statements here ...
            connection.commit();   // save all changes
            // connection.rollback(); // or undo all changes if something went wrong

        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        } finally {
            // ALWAYS close the connection in a finally block if not using try-with-resources
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}
