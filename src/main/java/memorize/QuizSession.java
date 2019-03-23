package memorize;

import java.util.List;
import java.util.Scanner;

class QuizSession {

    /**
     *  This method will start the session of quizzes;
     *
     * @param quizzes to be submitted to the user
     */
    void start(List<Quiz> quizzes) {
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

        return quiz.validate(readUserInput());
    }

    /**
     * Display the message to the user
     *
     * @param message the message to be displayed
     */
    private void display(String message) {
        System.out.println(message);
    }

    /**
     * Read the input from the standard input
     *
     * @return the input from the user
     */
    private String readUserInput() {
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
