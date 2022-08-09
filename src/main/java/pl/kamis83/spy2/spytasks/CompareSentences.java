package pl.kamis83.spy2.spytasks;

import pl.kamis83.spy2.model.Sentence;
import pl.kamis83.spy2.spytasks.compareSingleTasks.SameLetters;
import pl.kamis83.spy2.spytasks.compareSingleTasks.SameSentence;
import pl.kamis83.spy2.spytasks.compareSingleTasks.SameWords;
import pl.kamis83.spy2.spytasks.compareSingleTasks.SimilarSentence;

import java.util.List;

public class CompareSentences extends Task {
    public static final String COMMAND_NAME = "Compare";
    private final SameWords sameWords = new SameWords();
    private final SameSentence sameSentence = new SameSentence();
    private final SameLetters sameLetters = new SameLetters();
    private final SimilarSentence similarSentence = new SimilarSentence(sameWords, sameLetters, sameSentence);

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void makeTaskWithoutParam(List<Sentence> sentences) {
        String[] firstSentenceWords = getWordsFromSentence(sentences, 0);
        String[] secondSentenceWords = getWordsFromSentence(sentences, 1);
        int numberOfWords = sameWords.getNumberOfWordsToCompare(firstSentenceWords, secondSentenceWords);
        similarSentence.areBothSentencesSimilar(firstSentenceWords, secondSentenceWords, numberOfWords);
    }

}
