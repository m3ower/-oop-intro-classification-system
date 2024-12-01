package Lab3.interfaces;

public interface IQueue<T> {
    void enqueue(T item);
    T dequeue();
    T peek();
    int count();
}