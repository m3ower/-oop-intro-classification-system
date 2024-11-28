package Lab3.Task1;

public class CircularQueue<T> implements IQueue<T> {
    private static final int CAPACITY = 10;
    private T[] buffer;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public CircularQueue() {
        buffer = (T[]) new Object[CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (size == buffer.length) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % buffer.length;
        buffer[rear] = item;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = buffer[front];
        buffer[front] = null;
        front = (front + 1) % buffer.length;
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return buffer[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}