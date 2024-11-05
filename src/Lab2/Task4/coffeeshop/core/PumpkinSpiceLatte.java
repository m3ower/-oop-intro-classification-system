package Lab2.Task4.coffeeshop.core;

protected class PumpkinSpiceLatte extends Cappuccino {
    private Integer mgOfPumpkinSpice;
    private static final String NAME = "PumpkinSpiceLatte";

    private PumpkinSpiceLatte(Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(coffeeIntensity, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    @Override
    public String getName() {
        return NAME;
    }

    public Integer getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Amount of pumpkin spice (mg): " + mgOfPumpkinSpice);
    }

    public static PumpkinSpiceLatte makePumpkinSpiceLatte(Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        PumpkinSpiceLatte newPumpkinSpiceLatte = new PumpkinSpiceLatte(coffeeIntensity, mlOfMilk, mgOfPumpkinSpice);
        System.out.println("Making " + newPumpkinSpiceLatte.getName());
        System.out.println("Adding " + mgOfPumpkinSpice + " mg of pumpkin spice");
        return newPumpkinSpiceLatte;
    }
}
