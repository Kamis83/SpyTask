package pl.kamis83.spy2.handlers;

import pl.kamis83.spy2.dao.SentanceDao;
import pl.kamis83.spy2.input.UserInputCommand;
import pl.kamis83.spy2.spyTasks.CountChars;
import pl.kamis83.spy2.spyTasks.CountWords;
import pl.kamis83.spy2.spyTasks.FindWord;
import pl.kamis83.spy2.spyTasks.SpyTaskDetector;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpyTaskCommandHandler extends BaseCommandHandler {
    public static final String COMMAND_NAME = "task";
    private final SentanceDao sentanceDao;

    public SpyTaskCommandHandler() {
        sentanceDao = new SentanceDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        List<SpyTaskDetector> tasks = new ArrayList<>();
        tasks.add(new CountWords());
        tasks.add(new CountChars());
        tasks.add(new FindWord());

        switch (command.getAction()) {
            case "CountWords", "CountChars" -> {
                taskDetect(command, tasks);
            }
            case "FindWords" ->{
                String sentanceName = command.getParam().get(0);
                String word = command.getParam().get(1);



            }
        }
    }

    private void taskDetect(UserInputCommand command, List<SpyTaskDetector> tasks) {
        String sentanceName = command.getParam().get(0);
        Optional<SpyTaskDetector> currentTask = Optional.empty();

        for (SpyTaskDetector task : tasks) {
            if (task.supportsTask(command.getAction())) {
                currentTask = Optional.of(task);
                break;
}
        }
                currentTask
                .orElseThrow(() -> new IllegalArgumentException("Unknown action: " + command.getAction()))
                .makeTask(sentanceDao.findOne(sentanceName));
                }
}


