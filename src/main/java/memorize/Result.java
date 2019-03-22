package memorize;

enum Result {
    CORRECT("OK"), WRONG("ERRORE");

    private final String description;

    Result(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
