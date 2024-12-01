package Lab3;

import java.util.List;
import Lab3.interfaces.IDineable;
import Lab3.interfaces.IRefuelable;

public class Semaphore {
    private List<CarStation> carStations;
    private int totalCount = 0;

    public Semaphore(List<CarStation> carStations) {
        this.carStations = carStations;
    }

    public boolean classify(Car car) {
        try {
            IRefuelable refuelStation;
            if ("ELECTRIC".equals(car.getType())) {
                refuelStation = new ElectricStation();
            } else {
                refuelStation = new GasStation();
            }

            IDineable dienablePassenger;
            if ("PEOPLE".equals(car.getPassengers())) {
                dienablePassenger = new PeopleDinner();
            } else {
                dienablePassenger = new RobotDinner();
            }

            CarStation station = carStations.stream()
                    .filter(cs ->
                            cs.getRefuelable().getClass() == refuelStation.getClass() &&
                                    cs.getDineable().getClass() == dienablePassenger.getClass())
                    .findFirst()
                    .orElse(null);

            if (station != null) {
                boolean added = station.addCar(car); // Assuming addCar returns boolean
                if (added) {
                    totalCount++;
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error classifying car: " + e.getMessage());
            return false;
        }
    }

    public void displayResults() {
        System.out.println("\n\nAt our car station we served " + totalCount + " cars.");
        System.out.println("Gas station cars: " + GasStation.getCount());
        System.out.println("Electric station cars: " + ElectricStation.getCount());
        System.out.println("People dinner: " + PeopleDinner.getCount());
        System.out.println("Robot dinner: " + RobotDinner.getCount());
    }
}