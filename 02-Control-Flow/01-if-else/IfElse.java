import java.util.Scanner;

public class IfElse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your marks: ");
        int marks = sc.nextInt();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid marks");

        } else if (marks >= 90) {
            System.out.println("Grade: A+");

        } else if (marks >= 80) {
            System.out.println("Grade: A");

        } else if (marks >= 70) {
            System.out.println("Grade: B");

        } else if (marks >= 60) {
            System.out.println("Grade: C");

        } else if (marks >= 40) {
            System.out.println("Grade: D");

        } else {
            System.out.println("Grade: F - Fail");
        }

        sc.close();
    }
}
