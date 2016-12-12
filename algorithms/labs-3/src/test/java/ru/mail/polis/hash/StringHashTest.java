package ru.mail.polis.hash;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringHashTest {
    @Test
    public void hash1SingleLetterA() throws Exception {
        final String a = "a";
        assertThat(StringHash.h1(a), is(1));
    }

    @Test
    public void hash2SingleLetterA() throws Exception {
        final String a = "a";
        assertThat(StringHash.h2(a), is(1));
    }

    @Test
    public void hash1TwoLetterA() throws Exception {
        final String a = "aa";
        assertThat(StringHash.h1(a), is(29));
    }

    @Test
    public void hash2TwoLetterA() throws Exception {
        final String a = "aa";
        assertThat(StringHash.h2(a), is(2));
    }
}
