package ru.mail.polis.hash;

public class StringHashArray {
    private int capacity;

    private String[] elementArray;
    private boolean[] isDeleteArray;

    public StringHashArray(int capacity) {
        this.capacity = capacity;
        elementArray = new String[capacity];
        isDeleteArray = new boolean[capacity];
    }

    public String get(int position) {
        return elementArray[position];
    }

    public void set(String s, int position) {
        elementArray[position] = s;
        isDeleteArray[position] = false;
    }

    public boolean isFree(int position){
        return elementArray[position] == null || isDeleteArray[position];
    }

    public void delete(int position) {
        isDeleteArray[position] = true;
    }
}
