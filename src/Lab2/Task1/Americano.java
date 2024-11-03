package Lab2.Task1;

public class Americano extends Coffee {
    private int mlOfWater;
    private static final String name = "Americano";

    public Americano(Intensity coffeeIntensity, int mlOfWater) {
        super(coffeeIntensity);
        this.mlOfWater = mlOfWater;
    }

    @Override
    public String getName() {
        return name;
    }
}
