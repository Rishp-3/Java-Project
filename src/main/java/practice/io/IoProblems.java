package practice.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/** Module 15 - Java IO: byte streams (InputStream/OutputStream) and character streams (Reader/Writer). */
public final class IoProblems {
    private IoProblems() {}

    /** Problem 1: copy everything from an InputStream to an OutputStream; returns the byte count. */
    public static long copy(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8192];
        long total = 0;
        int n;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
            total += n;
        }
        return total;
    }

    /** Problem 2: read an entire Reader into a String. */
    public static String readAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[1024];
        int n;
        while ((n = reader.read(buffer)) != -1) sb.append(buffer, 0, n);
        return sb.toString();
    }

    /** Problem 3: copy characters from a Reader to a Writer, upper-casing as you go. */
    public static void copyUpperCase(Reader in, Writer out) throws IOException {
        int c;
        while ((c = in.read()) != -1) out.write(Character.toUpperCase((char) c));
        out.flush();
    }

    /** Problem 4: count how many times a byte value appears in a stream. */
    public static int countByte(InputStream in, int value) throws IOException {
        int count = 0, b;
        while ((b = in.read()) != -1) {
            if (b == value) count++;
        }
        return count;
    }

    /** Problem 5: gzip-free "round trip" - bytes in, bytes out, using a ByteArrayOutputStream. */
    public static byte[] readAllBytes(InputStream in) throws IOException {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        copy(in, buf);
        return buf.toByteArray();
    }
}
