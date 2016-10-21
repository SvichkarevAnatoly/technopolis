import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class HeapTest {
    @Test
    public void sample1() {
        final Heap heap = new Heap();
        heap.insert(100);
        heap.insert(10);
        assertEquals(heap.extract(), 100);
        heap.insert(5);
        heap.insert(30);
        heap.insert(50);
        assertEquals(heap.extract(), 50);
    }

    @Test
    public void sample2() {
        final Heap heap = new Heap();
        heap.insert(5);
        heap.insert(3);
        heap.insert(9);
        heap.insert(6);
        heap.insert(8);
        heap.insert(-2);
        heap.insert(1);
        assertEquals(heap.extract(), 9);
    }
}
