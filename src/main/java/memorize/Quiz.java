package memorize;

/**
 * The abstraction of a quiz. It's composed by a question and
 * an answer. The quiz must be able to understand if a given
 * answer is correct for a certain question.
 */
class Quiz {
    private final String question;
    private final String answer;

    /**
     * To create a quiz is needed a question and an answer
     *
     * @param question the statement of the quiz to perform to the user
     * @param answer the correct answer to test the qiz against
     */

    Quiz(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * The description of the quiz is the question to perform
     * to the user
     *
     * @return the description of the quiz
     */
    String getDescription() {
        return question;
    }

    /**
     * This method check if an external answer
     * @param userAnswer is the user answer
     * @return true if the answer is correct
     */
    boolean isCorrect(String userAnswer) {
        return answer.equalsIgnoreCase(userAnswer);
    }
}
