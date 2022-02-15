package ch8ex4;

public class Archaeologist implements Excavator {
    private String excavator;
    private Mole tool1;
    private BackHoe tool2;

    public Archaeologist(String position) {
        excavator = position;
        tool1 = new Mole();
        tool2 = new BackHoe();
    }

    public void dig() {
        System.out.println(String.format("%s digs with a %s and a %s.", 
        		excavator, tool1.getTool(), tool2.getTool()));
    }

    public static void main(String[] args) {
        Archaeologist a = new Archaeologist("Archaeologist");
        a.dig();
        a.tool1.dig();
        a.tool2.dig();
    }
}

// hw3_ch8_p372_pdf377_ex4
