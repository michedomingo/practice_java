import java.awt.*;
import java.awt.geom.*;
import com.programwithjava.basic.DrawingKit;

public class RectangleDemo {
    public static void main(String[] args) {
        // create a window on computer screen using DrawingKit contructor
        // title on the window is 'Rectangle'
        DrawingKit dk = new DrawingKit("Rectangle");

        // creates a rectangle
        Rectangle2D.Float rect = new Rectangle2D.Float(50, 100, 200, 100);

        // instance of dk of class DrawingKit calls its draw method
        // to draw the 'rect' object in the window
        dk.draw(rect);
        dk.setPaint(Color.red);
        dk.fill(rect);
    }
}
