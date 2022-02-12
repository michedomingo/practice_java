package ch7ex28;

// import java.awt.*;
// import java.awt.image.BufferedImage;
// import com.programwithjava.basic.DrawingKit;

// PROCESSING CLASS
public class Convolution {

    // // constructor
    // public Convolution() {
    // // some data structure (maybe 3D array?) to hold filters / kernals
    // }

    public int[][][] applyFilter(int[][][] imgArr3D, int imgRows, int imgColumns, int[][] kernal) {
        int[][][] modifiedImgArr3D = new int[3][imgRows][imgColumns];

        int[][][] copiedImgArr3D = new int[3][imgRows][imgColumns];
        for (int row = 0; row < imgRows; row++) { // make working copy to avoid original image data changes
            for (int col = 0; col < imgColumns; col++) {
                copiedImgArr3D[0][row][col] = imgArr3D[0][row][col];
                copiedImgArr3D[1][row][col] = imgArr3D[1][row][col];
                copiedImgArr3D[2][row][col] = imgArr3D[2][row][col];
            }
        }

        return modifiedImgArr3D;
    }

}

// hw2_ch7_p331_pdf336_ex28
