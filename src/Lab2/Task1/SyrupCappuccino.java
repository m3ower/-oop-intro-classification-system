package Lab2.Task1;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    private static final String name = "SyrupCappuccino";

    public SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, mlOfMilk);
        this.syrup = syrup;
    }

    @Override
    public String getName() {
        return name;
    }
}
