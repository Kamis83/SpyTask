package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentance;

import java.util.Arrays;
import java.util.List;

public class CompareSentances extends Task {
    public static final String COMMAND_NAME = "Compare";

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void makeTaskWithoutParam(List<Sentance> sentances) {
        String[] firstSentance = sentances.get(0).getSentanceText().
                replace('.', ' ').toLowerCase().split("\\s");
        String[] secondSentance = sentances.get(1).getSentanceText().
                replace('.', ' ').toLowerCase().split("\\s");
        int numberOfWords = Math.min(firstSentance.length,secondSentance.length);
        compareTwoSentances(firstSentance, secondSentance,numberOfWords);

    }

    private void compareTwoSentances(String[] firstSentance, String[] secondSentance,int numberOfWords) {
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
                    if (length == numberOfSameLetters) {
                        numberOfSameWord++;
                    }
                }
            }
        System.out.println("Both sentances has got " + numberOfSameWord + " same words. ");
    }
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
}
