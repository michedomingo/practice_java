package ch9ex21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ModifiedPhoto {
    JFrame window;
    JPanel topPanel;
    ButtonGroup group;

    public ModifiedPhoto() {
        window = new JFrame("Modified Photo");
        group = new ButtonGroup();

        createPanels();

        window.setContentPane(topPanel);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public void createPanels() {
        topPanel = new JPanel(new BorderLayout());

    }

    public static void main(String[] args) {
        new ModifiedPhoto();
    }
}

// hw3_ch9_p461_pdf466_ex21
