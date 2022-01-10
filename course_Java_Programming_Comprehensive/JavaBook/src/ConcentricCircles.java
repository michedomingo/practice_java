import java.awt.geom.*;
import com.programwithjava.basic.DrawingKit;

public class ConcentricCircles {
    public static void main(String[] args) {
        // create a window on computer screen using DrawingKit contructor
        // title on the window is 'Concentric Circles'
        DrawingKit dk = new DrawingKit("Concentric Circles");
        float x = 125, y = 125, r = 100;

        for (int i = 0; i <= r; i += 20) {
            // draw a circle with diameter 2*(r-i)
            Ellipse2D.Float circle = new Ellipse2D.Float(x + i, y + i, 2 * (r - i), 2 * (r - i));
            dk.draw(circle);
        }
    }
}

// draws five concentric circles with (225, 225) center
// radii of circles are 100, 80, 60, 40 and 20
// ch4_p111_pdf117
