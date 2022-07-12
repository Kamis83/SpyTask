package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentance;

import java.util.List;
import java.util.Optional;

public class CountChars extends Task {

    public static String COMMAND_NAME = "CountChars";

    @Override
    public void makeTask(Optional<Sentance> sentance) {
        if (sentance.isPresent()) {
            int length = sentance.get().getSentanceText().length();
            System.out.println("Number of chars in a sentance is: " + length);
        }
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }
}
