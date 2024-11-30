package Lab3.Task2;

import Lab3.Task1.IQueue;
import Lab3.Task1.LinkedQueue;

public class GasStation implements IRefuelable {
    private int carsFueled = 0;
    private final IQueue<String> waitingCars;
    private static final int MAX_CAPACITY = 4;
    private int currentCars = 0;

    public GasStation() {
        this.waitingCars = new LinkedQueue<>();
    }

    @Override
    public void refuel(String carId) {
        if (currentCars < MAX_CAPACITY) {
            processRefueling(carId);
        } else {
            System.out.println("Gas station full, car " + carId + " added to waiting queue");
            waitingCars.enqueue(carId);
        }
    }

    private void processRefueling(String carId) {
        currentCars++;
        carsFueled++;
        System.out.println("Refueling gas car " + carId);
        currentCars--;

        if (!waitingCars.isEmpty()) {
            String nextCar = waitingCars.dequeue();
            System.out.println("Taking next car " + nextCar + " from gas station queue");
            processRefueling(nextCar);
        }
    }

    public int getCarsFueled() {
        return carsFueled;
    }
}
