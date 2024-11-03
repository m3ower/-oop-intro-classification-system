package Lab2.Task2;

public class main {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Intensity.NORMAL, 50);
        System.out.println("Making Cappuccino:");
        cappuccino.printCoffeeDetails();
        System.out.println();

        Americano americano = new Americano(Intensity.STRONG, 70);
        System.out.println("Making Americano:");
        americano.printCoffeeDetails();
        System.out.println();

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.LIGHT, 50, SyrupType.VANILIA);
        System.out.println("Making Syrup Cappuccino:");
        syrupCappuccino.printCoffeeDetails();
        System.out.println();

        PumpkinSpiceLatte psl = new PumpkinSpiceLatte(Intensity.NORMAL, 150, 30);
        System.out.println("Making Pumpkin Spice Latte:");
        psl.printCoffeeDetails();
    }
}