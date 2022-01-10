import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;
import com.programwithjava.basic.DrawingKit;

public class PixelColorDemo {
    public static void main(String[] args) {
        int x = 500, y = 80;
        // create a window on computer screen using DrawingKit constructor
        // specify window size (update from default WxH: 500x500)
        DrawingKit dk = new DrawingKit("Daffodils", 800, 800);

        // transfer image from daffodils.jpg file into computer memory
        BufferedImage pict = dk.loadPicture("image/daffodils.jpg");

        // get pixel value at location (500, 80)
        int encodedPixelColor = pict.getRGB(x, y);
        // creates a new Color object using the encoded color value encodedPixelColor
        Color pixelColor = new Color(encodedPixelColor);
        System.out.println(pixelColor);

    }
}

// displays contents of daffodils.jpg in window
// prints samples of a pixel at location (500, 80) of window
// ch3_p75_pdf80