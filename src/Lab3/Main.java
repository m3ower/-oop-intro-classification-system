package Lab3;

import java.util.ArrayList;
import java.util.List;
import Lab3.queues.QueueDistribution;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        List<CarStation> carStations = new ArrayList<>();
        carStations.add(new CarStation(new GasStation(), new PeopleDinner(), QueueDistribution.getQueue()));
        carStations.add(new CarStation(new ElectricStation(), new PeopleDinner(), QueueDistribution.getQueue()));
        carStations.add(new CarStation(new GasStation(), new RobotDinner(), QueueDistribution.getQueue()));
        carStations.add(new CarStation(new ElectricStation(), new RobotDinner(), QueueDistribution.getQueue()));

        Semaphore semaphore = new Semaphore(carStations);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        JsonReader jsonReader = new JsonReader(semaphore);
        Future<?> readerFuture = executorService.submit(() -> {
            jsonReader.readStream();
        });

        Future<?> processingFuture = executorService.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                for (CarStation cs : carStations) {
                    try {
                        cs.serveCar();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\n=== Shutting down car service system ===");
            executorService.shutdownNow();
            try {
                executorService.awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                System.err.println("Shutdown interrupted: " + e.getMessage());
            }
            semaphore.displayResults();
            System.out.println("=== System shutdown complete ===\n");
        }));
    }
}