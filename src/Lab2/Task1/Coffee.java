package Lab2.Task1;

public abstract class Coffee {
    private Intensity coffeeIntensity;
    private static final String name = "Coffee";

    protected Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public String getName() {
        return name;
    }
}
