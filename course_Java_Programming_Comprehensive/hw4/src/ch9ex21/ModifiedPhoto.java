package ch9ex21;

import java.awt.*;
// import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class ModifiedPhoto {
    private JFrame window;
    private JPanel topPanel, groupPanel;
    private ModifiedPhotoDrawingPanel drawingPanel;
    private JPanel titlePanel;
    private JLabel titleLabel;
    // private ButtonGroup group;

    public ModifiedPhoto() {
        window = new JFrame("Modified Photo");
        // group = new ButtonGroup();

        createPanels();
        titlePanel = createTitlePanel(); // panel to hold photo's title
        titleLabel = new JLabel("birds.jpeg"); // create label
        titlePanel.add(titleLabel);

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

        // add borders and backgrounds
        groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS)); // add components to a single column
        groupPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        groupPanel.setBackground(Color.lightGray);
        topPanel.setBackground(Color.lightGray);
    }

    // method creates light gray panel at top of window to label photo
    public JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        topPanel.add(titlePanel, BorderLayout.NORTH);
        titlePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        titlePanel.setBackground(Color.lightGray);
        return titlePanel;
    }

    public static void main(String[] args) {
        new ModifiedPhoto();
    }
}

// hw3_ch9_p461_pdf466_ex21
