package inheritance;

class Goat extends Animal {
}

public class PettingZoo extends Zoo {
    private Goat billy;

    public PettingZoo() {
        billy = new Goat();
    }

    // return type of Goat (subclass of Animal) allowed
    public Goat getAnimal() {
        return billy;
    }
}
