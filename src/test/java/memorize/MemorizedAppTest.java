package memorize;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class MemorizedAppTest {

    private App app;

    private final ByteArrayOutputStream stdout = new ByteArrayOutputStream();

    @AfterEach
    public void after() {
        System.setOut(System.out);
    }

    @BeforeEach
    public void before() {
        System.setOut(new PrintStream(stdout));
        app = new App();
    }

    @Test
    public void it_asks_for_a_question() {
        writeOnSystemIn("corretta");
        app.run();
        assertThat(stdout.toString()).isEqualTo("Domanda?\n> OK\n");
    }

    private void writeOnSystemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(UTF_8)));
        System.setIn(System.in);
    }
}
