import java.util.ArrayList;
import java.util.List;

public class Container {

    private List<Input> inputs;

    public Container() {
        this.inputs = new ArrayList<>();
    }

    public void addInput(Input input) {
        inputs.add(input);
    }

    public List<Input> getAllInputs() {
        return inputs;
    }

    public void displayHumanoids() {
        for (Input input : inputs) {
            if (input.isHumanoid()) { // Filter for humanoids only
                System.out.println("ID: " + input.getId());
                System.out.println("Is Humanoid: " + input.isHumanoid());
                System.out.println("Planet: " + input.getPlanet());
                System.out.println("Age: " + input.getAge());
                System.out.println("Traits: " + input.getTraits());
                System.out.println();
            }
        }
    }
    public void displayInputs() {
        for (Input input : inputs) {
            System.out.println("ID: " + input.getId());
            System.out.println("Is Humanoid: " + input.isHumanoid());
            System.out.println("Planet: " + input.getPlanet());
            System.out.println("Age: " + input.getAge());
            System.out.println("Traits: " + input.getTraits());
            System.out.println();


        }
    }
}
