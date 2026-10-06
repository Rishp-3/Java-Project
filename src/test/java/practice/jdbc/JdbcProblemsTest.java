package practice.jdbc;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.jdbc.JdbcProblems.Student;

class JdbcProblemsTest {
    private Connection conn;

    @BeforeEach void open() throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:mem:" + UUID.randomUUID(), "sa", "");
        JdbcProblems.createSchema(conn);
    }
    @AfterEach void close() throws SQLException { conn.close(); }

    private void seed() throws SQLException {
        JdbcProblems.insertAll(conn, List.of(new Student(1, "Asha", 90), new Student(2, "Bo", 75),
                new Student(3, "Cy", 90), new Student(4, "Di", 60)));
    }

    @Test void schemaIsIdempotent() throws SQLException {
        JdbcProblems.createSchema(conn);
        assertTrue(JdbcProblems.topScorers(conn, 5).isEmpty());
    }
    @Test void batchInsertCountsRows() throws SQLException {
        assertEquals(2, JdbcProblems.insertAll(conn, List.of(new Student(1, "A", 1), new Student(2, "B", 2))));
        assertEquals(0, JdbcProblems.insertAll(conn, List.of()));
    }
    @Test void topScorersWithTieBreak() throws SQLException {
        seed();
        assertEquals(List.of("Asha", "Cy"), JdbcProblems.topScorers(conn, 2).stream().map(Student::name).toList());
    }
    @Test void average() throws SQLException {
        assertTrue(JdbcProblems.averageMarks(conn).isEmpty());
        seed();
        assertEquals(78.75, JdbcProblems.averageMarks(conn).getAsDouble(), 1e-9);
    }
    @Test void parameterisedLookupNeutralisesInjection() throws SQLException {
        seed();
        assertEquals(1, JdbcProblems.findByName(conn, "Bo").size());
        assertTrue(JdbcProblems.findByName(conn, "x' OR '1'='1").isEmpty());
    }
    @Test void bonusesCommitTogether() throws SQLException {
        seed();
        JdbcProblems.applyBonuses(conn, Map.of(2, 5, 4, 10));
        assertEquals(80, JdbcProblems.findByName(conn, "Bo").get(0).marks());
        assertEquals(70, JdbcProblems.findByName(conn, "Di").get(0).marks());
    }
    @Test void bonusesRollBackOnFailure() throws SQLException {
        seed();
        // student 99 does not exist -> the whole batch must be undone, including the valid update for id 2
        Map<Integer, Integer> bonuses = new java.util.LinkedHashMap<>();
        bonuses.put(2, 5);
        bonuses.put(99, 1);
        assertThrows(SQLException.class, () -> JdbcProblems.applyBonuses(conn, bonuses));
        assertEquals(75, JdbcProblems.findByName(conn, "Bo").get(0).marks());
        assertTrue(conn.getAutoCommit());
    }
}
