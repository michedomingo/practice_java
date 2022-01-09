import java.awt.*;
import java.awt.geom.*;
import com.programwithjava.basic.DrawingKit;

public class StickFigure {
    public static void main(String[] args) {
        // create a window on computer screen using DrawingKit contructor
        // title on the window is 'Stick Figure'
        DrawingKit dk = new DrawingKit("Stick Figure");
        // initialize reference point/dot coordinates
        int x = 100, y = 100;

        BasicStroke s = new BasicStroke(5);
        dk.setStroke(s);
        Font f = new Font("Arial", Font.ITALIC, 50);
        dk.setFont(f);
        // stick figure moves with this dot/reference point (near figure's head)
        dk.drawString(".", x, y);

        // draw the head
        Ellipse2D.Float head = new Ellipse2D.Float(x, y, 80, 80);
        dk.draw(head);

        // draw the body
        Line2D.Float body = new Line2D.Float(x + 40, y + 80, x + 40, y + 200);
        dk.draw(body);

        // draw the hands
        Line2D.Float hand1 = new Line2D.Float(x + 40, y + 110, x - 20, y + 160);
        dk.draw(hand1);
        Line2D.Float hand2 = new Line2D.Float(x + 40, y + 110, x + 100, y + 160);
        dk.draw(hand2);

        // draw the legs
        Line2D.Float leg1 = new Line2D.Float(x + 40, y + 200, x + 20, y + 300);
        dk.draw(leg1);
        Line2D.Float leg2 = new Line2D.Float(x + 40, y + 200, x + 70, y + 300);
        dk.draw(leg2);
    }
}

// ch3_p57_pdf62
