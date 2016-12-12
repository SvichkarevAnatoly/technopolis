package ru.mail.polis.hash;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringHashTableTest {
    @Test
    public void oneElementOneLetterInHashTable() throws Exception {
        final String element = "a";

        final StringHashTable hashTable = new StringHashTable();
        hashTable.put(element);

        assertThat(hashTable.isContain(element), is(true));
    }

    @Test
    public void notContain() throws Exception {
        final String element = "a";
        final String anotherElement = "b";

        final StringHashTable hashTable = new StringHashTable();
        hashTable.put(element);

        assertThat(hashTable.isContain(anotherElement), is(false));
    }
}
