package pl.kamis83.spy2;

import pl.kamis83.spy2.handlers.*;
import pl.kamis83.spy2.input.UserInputCommand;
import pl.kamis83.spy2.input.UserInputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpyApplication {
    public static void main(String[] args) {
        new SpyApplication().run();
    }

    private void run() {
        System.out.println("Run... App");
        Welcome welcome = new Welcome();
        welcome.showInfo();

        UserInputManager userInputManager = new UserInputManager();
        List<CommmandHandler> handlers = new ArrayList<>();
        handlers.add(new HelpCommandHandler());
        handlers.add(new QuitCommandHandler());
        handlers.add(new SentanceCommandHandler());
        handlers.add(new SingleTaskCommandHandler());
        handlers.add(new MultiTaskCommandHandler());

        boolean applicationLoop = true;
        while (applicationLoop) {
            try {
                UserInputCommand userInputCommand = userInputManager.nextCommand();
                System.out.println(userInputCommand);
                Optional<CommmandHandler> currentHandler = Optional.empty();
                for (CommmandHandler handler : handlers) {
                    if (handler.supports(userInputCommand.getCommand())) {
                        currentHandler = Optional.of(handler);
                        break;
                    }
                }
                currentHandler
                        .orElseThrow(() -> new IllegalArgumentException("Unknown handler: " + userInputCommand.getCommand()))
                        .handle(userInputCommand);
            } catch(QuitSpy2ApplicationException e) {
                System.out.println("Quit Application...");
                applicationLoop = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

