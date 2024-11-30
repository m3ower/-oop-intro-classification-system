package Lab3.Task2;

public class Car {
    private String id;
    private boolean needsDinner;
    private boolean isElectric;
    private boolean isRobot;

    // Default constructor needed for Jackson
    public Car() {}

    // Constructor
    public Car(String id, boolean needsDinner, boolean isElectric, boolean isRobot) {
        this.id = id;
        this.needsDinner = needsDinner;
        this.isElectric = isElectric;
        this.isRobot = isRobot;
    }

    // Getters and setters needed for Jackson
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public boolean getNeedsDinner() { return needsDinner; }
    public void setNeedsDinner(boolean needsDinner) { this.needsDinner = needsDinner; }

    public boolean getIsElectric() { return isElectric; }
    public void setIsElectric(boolean isElectric) { this.isElectric = isElectric; }

    public boolean getIsRobot() { return isRobot; }
    public void setIsRobot(boolean isRobot) { this.isRobot = isRobot; }
}