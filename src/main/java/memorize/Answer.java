package memorize;

enum Answer {
    CORRECT("OK"), WRONG("ERRORE");

    private final String description;

    Answer(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
