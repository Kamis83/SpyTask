package pl.kamis83.spy2.handlers;

import pl.kamis83.spy2.dao.SentanceDao;
import pl.kamis83.spy2.input.UserInputCommand;
import pl.kamis83.spy2.model.Sentance;
import pl.kamis83.spy2.spyTasks.*;

import java.util.ArrayList;
import java.util.List;

public class MultiTaskCommandHandler extends BaseCommandHandler {
    public static String COMMAND_NAME ="multiTask";
    private final SentanceDao sentanceDao;

    public MultiTaskCommandHandler() {

        sentanceDao = new SentanceDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        List<Task> multiTasks = new ArrayList<>();
        multiTasks.add(new CompareSentances());
        List<Sentance> sentances = new ArrayList<>(getSentances(command));
        System.out.println();

        try {
            switch (command.getAction()) {
                case "Compare" -> lookForTasksWithoutParams(command, multiTasks, sentances);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Sentance> getSentances(UserInputCommand command) {
        String firstSentanceName = command.getParam().get(0);
        String secondSentanceName = command.getParam().get(1);
        Sentance firstSentance = sentanceDao.findOne(firstSentanceName);
        Sentance secondSentance = sentanceDao.findOne(secondSentanceName);
        return List.of(firstSentance,secondSentance);
    }

//    private List<String> getParams(UserInputCommand command) {
//        List<String> taskParams = new ArrayList<>();
//        if (command.getParam().size() > 1) {
//            taskParams.addAll(command.getParam());
//            taskParams.remove(0);
//        }
//        return taskParams;
 //   }

    private void lookForTasksWithParams(UserInputCommand command, List<Task> tasks, List<Sentance> sentance, List<String> taskParam) {
        for (Task task : tasks) {
            if (task.supportsTask(command.getAction())) {
                task.makeTaskWithParam(sentance, taskParam);
            }
        }
    }

    private void lookForTasksWithoutParams(UserInputCommand command, List<Task> tasks, List<Sentance> sentances) {
        for (Task task : tasks) {
            if (task.supportsTask(command.getAction())) {
                task.makeTaskWithoutParam(sentances);
            }
        }
    }
}
