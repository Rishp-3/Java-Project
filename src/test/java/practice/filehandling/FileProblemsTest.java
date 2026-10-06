package practice.filehandling;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileProblemsTest {
    @TempDir Path dir;

    @Test void writeThenRead() throws IOException {
        Path f = dir.resolve("a.txt");
        FileProblems.writeLines(f, List.of("one", "two"));
        assertEquals(List.of("one", "two"), FileProblems.readLines(f));
        FileProblems.writeLines(f, List.of("only"));
        assertEquals(List.of("only"), FileProblems.readLines(f));
    }
    @Test void appendCreatesAndExtends() throws IOException {
        Path f = dir.resolve("log.txt");
        FileProblems.appendLine(f, "first");
        FileProblems.appendLine(f, "second");
        assertEquals(List.of("first", "second"), FileProblems.readLines(f));
    }
    @Test void wordCountAndLongestLine() throws IOException {
        Path f = dir.resolve("w.txt");
        FileProblems.writeLines(f, List.of("hello big world", "", "  hi  ", "short"));
        assertEquals(5, FileProblems.countWords(f));
        assertEquals("hello big world", FileProblems.longestLine(f));
    }
    @Test void properties() throws IOException {
        Path f = dir.resolve("app.properties");
        FileProblems.writeLines(f, List.of("# comment", "name = Rishabh", "", "lang=Java", "bad line"));
        assertEquals(Map.of("name", "Rishabh", "lang", "Java"), FileProblems.readProperties(f));
    }
    @Test void missingFileThrows() {
        assertThrows(NoSuchFileException.class, () -> FileProblems.readLines(dir.resolve("nope.txt")));
    }
}
