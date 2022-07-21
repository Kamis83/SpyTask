package pl.kamis83.spy2.handlers;

import pl.kamis83.spy2.dao.SentenceDao;
import pl.kamis83.spy2.input.UserInputCommand;
import pl.kamis83.spy2.model.Sentence;
import pl.kamis83.spy2.spyTasks.*;

import java.util.ArrayList;
import java.util.List;

public class MultiTaskCommandHandler extends BaseCommandHandler {
    public static String COMMAND_NAME ="multiTask";
    private final SentenceDao sentenceDao;

    public MultiTaskCommandHandler() {

        sentenceDao = new SentenceDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        List<Task> multiTasks = new ArrayList<>();
        multiTasks.add(new CompareSentences());
        List<Sentence> sentences = new ArrayList<>(getSentances(command));
        try {
            switch (command.getAction()) {
                case "Compare" -> lookForTasksWithoutParams(command, multiTasks, sentences);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Sentence> getSentances(UserInputCommand command) {
        String firstSentanceName = command.getParam().get(0);
        String secondSentanceName = command.getParam().get(1);
        Sentence firstSentence = sentenceDao.findOne(firstSentanceName);
        Sentence secondSentence = sentenceDao.findOne(secondSentanceName);
        return List.of(firstSentence, secondSentence);
    }

    private void lookForTasksWithoutParams(UserInputCommand command, List<Task> tasks, List<Sentence> sentences) {
        for (Task task : tasks) {
            if (task.supportsTask(command.getAction())) {
                task.makeTaskWithoutParam(sentences);
            }
        }
    }
}
