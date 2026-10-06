package practice.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class IoProblemsTest {
    @Test void copyReportsByteCount() throws IOException {
        byte[] data = new byte[20_000];
        for (int i = 0; i < data.length; i++) data[i] = (byte) i;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        assertEquals(20_000, IoProblems.copy(new ByteArrayInputStream(data), out));
        assertArrayEquals(data, out.toByteArray());
    }
    @Test void readAll() throws IOException {
        assertEquals("héllo\nworld", IoProblems.readAll(new StringReader("héllo\nworld")));
        assertEquals("", IoProblems.readAll(new StringReader("")));
    }
    @Test void upperCaseCopy() throws IOException {
        StringWriter out = new StringWriter();
        IoProblems.copyUpperCase(new StringReader("Hello, Java 17!"), out);
        assertEquals("HELLO, JAVA 17!", out.toString());
    }
    @Test void countByte() throws IOException {
        assertEquals(3, IoProblems.countByte(new ByteArrayInputStream("banana".getBytes(StandardCharsets.UTF_8)), 'a'));
    }
    @Test void readAllBytes() throws IOException {
        byte[] data = {1, 2, 3};
        assertArrayEquals(data, IoProblems.readAllBytes(new ByteArrayInputStream(data)));
    }
}
