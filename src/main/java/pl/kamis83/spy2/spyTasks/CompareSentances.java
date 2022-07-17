package pl.kamis83.spy2.spyTasks;

import pl.kamis83.spy2.model.Sentance;

import java.util.Arrays;
import java.util.List;

public class CompareSentances extends Task{
    public static final String COMMAND_NAME = "Compare";

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void makeTaskWithoutParam(List <Sentance> sentances) {
        String[] firstSentance = sentances.get(0).getSentanceText().
                replace('.', ' ').toLowerCase().split("\\s");
        String[] secondSentance = sentances.get(1).getSentanceText().
                replace('.', ' ').toLowerCase().split("\\s");
        areBothSentancesExactlySame(firstSentance, secondSentance);
    }

    private void areBothSentancesExactlySame(String[] firstSentance, String[] secondSentance) {
        if(Arrays.equals(firstSentance, secondSentance)){
            System.out.println("The sentence is the same");
        } else System.out.println("Sentance are not the same but for more details you need too make more specific comparison. ");
    }
}
