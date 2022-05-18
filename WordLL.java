public class WordLL {
    private Word mysteryWord;
    private LinearNode<Word> history;

    public WordLL(Word mystery) {
        LinearNode<Word> history = null;
        mysteryWord = mystery;
    }

    public boolean tryWord(Word guess) {
        LinearNode<Word> guessNode;

        guess.labelWord(mysteryWord);
        guessNode = new LinearNode<Word>(guess);
        guessNode.setNext(history);
        history = guessNode;

        return guess.labelWord(mysteryWord);
    }

    public String toString() {
        String guesses = "";

        while (history != null) {
            guesses += history.getElement().toString() + "\n";
            history = history.getNext();
        }

        return guesses;
    }
}