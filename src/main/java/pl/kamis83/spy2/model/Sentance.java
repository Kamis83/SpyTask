package pl.kamis83.spy2.model;

public class Sentance {
    String sentanceName;
    String sentanceText;

    public Sentance(String sentanceName,String sentanceText) {
        this.sentanceName = sentanceName;
        this.sentanceText = sentanceText;
    }

    public Sentance(String sentanceName) {
        this.sentanceName = sentanceName;
    }

    public Sentance() {
    }

    public String getSentanceName() {
        return sentanceName;
    }

    public void setSentanceName(String sentanceName) {

        this.sentanceName = sentanceName;
    }

    public String getSentanceText() {
        return sentanceText;
    }

    public void setSentanceText(String sentanceText) {
        this.sentanceText = sentanceText;
    }

    @Override
    public String toString() {
        return "Sentance{" +
                "sentanceName='" + sentanceName + '\'' +
                ", sentanceText='" + sentanceText + '\'' +
                '}';
    }
}
