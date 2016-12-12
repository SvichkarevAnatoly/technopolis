package ru.mail.polis.hash;

public class StringHash {
    private static final char CHAR_SHIFT = 'a';
    private static final int ALPHABET_SIZE = 28;

    public static int h1(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = ALPHABET_SIZE * hash + index(s, i);
        }
        return hash;
    }

    public static int h2(String s) {

        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += index(s, i);
        }
        return hash;
    }

    private static int index(String s, int i) {
        return s.charAt(i) - CHAR_SHIFT + 1;
    }
}
