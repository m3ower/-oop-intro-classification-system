package Lab2.Task1;

public class Cappuccino extends Coffee {
    private int mlOfMilk;
    private static final String name = "Cappuccino";

    public Cappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        super(coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
    }

    @Override
    public String getName() {
        return name;
    }
}
