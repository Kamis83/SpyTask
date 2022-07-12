package pl.kamis83.spy2.handlers;

import pl.kamis83.spy2.QuitSpy2ApplicationException;
import pl.kamis83.spy2.input.UserInputCommand;

public class QuitCommandHandler extends BaseCommandHandler {

    public static final String COMMAND_NAME = "quit";

    @Override
    public void handle(UserInputCommand command) {
        throw new QuitSpy2ApplicationException();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }
}