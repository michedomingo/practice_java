import java.awt.*;
import java.awt.image.BufferedImage;
import com.programwithjava.basic.DrawingKit;

public class ChangeImageColorsToRed {
    public static void main(String[] args) {
        DrawingKit dk = new DrawingKit("Change colors - display red", 1680, 700);
        BufferedImage picture = dk.loadPicture("image/daffodils.jpg");
        // draw the original picture
        dk.drawPicture(picture, 0, 50);

        // modify the pixels in picture to display only red channel
        for (int x = 0; x < picture.getWidth(); x++) {
            for (int y = 0; y < picture.getHeight(); y++) {

                int newGreen = 0, newBlue = 0;

                // get red component of pixel at (x, y)
                int colorValue = picture.getRGB(x, y);
                Color pixelColor = new Color(colorValue);
                int red = pixelColor.getRed();

                // update the pixel color in picture
                Color newPixelColor = new Color(red, newGreen, newBlue);
                int newRgbvalue = newPixelColor.getRGB();
                picture.setRGB(x, y, newRgbvalue);
            }
        }
        // draw modified picture
        dk.drawPicture(picture, 800, 50);
    }
}

// manipulate image pixels to display only the red channel of the image
// ch4_p119_pdf124_example8, hw1_p131_pdf136_exercise22
