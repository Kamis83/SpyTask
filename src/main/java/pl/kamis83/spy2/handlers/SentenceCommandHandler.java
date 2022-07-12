package pl.kamis83.spy2.handlers;

import pl.kamis83.spy2.dao.SentanceDao;
import pl.kamis83.spy2.input.UserInputCommand;
import pl.kamis83.spy2.model.Sentance;

import java.util.List;
import java.util.Scanner;

public class SentenceCommandHandler extends BaseCommandHandler {

    public static final String COMMAND_NAME = "sentance";
    private final SentanceDao sentanceDao;

    public SentenceCommandHandler() {
        sentanceDao = new SentanceDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        Scanner scanner = new Scanner(System.in);
        Sentance sentance = new Sentance();


        switch (command.getAction()) {
            case "list" -> {
                System.out.println("The list of sentaces");
                List<Sentance> sentances = sentanceDao.findAll();
                sentances.forEach(System.out::println);
            }
            case "add" -> {
                System.out.println("Please write a unique name for sentance");
                sentance.setSentanceName(scanner.nextLine());
                System.out.println("Please write a text for sentance");
                sentance.setSentanceText(scanner.nextLine());
                sentanceDao.add(new Sentance(sentance.getSentanceName(), sentance.getSentanceText()));
            }
            case "delete" -> {
                String sentanceName = command.getParam().get(0);
                System.out.println("The sentance with sentance Name:" + sentanceName + " was removed");
                sentanceDao.delete(sentanceName);
            }
            default -> throw new IllegalArgumentException(String.format("Uknown action: %s from command %s",
                    command.getAction(), command.getCommand()));
        }

    }
}





