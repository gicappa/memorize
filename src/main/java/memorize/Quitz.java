package memorize;

public class Quitz {
    private final String question;
    private final String answer;

    Quitz(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    String getQuestion() {
        return question;
    }

    boolean isCorrect(String userAnswer) {
        return answer.equalsIgnoreCase(userAnswer);
    }
}
