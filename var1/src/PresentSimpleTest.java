import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PresentSimpleTest {
    public static void main(String[] args) {
        Map<String, String> questions = createQuestions();
        int totalQuestions = questions.size();
        int correctAnswers = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Present Simple Test!");
        System.out.println("Answer the following 5 questions by entering the corresponding letter (a, b, c, or d).");
        System.out.println("Enter 'q' at any time to quit.");

        for (Map.Entry<String, String> entry : questions.entrySet()) {
            String question = entry.getKey();
            String answer = entry.getValue();

            System.out.println("\n" + question);

            String userAnswer;
            while (true) {
                System.out.print("Your answer: ");
                userAnswer = scanner.nextLine();

                if (userAnswer.equals("q")) {
                    System.out.println("Test aborted.");
                    return;
                } else if (userAnswer.matches("[a-d]")) {
                    break;
                } else {
                    System.out.println("Invalid option. Please enter a valid answer (a, b, c, or d).");
                }
            }

            if (userAnswer.equals(answer)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.println("Incorrect!");
                System.out.println("The correct answer is: " + answer);
            }
        }

        double score = (double) correctAnswers / totalQuestions * 100;
        System.out.println("\nTest completed!");
        System.out.println("Your score: " + score + "%");

        System.out.print("Enter password to view correct answers (or 'q' to quit): ");
        String password = scanner.nextLine();
        if (password.equals("q")) {
            System.out.println("Program terminated.");
        } else if (password.equals("1111")) {
            System.out.println("\nCorrect answers:");
            for (Map.Entry<String, String> entry : questions.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        } else {
            System.out.println("Invalid password. Program terminated.");
        }
    }

    private static Map<String, String> createQuestions() {
        Map<String, String> questions = new HashMap<>();
        questions.put("1. Choose the correct form of the verb: I _______ basketball every Sunday.",
                "b");
        questions.put("a) plays\nb) play\nc) played\nd) will play", "b");
        questions.put("2. He _______ a car to work every day.",
                "d");
        questions.put("a) drives\nb) drove\nc) driving\nd) will drive", "a");
        questions.put("3. My sister _______ at a bank.",
                "a");
        questions.put("a) works\nb) work\nc) worked\nd) will work", "a");
        questions.put("4. They _______ soccer on weekends.",
                "c");
        questions.put("a) plays\nb) played\nc) play\nd) will play", "c");
        questions.put("5. The train _______ at 6 PM.",
                "b");
        questions.put("a) arrives\nb) arrived\nc) arriving\nd) will arrive", "a");
        return questions;
    }
}
