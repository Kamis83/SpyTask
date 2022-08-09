package pl.kamis83.spy2.spytasks.compareSingleTasks;

public class SameWords {
    int numberOfSameWord;

    public SameWords() {
    }

    int getNumberOfSameWord(String word, String wordToCompare, int length, int numberOfSameLetters) {
        if (numberOfSameLetters > 0.5 * length) {
            numberOfSameWord++;
            System.out.println("\"" + word + "\"" + " seems to be similar to word " + "\""
                    + wordToCompare + "\"");
        }
        return numberOfSameWord;
    }

    public int getNumberOfWordsToCompare(String[] firstSentenceWords, String[] secondSentenceWords) {
        return Math.min(firstSentenceWords.length, secondSentenceWords.length);
    }
}