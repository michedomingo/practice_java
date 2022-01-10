import java.awt.*;
import java.awt.geom.*;
import com.programwithjava.basic.DrawingKit;

public class Squares {
    public static void main(String[] args) {
        // create a window on computer screen using DrawingKit contructor
        // title on the window is 'Squares'
        DrawingKit dk = new DrawingKit("Squares");
        int numberOfSquares = 0, x = 100, y = 150, width = 30, height = 30;

        while (numberOfSquares < 4) {
            // draw and color a square
            Rectangle2D.Float rect_same = new Rectangle2D.Float(x, y, width, height);
            dk.setPaint(Color.blue);
            dk.fill(rect_same);

            // increment number of squares drawn by 1
            numberOfSquares += 1;
            System.out.println(numberOfSquares);

            // increment the x coordinate of the next square by 50
            x += 50;
        }
    }
}

// draws four blue squares with sides of length 30,
// at points (100, 150), (150, 150), (200, 150), and (250, 150)
// ch4_p107_pdf112
