package practice.projects.student;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
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

class JdbcStudentRepositoryTest {
    private Connection conn;
    private StudentRepository repo;

    @BeforeEach void setUp() throws SQLException {
        conn = DriverManager.getConnection("jdbc:h2:mem:" + UUID.randomUUID(), "sa", "");
        repo = new JdbcStudentRepository(conn);
    }
    @AfterEach void tearDown() throws SQLException { conn.close(); }

    @Test void addAssignsIds() {
        Student a = repo.add("Asha", 21, 90);
        Student b = repo.add("Bo", 22, 70.5);
        assertEquals(a.id() + 1, b.id());
        assertEquals(List.of(a, b), repo.findAll());
    }
    @Test void findByIdAndMissing() {
        Student a = repo.add("Asha", 21, 90);
        assertEquals(a, repo.findById(a.id()).orElseThrow());
        assertTrue(repo.findById(999).isEmpty());
    }
    @Test void searchIsCaseInsensitive() {
        repo.add("Rishabh", 22, 88);
        repo.add("Aman", 23, 76);
        assertEquals(1, repo.searchByName("RISH").size());
        assertEquals(2, repo.searchByName("a").size());
        assertTrue(repo.searchByName("zzz").isEmpty());
    }
    @Test void updateAndDelete() {
        Student a = repo.add("Asha", 21, 90);
        assertTrue(repo.updateMarks(a.id(), 95));
        assertEquals(95, repo.findById(a.id()).orElseThrow().marks(), 1e-9);
        assertFalse(repo.updateMarks(999, 1));
        assertTrue(repo.delete(a.id()));
        assertFalse(repo.delete(a.id()));
        assertTrue(repo.findAll().isEmpty());
    }
    @Test void injectionAttemptIsJustText() {
        repo.add("x'); DROP TABLE students; --", 1, 1);
        assertEquals(1, repo.findAll().size());
    }

    /** The point of persistence: close the connection, reopen the same file, and the data is still there. */
    @Test void dataSurvivesReconnect(@TempDir Path dir) throws SQLException, IOException {
        String url = "jdbc:h2:file:" + dir.resolve("students");
        try (Connection c1 = DriverManager.getConnection(url, "sa", "")) {
            new JdbcStudentRepository(c1).add("Persistent", 20, 99);
        }
        try (Connection c2 = DriverManager.getConnection(url, "sa", "")) {
            List<Student> all = new JdbcStudentRepository(c2).findAll();
            assertEquals(1, all.size());
            assertEquals("Persistent", all.get(0).name());
        }
    }
}
