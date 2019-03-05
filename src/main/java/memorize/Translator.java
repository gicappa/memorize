package memorize;

import java.util.Dictionary;

public class Translator {

    private final Dictionary<String, String> dictionary;

    public Translator(Dictionary<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public String translate(String word) {
        return dictionary.get(word);
    }
}
