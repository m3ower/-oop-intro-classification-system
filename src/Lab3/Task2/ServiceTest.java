package Lab3.Task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {
    @Test
    public void testServices() {
        PeopleDinner peopleDinner = new PeopleDinner();
        RobotDinner robotDinner = new RobotDinner();
        ElectricStation electricStation = new ElectricStation();
        GasStation gasStation = new GasStation();

        // Test dinners
        peopleDinner.serveDinner("P1");
        peopleDinner.serveDinner("P2");
        robotDinner.serveDinner("R1");

        // Test refueling
        electricStation.refuel("E1");
        gasStation.refuel("G1");
        gasStation.refuel("G2");

        assertEquals(2, peopleDinner.getPeopleServed());
        assertEquals(1, robotDinner.getRobotsServed());
        assertEquals(1, electricStation.getCarsCharged());
        assertEquals(2, gasStation.getCarsFueled());
    }
}
