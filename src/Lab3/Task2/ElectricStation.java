package Lab3.Task2;

public class ElectricStation implements IRefuelable {
    private int carsCharged = 0;

    @Override
    public void refuel(String carId) {
        carsCharged++;
        System.out.println("Charging electric car " + carId);
    }

    public int getCarsCharged() {
        return carsCharged;
    }
}
