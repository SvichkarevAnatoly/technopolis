package test.collections;

import collections.LinkedDeque;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class LinkedDequeTest {
    private LinkedDeque<Integer> deque;

    @Before
    public void setUp() throws Exception {
        deque = new LinkedDeque<>();
    }

    @Test
    public void constructor() {
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    public void pushFrontPopFront() throws Exception {
        deque.pushFront(5);
        assertEquals(1, deque.size());
        assertEquals(5, deque.popFront().intValue());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void pushBackPopBack() throws Exception {
        deque.pushBack(5);
        assertEquals(1, deque.size());
        assertEquals(5, deque.popBack().intValue());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void push3Items() throws Exception {
        deque.pushBack(2);
        deque.pushFront(1);
        deque.pushBack(3);

        assertEquals(3, deque.size());

        assertEquals(1, deque.popFront().intValue());
        assertEquals(2, deque.popFront().intValue());
        assertEquals(3, deque.popBack().intValue());

        assertTrue(deque.isEmpty());
    }

    @Test
    public void iterator() {
        deque.pushFront(5);
        deque.pushFront(7);
        deque.pushBack(9);

        final Iterator<Integer> iterator = deque.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(7, iterator.next().intValue());
        Assert.assertEquals(5, iterator.next().intValue());
        Assert.assertEquals(9, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }
}
