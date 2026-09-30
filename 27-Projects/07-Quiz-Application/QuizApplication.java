import java.util.*;

// A console-based Quiz Application: presents multiple-choice questions and scores the user.
public class QuizApplication {

    record Question(String text, String[] options, int correctOption) {}

    static List<Question> questions = List.of(
        new Question("What is the size of an int in Java?",
            new String[]{"16 bits", "32 bits", "64 bits", "8 bits"}, 1),
        new Question("Which keyword is used to inherit a class?",
            new String[]{"implements", "extends", "inherits", "super"}, 1),
        new Question("Which collection does NOT allow duplicate elements?",
            new String[]{"ArrayList", "LinkedList", "HashSet", "Vector"}, 2),
        new Question("What does JVM stand for?",
            new String[]{"Java Virtual Machine", "Java Variable Method", "Java Verified Module", "Java Visual Machine"}, 0),
        new Question("Which method is the entry point of a Java program?",
            new String[]{"start()", "run()", "main()", "init()"}, 2)
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        System.out.println("=== Java Quiz ===");
        System.out.println("Answer by entering the option number (1-4).\n");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println((i + 1) + ". " + q.text());
            for (int j = 0; j < q.options().length; j++) {
                System.out.println("   " + (j + 1) + ". " + q.options()[j]);
            }

            System.out.print("Your answer: ");
            int answer;
            try {
                answer = Integer.parseInt(sc.nextLine().trim()) - 1;
            } catch (NumberFormatException e) {
                answer = -1;
            }

            if (answer == q.correctOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong. Correct answer: " + q.options()[q.correctOption()] + "\n");
            }
        }

        System.out.println("=== Quiz Complete ===");
        System.out.println("Your score: " + score + " / " + questions.size());
        double percentage = (score * 100.0) / questions.size();
        System.out.printf("Percentage: %.1f%%%n", percentage);

        sc.close();
    }
}
