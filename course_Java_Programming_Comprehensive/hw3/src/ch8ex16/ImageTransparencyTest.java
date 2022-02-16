package ch8ex16;

import java.awt.image.BufferedImage;
import com.programwithjava.basic.DrawingKit;

public class ImageTransparencyTest {

    public String determineTransparency(BufferedImage pic) {
        if (pic.getTransparency() == 1) {
            return "image is fully opaque and cannot be made transparent (OPAQUE). "
                    + "\n\tPossible to modify transparent pixels? "
                    + pic.getColorModel().hasAlpha();
        } else if (pic.getTransparency() == 2) {
            return "image can only be either fully opaque or fully transparent (BITMASK).";
        } else {
            return "image can be partially transparent (TRANSLUCENT).";
        }
    }

    public static void main(String[] args) {
        DrawingKit dk = new DrawingKit("Check Image Transparency", 600, 265);
        BufferedImage gifImgBees = dk.loadPicture("image/bees.gif");
        dk.drawPicture(gifImgBees, 0, 10);
        BufferedImage jpegImgBirds = dk.loadPicture("image/birds.jpeg");
        dk.drawPicture(jpegImgBirds, 220, 10);
        BufferedImage pngImgBflies = dk.loadPicture("image/butterflies.png");
        dk.drawPicture(pngImgBflies, 470, 10);

        ImageTransparencyTest test = new ImageTransparencyTest();
        System.out.println("bees.gif " + test.determineTransparency(gifImgBees));
        System.out.println("birds.jpeg " + test.determineTransparency(jpegImgBirds));
        System.out.println("butterflies.png " + test.determineTransparency(pngImgBflies));
    }
}

// hw3_ch8_p375_pdf380_ex16
