package Lab3.queues;
import Lab3.Car;
import Lab3.interfaces.IQueue;

public class QueueDistribution {
    private static int count = 0;
    private static final int DEFAULT_CAPACITY = 20;

    public static IQueue<Car> getQueue() {
        count = (count + 1) % 3;
        switch (count) {
            case 0:
                return new ArrayQueue<>();
            case 1:
                return new LinkedQueue<>();
            default:
                return new CircularQueue<>();
        }
    }
}