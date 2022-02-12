package ch7ex28;

import java.awt.*;
import java.awt.image.BufferedImage;
import com.programwithjava.basic.DrawingKit;

// MAIN DRIVER
public class FilteredImage extends Convolution {

    public static final int[][] SHARPENING_KERNAL = { { -1, -1, -1 }, { -1, 9, -1 }, { -1, -1, -1 } };
    public static final int[][] BLURRING_KERNAL = { { -1, -1, -1 }, { -1, 9, -1 }, { -1, -1, -1 } };
    public static final int[][] EDGE_DETECTING_KERNAL = { { -1, -1, -1 }, { -1, 9, -1 }, { -1, -1, -1 } };
    public static final int[][] EMBOSSING_KERNAL = { { -1, -1, -1 }, { -1, 9, -1 }, { -1, -1, -1 } };

    public BufferedImage originalImage; // aka inputImage param in convolve()
    public BufferedImage resultingImage; // reference to modified image ('originalImage' updated)
    public int imgRows; // height = number of horizontal rows of pixels within inputImage
    public int imgColumns; // width = number of vertical columns of pixels within inputImage
    // public int kernalRows; // rows = height
    // public int kernalColumns; // columns = width
    public int[][][] imgArr3D; // stores originalImage pixel data
    public int[][][] imgArrMod3D; // stores resultingImage pixel data
    // public int[] imgArr1D; // stores pixel data...
    // Convolution convolutionObject; // reference to image-processing object ?

    // method populates array w/ inputImage pixel data
    public int[][][] makeImgArr3D(BufferedImage pixelDataToArray) {
        int[][][] pixelData = new int[3][imgRows][imgColumns];

        for (int row = 0; row < imgRows; row++) { // .getHeight()
            for (int col = 0; col < imgColumns; col++) { // .getWidth()
                // get red, green, & blue components of pixel at (col, row)
                Color pixelColor = new Color(pixelDataToArray.getRGB(col, row));
                pixelData[0][row][col] = pixelColor.getRed();
                pixelData[1][row][col] = pixelColor.getGreen();
                pixelData[2][row][col] = pixelColor.getBlue();

            }
        }
        return pixelData;
    }

    // method to process inputImage by
    /// APPLYing the CONVOLUTION OPERATOR 'stored in kernal'
    // returns resulting image
    public BufferedImage convolve(int[][] kernal, BufferedImage inputImage) {

        imgRows = inputImage.getHeight();
        imgColumns = inputImage.getWidth();

        imgArr3D = makeImgArr3D(inputImage);
        imgArrMod3D = applyFilter(imgArr3D, imgRows, imgColumns, kernal);

        // BufferedImage resultingImage = new BufferedImage(imgRows, imgColumns,
        // BufferedImage.TYPE_INT_ARGB);
        resultingImage = inputImage; // placeholder pending method...

        return resultingImage;
    }

    public static void main(String[] args) {
        DrawingKit dk = new DrawingKit("Convolution", 1300, 470);
        BufferedImage originalPicture = dk.loadPicture("image/birds.jpeg");
        dk.drawPicture(originalPicture, 10, 10); // draw original picture

        FilteredImage img = new FilteredImage();
        BufferedImage resultingPicture = img.convolve(BLURRING_KERNAL, originalPicture);
        dk.drawPicture(resultingPicture, 650, 10); // draw modified picture
    }

}

// hw2_ch7_p331_pdf336_ex28
