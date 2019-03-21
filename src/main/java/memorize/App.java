package memorize;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 * Entry point for the whole application.
 * The journey starts here.
 */
public class App {

    private final ArrayList<Quiz> quizzes;

    /**
     * Main method where the application starts.
     *
     * @param args list of arguments.
     */
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

    /**
     * Constructor of the main app
     *
     * @param quizzes list of quizzes as a parameter
     */
    App(ArrayList<Quiz> quizzes) {
        this.quizzes = quizzes;
    }


    /**
     * starting all the things
     */
    void run() {
        for (Quiz quiz : quizzes) {
            askQuiz(quiz);
        }
    }

    /**
     * Single quiz question
     *
     * @param quiz the quiz to be asked
     */
    void askQuiz(Quiz quiz) {
        displayQuestion(quiz.getDescription());
        String answer = getUserAnswer();

        if (quiz.isCorrect(answer)) {
            displaySuccess();
        } else {
            displayFailure();
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
