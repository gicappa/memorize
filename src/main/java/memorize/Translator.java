package memorize;

import java.util.Dictionary;
import java.util.Optional;

public class Translator {

    private final Dictionary<String, String> dictionary;

    public Translator(Dictionary<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public Optional<String> translate(String word) {
        return Optional.ofNullable(dictionary.get(word));
    }
}
