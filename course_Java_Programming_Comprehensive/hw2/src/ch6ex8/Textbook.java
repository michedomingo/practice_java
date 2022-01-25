package ch6ex8;

public class Textbook extends Book {
    // constructs new Textbook with specified arguments
    public Textbook(String name, float cost) {
        super(name, cost);
    }

    public static void main(String[] args) {
        Textbook myBook = new Textbook("Java Programming", 100);
        System.out.println(myBook.getName());
        System.out.println(myBook.getCost());
    }
}

// hw2_ch6_p263_pdf268_ex8
