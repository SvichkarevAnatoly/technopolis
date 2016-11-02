package collections;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class ArrayPriorityQueueTest {
    private ArrayPriorityQueue<Integer> heap;

    @Before
    public void setUp() throws Exception {
        heap = new ArrayPriorityQueue<>();
    }

    @Test
    public void sample1() {
        heap.add(100);
        heap.add(10);
        assertEquals(10, heap.extractMin().intValue());
        heap.add(5);
        heap.add(30);
        heap.add(50);
        assertEquals(5, heap.extractMin().intValue());
    }

    @Test
    public void sample2() {
        heap.add(5);
        heap.add(3);
        heap.add(9);
        heap.add(6);
        heap.add(8);
        heap.add(-2);
        heap.add(1);
        assertEquals(-2, heap.extractMin().intValue());
    }

    @Test
    public void addMany() {
        for (int i = 20; i >= 0; i--) {
            heap.add(i);
        }
        for (int i = 0; i <= 20; i++) {
            assertEquals(i, heap.extractMin().intValue());
        }
    }

    @Test
    public void iterator() {
        for (int i = 3; i >= 0; i--) {
            heap.add(i);
        }
        final Iterator<Integer> iterator = heap.iterator();
        assertEquals(0, iterator.next().intValue());
        assertEquals(1, iterator.next().intValue());
        assertEquals(2, iterator.next().intValue());
    }

    @Test
    public void build() {
        final Integer[] ints = {5, 3, 9, 6, 8, -2, 1};
        heap = new ArrayPriorityQueue<>(ints);

        assertEquals(-2, heap.extractMin().intValue());
        assertEquals(1, heap.extractMin().intValue());
        assertEquals(3, heap.extractMin().intValue());
        assertEquals(5, heap.extractMin().intValue());
        assertEquals(6, heap.extractMin().intValue());
        assertEquals(8, heap.extractMin().intValue());
        assertEquals(9, heap.extractMin().intValue());
    }
}
