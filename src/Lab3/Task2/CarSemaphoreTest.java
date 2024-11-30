package Lab3.Task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarSemaphoreTest {
    private static final String SAMPLE_JSON = """
        {
            "cars": [
                {"id": "E1", "needsDinner": true, "isElectric": true, "isRobot": true},
                {"id": "E2", "needsDinner": false, "isElectric": true, "isRobot": false},
                {"id": "E3", "needsDinner": true, "isElectric": true, "isRobot": true},
                {"id": "E4", "needsDinner": true, "isElectric": true, "isRobot": true},
                {"id": "G1", "needsDinner": true, "isElectric": false, "isRobot": true},
                {"id": "G2", "needsDinner": true, "isElectric": false, "isRobot": false},
                {"id": "E5", "needsDinner": true, "isElectric": true, "isRobot": false},
                {"id": "E6", "needsDinner": false, "isElectric": true, "isRobot": true},
                {"id": "G3", "needsDinner": true, "isElectric": false, "isRobot": true},
                {"id": "G4", "needsDinner": true, "isElectric": false, "isRobot": true},
                {"id": "E7", "needsDinner": true, "isElectric": true, "isRobot": true},
                {"id": "G5", "needsDinner": true, "isElectric": false, "isRobot": false}
            ]
        }
    """;

    @Test
    public void testCarRoutingAndQueues() throws Exception {
        Semaphore semaphore = new Semaphore();
        ObjectMapper mapper = new ObjectMapper();
        CarData carData = mapper.readValue(SAMPLE_JSON, CarData.class);
        for (int i = 0; i < 6; i++) {
            semaphore.routeCar(carData.getCars().get(i));
        }

        semaphore.serveAllStations();

        for (int i = 6; i < carData.getCars().size(); i++) {
            semaphore.routeCar(carData.getCars().get(i));
        }
        semaphore.serveAllStations();


        assertEquals(4, ((RobotDinner)semaphore.getElectricRobotStation()
                .getDiningService()).getRobotsServed());
        assertEquals(5, ((ElectricStation)semaphore.getElectricRobotStation()
                .getRefuelingService()).getCarsCharged());

        assertEquals(1, ((PeopleDinner)semaphore.getElectricHumanStation()
                .getDiningService()).getPeopleServed());
        assertEquals(2, ((ElectricStation)semaphore.getElectricHumanStation()
                .getRefuelingService()).getCarsCharged());

        assertEquals(3, ((RobotDinner)semaphore.getGasRobotStation()
                .getDiningService()).getRobotsServed());
        assertEquals(3, ((GasStation)semaphore.getGasRobotStation()
                .getRefuelingService()).getCarsFueled());

        assertEquals(2, ((PeopleDinner)semaphore.getGasHumanStation()
                .getDiningService()).getPeopleServed());
        assertEquals(2, ((GasStation)semaphore.getGasHumanStation()
                .getRefuelingService()).getCarsFueled());
    }
}