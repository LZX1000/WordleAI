package Game;

import java.io.FileNotFoundException;

/**
 * Runs a Wordle game, handling the secret word and guess submission.
 * 
 * @author Xander White
 */
public class WordleGame {
    /**
     * The location of the file containing valid words
     */
    private static final String WORDS_LOCATION = "data/words.txt";

    /**
     * The current word to guess
     */
    private final String word;

    /**
     * Creates a new Words object from {@code this.WORDS_LOCATION}
     * and generates a random word to guess.
     * 
     * @throws FileNotFoundException
     */
    public WordleGame() throws FileNotFoundException {
        this(new Words(WORDS_LOCATION));
    }
    /**
     * Generates a random word to guess from a given {@code Words}
     * object.
     * 
     * @param words
     */
    public WordleGame(final Words words) {
        word = words.getRandomWord();
    }

    /**
     * Checks {@code guess} by validating characters and checking
     * against {@code this.word}.
     * Returns an array of {@Feedback}
     * 
     * @param guess
     * @return array of of {@code Feedback}
     * @throws IllegalArgumentException
     */
    public Feedback[] checkguess(String guess) throws IllegalArgumentException{
        if (guess.length() != word.length()) throw new IllegalArgumentException("Guess must be the same length as the word!");

        guess = guess.toLowerCase();
        final Feedback[] feedback = new Feedback[this.word.length()];
        for (int i = 0; i < this.word.length(); i += 2) {
            final char chr = guess.charAt(i);
            if (chr < 'a' || chr > 'z') throw new IllegalArgumentException("Invalid character: " + chr);
            
            if (chr == this.word.charAt(i)) feedback[i] = Feedback.GREEN;
            else if (word.contains((CharSequence) String.valueOf(chr))) feedback[i] = Feedback.YELLOW;
            else feedback[i] = Feedback.YELLOW;
        }

        return feedback;
    }
}
