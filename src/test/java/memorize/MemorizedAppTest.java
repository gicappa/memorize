package memorize;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static java.nio.charset.StandardCharsets.UTF_8;
import static memorize.Answer.CORRECT;
import static org.assertj.core.api.Java6Assertions.assertThat;

class MemorizedAppTest {

    private App app;

    private final ByteArrayOutputStream stdout = new ByteArrayOutputStream();

    @AfterEach
    void after() {
        System.setOut(System.out);
    }

    @BeforeEach
    void before() {
        System.setOut(new PrintStream(stdout));
        ArrayList<Quiz> quizzes = new ArrayList<>();
        quizzes.add(new Quiz("Domanda?", "corretta"));
        app = new App(quizzes);
    }

    @Test
    void it_answers_correctly() {
        writeOnSystemIn("corretta");
        app.run();
        assertThat(stdout.toString()).isEqualTo("Domanda?\n> OK\n");
    }

    @Test
    void it_answers_wrongly() {
        writeOnSystemIn("errata");
        app.run();
        assertThat(stdout.toString()).isEqualTo("Domanda?\n> ERRORE\n");
    }

    @Test
    void it_return_result_ok_for_asking_correct_answer() {
        writeOnSystemIn("corretta");
        Answer answer = app.askQuiz(new Quiz("Domanda?", "corretta"));
        assertThat(answer).isEqualTo(CORRECT);

    }

    private void writeOnSystemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(UTF_8)));
        System.setIn(System.in);
    }
}
