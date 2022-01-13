import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
import com.programwithjava.basic.DrawingKit;

public class BoundedCircles {
    // fields of class BoundedCircles
    int low_x = 150; // smallest x-coordinate of the square
    int low_y = 150; // smallest y-coordinate of the square
    int width = 200; // square width
    int height = 200; // square height
    int radius = 36; // circle radius

    // returns true if circle lies completely within square
    boolean checkIfCircleIsInsideSquare(int x, int y) {
        boolean result = false;
        int high_x = low_x + width, high_y = low_y + height;
        if ((x > low_x) && ((x + 2 * radius) < high_x) && (y > low_y) && ((y + 2 * radius) < high_y))
            result = true;

        return result;
    }

    // create a circle at a random point
    void drawCircle(DrawingKit dk) {
        Random rand = new Random();
        int x = rand.nextInt(400);
        int y = rand.nextInt(400);
        Ellipse2D.Float e1 = new Ellipse2D.Float(x, y, 2 * radius, 2 * radius);
        boolean insideSquare = checkIfCircleIsInsideSquare(x, y);

        // fill circle with red if it lies completely within square
        if (insideSquare) {
            dk.setPaint(Color.RED);
            dk.fill(e1);
        } else {
            dk.setPaint(Color.BLUE);
            dk.draw(e1);
        }
    }

    // draw a square & 15 circles
    void generate(DrawingKit dk) {
        int numCircles = 15;
        // draw square at (150, 150) with height & width of 200
        Rectangle2D.Double r1 = new Rectangle2D.Double(low_x, low_y, width, height);
        dk.draw(r1);

        // draw 15 circles
        for (int i = 0; i < numCircles; i++) {
            drawCircle(dk);
        }
    }

    public static void main(String[] args) {
        DrawingKit mydrawingkit = new DrawingKit("Bounded Circles");
        BoundedCircles circles = new BoundedCircles();
        circles.generate(mydrawingkit);
    }
}

// randomly draws 15 colored circles w/ radius of 36
// circles completely inside square filled with red, otherwise outlined blue
// ch5_p144_pdf149
