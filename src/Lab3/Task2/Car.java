package Lab3.Task2;

public class Car {
    private final String id;
    private final boolean needsDinner;
    private final boolean isElectric;
    private final boolean isRobot;

    public Car(String id, boolean needsDinner, boolean isElectric, boolean isRobot) {
        this.id = id;
        this.needsDinner = needsDinner;
        this.isElectric = isElectric;
        this.isRobot = isRobot;
    }

    public boolean isElectric() { return isElectric; }
    public boolean isRobot() { return isRobot; }

    public String getId() {
        return id;
    }

    public boolean needsDinner() {
        return needsDinner;
    }
}