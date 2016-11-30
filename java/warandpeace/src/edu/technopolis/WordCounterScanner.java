package edu.technopolis;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCounterScanner {
    public static void main(String[] args) throws IOException {
        final Scanner text = new Scanner(new FileReader("text.txt"));

        int charCounter = 0;
        int wordCounter = 0;

        String line;
        while (text.hasNextLine()) {
            line = text.nextLine();
            charCounter += line.length();
            wordCounter += line.split("\\s+").length;
        }

        System.out.println("chars = " + charCounter);
        System.out.println("words = " + wordCounter);
    }
}
