package Lab3.Task2;

public class Semaphore {
    private final CarStation electricRobotStation;
    private final CarStation electricHumanStation;
    private final CarStation gasRobotStation;
    private final CarStation gasHumanStation;

    public Semaphore() {
        this.electricRobotStation = new CarStation(
                new RobotDinner(),
                new ElectricStation(),
                CarStation.StationType.ELECTRIC,
                CarStation.DinerType.ROBOT
        );

        this.electricHumanStation = new CarStation(
                new PeopleDinner(),
                new ElectricStation(),
                CarStation.StationType.ELECTRIC,
                CarStation.DinerType.HUMAN
        );

        this.gasRobotStation = new CarStation(
                new RobotDinner(),
                new GasStation(),
                CarStation.StationType.GAS,
                CarStation.DinerType.ROBOT
        );

        this.gasHumanStation = new CarStation(
                new PeopleDinner(),
                new GasStation(),
                CarStation.StationType.GAS,
                CarStation.DinerType.HUMAN
        );
    }

    public void routeCar(Car car) {
        CarStation targetStation;
        if (car.getIsElectric()) {
            targetStation = car.getIsRobot() ? electricRobotStation : electricHumanStation;
        } else {
            targetStation = car.getIsRobot() ? gasRobotStation : gasHumanStation;
        }
        targetStation.addCar(car);
    }

    public void serveAllStations() {
        electricRobotStation.serveCars();
        electricHumanStation.serveCars();
        gasRobotStation.serveCars();
        gasHumanStation.serveCars();
    }

    public CarStation getElectricRobotStation() { return electricRobotStation; }
    public CarStation getElectricHumanStation() { return electricHumanStation; }
    public CarStation getGasRobotStation() { return gasRobotStation; }
    public CarStation getGasHumanStation() { return gasHumanStation; }
}
