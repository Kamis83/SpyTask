package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentence;

import java.util.List;

public class CountWords extends Task {

    private static final String COMMAND_NAME = "CountWords";

    public void makeTaskWithoutParam(List<Sentence> sentence) {
        String[] array = sentence.get(0).getSentenceText().split("\\s");
        int numberOfWords = array.length;
        System.out.println("The number of words is: " + numberOfWords);
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

}
