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
        String question = getQuestion();
        String correctAnswer = getResolution(question);
        displayQuestion(question);
        String answer = getUserAnswer();

        if (answer.equalsIgnoreCase(correctAnswer)) {
            displaySuccess();
        } else {
            displayFailure(correctAnswer);
        }
    }

    private String getQuestion() {
        return "Risposta corretta?";
    }

    private void displayQuestion(String question) {
        System.out.println(question);
    }

    private String getResolution(String question) {
        return "corretta";
    }

    private String getUserAnswer() {
        System.out.print("Risposta: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void displayFailure(String correctAnswer) {
        System.out.println("ERRORE: la risposta corretta è '" + correctAnswer + "'");
    }

    private void displaySuccess() {
        System.out.println("OK!");
    }

}
