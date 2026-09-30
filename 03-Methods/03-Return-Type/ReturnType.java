public class ReturnType {

    // void: returns nothing
    static void printMessage() {
        System.out.println("This method returns nothing (void).");
    }

    // returns a primitive
    static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    // returns a String
    static String getGrade(int marks) {
        if (marks >= 90) return "A";
        if (marks >= 75) return "B";
        if (marks >= 50) return "C";
        return "F";
    }

    // returns an array
    static int[] getFirstThreeSquares() {
        return new int[] { 1, 4, 9 };
    }

    // a method can have multiple return statements, but only one executes
    static String checkNumber(int n) {
        if (n > 0) return "Positive";
        if (n < 0) return "Negative";
        return "Zero";
    }

    public static void main(String[] args) {
        printMessage();

        System.out.println("Area = " + calculateArea(5));
        System.out.println("Grade = " + getGrade(82));

        int[] squares = getFirstThreeSquares();
        for (int s : squares) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println(checkNumber(-5));
    }
}
