package memorize;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

import static org.assertj.core.api.Assertions.assertThat;

public class TranslatorTest {

    private Translator translator;

    @BeforeEach
    public void before() {
        Dictionary<String, String> dictionary = new Hashtable<>();
        dictionary.put("word", "parola");

        translator = new Translator(dictionary);
    }

    // selectTerm . displayTerm . readTranslation . displayResult

    @Test
    public void it_translates_a_word() {
        assertThat(translator.translate("word")).isEqualTo("parola");
    }
}
