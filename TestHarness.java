public class TestHarness {
    public static void main(String[] args) {

        WordLL wll = new WordLL(new Word(Letter.fromString("OBJECT")));
        String[] arr = {"JOB", "TESTING", "OBJECTS"};
        for (int i = 0; i < arr.length; i++) {
            wll.tryWord(new Word(Letter.fromString(arr[i])));
        }
        System.out.println(wll);

        String[][] stArr = {{"JD", "AD", "9H", "10S"},
                {"JC", "9H", "KH", "AS"},
                {"10C", "JC", "9D", "KH"},
                {"JC", "10D", "9H", "QH"},
                {"10C", "AD", "9H", "KH"},
                {"10C", "QC", "QD", "10H"},
                {"JC", "9D", "KH", "9S"}};
        int[][] intArr = {{2, 5, 0, 1},
                {2, 0, 4, 5},
                {1, 2, 0, 4},
                {2, 1, 0, 3},
                {1, 5, 0, 4},
                {1, 3, 3, 1},
                {2, 0, 4, 0}};

        WordLL wll2 = new WordLL(new Word(ExtendedLetter.fromStrings(stArr[stArr.length - 1], intArr[stArr.length - 1])));
        for (int i = 0; i < stArr.length; i++) {
            wll2.tryWord(new Word(ExtendedLetter.fromStrings(stArr[i], intArr[i])));
        }

        System.out.println(wll2);
    }
}