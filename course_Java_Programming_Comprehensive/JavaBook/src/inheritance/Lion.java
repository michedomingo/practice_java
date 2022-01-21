package inheritance;

public class Lion extends Cat {
    // vocalize method in Lion
    public void vocalize() {
        System.out.println("ROAR!");
    }

    public static void main(String[] args) {
        Cat lion = new Lion();
        lion.vocalize();
        Cat houseCat = new HouseCat();
        houseCat.vocalize();
    }
}
