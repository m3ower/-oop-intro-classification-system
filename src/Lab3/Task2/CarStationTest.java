package Lab3.Task2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarStationTest {
    @Test
    public void testElectricRobotStation() {
        CarStation station = new CarStation(
                new RobotDinner(),
                new ElectricStation(),
                CarStation.StationType.ELECTRIC,
                CarStation.DinerType.ROBOT
        );

        Car electricRobotCar = new Car("E1", true, true, true);
        station.addCar(electricRobotCar);
        station.serveCars();
    }

    @Test
    public void testGasHumanStation() {
        CarStation station = new CarStation(
                new PeopleDinner(),
                new GasStation(),
                CarStation.StationType.GAS,
                CarStation.DinerType.HUMAN
        );

        Car gasHumanCar = new Car("G1", true, false, false);
        station.addCar(gasHumanCar);
        station.serveCars();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWrongCarType() {
        CarStation station = new CarStation(
                new RobotDinner(),
                new ElectricStation(),
                CarStation.StationType.ELECTRIC,
                CarStation.DinerType.ROBOT
        );

        Car gasCar = new Car("G1", true, false, true);
        station.addCar(gasCar);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidStationConfiguration() {
        new CarStation(
                new RobotDinner(),
                new GasStation(),
                CarStation.StationType.ELECTRIC,
                CarStation.DinerType.ROBOT
        );
    }
}
