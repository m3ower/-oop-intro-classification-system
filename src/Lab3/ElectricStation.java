package Lab3;


import Lab3.interfaces.IRefuelable;

public class ElectricStation implements IRefuelable {
    private static int count = 0;

    @Override
    public void refuel(int carId) {
        count++;
        System.out.println("Charging electric car " + carId + ".");
    }

    public static int getCount() {
        return count;
    }
}