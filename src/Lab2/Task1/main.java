package Lab2.Task1;


public class main {
    public static void main(String[] args) {
        Cappuccino myCappuccino = new Cappuccino(Intensity.NORMAL, 50);
        Americano myAmericano = new Americano(Intensity.STRONG, 70);
        PumpkinSpiceLatte myPumpkin = new PumpkinSpiceLatte(Intensity.LIGHT, 100, 150);
        SyrupCappuccino mySyrupCappuccino = new SyrupCappuccino(Intensity.NORMAL, 80, SyrupType.CARAMEL);

        //System.out.println(mySyrupCappuccino.getName());
        // System.out.println(myCappuccino.getName());
        // System.out.println(myPumpkin.getName());
        // System.out.println(myAmericano.getName());
    }
}
