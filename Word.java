public class Word {
    private LinearNode<Letter> firstLetter = null;

    public Word(Letter[] letters) {
        LinearNode<Letter> intNode;

        for (int i = letters.length-1; i >= 0; i--) {
            intNode = new LinearNode<Letter>(letters[i]);
            intNode.setNext(firstLetter);
            firstLetter = intNode;
        }
    }

    public String toString() {
        LinearNode<Letter> node = firstLetter;
        String word = "Word: ";

        while (node != null) {
            word += node.getElement().toString() + " ";
            node = node.getNext();
        }
        return word;
    }

    public boolean labelWord(Word mystery) {
        LinearNode<Letter> mysteryNodeHead = mystery.firstLetter;
        LinearNode<Letter> mysteryNode = mystery.firstLetter;
        LinearNode<Letter> thisNodeHead = firstLetter;
        LinearNode<Letter> thisNode = firstLetter;

        // Cycle through every letter in mystery to see if any are used in the guessed word
        while (thisNode != null) {
            while (mysteryNode != null) {
                if (thisNode.getElement().equals(mysteryNode.getElement())) {
                    thisNode.getElement().setUsed();
                    break;
                } else {
                    thisNode.getElement().setUnused();
                    mysteryNode = mysteryNode.getNext();
                }
            }
            mysteryNode = mysteryNodeHead;
            thisNode = thisNode.getNext();
        }

        // Check if node of guess matches node of mystery word and label correct if true
        thisNode = thisNodeHead;

        while (thisNode != null && mysteryNode != null) {
            if (thisNode.getElement().equals(mysteryNode.getElement())) {
                thisNode.getElement().setCorrect();
            }
            thisNode = thisNode.getNext();
            mysteryNode = mysteryNode.getNext();
        }

        // Check if this word matches mystery word
        thisNode = thisNodeHead;
        mysteryNode = mysteryNodeHead;

        while (thisNode != null && mysteryNode != null) {
            if (!thisNode.getElement().equals(mysteryNode.getElement())) {
                return false;
            }
            thisNode = thisNode.getNext();
            mysteryNode = mysteryNode.getNext();
        }
        return (thisNode == null && mysteryNode == null);
    }
}