import java.awt.*;
import java.awt.image.BufferedImage;
import com.programwithjava.basic.DrawingKit;

public class ChangeImageBrightness {
    public static void main(String[] args) {
        // create a window on computer screen using DrawingKit constructor
        // specify window size (update from default WxH: 500x500)
        DrawingKit dk = new DrawingKit("Change brightness", 1680, 700);
        BufferedImage picture = dk.loadPicture("image/yosemite.jpg");
        // draw original picture
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

                // multiply red, green, & blue samples by 1.75 (or set 255 max)
                red = red <= 145 ? (int) (red * 1.75f) : 255;
                green = green <= 145 ? (int) (green * 1.75f) : 255;
                blue = blue <= 145 ? (int) (blue * 1.75f) : 255;

                // update the pixel color in picture
                Color newPixelColor = new Color(red, green, blue);
                int newRgbvalue = newPixelColor.getRGB();
                picture.setRGB(x, y, newRgbvalue);
            } // end inner for loop
        } // end outer for loop

        // draw modified picture
        dk.drawPicture(picture, 860, 50);
    }
}

// change brightness of picture by multiplying RGB samples of each pixel by 1.75
// sample values should not exceed 255
// ch4_p124_pdf129
