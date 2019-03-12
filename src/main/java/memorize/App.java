package memorize;

import java.util.Hashtable;
import java.util.Optional;

public class App implements Runnable {

    private final TermChooser tc;
    private final Translator tr;

    public static void main(String... args) {

        var dict = new Hashtable<String, String>();
        var tr = new DefaultTranslator(dict);

        var tc = new TermChooser() {
            @Override
            public String chooseTerm() {
                return null;
            }
        };

        var app = new App(tc, tr);
        app.run();
    }

    private App(TermChooser tc, Translator tr) {
        this.tc = tc;
        this.tr = tr;
    }

    @Override
    public void run() {
//        Optional.of(tc::chooseTerm)
//                .flatMap(tr::translate).get();
    }

    private String displayTerm(String term) {
        System.out.println(term);
        return term;
    }
}
