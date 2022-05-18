/**
 * The Letter class represents a single letter that will be used in the game
 * Each letter has an accompanying integer label that determines whether if it is used within the mystery word
 * @author gsotelo
 */

public class Letter {
    private char letter;
    private int label;
    private final int UNSET = 0;
    private final int UNUSED = 1;
    private final int USED = 2;
    private final int CORRECT = 3;

    /**
     * Constructor sets letter to equal the char taken as a parameter and sets the label to unset
     */
    public Letter(char c) {
        letter = c;
        label = 0;
    }

    /**
     * Compares whether two objects are of the Letter class and if they are equal
     * @param otherObject An object of any class
     * @return false if objects are not of same class, true if objects are same class and same content
     */
    public boolean equals(Object otherObject) {

        if (this.getClass() == otherObject.getClass()) {
            return this.letter == ((Letter) otherObject).letter;
        } else
            return false;
    }

    /**
     * Shows the significance of the character in relation to the mystery word
     * @return a symbol based on whether the letter is unused, used, or correct
     */
    public String decorator() {
        switch (label) {
            case UNUSED:
                return "-";
            case USED:
                return "+";
            case CORRECT:
                return "!";
            default:
                return " ";
        }
    }

    /**
     * Overrides the default toString method to display a formatted letter
     * @return the letter surrounded by decorators on each side
     */
    public String toString() {
        return decorator() + letter + decorator();
    }

    /**
     * Sets label of letter to be unused
     */
    public void setUnused() {
        label = UNUSED;
    }

    /**
     * Sets label of letter to be used
     */
    public void setUsed() {
        label = USED;
    }

    /**
     * Sets label of letter to be correct
     */
    public void setCorrect() {
        label = CORRECT;
    }

    /**
     * Checks whether letter is unused in the mystery word
     * @return true if letter is unused, false otherwise
     */
    public boolean isUnused() {
        return label == UNUSED;
    }

    /**
     * Creates an array containing each letter from a word
     * @param s any word of type String
     * @return an array of letters generated from the parameter s
     */
    public static Letter[] fromString(String s) {
        Letter[] letterArray = new Letter[s.length()];

        for (int i = 0; i < s.length(); i++) {
            letterArray[i] = new Letter(s.charAt(i));
        }
        return letterArray;
    }
}