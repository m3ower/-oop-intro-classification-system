package Lab3.Task2;

public class GasStation implements IRefuelable {
    private int carsFueled = 0;

    @Override
    public void refuel(String carId) {
        carsFueled++;
        System.out.println("Refueling gas car " + carId);
    }

    public int getCarsFueled() {
        return carsFueled;
    }
}
