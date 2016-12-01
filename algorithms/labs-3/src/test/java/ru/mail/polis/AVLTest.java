package ru.mail.polis;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AVLTest {
    @Test
    public void emptyTree() throws Exception {
        final Tree avl = new AVL();
        assertThat(avl.find(0), is(false));
    }


}
