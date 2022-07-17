package pl.kamis83.spy2.handlers;

import pl.kamis83.spy2.dao.SentanceDao;
import pl.kamis83.spy2.input.UserInputCommand;
import pl.kamis83.spy2.model.Sentance;
import pl.kamis83.spy2.spyTasks.*;

import java.util.ArrayList;
import java.util.List;

public class SingleTaskCommandHandler extends BaseCommandHandler {
    public static String COMMAND_NAME = "task";
    private final SentanceDao sentanceDao;

    public SingleTaskCommandHandler() {

        sentanceDao = new SentanceDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new CountWords());
        tasks.add(new CountChars());
        tasks.add(new FindWord());

        List <Sentance> sentances = new ArrayList<>();
        sentances.add(getSentance(command));
        List<String> taskParams = getParams(command);

        try {
            switch (command.getAction()) {
                case "CountWords", "CountChars" -> lookForTasksWithoutParams(command, tasks, sentances);
                case "FindWord"-> lookForTasksWithParams(command, tasks, sentances, taskParams);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Sentance getSentance(UserInputCommand command) {
        String sentanceName = command.getParam().get(0);
        sentanceDao.findOne(sentanceName);
        return sentanceDao.findOne(sentanceName);
    }

    private List<String> getParams(UserInputCommand command) {
        List<String> taskParams = new ArrayList<>();
        if (command.getParam().size() > 1) {
            taskParams.addAll(command.getParam());
            taskParams.remove(0);
        }
        return taskParams;
    }

    private void lookForTasksWithParams(UserInputCommand command, List<Task> tasks, List <Sentance> sentance, List<String> taskParam) {
        for (Task task : tasks) {
            if (task.supportsTask(command.getAction())) {
                task.makeTaskWithParam(sentance, taskParam);
            }
        }
    }
    private void lookForTasksWithoutParams(UserInputCommand command, List<Task> tasks, List <Sentance> sentance) {
        for (Task task : tasks) {
            if (task.supportsTask(command.getAction())) {
                task.makeTaskWithoutParam(sentance);
            }
        }
    }
}

