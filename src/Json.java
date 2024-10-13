import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Json {
    public static String getJSONFromFile(String filename) {
        StringBuilder jsonText = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText.append(line).append("\n");
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonText.toString();
    }

    public static void prettyPrintJSON(String json) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(json);
            JSONArray inputArray = (JSONArray) jsonObject.get("input");

            for (Object obj : inputArray) {
                JSONObject entry = (JSONObject) obj;
                long id = (long) entry.get("id");

                boolean isHumanoid = entry.get("isHumanoid") != null && (boolean) entry.get("isHumanoid");
                String planet = (String) entry.get("planet");
                long age = entry.get("age") != null ? (long) entry.get("age") : -1; // Use -1 if age is null
                JSONArray traits = (JSONArray) entry.get("traits");

                System.out.println("\nid: " + id);
                System.out.println("isHumanoid: " + isHumanoid);
                System.out.println("planet: " + (planet != null ? planet : "N/A"));
                System.out.println("age: " + (age != -1 ? age : "N/A")); // Print "N/A" if age is -1
                System.out.print("traits: ");
                if (traits != null) {
                    for (int j = 0; j < traits.size(); j++) {
                        System.out.print(traits.get(j));
                        if (j < traits.size() - 1) {
                            System.out.print(", ");
                        }
                    }
                } else {
                    System.out.print("N/A");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String filename = "./filesdoc/input.json";
        String json = getJSONFromFile(filename);
        prettyPrintJSON(json);
    }
}
