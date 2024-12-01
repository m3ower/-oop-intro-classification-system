package Lab3.queues;
import Lab3.interfaces.IQueue;
import java.util.LinkedList;

public class LinkedQueue<T> implements IQueue<T> {
    private LinkedList<T> list;
    private final int capacity;

    public LinkedQueue() {
        list = new LinkedList<>();
        this.capacity = 20;
    }

    @Override
    public void enqueue(T item) throws IllegalStateException {
        if (list.size() >= capacity) {
            throw new IllegalStateException("Queue is full.");
        }
        list.addLast(item);
    }
    @Override
    public T dequeue() {
        if (list.isEmpty()) {
            return null;
        }

        T value = list.getFirst();
        list.removeFirst();
        return value;
    }

    @Override
    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    @Override
    public int count() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}

