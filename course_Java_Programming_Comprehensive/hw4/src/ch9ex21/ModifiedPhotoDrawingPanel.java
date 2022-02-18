package ch9ex21;

import java.awt.*;
import javax.swing.*;

public class ModifiedPhotoDrawingPanel extends JPanel {
    private Image backgroundImage;

    private int shiftX = 0; // shift image along x-axis
    private int shiftY = 0; // shift image along y-axis
    private double angle = 0.0; // rotate image by this angle

    public ModifiedPhotoDrawingPanel() {
        backgroundImage = new javax.swing.ImageIcon("image/birds.jpeg").getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // shift image
        g2.translate(shiftX, shiftY);

        // rotate image
        g2.rotate(angle, 250, 250);

        g2.drawImage(backgroundImage, 0, 0, null);
    }

    public void shiftImage(int x, int y) {
        shiftX += x;
        shiftY += y;
        repaint();
    }

    public void rotateImage(double a) {
        angle += a;
        repaint();
    }

    public void loadImage(Image i) {
        backgroundImage = i;
        repaint();
    }

}

// hw3_ch9_p461_pdf466_ex21
