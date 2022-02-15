package ch8ex5;

public class Guitar implements Tuner {
    public void tune() {
        System.out.println("Tuning Guitar");
    }

    public static void main(String[] args) {
        Radio r = new Radio();
        r.tune();
        Guitar g = new Guitar();
        g.tune();
    }
}

// hw3_ch8_p372_pdf377_ex5
