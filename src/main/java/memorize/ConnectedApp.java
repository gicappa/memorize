package memorize;

import java.util.Scanner;

import static java.lang.System.exit;

public class ConnectedApp {

    public static void main(String[] args) {
        try {
            new ConnectedApp(args).run();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            exit(1);
        }
    }

    private ConnectedApp(String[] args) {
    }

    private void run() {
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
        return new Quitz("Risposta corretta?", "corretta");
    }

    private void displayQuestion(String question) {
        System.out.println(question);
    }

    private String getUserAnswer() {
        System.out.print("Risposta: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void displayFailure() {
        System.out.println("ERRORE");
    }

    private void displaySuccess() {
        System.out.println("OK!");
    }

}
