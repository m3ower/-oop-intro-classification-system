//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    String filename = "./filesdoc/input.json";
        String jsonData = Json.getJSONFromFile(filename);

        System.out.println("JSON file:");
        System.out.println(jsonData);

    }
}