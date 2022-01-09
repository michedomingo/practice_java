import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        // read the number from console input, assign to variable number 1
        double number1 = scanner.nextDouble();

        System.out.print("Enter another number: ");
        // read the number from console input, assign to variable number 2
        double number2 = scanner.nextDouble();

        System.out.println("The result is: " + (number1 - number2));
    }
}

// ch3_p61_pdf66
