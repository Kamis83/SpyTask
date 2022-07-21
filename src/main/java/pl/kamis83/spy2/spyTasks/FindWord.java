package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentence;

import java.util.List;

public class FindWord extends Task {

    private static final String COMMAND_NAME = "FindWord";

    public void makeTaskWithParam(List <Sentence> sentence, List<String> param) {
        String[] array = sentence.get(0).getSentenceText().
                replace('.', ' ').toLowerCase().split("\\s");
        String paramWithoutCase = param.get(0).toLowerCase();
        int numberOfDuplication = 0;
        for (String name : array) {
            if (name.equals(paramWithoutCase)) {
                numberOfDuplication++;
            }
        }
        if (numberOfDuplication == 0) {
            System.out.println("There is no word like " + param.get(0));
        }
        System.out.println("We have found  word: " + param.get(0) + " "
                + numberOfDuplication + " times in the sentance named" + sentence.get(0).getSentenceName());

    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

}
