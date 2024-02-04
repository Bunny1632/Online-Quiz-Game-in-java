import java.util.Scanner;

public class QuizGame {
    private static final String[] questions = {
        "What is the capital of France?",
        "Which planet is known as the Red Planet?",
        "Who wrote 'Romeo and Juliet'?",
    };

    private static final String[] options = {
        "A. London\tB. Paris\tC. Berlin\tD. Rome",
        "A. Venus\tB. Mars\tC. Jupiter\tD. Saturn",
        "A. Charles Dickens\tB. Jane Austen\tC. William Shakespeare\tD. Mark Twain",
    };

    private static final char[] correctAnswers = {'B', 'B', 'C'};

    private static int score = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz Game!\n");

        for (int i = 0; i < questions.length; i++) {
            displayQuestion(i);
            char userAnswer = getUserAnswer(scanner);

            if (userAnswer == correctAnswers[i]) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswers[i] + ".\n");
            }
        }

        System.out.println("Quiz completed! Your final score is: " + score + " out of " + questions.length);

        scanner.close();
    }

    private static void displayQuestion(int index) {
        System.out.println("Question " + (index + 1) + ": " + questions[index]);
        System.out.println(options[index]);
    }

    private static char getUserAnswer(Scanner scanner) {
        char userAnswer = ' ';
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Your answer (A/B/C/D): ");
            String input = scanner.nextLine().toUpperCase();

            if (input.length() == 1 && "ABCD".contains(input)) {
                userAnswer = input.charAt(0);
                isValidInput = true;
            } else {
                System.out.println("Invalid input. Please enter A, B, C, or D.");
            }
        }

        return userAnswer;
    }
}
