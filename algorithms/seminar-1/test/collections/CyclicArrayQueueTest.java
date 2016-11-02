package collections;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class CyclicArrayQueueTest {
    @Test
    public void constructor() {
        final CyclicArrayQueue queue = new CyclicArrayQueue();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void enqueueDequeue() {
        final CyclicArrayQueue<Integer> queue = new CyclicArrayQueue<>();
        queue.enqueue(5);
        assertEquals(5, queue.dequeue().intValue());
    }

    @Test
    public void enqueueDequeueDouble() {
        final CyclicArrayQueue<Integer> queue = new CyclicArrayQueue<>();
        queue.enqueue(5);
        assertEquals(5, queue.dequeue().intValue());
        queue.enqueue(7);
        assertEquals(7, queue.dequeue().intValue());
    }

    @Test
    public void enqueueManyItems() {
        final CyclicArrayQueue<Integer> queue = new CyclicArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        assertEquals(20, queue.size());
        for (int i = 0; i < 20; i++) {
            assertEquals(i, queue.dequeue().intValue());
        }
    }

    @Test
    public void enqueueHeadGreaterThanTail() {
        final CyclicArrayQueue<Integer> queue = new CyclicArrayQueue<>();
        for (int i = 0; i < 7; i++) {
            queue.enqueue(i);
            queue.dequeue();
        }
        assertTrue(queue.isEmpty());
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 20; i++) {
            assertEquals(i, queue.dequeue().intValue());
        }
    }

    @Test
    public void size2() {
        final CyclicArrayQueue<Integer> queue = new CyclicArrayQueue<>();
        queue.enqueue(5);
        queue.enqueue(7);
        assertEquals(2, queue.size());
        assertEquals(5, queue.dequeue().intValue());
        assertEquals(7, queue.dequeue().intValue());
    }

    @Test
    public void sizeIsEmpty() {
        final CyclicArrayQueue<Integer> queue = new CyclicArrayQueue<>();
        queue.enqueue(5);

        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void iterator() {
        final CyclicArrayQueue<Integer> queue = new CyclicArrayQueue<>();
        queue.enqueue(5);
        queue.enqueue(7);

        final Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next().intValue());
        assertEquals(7, iterator.next().intValue());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorHeadGreaterThanTail() {
        final CyclicArrayQueue<Integer> queue = new CyclicArrayQueue<>();
        for (int i = 0; i < 7; i++) {
            queue.enqueue(i);
            queue.dequeue();
        }
        assertTrue(queue.isEmpty());
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }

        final Iterator<Integer> iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(i, iterator.next().intValue());
            i++;
        }
        assertFalse(iterator.hasNext());
    }
}
