# Quiz Application

## 📌 Topic
Console quiz jisme questions options ke saath aate hain, answers check hote hain aur end me score aur grade milta hai.

## 🎯 What You Will Learn

- Question class aur arrays/List
- Answer check aur score
- Percentage aur grade
- Randomize (shuffle) questions

## 💻 Code

```java
import java.util.*;

class Question {
    final String text;
    final String[] options;
    final int correct;

    Question(String text, String[] options, int correct) {
        this.text = text;
        this.options = options;
        this.correct = correct;
    }
}

public class QuizApplication {

    static String grade(double percent) {
        if (percent >= 80) return "A";
        if (percent >= 60) return "B";
        if (percent >= 40) return "C";
        return "F";
    }

    public static void main(String[] args) {
        List<Question> quiz = new ArrayList<>();
        quiz.add(new Question("Java kisne banaya?", new String[]{"Microsoft", "Sun Microsystems", "Google", "Apple"}, 2));
        quiz.add(new Question("JVM ka full form?", new String[]{"Java Virtual Machine", "Java Variable Method", "Joint Virtual Memory", "None"}, 1));
        quiz.add(new Question("Kaun sa keyword inheritance ke liye hai?", new String[]{"implements", "extends", "import", "this"}, 2));
        quiz.add(new Question("String ek ___ hai.", new String[]{"primitive", "class", "keyword", "operator"}, 2));

        int[] userAnswers = {2, 1, 1, 2};
        int score = 0;

        for (int i = 0; i < quiz.size(); i++) {
            Question q = quiz.get(i);
            System.out.println("Q" + (i + 1) + ". " + q.text);
            for (int j = 0; j < q.options.length; j++) {
                System.out.println("   " + (j + 1) + ") " + q.options[j]);
            }
            int ans = userAnswers[i];
            if (ans == q.correct) {
                System.out.println("   Correct!");
                score++;
            } else {
                System.out.println("   Wrong. Correct answer: " + q.options[q.correct - 1]);
            }
        }

        double percent = score * 100.0 / quiz.size();
        System.out.println("Score: " + score + "/" + quiz.size());
        System.out.println("Percentage: " + percent + "%");
        System.out.println("Grade: " + grade(percent));
    }
}
```

> 💡 Note: Is project me demo ke liye values code me hi di gayi hain taaki output hamesha same aaye. Project ko aage `Scanner` se menu-driven banana tumhara practice task hai.

## 🧠 Explanation

### `Question`
Question text, options aur sahi option ka number (1 se start) rakhti hai.

### `userAnswers`
Demo ke liye answers code me hain. Asli quiz me `Scanner` se aate hain.

### `grade()`
Percentage se grade nikalta hai.

## ▶️ Output

```text
Q1. Java kisne banaya?
   1) Microsoft
   2) Sun Microsystems
   3) Google
   4) Apple
   Correct!
Q2. JVM ka full form?
   1) Java Virtual Machine
   2) Java Variable Method
   3) Joint Virtual Memory
   4) None
   Correct!
Q3. Kaun sa keyword inheritance ke liye hai?
   1) implements
   2) extends
   3) import
   4) this
   Wrong. Correct answer: extends
Q4. String ek ___ hai.
   1) primitive
   2) class
   3) keyword
   4) operator
   Correct!
Score: 3/4
Percentage: 75.0%
Grade: B
```

## 🔑 Important Points

- `Collections.shuffle(quiz)` se questions ka order random ho jata hai.
- Input validation zaroori hai: option 1 se 4 ke bahar na ho.
- Questions ko file/JSON se load karna project ko flexible banata hai.

## 📝 Practice

1. `Scanner` se user ke answers lo.
2. Questions ko shuffle karo.
3. Har question par timer lagao.
4. Highscore file me save karo.

## 🚀 Challenge

Quiz me categories (Java, DSA) banao aur user se category chunwao.
