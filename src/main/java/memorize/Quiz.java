package memorize;

class Quiz {
    private final String question;
    private final String answer;

    Quiz(String question, String answer) {
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
