package test;

import collections.LinkedStack;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestLinkedStack {
    @Test
    public void constructor() {
        final LinkedStack<Integer> stack = new LinkedStack<>();
        assertEquals(0, stack.size());
    }

    @Test
    public void pushPop() {
        final LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(5);
        assertEquals(1, stack.size());
        assertEquals(5, (int) stack.pop());

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.size());
        assertEquals(2, (int) stack.pop());
        assertEquals(1, (int) stack.pop());
    }

    @Test
    public void peek() {
        final LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(5);
        assertEquals(1, stack.size());
        assertEquals(5, (int) stack.peek());
        assertEquals(1, stack.size());
        assertEquals(5, (int) stack.peek());
    }

    @Test
    public void iterator() throws Exception {
        final LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        final Iterator<Integer> iterator = stack.iterator();
        for (int i = 2; i > 0; i--) {
            assertTrue(iterator.hasNext());
            assertEquals(i, (int)iterator.next());
        }
        assertFalse(iterator.hasNext());
    }
}
