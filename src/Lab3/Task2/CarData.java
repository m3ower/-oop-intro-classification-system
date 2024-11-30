package Lab3.Task2;

import java.util.List;

public class CarData {
    private List<Car> cars;

    // Default constructor needed for Jackson
    public CarData() {}

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}