import java.util.*;

public class BreakDemo {
    public static void main(String[] args) {
        int number, x = 10, y = 50;

        for (int i = 0; i < 50; i++) {
            Random r = new Random();
            number = r.nextInt(11);

            System.out.println(number);
            if (number == 5)
                break;
        }
    }
}

// generates 50 random numbers in range 0 to 10
// terminates if number 5 is generated
// ch4_p117_pdf122