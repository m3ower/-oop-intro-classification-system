//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Input alien1 = new Input(5, true, "Terra", 15, "Small and fat");

        System.out.println(alien1.id);
        alien1.universe1();
    }
}