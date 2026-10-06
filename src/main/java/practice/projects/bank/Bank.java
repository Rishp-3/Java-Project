package practice.projects.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Bank accounts persisted via JDBC. Money movements use transactions so a failed transfer
 * never leaves half an update behind.
 */
public class Bank {
    private final Connection conn;

    public Bank(Connection conn) throws SQLException {
        this.conn = conn;
        try (Statement st = conn.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS accounts (account_no INT AUTO_INCREMENT(1001) PRIMARY KEY, "
                    + "holder VARCHAR(100) NOT NULL, balance DECIMAL(15,2) NOT NULL CHECK (balance >= 0))");
            st.execute("CREATE TABLE IF NOT EXISTS transactions (id INT AUTO_INCREMENT PRIMARY KEY, account_no INT NOT NULL, "
                    + "description VARCHAR(200) NOT NULL, FOREIGN KEY (account_no) REFERENCES accounts(account_no))");
        }
    }

    /** Opens an account and returns its new account number. */
    public int openAccount(String holder, double initialDeposit) throws SQLException {
        if (holder == null || holder.isBlank()) throw new IllegalArgumentException("holder required");
        if (initialDeposit < 0) throw new IllegalArgumentException("initial deposit cannot be negative");
        return inTransaction(() -> {
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO accounts (holder, balance) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, holder);
                ps.setBigDecimal(2, java.math.BigDecimal.valueOf(initialDeposit));
                ps.executeUpdate();
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    keys.next();
                    int no = keys.getInt(1);
                    log(no, "Account opened with " + initialDeposit);
                    return no;
                }
            }
        });
    }

    public double balance(int accountNo) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT balance FROM accounts WHERE account_no = ?")) {
            ps.setInt(1, accountNo);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) throw new IllegalArgumentException("no such account: " + accountNo);
                return rs.getBigDecimal(1).doubleValue();
            }
        }
    }

    public void deposit(int accountNo, double amount) throws SQLException {
        requirePositive(amount);
        inTransaction(() -> { adjust(accountNo, amount); log(accountNo, "Deposited " + amount); return null; });
    }

    public void withdraw(int accountNo, double amount) throws SQLException, InsufficientFundsException {
        requirePositive(amount);
        checkFunds(accountNo, amount);
        inTransaction(() -> { adjust(accountNo, -amount); log(accountNo, "Withdrew " + amount); return null; });
    }

    /** Moves money atomically: either both balances change or neither does. */
    public void transfer(int from, int to, double amount) throws SQLException, InsufficientFundsException {
        requirePositive(amount);
        if (from == to) throw new IllegalArgumentException("cannot transfer to the same account");
        balance(to);   // fail early if the destination does not exist
        checkFunds(from, amount);
        inTransaction(() -> {
            adjust(from, -amount);
            adjust(to, amount);
            log(from, "Transferred " + amount + " to " + to);
            log(to, "Received " + amount + " from " + from);
            return null;
        });
    }

    public List<String> history(int accountNo) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("SELECT description FROM transactions WHERE account_no = ? ORDER BY id")) {
            ps.setInt(1, accountNo);
            try (ResultSet rs = ps.executeQuery()) {
                List<String> out = new ArrayList<>();
                while (rs.next()) out.add(rs.getString(1));
                return out;
            }
        }
    }

    // ---- internals ----
    private void checkFunds(int accountNo, double amount) throws SQLException, InsufficientFundsException {
        if (balance(accountNo) < amount) throw new InsufficientFundsException("insufficient funds in account " + accountNo);
    }

    private static void requirePositive(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount must be positive");
    }

    private void adjust(int accountNo, double delta) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE account_no = ?")) {
            ps.setBigDecimal(1, java.math.BigDecimal.valueOf(delta));
            ps.setInt(2, accountNo);
            if (ps.executeUpdate() != 1) throw new SQLException("no such account: " + accountNo);
        }
    }

    private void log(int accountNo, String description) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO transactions (account_no, description) VALUES (?, ?)")) {
            ps.setInt(1, accountNo);
            ps.setString(2, description);
            ps.executeUpdate();
        }
    }

    @FunctionalInterface
    private interface SqlWork<T> { T run() throws SQLException; }

    private <T> T inTransaction(SqlWork<T> work) throws SQLException {
        boolean previous = conn.getAutoCommit();
        conn.setAutoCommit(false);
        try {
            T result = work.run();
            conn.commit();
            return result;
        } catch (SQLException | RuntimeException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(previous);
        }
    }
}
