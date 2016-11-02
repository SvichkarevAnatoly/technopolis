package collections;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class CyclicArrayDequeTest {
    private CyclicArrayDeque<Integer> deque;

    @Before
    public void setUp() throws Exception {
        deque = new CyclicArrayDeque<>();
    }

    @Test
    public void constructor() {
        assertTrue(deque.isEmpty());
        assertEquals(0, deque.size());
    }

    @Test
    public void pushBackPopFront() {
        deque.pushBack(5);
        assertEquals(5, deque.popFront().intValue());
    }

    @Test
    public void pushFrontPopBack() {
        deque.pushFront(5);
        assertEquals(5, deque.popBack().intValue());
    }

    @Test
    public void pushBackPopFrontDouble() {
        deque.pushBack(5);
        assertEquals(5, deque.popFront().intValue());
        deque.pushBack(7);
        assertEquals(7, deque.popFront().intValue());
    }

    @Test
    public void allPushPop() {
        deque.pushFront(2);
        deque.pushFront(1);
        deque.pushBack(3);
        assertEquals(1, deque.popFront().intValue());
        assertEquals(3, deque.popBack().intValue());
        assertEquals(2, deque.popFront().intValue());
    }

    @Test
    public void pushBackManyItems() {
        for (int i = 0; i < 20; i++) {
            deque.pushBack(i);
        }
        assertEquals(20, deque.size());
        for (int i = 0; i < 20; i++) {
            assertEquals(i, deque.popFront().intValue());
        }
    }

    @Test
    public void pushBackHeadGreaterThanTail() {
        for (int i = 0; i < 7; i++) {
            deque.pushBack(i);
            deque.popFront();
        }
        assertTrue(deque.isEmpty());
        for (int i = 0; i < 20; i++) {
            deque.pushBack(i);
        }
        for (int i = 0; i < 20; i++) {
            assertEquals(i, deque.popFront().intValue());
        }
    }

    @Test
    public void size2() {
        deque.pushBack(5);
        deque.pushBack(7);
        assertEquals(2, deque.size());
        assertEquals(5, deque.popFront().intValue());
        assertEquals(7, deque.popFront().intValue());
    }

    @Test
    public void sizeIsEmpty() {
        deque.pushBack(5);

        assertEquals(1, deque.size());
        assertFalse(deque.isEmpty());

        deque.popFront();
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @Test
    public void iterator() {
        deque.pushBack(5);
        deque.pushBack(7);

        final Iterator<Integer> iterator = deque.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next().intValue());
        assertEquals(7, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorHeadGreaterThanTail() {
        final CyclicArrayDeque<Integer> Deque = new CyclicArrayDeque<>();
        for (int i = 0; i < 7; i++) {
            deque.pushFront(i);
            deque.popBack();
        }
        assertTrue(Deque.isEmpty());
        for (int i = 0; i < 20; i++) {
            Deque.pushBack(i);
        }

        final Iterator<Integer> iterator = Deque.iterator();
        assertTrue(iterator.hasNext());
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(i, iterator.next().intValue());
            i++;
        }
        assertFalse(iterator.hasNext());
    }
}
