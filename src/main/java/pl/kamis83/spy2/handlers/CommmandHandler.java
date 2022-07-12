package pl.kamis83.spy2.handlers;

import pl.kamis83.spy2.input.UserInputCommand;

public interface CommmandHandler {
    void handle(UserInputCommand command);
    boolean supports(String name);



}
