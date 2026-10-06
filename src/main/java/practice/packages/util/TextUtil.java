package practice.packages.util;

/** Module 07 - Packages: public API plus a package-private helper hidden from other packages. */
public final class TextUtil {
    private TextUtil() {}

    /** Problem 1: capitalise the first letter of every word. */
    public static String titleCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (String w : normalize(s).split(" ")) {
            if (w.isEmpty()) continue;
            if (sb.length() > 0) sb.append(' ');
            sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1).toLowerCase());
        }
        return sb.toString();
    }

    /** Problem 2: URL-friendly slug ("Hello, World!" -> "hello-world"). */
    public static String slugify(String s) {
        return normalize(s).toLowerCase().replaceAll("[^a-z0-9 ]", "").trim().replace(' ', '-');
    }

    /** Problem 3 (package-private on purpose): trim and collapse repeated whitespace. */
    static String normalize(String s) {
        return s.trim().replaceAll("\\s+", " ");
    }

    // 'protected' and 'private' members are not visible to other packages either - try it from another package!
}
