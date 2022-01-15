import java.awt.*;
import java.awt.image.BufferedImage;
import com.programwithjava.basic.DrawingKit;

public class ChangeImageColors {
    public static void main(String[] args) {
        // create a window on computer screen with title 'Change colors'
        DrawingKit dk = new DrawingKit("Change colors", 1680, 700);
        BufferedImage picture = dk.loadPicture("image/daffodils.jpg");
        // draw the original picture
        dk.drawPicture(picture, 0, 50);

        // modify pixels in picture
        for (int x = 0; x < picture.getWidth(); x++) {
            for (int y = 0; y < picture.getHeight(); y++) {
                // get red, green, & blue components of pixel at (x, y)
                int colorValue = picture.getRGB(x, y);
                Color pixelColor = new Color(colorValue);
                int red = pixelColor.getRed();
                int green = pixelColor.getGreen();
                int blue = pixelColor.getBlue();

                // assign new red, green, & blue components with inverted values
                int newRed = 255 - red;
                int newGreen = 255 - green;
                int newBlue = 255 - blue;

                // update the pixel color in picture
                Color newPixelColor = new Color(newRed, newGreen, newBlue);
                int newRgbvalue = newPixelColor.getRGB();
                picture.setRGB(x, y, newRgbvalue);
            }
        }
        // draw modified picture
        dk.drawPicture(picture, 800, 50);
    }
}

// manipulate image pixels replaced with inverted/complementary values
// ch4_p119_pdf124_example8, hw1_p131_pdf136_exercise21
