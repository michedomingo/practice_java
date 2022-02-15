package ch8ex4;

public class Mole implements Excavator {
    private String tool = "mole";

    public void dig() {
        System.out.println("Dig with a " + tool + ".");
    }

    public String getTool() {
        return tool;
    }

    public static void main(String[] args) {
        Mole m = new Mole();
        m.dig();
    }
}

// hw3_ch8_p372_pdf377_ex4
