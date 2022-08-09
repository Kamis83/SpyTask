package pl.kamis83.spy2.spytasks;

import pl.kamis83.spy2.model.Sentence;

import java.util.List;

public class CountChars extends Task {

    public static String COMMAND_NAME = "CountChars";
    public void makeTaskWithoutParam(List<Sentence> sentences) {
        int length = sentences.get(0).getSentenceText().length();
        System.out.println("Number of chars in a sentance is: " + length);
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

}