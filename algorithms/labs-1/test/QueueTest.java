import org.junit.Before;
import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class QueueTest {
    private final Queue queue = new Queue();

    @Before
    public void setUp() throws Exception {
        queue.push(5);
    }

    @Test
    public void pop() {
        assertEquals(queue.size(), 1);
        assertEquals(queue.pop(), 5);
    }

    @Test
    public void front() {
        assertEquals(queue.front(), 5);
        assertEquals(queue.size(), 1);
    }

    @Test
    public void clear() {
        queue.clear();
        assertEquals(queue.size(), 0);
    }

    @Test
    public void overPush() {
        final Queue q = new Queue();
        for (int i = 1; i < 101; i++) {
            q.push(i);
        }
        for (int i = 0; i < 50; i++) {
            q.pop();
        }
        for (int i = 1; i < 51; i++) {
            q.push(i);
        }
        assertEquals(q.size(), 100);
    }
}
