package Lab3.Task2;

import Lab3.Task1.IQueue;
import Lab3.Task1.LinkedQueue;

    public class ElectricStation implements IRefuelable {
    private int carsCharged = 0;
    private final IQueue<String> waitingCars;
    private static final int MAX_CAPACITY = 3;
    private int currentCars = 0;

    public ElectricStation() {
        this.waitingCars = new LinkedQueue<>();
    }

    @Override
    public void refuel(String carId) {
        if (currentCars < MAX_CAPACITY) {
            processCharging(carId);
        } else {
            System.out.println("Electric station full, car " + carId + " added to waiting queue");
            waitingCars.enqueue(carId);
        }
    }

    private void processCharging(String carId) {
        currentCars++;
        carsCharged++;
        System.out.println("Charging electric car " + carId);
        currentCars--;

        if (!waitingCars.isEmpty()) {
            String nextCar = waitingCars.dequeue();
            System.out.println("Taking next car " + nextCar + " from electric station queue");
            processCharging(nextCar);
        }
    }

    public int getCarsCharged() {
        return carsCharged;
    }
}
