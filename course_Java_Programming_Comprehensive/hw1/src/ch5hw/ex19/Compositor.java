package ch5hw.ex19;

import java.awt.*;
import java.awt.image.BufferedImage;
import com.programwithjava.basic.DrawingKit;

public class Compositor {
    private static final int MIN_VALUE = 0;

    // this method returns a new image (created with image1 & image2)
    public BufferedImage subtract(BufferedImage image1, BufferedImage image2) {
        int width = Math.min(image1.getWidth(), image2.getWidth());
        int height = Math.min(image1.getHeight(), image2.getHeight());

        BufferedImage image3 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // get samples of pixel at (x, y) in image 1
                int colorValue1 = image1.getRGB(x, y);
                Color pixelColor1 = new Color(colorValue1);
                int red1 = pixelColor1.getRed();
                int green1 = pixelColor1.getGreen();
                int blue1 = pixelColor1.getBlue();

                // get samples of pixel at (x, y) in image 2
                int colorValue2 = image2.getRGB(x, y);
                Color pixelColor2 = new Color(colorValue2);
                int red2 = pixelColor2.getRed();
                int green2 = pixelColor2.getGreen();
                int blue2 = pixelColor2.getBlue();

                // subtract samples to create a new color
                int red3 = Math.max(red1 - red2, MIN_VALUE);
                int green3 = Math.max(green1 - green2, MIN_VALUE);
                int blue3 = Math.max(blue1 - blue2, MIN_VALUE);

                // set color of a pixel in image3
                Color newPixelColor = new Color(red3, green3, blue3);
                int newRgbvalue = newPixelColor.getRGB();
                image3.setRGB(x, y, newRgbvalue);
            }
        }
        return image3;
    }

    public static void main(String[] args) {
        DrawingKit dk = new DrawingKit("Compositor", 1250, 1450);
        BufferedImage p1 = dk.loadPicture("image/pattern1.jpg");
        BufferedImage p2 = dk.loadPicture("image/pattern2.jpg");
        Compositor c = new Compositor();

        BufferedImage p3 = c.subtract(p1, p2);
        dk.drawPicture(p3, 0, 25);

        BufferedImage p4 = c.subtract(p2, p1);
        dk.drawPicture(p4, 0, 700);
    }
}

// manipulates & combines 2 images to produce a new image
// ch5_p148_pdf153, hw1_p190_pdf195_ex19
