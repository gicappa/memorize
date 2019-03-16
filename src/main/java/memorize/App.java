package memorize;

import java.util.Scanner;

import static java.lang.System.exit;

public class App {

    public static void main(String[] args) {
        try {
            new App().run();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            exit(1);
        }
    }

    void run() {
        Quitz quitz = getQuitz();
        displayQuestion(quitz.getQuestion());
        String answer = getUserAnswer();

        if (quitz.isCorrect(answer)) {
            displaySuccess();
        } else {
            displayFailure();
        }
    }

    private Quitz getQuitz() {
        return new Quitz("Domanda?", "corretta");
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
