package Lab3;
import Lab3.interfaces.IDineable;

public class PeopleDinner implements IDineable {
    private static int count = 0;

    @Override
    public void serveDinner(int carId) {
        count++;
        System.out.println("Serving dinner to people on car " + carId + ".");
    }

    public static int getCount() {
        return count;
    }
}
