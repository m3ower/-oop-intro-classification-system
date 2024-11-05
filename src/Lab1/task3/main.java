package Lab1.task3;
import Lab1.task1.Display;

public class main {
    public static void main(String[] args) {
        Display display_1 = new Display(54, 33, 109, "Philips");
        Display display_2 = new Display(60, 33, 92, "Asus");
        Display display_3 = new Display(50, 40, 107, "Dell");

        Assistant assistant = new Assistant("Andrei");
        assistant.assignDisplay(display_1);
        assistant.assist();
        assistant.assignDisplay(display_2);
        assistant.assist();
        assistant.assignDisplay(display_3);
        assistant.assist();

        assistant.buyDisplay(display_1);
    }
}
