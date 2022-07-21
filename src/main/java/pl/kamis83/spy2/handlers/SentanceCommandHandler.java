package pl.kamis83.spy2.handlers;

import pl.kamis83.spy2.dao.SentenceDao;
import pl.kamis83.spy2.input.UserInputCommand;
import pl.kamis83.spy2.model.Sentence;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class SentanceCommandHandler extends BaseCommandHandler {

    private static final Logger LOG = Logger.getLogger(SentanceCommandHandler.class.getName());

    public static final String COMMAND_NAME = "sentence";
    private final SentenceDao sentenceDao;

    public SentanceCommandHandler() {
        sentenceDao = new SentenceDao();
    }

    @Override
    protected String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void handle(UserInputCommand command) {
        Scanner scanner = new Scanner(System.in);
        Sentence sentence = new Sentence();
        if (command.getAction() == null) {
            throw new IllegalArgumentException("Action can't be empty");
        }
        switch (command.getAction()) {
            case "list" -> {
                if (!command.getParam().isEmpty()) {
                    throw new IllegalArgumentException("Sentence list doesn't support additional params");
                }
                LOG.info("The list of sentences...");
                List<Sentence> sentences = sentenceDao.findAll();
                sentences.forEach(System.out::println);
            }
            case "add" -> {
                if (!command.getParam().isEmpty()) {
                    throw new IllegalArgumentException("Sentence list doesn't support additional params");
                }
                LOG.info("Please write a unique name for sentence");
                sentence.setSentenceName(scanner.nextLine().trim());
                LOG.info("Please write a text for sentence");
                sentence.setSentenceText(scanner.nextLine().trim());
                sentenceDao.add(new Sentence(sentence.getSentenceName(), sentence.getSentenceText()));
            }
            case "delete" -> {
                String sentenceName = command.getParam().get(0);
                sentenceDao.delete(sentenceName);
            }
            default -> throw new IllegalArgumentException(String.format("Unknown action: %s from command %s",
                    command.getAction(), command.getCommand()));
        }


    }
}





