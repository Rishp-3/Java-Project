package practice.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Module 24 - Regex: Pattern and Matcher. */
public final class RegexProblems {
    private RegexProblems() {}

    // Patterns are compiled once and reused - compiling inside a loop is slow.
    private static final Pattern EMAIL = Pattern.compile("^[\\w.+-]+@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*\\.[A-Za-z]{2,}$");
    private static final Pattern NUMBER = Pattern.compile("-?\\d+(?:\\.\\d+)?");
    private static final Pattern HASHTAG = Pattern.compile("(?<![\\w#])#([A-Za-z][\\w]*)");
    private static final Pattern PHONE = Pattern.compile("^(\\+91[- ]?)?[6-9]\\d{9}$");

    /** Problem 1: simple email validation. */
    public static boolean isValidEmail(String s) {
        return s != null && EMAIL.matcher(s).matches();
    }

    /** Problem 2: pull every number (integers, decimals, negatives) out of a sentence. */
    public static List<Double> extractNumbers(String text) {
        List<Double> out = new ArrayList<>();
        Matcher m = NUMBER.matcher(text);
        while (m.find()) out.add(Double.parseDouble(m.group()));
        return out;
    }

    /** Problem 3: hashtags without the '#', in order of appearance. */
    public static List<String> hashtags(String text) {
        List<String> out = new ArrayList<>();
        Matcher m = HASHTAG.matcher(text);
        while (m.find()) out.add(m.group(1));
        return out;
    }

    /** Problem 4: Indian mobile number, optional +91 prefix. */
    public static boolean isIndianMobile(String s) {
        return PHONE.matcher(s).matches();
    }

    /** Problem 5: password strength: 8+ chars with lower, upper, digit and a symbol (lookaheads). */
    public static boolean isStrongPassword(String s) {
        return s.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$");
    }

    /** Problem 6: mask all but the last 4 digits of a card-like number, keeping separators. */
    public static String maskDigits(String s) {
        return s.replaceAll("\\d(?=(?:\\D*\\d){4})", "*");
    }

    /** Problem 7: reformat a date from yyyy-MM-dd to dd/MM/yyyy using capture groups. */
    public static String isoToDayFirst(String text) {
        return text.replaceAll("(\\d{4})-(\\d{2})-(\\d{2})", "$3/$2/$1");
    }
}
