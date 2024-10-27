package Lab1.task1;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;


    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getPpi() {
        return ppi;
    }

    public String getModel() {
        return model;
    }


    public void compareSize(Display m) {
        if ((this.height * this.width) > (m.getHeight() * m.getWidth())) {
            System.out.println(this.model + " is larger than " + m.getModel() + ".");
        } else if ((this.height * this.width) < (m.getHeight() * m.getWidth())) {
            System.out.println(m.getModel() + " is larger than " + this.model + ".");
        } else {
            System.out.println("Both " + this.model + " and " + m.getModel() + " are the same size.");
        }
    }

    public void compareSharpness(Display m) {
        if (this.ppi > m.getPpi()) {
            System.out.println(this.model + " is sharper than " + m.getModel() + ".");
        } else if (this.ppi < m.getPpi()) {
            System.out.println(m.getModel() + " is sharper than " + this.model + ".");
        } else {
            System.out.println("Both " + this.model + " and " + m.getModel() + " have the same sharpness.");
        }
    }

    public void compareWithMonitor(Display m) {
        System.out.println("Comparing " + this.model + " with " + m.getModel() + ":");
        compareSize(m);
        compareSharpness(m);
    }
}
