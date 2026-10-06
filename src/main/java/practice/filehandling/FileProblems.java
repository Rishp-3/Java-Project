package practice.filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/** Module 14 - File Handling: reading, writing, appending with java.nio.file and try-with-resources. */
public final class FileProblems {
    private FileProblems() {}

    /** Problem 1: write lines to a file (replacing any old content). */
    public static void writeLines(Path file, List<String> lines) throws IOException {
        Files.write(file, lines, StandardCharsets.UTF_8);
    }

    /** Problem 2: read every line with a BufferedReader. */
    public static List<String> readLines(Path file) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            return reader.lines().toList();
        }
    }

    /** Problem 3: append one line, creating the file if it does not exist. */
    public static void appendLine(Path file, String line) throws IOException {
        try (BufferedWriter w = Files.newBufferedWriter(file, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            w.write(line);
            w.newLine();
        }
    }

    /** Problem 4: count words in a file. */
    public static int countWords(Path file) throws IOException {
        int count = 0;
        for (String line : readLines(file)) {
            String t = line.trim();
            if (!t.isEmpty()) count += t.split("\\s+").length;
        }
        return count;
    }

    /** Problem 5: the longest line, or empty text for an empty file. */
    public static String longestLine(Path file) throws IOException {
        String best = "";
        for (String line : readLines(file)) {
            if (line.length() > best.length()) best = line;
        }
        return best;
    }

    /** Problem 6: parse "key=value" lines into a sorted map, ignoring blank lines and # comments. */
    public static Map<String, String> readProperties(Path file) throws IOException {
        Map<String, String> map = new TreeMap<>();
        for (String line : readLines(file)) {
            String t = line.trim();
            if (t.isEmpty() || t.startsWith("#")) continue;
            int eq = t.indexOf('=');
            if (eq > 0) map.put(t.substring(0, eq).trim(), t.substring(eq + 1).trim());
        }
        return map;
    }
}
