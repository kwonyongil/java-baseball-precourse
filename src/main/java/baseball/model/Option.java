package baseball.model;

public enum Option {
    RESTART("1"), END("2");

    private final String option;

    Option(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
