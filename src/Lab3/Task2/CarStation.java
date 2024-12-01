package Lab3.Task2;

import Lab3.Task1.IQueue;
import Lab3.Task1.LinkedQueue;

public class CarStation {
    private final IDineable diningService;
    private final IRefuelable refuelingService;
    private final IQueue<Car> queue;
    private final StationType stationType;
    private final DinerType dinerType;

    public enum StationType {
        ELECTRIC, GAS
    }

    public enum DinerType {
        ROBOT, HUMAN
    }

    public CarStation(IDineable diningService, IRefuelable refuelingService,
                      StationType stationType, DinerType dinerType) {
        validateServices(diningService, refuelingService, stationType, dinerType);
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = new LinkedQueue<>();
        this.stationType = stationType;
        this.dinerType = dinerType;
    }

    private void validateServices(IDineable diningService, IRefuelable refuelingService,
                                  StationType stationType, DinerType dinerType) {
        boolean validDining = (dinerType == DinerType.ROBOT && diningService instanceof RobotDinner) ||
                (dinerType == DinerType.HUMAN && diningService instanceof PeopleDinner);
        boolean validRefueling = (stationType == StationType.ELECTRIC && refuelingService instanceof ElectricStation) ||
                (stationType == StationType.GAS && refuelingService instanceof GasStation);

        if (!validDining || !validRefueling) {
            throw new IllegalArgumentException("Invalid service configuration");
        }
    }

    public IDineable getDiningService() {
        return diningService;
    }

    public IRefuelable getRefuelingService() {
        return refuelingService;
    }

    public void addCar(Car car) {
        if ((car.getIsElectric() && stationType != StationType.ELECTRIC) ||
                (!car.getIsElectric() && stationType != StationType.GAS) ||
                (car.getIsRobot() && dinerType != DinerType.ROBOT) ||
                (!car.getIsRobot() && dinerType != DinerType.HUMAN)) {
            throw new IllegalArgumentException("Car type incompatible with station");
        }
        queue.enqueue(car);
        System.out.println("Car " + car.getId() + " joined the queue at " + stationType + " " + dinerType + " station");
    }

    public void serveCars() {
        System.out.println("\nServing cars at " + stationType + " " + dinerType + " station:");
        System.out.println("Current queue size: " + queue.size() + " cars");

        while (!queue.isEmpty()) {
            Car car = queue.dequeue();
            String carId = car.getId();
            System.out.println("\nServing car: " + carId);
            System.out.println("Cars remaining in queue: " + queue.size());

            if (car.getNeedsDinner()) {
                diningService.serveDinner(carId);
            }
            refuelingService.refuel(carId);
        }
    }
}