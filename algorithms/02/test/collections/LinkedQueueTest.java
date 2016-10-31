package test.collections;

import collections.LinkedQueue;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedQueueTest {
    @Test
    public void constructor() {
        final LinkedQueue queue = new LinkedQueue();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void enqueueDequeue() {
        final LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(5);
        assertEquals(5, queue.dequeue().intValue());
    }

    @Test
    public void enqueueDequeueDouble() {
        final LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(5);
        assertEquals(5, queue.dequeue().intValue());
        queue.enqueue(7);
        assertEquals(7, queue.dequeue().intValue());
    }

    @Test
    public void size2() {
        final LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(5);
        queue.enqueue(7);
        assertEquals(2, queue.size());
        assertEquals(5, queue.dequeue().intValue());
        assertEquals(7, queue.dequeue().intValue());
    }

    @Test
    public void sizeIsEmpty() {
        final LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(5);

        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void iterator() {
        final LinkedQueue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(5);
        queue.enqueue(7);

        final Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next().intValue());
        assertEquals(7, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }
}
