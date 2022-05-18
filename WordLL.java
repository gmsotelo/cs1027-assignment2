/**
 * Stores the mystery word and history of all guessed words so far
 * @author gsotelo
 */

public class WordLL {
    private Word mysteryWord;
    private LinearNode<Word> history;

    /**
     * Constructor initializes empty linked list
     * @param mystery the mystery word all guesses will be compared to
     */
    public WordLL(Word mystery) {
        history = new LinearNode<Word>();
        mysteryWord = mystery;
    }

    /**
     * Boolean that takes and stores each guess in a linked list
     * @param guess guessed word that will be compared to mystery word
     * @return true if guess is identical in order and content to mystery word, false otherwise
     */
    public boolean tryWord(Word guess) {
        guess.labelWord(mysteryWord);
        LinearNode<Word> guessNode = new LinearNode<Word>(guess);
        guessNode.setNext(history.getNext());
        history.setNext(guessNode);

        return guess.labelWord(mysteryWord);
    }

    /**
     * Overrides default toString to list all guesses so far
     * @return a string listing every guessed word
     */
    public String toString() {
        LinearNode<Word> node = history;
        String guesses = "";

        while (node != null) {
            if (node.getElement() != null) {
                guesses += node.getElement() + "\n";
            }
            node = node.getNext();
        }

        return guesses;
    }
}