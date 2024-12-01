package Lab3;
import Lab3.interfaces.IRefuelable;

public class GasStation implements IRefuelable {
    private static int count = 0;
    private static int consumption = 0;

    @Override
    public void refuel(int carId) {
        count++;
        System.out.println("Refueling gas for car " + carId + ".");
    }

    public static int getCount() {
        return count;
    }
}