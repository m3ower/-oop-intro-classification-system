package Lab1.task2;

import java.io.IOException;

public class main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Input Error: a file must be passed");
            return;
        } else if (args.length > 1) {
            System.out.println("Only the first file will be processed; See Task4 for multiple input files");
        }

        String filePath = args[0];
        String text;

        try {
            text = FileReader.readFileIntoString(filePath);
            TextData textData = new TextData(text);
            textData.setFileName(filePath);

            System.out.println(textData.getFileName());
            System.out.println("Number of vowels: " + textData.getNumberOfVowels());
            System.out.println("Number of consonants: " + textData.getNumberOfConsonants());
            System.out.println("Number of letters: " + textData.getNumberOfLetters());
            System.out.println("Number of sentences: " + textData.getNumberOfSentences());
            System.out.println("Longest word: " + textData.getLongestWord());
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
