public class Letter {
    private char letter;
    private int label;
    private final int UNSET = 0;
    private final int UNUSED = 1;
    private final int USED = 2;
    private final int CORRECT = 3;


    public Letter(char c) {
        letter = c;
        label = 0;
    }

    public boolean equals(Object otherObject) {

        if (this.getClass() == otherObject.getClass()) {
            return this.letter == ((Letter) otherObject).letter;
        } else
            return false;
    }

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

    public String toString() {
        return decorator() + letter + decorator();
    }

    public void setUnused() {
        label = UNUSED;
    }

    public void setUsed() {
        label = USED;
    }

    public void setCorrect() {
        label = CORRECT;
    }

    public boolean isUnused() {
        return label == UNUSED;
    }

    public static Letter[] fromString(String s) {
        Letter[] letterArray = new Letter[s.length()];

        for (int i = 0; i < s.length(); i++) {
            letterArray[i] = new Letter(s.charAt(i));
        }
        return letterArray;
    }
}