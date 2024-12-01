package Lab3.queues;
import Lab3.interfaces.IQueue;
import java.util.ArrayList;
import java.util.List;

public class ArrayQueue<T> implements IQueue<T> {
    protected List<T> queue = new ArrayList<>();
    private final int capacity;

    public ArrayQueue() {
        this.capacity = 20;
    }

    @Override
    public void enqueue(T item) throws IllegalStateException {
        if (queue.size() >= capacity) {
            throw new IllegalStateException("Queue is full.");
        }
        queue.add(item);
    }

    @Override
    public T dequeue() {
        if (queue.isEmpty()) {
            return null;
        }

        T item = queue.get(0);
        queue.remove(0);
        return item;
    }

    @Override
    public T peek() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.get(0);
    }

    @Override
    public int count() {
        return queue.size();
    }
}

