package pl.kamis83.spy2.spytasks.compareSingleTasks;

public class SameLetters {

    public SameLetters() {
    }

    int getNumberOfSameLetters(char[] firstChar, char[] secondChar, int length) {
        int numberOfSameLetters = 0;
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                if (firstChar[i] == secondChar[i]) {
                    numberOfSameLetters++;
                }
            }
        }
        return numberOfSameLetters;
    }

    int getLengthOfComparison(char[] firstChar, char[] secondChar) {
        int length;
        if (firstChar.length < 0.5 * secondChar.length || 0.5 * firstChar.length < secondChar.length) {
            length = Math.min(firstChar.length, secondChar.length);
        } else length = 0;
        return length;
    }
}