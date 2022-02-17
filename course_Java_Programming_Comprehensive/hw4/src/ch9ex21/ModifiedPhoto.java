package ch9ex21;

import java.awt.*;
// import java.awt.event.*;
import javax.swing.*;

public class ModifiedPhoto {
    private JFrame window;
    private JPanel topPanel, groupPanel;
    private ModifiedPhotoDrawingPanel drawingPanel;
    // private ButtonGroup group;

    public ModifiedPhoto() {
        window = new JFrame("Modified Photo");
        // group = new ButtonGroup();

        createPanels();

        window.setContentPane(topPanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setVisible(true);
    }

    public void createPanels() {
        topPanel = new JPanel(new BorderLayout());
        drawingPanel = new ModifiedPhotoDrawingPanel();
        groupPanel = new JPanel();

        // add drawingPanel to topPanel
        topPanel.add(drawingPanel, BorderLayout.CENTER);
        topPanel.add(groupPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        new ModifiedPhoto();
    }
}

// hw3_ch9_p461_pdf466_ex21
