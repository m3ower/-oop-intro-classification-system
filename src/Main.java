public class Main {
    public static void main(String[] args) {
        String filename = "./filesdoc/input.json";

        String json = Json.getJSONFromFile(filename);

        Container inputContainer = Json.parseJSONToInputContainer(json);

        Json.displayInputs(inputContainer);

        inputContainer.displayHumanoids();
    }
}
