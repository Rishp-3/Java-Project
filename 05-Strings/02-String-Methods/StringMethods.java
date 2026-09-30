public class StringMethods {
    public static void main(String[] args) {

        String text = "  Java Programming Language  ";

        System.out.println("Original: '" + text + "'");
        System.out.println("Trimmed: '" + text.trim() + "'");
        System.out.println("charAt(0): " + text.trim().charAt(0));
        System.out.println("indexOf('Programming'): " + text.indexOf("Programming"));
        System.out.println("contains('Java'): " + text.contains("Java"));
        System.out.println("replace('Java', 'Python'): " + text.replace("Java", "Python"));
        System.out.println("substring(2, 6): " + text.trim().substring(0, 4));
        System.out.println("startsWith('Java'): " + text.trim().startsWith("Java"));
        System.out.println("endsWith('Language'): " + text.trim().endsWith("Language"));

        String csv = "apple,banana,cherry";
        String[] fruits = csv.split(",");
        System.out.print("split(','): ");
        for (String fruit : fruits) {
            System.out.print(fruit + " | ");
        }
        System.out.println();

        String joined = String.join("-", fruits);
        System.out.println("String.join: " + joined);

        System.out.println("isEmpty on '': " + "".isEmpty());
        System.out.println("isBlank on '   ': " + "   ".isBlank());
        System.out.println("equalsIgnoreCase: " + "JAVA".equalsIgnoreCase("java"));
        System.out.println("compareTo: " + "apple".compareTo("banana"));

        // String.format / formatted output
        String formatted = String.format("Name: %s, Age: %d", "Rishabh", 22);
        System.out.println(formatted);
    }
}
