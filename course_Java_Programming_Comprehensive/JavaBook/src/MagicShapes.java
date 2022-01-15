import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
import com.programwithjava.basic.DrawingKit;

public class MagicShapes {
    public static void main(String[] args) {
        int x = 75, y = 75, w1 = 200, h1 = 300, w2 = 300, h2 = 300;
        // create a window on computer screen using DrawingKit contructor
        // title on the window is 'Magic Shapes'
        DrawingKit dk = new DrawingKit("Magic Shapes");

        Random rand = new Random();
        // magicShape gets a random integer value of 0, 1, 2 or 3
        int magicShape = rand.nextInt(4);
        // magicColor gets a random integer value of 0, 1, or 2
        int magicColor = rand.nextInt(3);

        // display the value of magicShape and magicColor
        dk.drawString("magicShape is " + magicShape, 50, 50);
        dk.drawString("magicColor is " + magicColor, 175, 50);

        if (magicColor == 0) {
            // magicColor is 0, set color to red
            dk.setPaint(Color.red);
        } else if (magicColor == 1) {
            // magicColor is 1, set color to cyan
            dk.setPaint(Color.cyan);
        } else {
            // magicColor is 0, set color to magenta
            dk.setPaint(Color.magenta);
        }

        if (magicShape == 0) {
            // magicShape is 0, draw & color a rectangle
            Rectangle2D.Float shape = new Rectangle2D.Float(x, y, w1, h1);
            dk.fill(shape);
        } else if (magicShape == 1) {
            // magicShape is 1, draw & color a elipse
            Ellipse2D.Float shape1 = new Ellipse2D.Float(x, y, w1, h1);
            dk.fill(shape1);
        } else if (magicShape == 2) {
            // magicShape is 2, draw & color a elipse
            Ellipse2D.Float shape2 = new Ellipse2D.Float(x, y, w2, h2);
            dk.fill(shape2);
        } else {
            // magicShape is 3, draw & color a square
            Rectangle2D.Float shape3 = new Rectangle2D.Float(x, y, w2, h2);
            dk.fill(shape3);
        }
    }
}

// creates different shapes with different colors each time program runs
// ch4_p97_pdf102
