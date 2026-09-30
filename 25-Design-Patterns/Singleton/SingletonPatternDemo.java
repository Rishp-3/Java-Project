public class SingletonPatternDemo {

    // Singleton: ensures a class has ONLY ONE instance, with a global access point.
    // Used for things like configuration managers, logging, connection pools.
    static class DatabaseConnection {
        // The single, shared instance - created once, lazily, thread-safely
        private static volatile DatabaseConnection instance;

        private DatabaseConnection() {
            System.out.println("Creating the one and only DatabaseConnection...");
        }

        // Double-checked locking: efficient AND thread-safe lazy initialization
        public static DatabaseConnection getInstance() {
            if (instance == null) {
                synchronized (DatabaseConnection.class) {
                    if (instance == null) {
                        instance = new DatabaseConnection();
                    }
                }
            }
            return instance;
        }

        void query(String sql) {
            System.out.println("Running query: " + sql);
        }
    }

    public static void main(String[] args) {
        DatabaseConnection conn1 = DatabaseConnection.getInstance();
        DatabaseConnection conn2 = DatabaseConnection.getInstance();

        conn1.query("SELECT * FROM users");
        conn2.query("SELECT * FROM orders");

        System.out.println("conn1 and conn2 are the same instance: " + (conn1 == conn2));
    }
}
