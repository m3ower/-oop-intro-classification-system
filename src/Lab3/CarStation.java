package Lab3;
import Lab3.interfaces.IDineable;
import Lab3.interfaces.IRefuelable;
import Lab3.interfaces.IQueue;


public class CarStation {
    private IDineable diningService;
    private IRefuelable refuelingService;
    private IQueue<Car> queue;

    public CarStation(IRefuelable refuelingService, IDineable diningService, IQueue<Car> queue) {
        this.refuelingService = refuelingService;
        this.diningService = diningService;
        this.queue = queue;
    }

    public void serveCar() {
        Car car = queue.dequeue();
        if (car == null) {
            return;
        }
        if (car.getIsDining()) {
            diningService.serveDinner(car.getId());
        }
        refuelingService.refuel(car.getId());
    }

    public boolean addCar(Car car) {
        try {
            queue.enqueue(car);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }


    public IQueue<Car> getQueue() {
        return queue;
    }

    public IRefuelable getRefuelable() {
        return refuelingService;
    }

    public IDineable getDineable() {
        return diningService;
    }
}