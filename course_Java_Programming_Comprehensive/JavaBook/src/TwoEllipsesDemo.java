import java.awt.*;
import java.awt.geom.*;
import com.programwithjava.basic.DrawingKit;

public class TwoEllipsesDemo {
    public static void main(String[] args) {
        // create a window on computer screen using DrawingKit constructor
        // title on the window is 'Two Ellipses'
        DrawingKit dk = new DrawingKit("Two Ellipses");

        // create and draw 1st ellipse with default line width (1.0)
        // top-left corner (50, 100) + width 50 & height 60
        Ellipse2D.Float one = new Ellipse2D.Float(50, 100, 50, 60);
        dk.draw(one);

        Ellipse2D.Float two = new Ellipse2D.Float(300, 100, 50, 60);
        // change line width/thickness using the constructor of class BasicStroke
        BasicStroke s2 = new BasicStroke(8);
        dk.setStroke(s2);

        // draw 2nd ellipse with new line width(8.0)
        dk.draw(two);

        // Set font & write the words 'Two Ellipses'
        Font myfont = new Font("ARIAL", Font.BOLD, 32);
        dk.setFont(myfont);
        dk.drawString("Two Ellipses", 100, 300);

        // color 1st ellipse with magenta
        dk.setPaint(Color.magenta);
        dk.fill(one);

        // color 2nd ellipse with yellow
        dk.setPaint(Color.yellow);
        dk.fill(two);
    }

}
