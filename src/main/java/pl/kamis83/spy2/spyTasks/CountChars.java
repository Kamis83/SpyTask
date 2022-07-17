package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentance;

import java.util.List;

public class CountChars extends Task {

    public static String COMMAND_NAME = "CountChars";

    public void makeTaskWithoutParam(List<Sentance> sentance) {

            int length = sentance.get(0).getSentanceText().length();
            System.out.println("Number of chars in a sentance is: " + length);

    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

}