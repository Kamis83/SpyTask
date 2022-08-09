package pl.kamis83.spy2.spytasks;

import pl.kamis83.spy2.model.Sentence;

import java.util.List;

public class FindWord extends Task {

    private static final String COMMAND_NAME = "FindWord";
    @Override
    public void makeTaskWithParam(List<Sentence> sentences, List<String> param) {
        String[] array = getWordsFromSentence(sentences,0);
        String searchedWord = getSearchedWord(param);
        int numberOfDuplication = findSearchedWordInArray(array, searchedWord);
        System.out.println("We have found  word: " + param.get(0) + " "
                + numberOfDuplication + " times in the sentance named" + sentences.get(0).getSentenceName());
        if (numberOfDuplication == 0) {
            System.out.println("There is no word like " + param.get(0));
        }
    }

    private String getSearchedWord(List<String> param) {
        return param.get(0).toLowerCase();
    }

    private int findSearchedWordInArray(String[] array, String searchedWord) {
        int numberOfDuplication = 0;
        for (String name : array) {
            if (name.equals(searchedWord)) {
                numberOfDuplication++;
            }
        }
        return numberOfDuplication;
    }
    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

}
