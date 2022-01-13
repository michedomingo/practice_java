package userdefinedclasses;

public class MathClassDemo {
    public static void main(String[] args) {
        double n1 = -85.6, n2 = 70.4;
        int angle = 45; // in degrees

        System.out.println(String.format("The larger of %.2f and %.2f is %.2f ", n1, n2, +Math.max(n1, n2)));
        System.out.println(String.format("The smaller of %.2f and %.2f is %.2f ", n1, n2, +Math.min(n1, n2)));
        System.out.println(String.format("The value of %.2f raised to the power of 5 is %.2f ", n2, +Math.pow(n2, 5)));
        System.out.println(String.format("abs(%.2f) = %.2f ", n1, +Math.abs(n1)));
        System.out.println(String.format("floor(%.2f) = %.2f ", n1, +Math.floor(n1)));
        System.out.println(String.format("floor(%.2f) = %.2f ", n2, +Math.floor(n2)));
        System.out.println(String.format("ceil(%.2f) = %.2f ", n1, +Math.ceil(n1)));
        System.out.println(String.format("ceil(%.2f) = %.2f ", n2, +Math.ceil(n2)));
        System.out.println(String.format("round(%.2f) = %d ", n1, +Math.round(n1)));
        System.out.println(String.format("round(%.2f) = %d ", n2, +Math.round(n2)));

        // For trigonometric functions, angle should be specified in radians
        double rad = (angle * Math.PI) / 180;
        System.out.println(String.format("sin(%d) = %.2f ", angle, +Math.sin(rad)));
        System.out.println(String.format("cos(%d) = %.2f ", angle, +Math.cos(rad)));
        System.out.println(String.format("tan(%d) = %.2f ", angle, +Math.tan(rad)));
    }
}

// examples of using Math class methods
// ch5_p172_pdf177

/*
 * program output:
 * 
 * The larger of -85.60 and 70.40 is 70.40
 * The smaller of -85.60 and 70.40 is -85.60
 * The value of 70.40 raised to the power of 5 is 1729271944.97
 * abs(-85.60) = 85.60
 * floor(-85.60) = -86.00
 * floor(70.40) = 70.00
 * ceil(-85.60) = -85.00
 * ceil(70.40) = 71.00
 * round(-85.60) = -86
 * round(70.40) = 70
 * sin(45) = 0.71
 * cos(45) = 0.71
 * tan(45) = 1.00
 */
