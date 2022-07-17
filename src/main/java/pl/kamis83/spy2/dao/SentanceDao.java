package pl.kamis83.spy2.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kamis83.spy2.model.Sentance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class SentanceDao {
    private ObjectMapper objectMapper;

    public SentanceDao() {
        this.objectMapper = new ObjectMapper();
    }

    public List<Sentance> findAll() {

        return getSentances();
    }

    private List<Sentance> getSentances() {
        try {
            return objectMapper.readValue(Files.readString(Paths.get("./sentances.txt")), new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void add(Sentance sentance) {
        try {
            List<Sentance> sentances = getSentances();
            isSentanceNameUnique(sentance, sentances);
            sentances.add(sentance);
            Files.writeString(Paths.get("./sentances.txt"), objectMapper.writeValueAsString(sentances));
            System.out.println("The new sentance is added");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String sentenceToDelete) {
        List<Sentance> sentances = getSentances();
        Sentance sentance = findOne(sentenceToDelete);
        sentances.removeIf(s -> s.getSentanceName().equals(sentance.getSentanceName()));
        try {
            Files.writeString(Paths.get("./sentances.txt"), objectMapper.writeValueAsString(sentances));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sentance: " + sentenceToDelete + " was removed from Sentance List");

    }

    private void isSentanceNameUnique(Sentance sentance, List<Sentance> sentances) {
        for (Sentance eachSentance : sentances) {
            if (eachSentance.getSentanceName().equals(sentance.getSentanceName())) {
                throw new IllegalArgumentException("SentanceName has already exist. You need to add new sentance " +
                        "one more time with uniq SentanceName");
            }
        }

    }

    public Sentance findOne(String sentanceName) {
        Optional<Sentance> searchedSentance = getSentances().stream().filter(s -> s.getSentanceName().equals(sentanceName)).findAny();
        searchedSentance.ifPresent(sentance -> System.out.println("The sentance was found" + " " + sentance));
        if (searchedSentance.isEmpty()) {
            throw new NoSuchElementException("Could not find sentance named" + " " + sentanceName);
        }
        return searchedSentance.get();
    }
}
