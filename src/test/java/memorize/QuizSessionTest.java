package memorize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;
import static memorize.Result.CORRECT;
import static org.assertj.core.api.Java6Assertions.assertThat;

class QuizSessionTest {

    private QuizSession quizSession;

    @BeforeEach
    void before() {
        ArrayList<Quiz> quizzes = new ArrayList<>();
        quizzes.add(new Quiz("Domanda?", "corretta"));
        quizSession = new QuizSession();
    }

    @Test
    void it_return_result_ok_for_asking_correct_answer() {
        writeOnSystemIn("corretta");
        Result answer = quizSession.askQuiz(new Quiz("Domanda?", "corretta"));
        assertThat(answer).isEqualTo(CORRECT);

    }
    private void writeOnSystemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(UTF_8)));
        System.setIn(System.in);
    }
}
