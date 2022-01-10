import java.awt.*;
import java.util.Random;
import java.awt.image.*;
import com.programwithjava.basic.DrawingKit;

public class CrystalBall {
    public static void main(String[] args) {
        // create a window on computer screen using DrawingKit contructor
        // title on the window is 'Crystal Ball'
        DrawingKit dk = new DrawingKit("Crystal Ball");
        int x1 = 120, y1 = 0, x2 = 175, y2 = 230, w1 = 22, w2 = 30, h1 = 40;
        // load & draw image of crystall ball
        BufferedImage pict = dk.loadPicture("image/crystalBall.jpg");
        dk.drawPicture(pict, x1, y1);

        // pseudorandom integer (0, 1, 2 or 3) assigned to variable magicNumber
        Random r = new Random();
        int magicNumber = r.nextInt(4);

        // set the font type & size
        Font myfont = new Font("ARIAL", Font.ITALIC, 18);
        dk.setPaint(Color.gray);
        dk.setFont(myfont);

        // based on magicNumber value, string displayed on screen
        switch (magicNumber) {
            case 0:
                dk.drawString("Something surprising", x2, y2);
                dk.drawString("will happen", x2 + w2, y2 + h1);
                break;
            case 1:
                dk.drawString("An exceptional event", x2, y2);
                dk.drawString("has occurred", x2 + w1, y2 + h1);
                break;
            case 2:
                dk.drawString("Shake the ball", x2 + w2, y2);
                dk.drawString("and focus harder", x2 + w1, y2 + h1);
                break;
            default:
                dk.drawString("Good fortune", x2 + w2, y2);
                dk.drawString("comes your way", x2 + w1, y2 + h1);
                break;
        }
    }
}

// outputs different message on crystal ball each time program runs
// ch4_p101_pdf106
