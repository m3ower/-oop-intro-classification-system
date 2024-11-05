package Lab1.task1;

public class main {
    public static void main(String[] args) {
        Display display_1 = new Display(54, 33, 109, "Philips");
        Display display_2 = new Display(60, 33, 92, "Asus");
        Display display_3 = new Display(50, 40, 107, "Dell");


        display_1.compareWithMonitor(display_2);
        System.out.println();
        display_1.compareWithMonitor(display_3);
        System.out.println();
        display_2.compareWithMonitor(display_3);
    }
}
