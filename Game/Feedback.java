package Game;

public enum Feedback {
    GREEN("!"),
    YELLOW("?"),
    GREY("-");
    
    final String symbol;

    private Feedback(final String symbol) {
        this.symbol = symbol;
    }
}
