package practice.projects.bank;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class BankTest {
    private Connection conn;
    private Bank bank;

    @BeforeEach void setUp() throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:mem:" + UUID.randomUUID(), "sa", "");
        bank = new Bank(conn);
    }
    @AfterEach void tearDown() throws SQLException { conn.close(); }

    @Test void accountNumbersStartAt1001() throws SQLException {
        assertEquals(1001, bank.openAccount("Asha", 100));
        assertEquals(1002, bank.openAccount("Bo", 0));
    }
    @Test void depositAndWithdraw() throws Exception {
        int a = bank.openAccount("Asha", 100);
        bank.deposit(a, 50.25);
        bank.withdraw(a, 30);
        assertEquals(120.25, bank.balance(a), 1e-9);
    }
    @Test void overdraftIsRejectedAndBalanceUnchanged() throws Exception {
        int a = bank.openAccount("Asha", 100);
        assertThrows(InsufficientFundsException.class, () -> bank.withdraw(a, 100.01));
        assertEquals(100, bank.balance(a), 1e-9);
    }
    @Test void transferMovesMoneyAndLogsBothSides() throws Exception {
        int a = bank.openAccount("Asha", 100), b = bank.openAccount("Bo", 20);
        bank.transfer(a, b, 40);
        assertEquals(60, bank.balance(a), 1e-9);
        assertEquals(60, bank.balance(b), 1e-9);
        assertEquals(List.of("Account opened with 100.0", "Transferred 40.0 to " + b), bank.history(a));
        assertEquals(List.of("Account opened with 20.0", "Received 40.0 from " + a), bank.history(b));
    }
    @Test void failedTransferChangesNothing() throws Exception {
        int a = bank.openAccount("Asha", 100);
        assertThrows(InsufficientFundsException.class, () -> bank.transfer(a, bank.openAccount("Bo", 0), 500));
        assertThrows(IllegalArgumentException.class, () -> bank.transfer(a, 9999, 10));   // unknown destination
        assertThrows(IllegalArgumentException.class, () -> bank.transfer(a, a, 10));
        assertEquals(100, bank.balance(a), 1e-9);
        assertEquals(1, bank.history(a).size());
    }
    @Test void rollbackOnMidTransferFailure() throws Exception {
        // adjust() on a vanished account fails AFTER the debit succeeded -> everything must roll back
        int a = bank.openAccount("Asha", 100), b = bank.openAccount("Bo", 0);
        try (var st = conn.createStatement()) { st.execute("SET REFERENTIAL_INTEGRITY FALSE; DELETE FROM accounts WHERE account_no = " + b + "; SET REFERENTIAL_INTEGRITY TRUE"); }
        assertThrows(IllegalArgumentException.class, () -> bank.transfer(a, b, 10));
        assertEquals(100, bank.balance(a), 1e-9);
    }
    @Test void validation() {
        assertThrows(IllegalArgumentException.class, () -> bank.openAccount(" ", 10));
        assertThrows(IllegalArgumentException.class, () -> bank.openAccount("X", -1));
        assertThrows(IllegalArgumentException.class, () -> bank.deposit(1001, 0));
        assertThrows(IllegalArgumentException.class, () -> bank.balance(424242));
    }
    @Test void accountsSurviveReconnect(@TempDir Path dir) throws Exception {
        String url = "jdbc:h2:file:" + dir.resolve("bank");
        int no;
        try (Connection c1 = DriverManager.getConnection(url, "sa", "")) {
            Bank b1 = new Bank(c1);
            no = b1.openAccount("Persistent", 250);
            b1.deposit(no, 50);
        }
        try (Connection c2 = DriverManager.getConnection(url, "sa", "")) {
            Bank b2 = new Bank(c2);
            assertEquals(300, b2.balance(no), 1e-9);
            assertEquals(2, b2.history(no).size());
        }
    }
}
