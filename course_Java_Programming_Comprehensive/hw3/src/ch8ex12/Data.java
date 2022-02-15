package ch8ex12;

public class Data {
    private int a = 1;
    private int b = 2;

    // inner class
    public class Display {
        // method to display values of Data's fields
        public void print() {
            System.out.println("a: " + a);
            System.out.println("b: " + b);
        }
    }

    public static void main(String[] args) {
        Data outerClass = new Data();
        Data.Display innerClass = outerClass.new Display();
        innerClass.print();
    }
}

// hw3_ch8_p375_pdf380_ex12
