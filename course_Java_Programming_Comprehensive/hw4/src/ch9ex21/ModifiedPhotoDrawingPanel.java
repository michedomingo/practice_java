package ch9ex21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModifiedPhotoDrawingPanel extends JPanel {
    private Image backgroundImage;

    public ModifiedPhotoDrawingPanel() {
        backgroundImage = new javax.swing.ImageIcon("image/birds.jpeg").getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(backgroundImage, 0, 0, null);
    }

}

// hw3_ch9_p461_pdf466_ex21
