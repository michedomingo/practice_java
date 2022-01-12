import java.awt.*;
import java.awt.image.BufferedImage;
import com.programwithjava.basic.DrawingKit;

public class ChangeImageTransparency {
    public static void main(String[] args) {
        // create a window on computer screen using DrawingKit constructor
        // specify window size (update from default WxH: 500x500)
        DrawingKit dk = new DrawingKit("Change transparency", 850, 700);
        BufferedImage picture1 = dk.loadPicture("image/daffodils.jpg");
        // draw first picture
        dk.drawPicture(picture1, 0, 50);

        // load second picture
        BufferedImage picture2 = dk.loadPicture("image/butterflies.png");

        // check if second picture has transparent pixels
        System.out.println(picture2.getColorModel().hasAlpha());

        // modify pixels in second picture
        for (int x = 0; x < picture2.getWidth(); x++) {
            for (int y = 0; y < picture2.getHeight(); y++) {
                // get red, green, & blue components of pixel at (x, y)
                int colorValue = picture2.getRGB(x, y);
                Color pixelColor = new Color(colorValue);
                int red = pixelColor.getRed();
                int green = pixelColor.getGreen();
                int blue = pixelColor.getBlue();

                // check if pixel is in the white background
                if (red > 240 && green > 240 && blue > 240) {
                    // make this pixel transparent by setting alpha to 0
                    int alpha = 0;
                    Color newPixelColor = new Color(red, green, blue, alpha);
                    int newRgbvalue = newPixelColor.getRGB();
                    picture2.setRGB(x, y, newRgbvalue);
                }
            } // end inner for loop
        } // end outer for loop

        // draw the modified second picture
        dk.drawPicture(picture2, 250, 280);
    }
}

// change transparency of picture by modifying alpha channel
// ch4_p122_pdf127
