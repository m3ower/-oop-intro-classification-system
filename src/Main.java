import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        String filename = "./filesdoc/input.json";

        String jsonData = Json.getJSONFromFile(filename);

        System.out.println("JSON Data:");
        System.out.println(jsonData);
    }
}