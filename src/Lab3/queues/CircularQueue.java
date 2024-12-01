package Lab3.queues;
import Lab3.interfaces.IQueue;

public class CircularQueue<T> implements IQueue<T> {
    private T[] items;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public CircularQueue() {
        this.capacity = 20; // Set a reasonable default capacity
        this.items = (T[]) new Object[this.capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    @Override
    public void enqueue(T item) throws IllegalStateException {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full.");
        }
        rear = (rear + 1) % capacity;
        items[rear] = item;
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            return null;
        }

        T item = items[front];
        front = (front + 1) % capacity;
        size--;

        return item;
    }

    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }

        return items[front];
    }

    @Override
    public int count() {
        return size;
    }
}
