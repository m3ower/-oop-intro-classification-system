package Lab3;
import java.io.File;
import java.nio.file.Files;
import java.util.HashSet;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class JsonReader {
    private Semaphore semaphore;
    private HashSet<String> processedFiles = new HashSet<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final AtomicBoolean running = new AtomicBoolean(true);

    public JsonReader(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void readStream() {
        Path directory = Paths.get("C:\\Users\\gurev\\OneDrive\\Desktop\\oop\\lab0\\lab0poo\\src\\Lab3\\queue");
        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

            while (running.get()) {
                // First, process any existing files
                readDirectory();

                // Then watch for new files
                WatchKey key = watchService.poll(1, TimeUnit.SECONDS);
                if (key != null) {
                    for (WatchEvent<?> event : key.pollEvents()) {
                        if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                            // Give the file a moment to be fully written
                            Thread.sleep(100);
                            readDirectory();
                        }
                    }
                    key.reset();
                }
            }
        } catch (Exception e) {
            System.err.println("Error watching directory: " + e.getMessage());
        }
    }

    public int readDirectory() {
        String directoryPath = "C:\\Users\\gurev\\OneDrive\\Desktop\\oop\\lab0\\lab0poo\\src\\Lab3\\queue";
        int count = 0;
        try {
            File directory = new File(directoryPath);
            File[] jsonFiles = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));

            if (jsonFiles != null) {
                for (File file : jsonFiles) {
                    if (processedFiles.contains(file.getPath())) {
                        continue;
                    }
                    String jsonString = Files.readString(file.toPath());
                    Car car = objectMapper.readValue(jsonString, Car.class);
                    if (car != null) {
                        boolean classified = semaphore.classify(car);
                        if (classified) {
                            count++;
                            processedFiles.add(file.getPath());
                            file.delete();
                        } else {
                            Thread.sleep(1000);
                        }
                    }
                }
            }
            if (count > 0) {
                System.out.println("Successfully processed " + count + " files.");
            }
        } catch (Exception ex) {
            System.err.println("An error occurred: " + ex.getMessage());
        }
        return count;
    }

    public void stop() {
        running.set(false);
    }
}