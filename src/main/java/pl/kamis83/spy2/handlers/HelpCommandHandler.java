package pl.kamis83.spy2.handlers;

import pl.kamis83.spy2.input.UserInputCommand;

public class HelpCommandHandler extends BaseCommandHandler {

    public static final String COMMAND_NAME = "help";

    @Override
    public void handle(UserInputCommand command) {
        System.out.println("Help....in future will be list of commands");
    }
    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }
}
