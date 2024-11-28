package Lab3.Task1;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void testArrayQueue() {
        IQueue<Integer> queue = new ArrayQueue<>();
        testQueueImplementation(queue);
    }

    @Test
    public void testLinkedQueue() {
        IQueue<Integer> queue = new LinkedQueue<>();
        testQueueImplementation(queue);
    }

    @Test
    public void testCircularQueue() {
        IQueue<Integer> queue = new CircularQueue<>();
        testQueueImplementation(queue);
    }

    private void testQueueImplementation(IQueue<Integer> queue) {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(3, queue.size());
        assertFalse(queue.isEmpty());
        assertEquals(Integer.valueOf(1), queue.peek());

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());

        assertTrue(queue.isEmpty());
    }
}