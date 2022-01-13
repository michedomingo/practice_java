import java.awt.*;
import java.awt.image.BufferedImage;
import com.programwithjava.basic.DrawingKit;

public class Compositor {
    // maximum value of a sample
    private static final int MAX_VALUE = 255;

    // this method returns a new image (created with image1 & image2)
    public BufferedImage add(BufferedImage image1, BufferedImage image2) {
        int width = Math.min(image1.getWidth(), image2.getWidth());
        int height = Math.min(image1.getHeight(), image2.getHeight());

        // create new BufferedImage named image3
        // TYPE_INIT_ARGB constant type (image in RGB color space w/ alpha channel)
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

                // add samples to create a new color
                // h&w of output image is set to smaller of h&w of input images
                int red3 = Math.min(red1 + red2, MAX_VALUE);
                int green3 = Math.min(green1 + green2, MAX_VALUE);
                int blue3 = Math.min(blue1 + blue2, MAX_VALUE);

                // set color of a pixel in image3
                Color newPixelColor = new Color(red3, green3, blue3);
                int newRgbvalue = newPixelColor.getRGB();
                image3.setRGB(x, y, newRgbvalue);
            }
        }
        // returns a reference to the new image
        return image3;
    }

    public static void main(String[] args) {
        // create a window on computer screen with title 'Compositor'
        // specify window size (update from default WxH: 500x500)
        DrawingKit dk = new DrawingKit("Compositor", 1000, 1000);
        // transfer images from files into computer memory
        BufferedImage p1 = dk.loadPicture("image/pattern1.jpg");
        BufferedImage p2 = dk.loadPicture("image/pattern2.jpg");

        // create an instance of class Compositor
        Compositor c = new Compositor();
        BufferedImage p3 = c.add(p1, p2);
        dk.drawPicture(p3, 0, 100);
    }
}

// manipulates & combines 2 images to produce a new image
// ch5_p148_pdf153
