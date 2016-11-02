package collections;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class TwoStackQueueTest {
    @Test
    public void constructor() {
        final TwoStackQueue queue = new TwoStackQueue();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void enqueueDequeue() {
        final TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        queue.enqueue(5);
        assertEquals(5, queue.dequeue().intValue());
    }

    @Test
    public void enqueueDequeueDouble() {
        final TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        queue.enqueue(5);
        assertEquals(5, queue.dequeue().intValue());
        queue.enqueue(7);
        assertEquals(7, queue.dequeue().intValue());
    }

    @Test
    public void size2() {
        final TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        queue.enqueue(5);
        queue.enqueue(7);
        assertEquals(2, queue.size());
        assertEquals(5, queue.dequeue().intValue());
        assertEquals(7, queue.dequeue().intValue());
    }

    @Test
    public void sizeIsEmpty() {
        final TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        queue.enqueue(5);

        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void iterator() {
        final TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        queue.enqueue(5);
        queue.enqueue(7);

        final Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next().intValue());
        assertEquals(7, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorInTwoStack() {
        final TwoStackQueue<Integer> queue = new TwoStackQueue<>();
        queue.enqueue(5);
        queue.enqueue(5);
        queue.enqueue(7);
        queue.dequeue();
        queue.enqueue(9);
        queue.enqueue(11);

        final Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next().intValue());
        assertEquals(7, iterator.next().intValue());
        assertEquals(9, iterator.next().intValue());
        assertEquals(11, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }
}
