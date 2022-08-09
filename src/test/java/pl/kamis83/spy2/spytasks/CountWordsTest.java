package pl.kamis83.spy2.spytasks;

import org.junit.jupiter.api.Test;
import pl.kamis83.spy2.model.Sentence;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CountWordsTest {

    @Test
    void areAmountOfWordsISentenceCorrect() {
        List<Sentence> sentences = new ArrayList<>();
        sentences.add(new Sentence("Hania","Hania lubi imię Hania."));

        CountWords countWords = new CountWords();
        int numberOfWords = countWords.getWordsFromSentence(sentences,0).length;

        assertThat(numberOfWords).isEqualTo(4);
    }
}