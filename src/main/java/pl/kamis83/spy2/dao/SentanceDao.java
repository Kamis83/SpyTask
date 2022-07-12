package pl.kamis83.spy2.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kamis83.spy2.model.Sentance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

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

    public void delete(String sentance) {
        try {
            List<Sentance> sentances = getSentances();
            sentances.removeIf(sentance1 -> sentance1.getSentanceName().equals(sentance));
            Files.writeString(Paths.get("./sentances.txt"), objectMapper.writeValueAsString(sentances));
        } catch (
                IOException e) {
            throw new RuntimeException(e);

        }
    }

    private void isSentanceNameUnique(Sentance sentance, List<Sentance> sentances) {
        for (Sentance eachSentance : sentances) {
            if (eachSentance.getSentanceName().equals(sentance.getSentanceName())) {
                throw new IllegalArgumentException("SentanceName has already exist. You need to add new sentance " +
                        "one more time with uniq SentanceName");
            }
        }
    }


    public Optional<Sentance> findOne(String sentanceName) {
        return getSentances().stream()
                .filter(s -> s.getSentanceName().equals(sentanceName))
                .findAny();
    }
}
