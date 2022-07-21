package pl.kamis83.spy2.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kamis83.spy2.model.Sentence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SentenceDao {
    private static Logger LOG = Logger.getLogger(SentenceDao.class.getName());
    private final ObjectMapper objectMapper;

    public SentenceDao() {
        this.objectMapper = new ObjectMapper();
    }

    public List<Sentence> findAll() {
        return getSentances();
    }

    private List<Sentence> getSentances() {
        try {
            return objectMapper.readValue(Files.readString(Paths.get("./sentences.txt")), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            LOG.log(Level.WARNING,"Error on getSentences",e);
            return new ArrayList<>();
        }
    }

    public void add(Sentence sentence) {
        try {
            List<Sentence> sentences = getSentances();
            isSentanceNameUnique(sentence, sentences);
            sentences.add(sentence);
            Files.writeString(Paths.get("./sentences.txt"), objectMapper.writeValueAsString(sentences));
            System.out.println("The new sentence added");

        } catch (IOException e) {
            LOG.log(Level.WARNING,"Error on addSentences",e);
        }
    }

    public void delete(String sentenceToDelete) {
        List<Sentence> sentences = getSentances();
        Sentence sentence = findOne(sentenceToDelete);
        sentences.removeIf(s -> s.getSentenceName().equals(sentence.getSentenceName()));
        try {
            Files.writeString(Paths.get("./sentences.txt"), objectMapper.writeValueAsString(sentences));
        } catch (IOException e) {
            LOG.log(Level.WARNING,"Error on deleteSentences",e);
        }
        System.out.println("Sentence: " + sentenceToDelete + " was removed from Sentence List");

    }

    private void isSentanceNameUnique(Sentence sentence, List<Sentence> sentences) {
        for (Sentence eachSentence : sentences) {
            if (eachSentence.getSentenceName().equals(sentence.getSentenceName())) {
                throw new IllegalArgumentException("SentenceName has already exist. You need to add new sentence " +
                        "one more time with unique SentenceName");
            }
        }

    }

    public Sentence findOne(String sentenceName) {
        Optional<Sentence> searchedSentence = getSentances().stream().filter(s -> s.getSentenceName().equals(sentenceName)).findAny();
        searchedSentence.ifPresent(sentence -> LOG.info("The sentence was found"));
        if (searchedSentence.isEmpty()) {
            throw new NoSuchElementException("Could not find sentence named" + " " + sentenceName);
        }
        return searchedSentence.get();
    }
}
