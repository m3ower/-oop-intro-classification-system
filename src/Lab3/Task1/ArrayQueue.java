package Lab3.Task1;

public class ArrayQueue<T> implements IQueue<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] array;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        array = (T[]) new Object[INITIAL_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    @Override
    public void enqueue(T item) {
        if (size == array.length) {
            resize();
        }
        rear = (rear + 1) % array.length;
        array[rear] = item;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[array.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % array.length];
        }
        array = newArray;
        front = 0;
        rear = size - 1;
    }
}