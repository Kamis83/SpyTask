package pl.kamis83.spy2.spytasks.compareSingleTasks;

import java.util.Arrays;

public class SameSentence {
    public SameSentence() {
    }
    public boolean areBothSentencesExactlySame(String[] firstSentence, String[] secondSentence) {
        boolean sentencesAreTheSame = false;
        if (Arrays.equals(firstSentence, secondSentence)) {
            sentencesAreTheSame = true;
            System.out.println(" Both sentances are exactly the same. ");
        }
        return sentencesAreTheSame;
    }
}