package ru.mail.polis.hash;

public class StringHashTable implements HashTable<String> {
    private static final int INITIAL_CAPACITY = 8;
    private static final double LOAD_FACTOR = 0.5;

    private int capacity = INITIAL_CAPACITY;
    private StringHashArray hashArray = new StringHashArray(capacity);

    @Override
    public void put(String element) {
        final int h1 = StringHash.h1(element);
        final int h2 = StringHash.h2(element);
        int h = h1;
        for (int i = 0; i < capacity; i++) {
            if (hashArray.isFree(i)) {
                hashArray.set(element, h);
                break;
            }
            h = (h + h2) % capacity;
        }
    }

    @Override
    public void remove(String element) {
    }

    @Override
    public boolean isContain(String element) {
        final int h1 = StringHash.h1(element);
        final int h2 = StringHash.h2(element);
        for (int i = 0; i < capacity; i++) {
            final int h = (h1 + i * h2) % capacity;
            if (hashArray.isFree(h)) {
                break;
            } else {
                final String hashElement = hashArray.get(h);
                if (hashElement.equals(element)) {
                    return true;
                }
            }
        }
        return false;
    }
}
