/**
 * Subclass of the Letter class and allows things other than letters to be used in the game
 * @author gsotelo
 */

public class ExtendedLetter extends Letter{
    private String content;
    private int family;
    private boolean related;
    private final int SINGLETON = -1;

    /**
     * Constructor for extended letter taking parameter s of type String
     * @param s any String
     */
    public ExtendedLetter(String s) {
        super('c');
        content = s;
        related = false;
        family = SINGLETON;
    }

    /**
     * Constructor for extended letter taking parameter s of type String and parameter fam of type int
     * @param s any String
     * @param fam an int representing the family this letter belongs to
     */
    public ExtendedLetter(String s, int fam) {
        super('c');
        content = s;
        related = false;
        family = fam;
    }

    /**
     * Checks if letters have the same family and content
     * @param other An object for this ExtendedLetter to be compared to
     * @return true if content of this ExtendedLetter matches object, false otherwise
     */
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        } else {
            if (this.family == ((ExtendedLetter) other).family) {
                this.related = true;
            }

            return this.content.equals(((ExtendedLetter) other).content);
        }
    }

    /**
     * Overrides toString in Letter to display formatted ExtendedLetter
     * @return content surrounded by "." if unused, content surrounded by appropriate decorators otherwise
     */
    public String toString() {
        String c = this.content;

        if (super.isUnused() && related) {
            return "." + c + ".";
        } else
            return decorator() + c + decorator();
    }

    /**
     * Creates an array of class Letter representing the word
     * @param content a String array of letters in the word
     * @param codes an int array of the codes
     * @return an array of type Letter
     */
    public static Letter[] fromStrings(String[] content, int[] codes) {
        Letter[] letters = new Letter[content.length];

        for (int i = 0; i < content.length; i++) {
            if (codes != null) {
                letters[i] = new ExtendedLetter(content[i], codes[i]);
            } else {
                letters[i] = new ExtendedLetter(content[i]);
            }
        }

        return letters;
    }
}
