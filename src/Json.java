import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    public static Container parseJSONToInputContainer(String json) {
        JSONParser parser = new JSONParser();
        Container inputContainer = new Container();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(json);
            JSONArray inputArray = (JSONArray) jsonObject.get("input");

            for (Object obj : inputArray) {
                JSONObject entry = (JSONObject) obj;

                long id = (long) entry.get("id");
                boolean isHumanoid = entry.get("isHumanoid") != null && (boolean) entry.get("isHumanoid");
                String planet = (String) entry.get("planet");
                Integer age = entry.get("age") != null ? (int) (long) entry.get("age") : -1;
                JSONArray traits = (JSONArray) entry.get("traits");

                List<String> traitsList = new ArrayList<>();
                if (traits != null) {
                    for (Object trait : traits) {
                        traitsList.add((String) trait);
                    }
                }

                Input input = new Input(
                        (int) id,
                        isHumanoid,
                        planet,
                        age,
                        traitsList
                );
                inputContainer.addInput(input);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inputContainer;
    }

    public static void displayInputs(Container inputContainer) {
        inputContainer.displayInputs();
    }

    public static void main(String[] args) {
        String filename = "./filesdoc/input.json";
        String json = getJSONFromFile(filename);
        Container inputContainer = parseJSONToInputContainer(json);
        displayInputs(inputContainer);

    }
}
