package practice.projects.student;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class StudentAppTest {
    @Test void menuFlowAddsViewsAndExits() throws Exception {
        PrintStream original = System.out;
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captured));
        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:" + UUID.randomUUID(), "sa", "")) {
            JdbcStudentRepository repo = new JdbcStudentRepository(conn);
            String script = String.join("\n", "1", "Asha", "21", "90", "abc", "2", "6") + "\n";
            StudentApp.run(repo, new Scanner(script));
            assertEquals(1, repo.findAll().size());
        } finally {
            System.setOut(original);
        }
        String out = captured.toString();
        assertTrue(out.contains("Added: Student[id=1, name=Asha"));
        assertTrue(out.contains("Please enter a valid number.") || out.contains("Invalid option."));
        assertTrue(out.contains("Bye!"));
    }
}
