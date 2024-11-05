package Lab1.task2;

import java.util.Arrays;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String text) {
        if (text.length() == 0) {
            throw new IllegalArgumentException("Error in processing: Empty text.");
        } else {
            this.text = text;
        }
        numberOfVowels = (int) text.chars().filter(c -> "aeiouAEIOU".indexOf(c) >= 0).count();
        numberOfConsonants = (int) text.chars().filter(c -> "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) >= 0).count();
        numberOfLetters = (int) text.chars().filter(Character::isLetter).count();
        numberOfSentences = (int) text.chars().filter(c -> c == '.').count();

        longestWord = Arrays.stream(text.split("[\\s.,!?]+"))
                .max((w1, w2) -> Integer.compare(w1.length(), w2.length()))
                .orElse("Last word not found");
    }

    public String getFileName() {
        return fileName;
    }

    public String getText() {
        return text;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
