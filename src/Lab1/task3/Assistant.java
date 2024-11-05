package Lab1.task3;
import Lab1.task1.Display;

import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        assignedDisplays = new ArrayList<>();
    }

    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
    }

    public void assist() {
        for (int i = 0; i < assignedDisplays.size() - 1; i++) {
            assignedDisplays.get(i).compareWithMonitor(assignedDisplays.get(i + 1));
            System.out.println();
        }
    }

    public Display buyDisplay(Display d) {
        assignedDisplays.remove(d);
        return d;
    }
}
