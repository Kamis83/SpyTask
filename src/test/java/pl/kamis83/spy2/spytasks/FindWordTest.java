package pl.kamis83.spy2.spytasks;

import org.junit.jupiter.api.Test;
import pl.kamis83.spy2.model.Sentence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FindWordTest {

    @Test
    void findSearchedWordInArray() {
        String[] array = {"Hania", "lubi", "imię", "Hania"};
        String searchedWord = "Hania";
        int numberOfDuplication = 0;
        for (String name : array) {
            if (name.equals(searchedWord)) {
                numberOfDuplication++;
            }
        }

        assertThat(numberOfDuplication).isEqualTo(2);
    }
    @Test
    void getWordsFromSetense() {
        FindWord findWord = new FindWord();
        List<Sentence> sentences = new ArrayList<>();
        sentences.add(new Sentence("Hania","Hania lubi imię Hania."));
        String[]actual = findWord.getWordsFromSentence(sentences,0);

        assertThat(actual.length).isEqualTo(4);
        assertThat(Arrays.toString(actual)).isEqualTo("[hania, lubi, imię, hania]");

    }
}
