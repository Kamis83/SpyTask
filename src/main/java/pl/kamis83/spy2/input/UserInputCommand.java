package pl.kamis83.spy2.input;

import java.util.ArrayList;
import java.util.List;

public class UserInputCommand {
    String command;
    String action;
    List<String> param;


    public UserInputCommand(String line) {
        if (line != null) {
            String[] array = line.split("\\s");
            hasGotCommand(array);
            hasGotAction(array);
            hasGotParam(array);
        }
    }

    private void hasGotParam(String[] array) {
        param = new ArrayList<>();
        for (int i = 2; i < array.length; i++) {
            param.add(array[i]);
        }
    }

    private void hasGotAction(String[] array) {
        if (array.length > 1) {
            action = array[1];
        }
    }
    private void hasGotCommand(String[] array) {
        if (array.length > 0) {
            command = array[0];
        }
    }

    public String getCommand() {
        return command;
    }

    public String getAction() {
        return action;
    }

    public List<String> getParam() {
        return param;
    }

    @Override
    public String toString() {
        return "UserInputCommand{" +
                "command='" + command + '\'' +
                ", action='" + action + '\'' +
                ", param=" + param +
                '}';
    }
}