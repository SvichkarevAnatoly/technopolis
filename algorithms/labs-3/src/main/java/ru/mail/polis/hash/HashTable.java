package ru.mail.polis.hash;

public interface HashTable<E> {
    void put(E element);

    void remove(E element);

    boolean isContain(E element);
}
