import java.util.Random;
import java.awt.geom.*;
import com.programwithjava.basic.DrawingKit;

public class ConcentricCircles {

    // generate random numbers to test program for various values of R
    public int selectRadius() {
        int max = 201, min = 20;
        Random randRadius = new Random();
        return randRadius.nextInt(max - min) + min;
    }

    // create circle at same center
    public void drawCircle(DrawingKit dk, float rad) {
        float x = 225, y = 225;
        Ellipse2D.Float circle = new Ellipse2D.Float(x - rad, y - rad, 2 * rad, 2 * rad);
        dk.draw(circle);
    }

    // draw set of consecutive circles with radii differ by 10
    public void generateCircles(DrawingKit dk) {
        float radius = selectRadius();
        // System.out.println(String.format("Random radius: %.2f", radius));
        int countCircles = 0;

        while (2 * radius >= 20) {
            drawCircle(dk, radius);
            countCircles += 1;
            radius -= 10;
        }
        System.out.println(String.format("Number of circles drawn: %d", countCircles));
        System.out.println(String.format("Diameter of innermost circle: %.2f", 2 * (radius + 10)));
    }

    public static void main(String[] args) {
        // create a window on computer screen with title 'Concentric Circles'
        DrawingKit newWindow = new DrawingKit("Concentric Circles");

        // create an instance of class ConcentricCircles
        ConcentricCircles c = new ConcentricCircles();

        // output circles instance on newWindow instance on screen
        c.generateCircles(newWindow);
    }
}

// draws concentric circles with (225, 225) center and random radius
// ch4_p111_pdf117_example6, hw1_p130_pdf135_exercise17
