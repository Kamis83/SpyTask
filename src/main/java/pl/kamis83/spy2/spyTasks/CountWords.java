package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentance;

import java.util.Optional;

public class CountWords extends Task{

    private static final String TASK_NAME = "CountWords" ;

    @Override
    public void makeTask(Optional<Sentance> sentance) {
        if (sentance.isPresent()) {
            String[] array = sentance.get().getSentanceText().split("\\s");
            int numberOfWords = array.length;
            System.out.println("The number of words is: " + numberOfWords);
        } throw new IllegalArgumentException("There is no Sentance");
    }

    @Override
    protected String getCommandName() {
        return TASK_NAME;
    }
}
