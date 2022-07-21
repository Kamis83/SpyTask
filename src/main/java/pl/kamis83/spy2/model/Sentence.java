package pl.kamis83.spy2.model;

public class Sentence {
    String sentenceName;
    String sentenceText;

    public Sentence(String sentenceName, String sentenceText) {
        this.sentenceName = sentenceName;
        this.sentenceText = sentenceText;
    }

    public Sentence() {
    }

    public String getSentenceName() {
        return sentenceName;
    }

    public void setSentenceName(String sentenceName) {

        this.sentenceName = sentenceName;
    }

    public String getSentenceText() {
        return sentenceText;
    }

    public void setSentenceText(String sentenceText) {
        this.sentenceText = sentenceText;
    }

    @Override
    public String toString() {
        return "Sentance{" +
                "sentanceName='" + sentenceName + '\'' +
                ", sentanceText='" + sentenceText + '\'' +
                '}';
    }
}
