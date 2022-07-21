package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentence;

import java.util.Arrays;
import java.util.List;




public class CompareSentences extends Task {
    public static final String COMMAND_NAME = "Compare";
  

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void makeTaskWithoutParam(List<Sentence> sentences) {
        String[] firstSentence = sentences.get(0).getSentenceText().
                replace('.', ' ').toLowerCase().split("\\s");
        String[] secondSentence = sentences.get(1).getSentenceText().
                replace('.', ' ').toLowerCase().split("\\s");
        int numberOfWords = Math.min(firstSentence.length,secondSentence.length);
        areBothSentancesSimilar(firstSentence, secondSentence,numberOfWords);

    }

    private boolean areBothSentancesExactlySame(String[] firstSentance, String[] secondSentance) {
        boolean areSentancesSame = false;
        if (Arrays.equals(firstSentance, secondSentance)) {
            areSentancesSame = true;
            System.out.println(" Both sentances are exactly the same. ");
        } else
            System.out.println("Sentances are diffrent, but they could be similar because: ");

        return areSentancesSame;
    }

    private void areBothSentancesSimilar(String[] firstSentance, String[] secondSentance, int numberOfWords) {
        int numberOfSameWord = 0;
        if (!areBothSentancesExactlySame(firstSentance, secondSentance)) {
            for (String word : firstSentance) {
                for (String wordElse : secondSentance) {
                    char[] firstChar = word.toLowerCase().toCharArray();
                    char[] secondChar = wordElse.toLowerCase().toCharArray();
                    int numberOfSameLetters = 0;
                    int length = Math.min(firstChar.length, secondChar.length);
                    for (int i = 0; i < length; i++) {
                        if (firstChar[i] == secondChar[i]) {
                            numberOfSameLetters++;
                        }
                    }
                    numberOfSameWord = areTwoWordsFamiliar(numberOfSameWord, word, wordElse, numberOfSameLetters, length);

                }
            }
            if(numberOfSameWord > 0.5 * numberOfWords){
                System.out.println("We suspect there is plagiarism, because " + Arrays.toString(firstSentance) +
                        "is familiar to " + Arrays.toString(secondSentance));
                System.out.println("Both sentances has got " + numberOfSameWord + " same words. ");
            }
        }
    }

    private int areTwoWordsFamiliar(int numberOfSameWord, String word, String wordElse, int numberOfSameLetters, int length) {
        if (numberOfSameLetters > 0.5* length) {
            numberOfSameWord++;
            System.out.println("\"" + word + "\"" + " seems to be familiar to word " + "\"" + wordElse + "\"");
        }
        return numberOfSameWord;
    }
}
