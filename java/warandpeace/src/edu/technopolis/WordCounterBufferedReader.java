package edu.technopolis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounterBufferedReader {
    public static void main(String[] args) throws IOException {
        final BufferedReader text = new BufferedReader(new FileReader("text.txt"));

        int charCounter = 0;
        int wordCounter = 0;

        String line;
        while ((line = text.readLine()) != null) {
            charCounter += line.length();
            wordCounter += line.split("\\s+").length;
        }

        System.out.println("chars = " + charCounter);
        System.out.println("words = " + wordCounter);
    }
}
