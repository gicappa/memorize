package memorize;

import java.util.Optional;

@FunctionalInterface
public interface Translator {
    Optional<String> translate(String word);
}
