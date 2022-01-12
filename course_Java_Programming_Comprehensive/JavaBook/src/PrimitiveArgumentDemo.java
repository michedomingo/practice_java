public class PrimitiveArgumentDemo {
    void modifyVariable(int photocopy) {
        photocopy = 1000;
    }

    public static void main(String[] args) {
        PrimitiveArgumentDemo obj = new PrimitiveArgumentDemo();
        int original = 1;
        obj.modifyVariable(original);
        System.out.println("original = " + original);
    }
}

// pass-by-value: Java copies arguments into the corresponding parameters
// only parameters (& not arguments) can change inside the method
// ch5_p141_pdf146
