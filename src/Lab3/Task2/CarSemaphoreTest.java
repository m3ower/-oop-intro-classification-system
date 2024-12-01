package Lab3.Task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarSemaphoreTest {
    private static final String SAMPLE_JSON = """
                {
                    "cars": [
                        {"id": "E1", "needsDinner": true, "isElectric": true, "isRobot": true},
                        {"id": "E2", "needsDinner": false, "isElectric": true, "isRobot": false},
                        {"id": "E3", "needsDinner": true, "isElectric": true, "isRobot": true},
                        {"id": "E4", "needsDinner": true, "isElectric": true, "isRobot": true},
                        {"id": "E5", "needsDinner": true, "isElectric": true, "isRobot": false},
                        {"id": "E6", "needsDinner": false, "isElectric": true, "isRobot": true},
                        {"id": "E7", "needsDinner": true, "isElectric": true, "isRobot": true},
                        {"id": "E8", "needsDinner": true, "isElectric": true, "isRobot": false},
                        {"id": "E9", "needsDinner": false, "isElectric": true, "isRobot": true},
                        {"id": "E10", "needsDinner": true, "isElectric": true, "isRobot": true},
                        {"id": "G1", "needsDinner": true, "isElectric": false, "isRobot": true},
                        {"id": "G2", "needsDinner": true, "isElectric": false, "isRobot": false},
                        {"id": "G3", "needsDinner": true, "isElectric": false, "isRobot": true},
                        {"id": "G4", "needsDinner": true, "isElectric": false, "isRobot": true},
                        {"id": "G5", "needsDinner": true, "isElectric": false, "isRobot": false}
                    ]
                }
            """;

    @Test
    public void testCarRoutingAndQueues() throws Exception {
        Semaphore semaphore = new Semaphore();
        ObjectMapper mapper = new ObjectMapper();
        CarData carData = mapper.readValue(SAMPLE_JSON, CarData.class);

        List<Car> remainingCars = new ArrayList<>(carData.getCars());

        while (!remainingCars.isEmpty()) {
            int gasRobotCount = 0, gasHumanCount = 0;
            int electricRobotCount = 0, electricHumanCount = 0;

            List<Car> nextBatch = new ArrayList<>();

            for (Car car : remainingCars) {
                if (car.getIsElectric()) {
                    if (car.getIsRobot() && electricRobotCount < 3) {
                        semaphore.routeCar(car);
                        electricRobotCount++;
                    } else if (!car.getIsRobot() && electricHumanCount < 3) {
                        semaphore.routeCar(car);
                        electricHumanCount++;
                    } else {
                        nextBatch.add(car);
                    }
                } else {
                    if (car.getIsRobot() && gasRobotCount < 4) {
                        semaphore.routeCar(car);
                        gasRobotCount++;
                    } else if (!car.getIsRobot() && gasHumanCount < 4) {
                        semaphore.routeCar(car);
                        gasHumanCount++;
                    } else {
                        nextBatch.add(car);
                    }
                }
            }

            semaphore.serveAllStations();

            remainingCars = nextBatch;
        }

        assertEquals(5, ((RobotDinner)semaphore.getElectricRobotStation()
                .getDiningService()).getRobotsServed());
        assertEquals(7, ((ElectricStation)semaphore.getElectricRobotStation()
                .getRefuelingService()).getCarsCharged());

        assertEquals(2, ((PeopleDinner)semaphore.getElectricHumanStation()
                .getDiningService()).getPeopleServed());
        assertEquals(3, ((ElectricStation)semaphore.getElectricHumanStation()
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