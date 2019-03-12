package memorize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class TranslatorTest {

    private Translator translator;

    @BeforeEach
    void before() {
        var dictionary = new Hashtable<String, String>();
        dictionary.put("word", "parola");

        translator = new DefaultTranslator(dictionary);
    }

    // selectTerm . displayTerm . readTranslation . displayResult

    @Test
    void it_translates_a_word() {
        assertThat(translator.translate("word")).isEqualTo(Optional.of("parola"));
    }

    @Test
    void it_returns_an_optional_empty_when_the_world_is_not_present() {
        assertThat(translator.translate("not_there")).isEqualTo(Optional.empty());
    }
}
