/**
 * Java Comments Practice
 */
public class Comments {

    public static void main(String[] args) {

        // ==============================
        // 1. Single-Line Comment
        // ==============================

        // This is a single-line comment
        System.out.println("Hello Java");


        // ==============================
        // 2. Comment After Code
        // ==============================

        int age = 20; // Student age
        System.out.println("Age: " + age);


        // ==============================
        // 3. Multi-Line Comment
        // ==============================

        /*
         * This is a multi-line comment.
         * It can contain multiple lines.
         */

        System.out.println("Multi-line comment example");


        // ==============================
        // 4. Documentation Comment
        // ==============================

        /**
         * Documentation comments are
         * used for Javadoc documentation.
         */

        System.out.println("Documentation comment example");


        // ==============================
        // 5. Temporarily Disable Code
        // ==============================

        // System.out.println("This line is disabled");

        System.out.println("This line is active");


        // ==============================
        // 6. Practice
        // ==============================

        String name = "Rishabh";
        int marks = 85;

        // Check whether student passed
        boolean passed = marks >= 40;

        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Passed: " + passed);
    }
}