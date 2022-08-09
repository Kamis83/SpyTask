package pl.kamis83.spy2.handlers;

import pl.kamis83.spy2.dao.SentenceDao;
import pl.kamis83.spy2.input.UserInputCommand;
import pl.kamis83.spy2.model.Sentence;
import pl.kamis83.spy2.spytasks.*;

import java.util.ArrayList;
import java.util.List;

public class SingleTaskCommandHandler extends BaseCommandHandler {
    public static String COMMAND_NAME = "task";
    private final SentenceDao sentenceDao;

    public SingleTaskCommandHandler() {

        sentenceDao = new SentenceDao();
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

        List <Sentence> sentences = new ArrayList<>();
        sentences.add(getSentance(command));
        List<String> taskParams = getParams(command);

        try {
            switch (command.getAction()) {
                case "CountWords", "CountChars" -> lookForTasksWithoutParams(command, tasks, sentences);
                case "FindWord"-> lookForTasksWithParams(command, tasks, sentences, taskParams);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Sentence getSentance(UserInputCommand command) {
        String sentanceName = command.getParam().get(0);
        sentenceDao.findOne(sentanceName);
        return sentenceDao.findOne(sentanceName);
    }

    private List<String> getParams(UserInputCommand command) {
        List<String> taskParams = new ArrayList<>();
        if (command.getParam().size() > 1) {
            taskParams.addAll(command.getParam());
            taskParams.remove(0);
        }
        return taskParams;
    }

    private void lookForTasksWithParams(UserInputCommand command, List<Task> tasks, List <Sentence> sentence, List<String> taskParam) {
        for (Task task : tasks) {
            if (task.supportsTask(command.getAction())) {
                task.makeTaskWithParam(sentence, taskParam);
            }
        }
    }
    private void lookForTasksWithoutParams(UserInputCommand command, List<Task> tasks, List <Sentence> sentence) {
        for (Task task : tasks) {
            if (task.supportsTask(command.getAction())) {
                task.makeTaskWithoutParam(sentence);
            }
        }
    }
}

