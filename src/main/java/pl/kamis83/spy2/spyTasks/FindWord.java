package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentance;

import java.util.List;

public class FindWord extends Task {

    private static final String COMMAND_NAME = "FindWord";

    public void makeTaskWithParam(List <Sentance> sentance, List<String> param) {
        String[] array = sentance.get(0).getSentanceText().
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
                + numberOfDuplication + " times in the sentance named" + sentance.get(0).getSentanceName());

    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

}
