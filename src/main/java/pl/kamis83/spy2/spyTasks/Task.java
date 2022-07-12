package pl.kamis83.spy2.spyTasks;

public abstract class Task implements SpyTaskDetector {


    public boolean supportsTask(String name) {
        return getCommandName().equals(name);
    }

    protected abstract String getCommandName();
}
