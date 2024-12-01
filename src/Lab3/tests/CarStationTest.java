package Lab3.tests;

import Lab3.Car;
import Lab3.CarStation;
import Lab3.GasStation;
import Lab3.PeopleDinner;
import Lab3.interfaces.IQueue;
import Lab3.queues.QueueDistribution;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarStationTest {
    @Test
    public void testEnqueue() {
        System.out.println("Testing enqueue");
        CarStation carStation = new CarStation(new GasStation(), new PeopleDinner(), QueueDistribution.getQueue());
        IQueue<Car> queue = carStation.getQueue();

        Car car = new Car(9, "ELECTRIC", "PEOPLE", true, 20);
        carStation.addCar(car);
        assertEquals(car, queue.peek());
    }

    @Test
    public void testDequeue() {
        System.out.println("Testing dequeue");
        CarStation carStation = new CarStation(new GasStation(), new PeopleDinner(), QueueDistribution.getQueue());
        IQueue<Car> queue = carStation.getQueue();

        Car car1 = new Car(10, "ELECTRIC", "PEOPLE", true, 20);
        Car car2 = new Car(11, "GAS", "PEOPLE", false, 30);

        queue.enqueue(car1);
        queue.enqueue(car2);
        carStation.serveCar();

        assertEquals(car2, queue.peek());
    }
}
