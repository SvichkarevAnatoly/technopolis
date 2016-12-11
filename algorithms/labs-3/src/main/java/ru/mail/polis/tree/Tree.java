package ru.mail.polis.tree;

public interface Tree {
    boolean add(int key);

    void delete(int key);

    boolean find(int key);
}
