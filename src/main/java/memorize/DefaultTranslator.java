package memorize;

import java.util.Dictionary;
import java.util.Optional;

class DefaultTranslator implements Translator {

    private final Dictionary<String, String> dictionary;

    DefaultTranslator(Dictionary<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public Optional<String> translate(String word) {
        return Optional.ofNullable(dictionary.get(word));
    }
}
