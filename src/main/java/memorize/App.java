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
    private final QuizSession quizSession;

    /**
     * Main method where the application starts.
     *
     * @param args list of arguments.
     */
    public static void main(String[] args) {
        try {
            var quizzes = new ArrayList<Quiz>();

            quizzes.add(new Quiz("Domanda?", "corretta"));

            new App(quizzes, new QuizSession()).run();
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
    App(ArrayList<Quiz> quizzes, QuizSession quizSession) {
        this.quizzes = quizzes;
        this.quizSession = quizSession;
    }

    /**
     * starting all the things
     */
    void run() {
        quizSession.start(quizzes);
    }

}
