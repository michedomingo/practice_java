package ch8ex5;

public class Radio implements Tuner {
    public void tune() {
        System.out.println("Tuning Radio");
    }

    public static void main(String[] args) {
        Radio r = new Radio();
        r.tune();
    }
}

// hw3_ch8_p372_pdf377_ex5
