package memorize;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class App {

    private final ArrayList<Quiz> quizzes;

    public static void main(String[] args) {
        try {
            var quizzes = new ArrayList<Quiz>();
            quizzes.add(new Quiz("Domanda?", "corretta"));

            new App(quizzes).run();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            exit(1);
        }
    }

    App(ArrayList<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    void run() {
        for (Quiz quiz : quizzes) {
            displayQuestion(quiz.getQuestion());
            String answer = getUserAnswer();

            if (quiz.isCorrect(answer)) {
                displaySuccess();
            } else {
                displayFailure();
            }

        }
    }

    private void displayQuestion(String question) {
        System.out.println(question);
    }

    private String getUserAnswer() {
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void displayFailure() {
        System.out.println("ERRORE");
    }

    private void displaySuccess() {
        System.out.println("OK");
    }

}
