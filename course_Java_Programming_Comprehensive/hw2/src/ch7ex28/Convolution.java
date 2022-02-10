package ch7ex28;

import java.awt.*;
import java.awt.image.BufferedImage;
import com.programwithjava.basic.DrawingKit;

public class Convolution {

    public int imageWidth, imageHeight, kernalWidth, kernalHeight;
    public int[][][] imageArray;

    // method makes a 2D array representiing the inputImage
    public int[][][] makeImageArray(BufferedImage imageToArray) {
        imageArray = new int[3][imageWidth][imageHeight];

        for (int x = 0; x < imageWidth; x++) {
            for (int y = 0; y < imageHeight; y++) {
                // get red, green, & blue components of pixel at (x, y)
                Color pixelColor = new Color(imageToArray.getRGB(x, y));
                imageArray[0][x][y] = pixelColor.getRed();
                imageArray[1][x][y] = pixelColor.getGreen();
                imageArray[2][x][y] = pixelColor.getBlue();
            }
        }
        return imageArray;
    }

    public int[][] applyConvolutionOperator(int kernal) {
        int[][] newRed = doSomeConvolution(imageArray[0], imageWidth, imageHeight, kernal, 3, 3, 1);
        int[][] newGreen = doSomeConvolution(imageArray[1], imageWidth, imageHeight, kernal, 3, 3, 1);
        int[][] newBlue = doSomeConvolution(imageArray[2], imageWidth, imageHeight, kernal, 3, 3, 1);
    }

    // method to process inputImage by
    /// APPLYing the CONVOLUTION OPERATOR 'stored in kernal'
    // returns resulting image
    public BufferedImage convolve(int[][] kernal, BufferedImage inputImage) {
        imageWidth = inputImage.getWidth();
        imageHeight = inputImage.getHeight();

        imageArray = makeImageArray(inputImage);

        // BufferedImage resultingImage = new BufferedImage(imageWidth, height,
        // BufferedImage.TYPE_INT_ARGB);
        BufferedImage resultingImage = inputImage; // placeholder process pending update

        return resultingImage;
    }

    public static void main(String[] args) {
        DrawingKit dk = new DrawingKit("Convolution", 1300, 470);
        BufferedImage originalPicture = dk.loadPicture("image/birds.jpeg");
        // draw original picture
        dk.drawPicture(originalPicture, 10, 10);

        int[][] kernal = { { -1, -1, -1 }, { -1, 9, -1 }, { -1, -1, -1 } };
        Convolution c = new Convolution();
        BufferedImage resultingPicture = c.convolve(kernal, originalPicture);
        // draw modified picture
        dk.drawPicture(resultingPicture, 650, 10);

    }
}

// hw2_ch7_p331_pdf336_ex28
