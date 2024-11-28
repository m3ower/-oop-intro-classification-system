package Lab3.Task2;

public class PeopleDinner implements IDineable {
    private int peopleServed = 0;

    @Override
    public void serveDinner(String carId) {
        peopleServed++;
        System.out.println("Serving dinner to people in car " + carId);
    }

    public int getPeopleServed() {
        return peopleServed;
    }
}

