import java.util.Scanner;

public class Trilateration2D {
    public static void main(String[] args) {
        // declare variables to store the coordinates of A, B, C and U
        double a1, b1, a2, b2, a3, b3, x, y;
        // declare variables to store the distances of A, B and C from U
        double r1, r2, r3;

        // Prompt user to enter coordinates of A, B and C and read them
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the x and y coordinates of point A: ");
        a1 = scanner.nextDouble();
        b1 = scanner.nextDouble();
        System.out.print("Enter the x and y coordinates of point B: ");
        a2 = scanner.nextDouble();
        b2 = scanner.nextDouble();
        System.out.print("Enter the x and y coordinates of point C: ");
        a3 = scanner.nextDouble();
        b3 = scanner.nextDouble();

        // Prompt user to enter the distances and read them
        System.out.print("Enter the distance between A and U: ");
        r1 = scanner.nextDouble();
        System.out.print("Enter the distance between B and U: ");
        r2 = scanner.nextDouble();
        System.out.print("Enter the distance between C and U: ");
        r3 = scanner.nextDouble();

        // Calculate coordinates of U using the formulas for y and x (p78)
        double a1Sq = a1 * a1, a2Sq = a2 * a2, a3Sq = a3 * a3, b1Sq = b1 * b1, b2Sq = b2 * b2, b3Sq = b3 * b3,
                r1Sq = r1 * r1, r2Sq = r2 * r2, r3Sq = r3 * r3;

        double numerator1 = (a2 - a1) * (a3Sq + b3Sq - r3Sq) + (a1 - a3) * (a2Sq + b2Sq - r2Sq)
                + (a3 - a2) * (a1Sq + b1Sq - r1Sq);
        double denominator1 = 2 * (b3 * (a2 - a1) + b2 * (a1 - a3) + b1 * (a3 - a2));
        y = numerator1 / denominator1;

        double numerator2 = r2Sq - r1Sq + a1Sq - a2Sq + b1Sq - b2Sq - 2 * (b1 - b2) * y;
        double denominator2 = 2 * (a1 - a2);
        x = numerator2 / denominator2;

        // Display the coordinates of U
        System.out.println("The coordinates of point U are " + x + " " + y);
    }
}

// use 2D trilateration to determine location of specific place point U
// ch3_p79_pdf84
