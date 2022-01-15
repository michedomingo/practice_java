import java.awt.geom.*;
import com.programwithjava.basic.DrawingKit;

public class GridOfSquares {

    // create square in first column & first row at (10, 30), each of side 20
    public void drawSquare(DrawingKit dk, int columnSpace, int rowSpace) {
        int x = 10 + rowSpace, y = 30 + columnSpace, width = 20, height = 20;
        Rectangle2D.Float square = new Rectangle2D.Float(x, y, width, height);
        dk.draw(square);
    }

    // draw grid of 81 squares, separated by a distance of 10
    public void generateSquares(DrawingKit dk) {
        int columnDistance = 0, rowDistance = 0;

        for (int column = 0; column < 9; column++) {
            for (int row = 0; row < 9; row++) {
                drawSquare(dk, columnDistance, rowDistance);
                // increment next square by 30 (each side 20 + distance 10)
                rowDistance += 30;
            }
            // reset 1st square x-coordinate of column to 10
            rowDistance = 0;
            // increment the y-coordinate of the next square by 30
            columnDistance += 30;
        }
    }

    public static void main(String[] args) {
        // create a window on computer screen with title 'Grid of squares'
        DrawingKit newWindow = new DrawingKit("Grid of squares");

        // create an instance of class GridOfSquares
        GridOfSquares grid = new GridOfSquares();

        // draw grid of squares on newWindow instance on screen
        grid.generateSquares(newWindow);

    }
}

// draws grid of 81 squares, each of side 20, separated by distance of 10
// ch4_p107_pdf112_example3, hw1_p130_pdf135_exercise19
