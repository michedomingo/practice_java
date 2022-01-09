import java.awt.*;
import java.awt.geom.*;
import com.programwithjava.basic.DrawingKit;

public class SpaceShip {
    public static void main(String[] args) {
        // create a window on computer screen using DrawingKit constructor
        // specify window size (update from default WxH: 500x500)
        DrawingKit dk = new DrawingKit("Spaceship", 1200, 900);

        // draw image stored in file
        dk.drawPicture("image/space.jpg");

        // draw the body
        // set line width (from default 1.0 to 2.0) & color to red
        BasicStroke stroke1 = new BasicStroke(2);
        dk.setStroke(stroke1);
        dk.setPaint(Color.red);

        // draw quadratic curves joining the points:
        // (500, 500) & (700, 500) through the point (600, 400)
        QuadCurve2D.Float curve1 = new QuadCurve2D.Float();
        curve1.setCurve(500, 500, 600, 400, 700, 500);
        dk.draw(curve1);
        // (500, 500) & (700, 500) through the point (600, 610)
        QuadCurve2D.Float curve2 = new QuadCurve2D.Float();
        curve2.setCurve(500, 500, 600, 610, 700, 500);
        dk.draw(curve2);
        dk.setPaint(Color.yellow);
        dk.fill(curve1);
        dk.fill(curve2);

        // draw a window
        dk.setPaint(Color.lightGray);
        Ellipse2D.Float curve3 = new Ellipse2D.Float(580, 425, 50, 60);
        dk.fill(curve3);
        dk.setPaint(Color.red);
        dk.draw(curve3);

        // draw the wings
        // create and draw 1st ellipse with stoke2 line width (22.0)
        // top-left corner (660, 495) + width 80 & height 15
        Ellipse2D.Float ellipse1 = new Ellipse2D.Float(660, 495, 80, 15);
        dk.fill(ellipse1);
        BasicStroke stroke2 = new BasicStroke(22);
        dk.setStroke(stroke2);

        Line2D.Float line1 = new Line2D.Float(685, 475, 700, 455);
        dk.draw(line1);
        Line2D.Float line2 = new Line2D.Float(685, 530, 710, 555);
        dk.draw(line2);

        // name the spaceship
        Font font1 = new Font("ARIAL", Font.ITALIC, 13);
        dk.setFont(font1);
        dk.drawString("STARSHIP", 570, 520);

    }
}

// ch2_p36_pdf42
