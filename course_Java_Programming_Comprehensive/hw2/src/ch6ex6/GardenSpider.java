package ch6ex6;

public class GardenSpider extends Spider {
    public GardenSpider() {
        System.out.println("Executing GardenSpider constructor.");
    }

    public void printNumberOfLegs() {
        System.out.println();
        System.out.println(String.format("Number of Legs: %d", numberOfLegs));
    }

    public static void main(String[] args) {
        // @SuppressWarnings("unused")
        GardenSpider spidergarden = new GardenSpider();
        spidergarden.printNumberOfLegs();
    }
}

// hw2_ch6_p262_pdf267_ex6
