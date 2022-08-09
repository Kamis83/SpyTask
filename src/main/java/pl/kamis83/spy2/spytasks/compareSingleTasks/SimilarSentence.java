package pl.kamis83.spy2.spytasks.compareSingleTasks;

import java.util.Arrays;

public class SimilarSentence {
    SameWords sameWords;
    SameLetters sameLetters;
    SameSentence sameSentence;

    public SimilarSentence(SameWords sameWords, SameLetters sameLetters, SameSentence sameSentence) {
        this.sameWords = sameWords;
        this.sameLetters = sameLetters;
        this.sameSentence = sameSentence;
    }

    public void areBothSentencesSimilar(String[] firstSentenceWords, String[] secondSentenceWords, int numberOfWords) {
        int numberOfSameWord = 0;
        if (!sameSentence.areBothSentencesExactlySame(firstSentenceWords, secondSentenceWords)) {
            for (String word : firstSentenceWords) {
                for (String wordToCompare : secondSentenceWords) {
                    char[] firstChar = word.toLowerCase().toCharArray();
                    char[] secondChar = wordToCompare.toLowerCase().toCharArray();
                    int length = sameLetters.getLengthOfComparison(firstChar, secondChar);
                    int numberOfSameLetters = sameLetters.getNumberOfSameLetters(firstChar, secondChar, length);
                    numberOfSameWord = sameWords.getNumberOfSameWord(word, wordToCompare, length, numberOfSameLetters);
                }
            }
        }
        if (numberOfSameWord > 0.5 * numberOfWords && numberOfSameWord != 0) {
            System.out.println("We suspect there is plagiarism, because " + Arrays.toString(firstSentenceWords) +
                    "is similar to " + Arrays.toString(secondSentenceWords));
            System.out.println("Both sentences has got " + numberOfSameWord + " same words from " +
                    numberOfWords + "to compare");
        }
        if (numberOfSameWord < 0.5 * numberOfWords && numberOfSameWord != 0) {
            System.out.println("Sentences are not similar, but they have " + numberOfSameWord +
                    "same words");
        }
        if (numberOfSameWord == 0) {
            System.out.println("Sentences are completely different");
        }
    }
}
