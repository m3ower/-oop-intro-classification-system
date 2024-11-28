package Lab3.Task2;

public class RobotDinner implements IDineable {
    private int robotsServed = 0;

    @Override
    public void serveDinner(String carId) {
        robotsServed++;
        System.out.println("Serving dinner to robots in car " + carId);
    }

    public int getRobotsServed() {
        return robotsServed;
    }
}
