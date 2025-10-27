package Game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Handles RNG and storage of a list of Words
 * 
 * @author Xander White
 */
public class Words {
    /**
     * Instance of Random to use for RNG
     */
    private final Random random = new Random();

    /**
     * List of all contained words
     */
    private final List<String> words;

    /**
     * Creates a new instance of {@code Words} to handle the
     * word list for a Wordle game.
     * 
     * @param filename
     * @throws FileNotFoundException
     */
    public Words(final String filename) throws FileNotFoundException {
        this.words = readWords(filename);
    }

    /**
     * Reads words line by line from a words file.
     * 
     * @param filename file location
     * @return {@code ArrayList} of all words
     * @throws FileNotFoundException
     */
    private static List<String> readWords(final String filename) throws FileNotFoundException {
        final List<String> words = new ArrayList<>();

        try(Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNext()) {
                words.add(scanner.nextLine().trim().toLowerCase());
            }
        }

        return words;
    }

    /**
     * Returns a random word from the word list.
     * 
     * @return random word
     */
    public String getRandomWord() { return words.get(random.nextInt(words.size())); }
}
