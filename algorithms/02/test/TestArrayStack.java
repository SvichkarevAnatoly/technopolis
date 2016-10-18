package test;

import collections.ArrayStack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestArrayStack {
    @Test
    public void constructor() {
        final ArrayStack<Integer> stack = new ArrayStack<>();
        assertEquals(0, stack.size());
    }

    @Test
    public void pushPop() {
        final ArrayStack<Integer> stack = new ArrayStack<>();
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
    public void growShrink() throws Exception {
        final ArrayStack<Integer> stack = new ArrayStack<>();
        assertEquals(0, stack.size());
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        assertEquals(10, stack.size());
        for (int i = 0; i < 3; i++) {
            stack.push(10 + i);
        }
        assertEquals(13, stack.size());
        for (int i = 12; i >= 0; i--) {
            assertEquals(i, (int)stack.pop());
        }
    }
}
