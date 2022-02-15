package ch8ex4;

public class BackHoe implements Excavator {
    private String tool = "backhoe";

    public void dig() {
        System.out.println("Dig with a " + tool + ".");
    }

    public String getTool() {
        return tool;
    }

    public static void main(String[] args) {
        BackHoe bh = new BackHoe();
        bh.dig();
    }
}

// hw3_ch8_p372_pdf377_ex4
