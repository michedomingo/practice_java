package ch9ex10;

import javax.swing.*;
import javax.swing.border.*;

public class WindowWithSinglePanel {
    private JFrame window;
    private JPanel newPanel;

    public WindowWithSinglePanel() {
        // create the window
        window = new JFrame();

        // create single panel
        newPanel = new JPanel();
        // set bevel raised border around an etched lowered border
        newPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));

        // set panel as the content pane of window
        window.setContentPane(newPanel);

        // when window is closed, terminate the program as well
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set window size
        window.setSize(600, 600);
        // set window title
        window.setTitle("Window with single panel");
        // make window visible
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new WindowWithSinglePanel();
    }
}

// hw3_ch9_p460_pdf465_ex10
