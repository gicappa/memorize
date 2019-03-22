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
            display(askQuiz(quiz).toString());
        }
    }

    /**
     * Single quiz question
     *
     * @param quiz the quiz to be asked
     */
    Result askQuiz(Quiz quiz) {
        display(quiz.getDescription());

        return quiz.validate(readInput());
    }

    private void display(String question) {
        System.out.println(question);
    }

    private String readInput() {
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
