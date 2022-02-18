package ch9ex21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModifiedPhotoDrawingPanel extends JPanel {
    private Image backgroundImage;

    private int shiftX = 0; // shift image along x-axis
    private int shiftY = 0; // shift image along y-axis

    public ModifiedPhotoDrawingPanel() {
        backgroundImage = new javax.swing.ImageIcon("image/birds.jpeg").getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // shift image
        g2.translate(shiftX, shiftY);

        g2.drawImage(backgroundImage, 0, 0, null);
    }

    public void shiftImage(int x, int y) {
        shiftX += x;
        shiftY += y;
        repaint();
    }

}

// hw3_ch9_p461_pdf466_ex21
