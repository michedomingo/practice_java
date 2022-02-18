package ch9ex21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ModifiedPhoto {
    private JFrame window;
    private JPanel topPanel, groupPanel;
    private ModifiedPhotoDrawingPanel drawingPanel;
    private JPanel titlePanel;
    private JLabel titleLabel;

    public ModifiedPhoto() {
        window = new JFrame("Modified Photo");

        createPanels();
        titlePanel = createTitlePanel(); // panel to hold photo's title
        titleLabel = new JLabel("birds.jpeg"); // create label
        titlePanel.add(titleLabel);

        groupPanel.add(createShiftPanel()); // create shift panel

        window.setContentPane(topPanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setVisible(true);
    }

    public void createPanels() {
        topPanel = new JPanel(new BorderLayout());
        drawingPanel = new ModifiedPhotoDrawingPanel();
        groupPanel = new JPanel();

        // add drawingPanel & groupPanel to topPanel
        topPanel.add(drawingPanel, BorderLayout.CENTER);
        topPanel.add(groupPanel, BorderLayout.SOUTH);

        // add borders & backgrounds
        groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.X_AXIS)); // add components to a single row
        groupPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        groupPanel.setBackground(Color.red);
        topPanel.setBackground(Color.blue);
        topPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));
    }

    // creates light gray panel at top of window to label photo
    public JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        topPanel.add(titlePanel, BorderLayout.NORTH);
        titlePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        titlePanel.setBackground(Color.lightGray);
        return titlePanel;
    }

    // creates panel with buttons to shift the image when clicked
    public JPanel createShiftPanel() {
        JPanel buttonPanel = new JPanel();

        JButton shiftNorthButton = new JButton("North");
        JButton shiftSouthButton = new JButton("South");
        JButton shiftEastButton = new JButton("East");
        JButton shiftWestButton = new JButton("West");
        buttonPanel.add(shiftNorthButton);
        buttonPanel.add(shiftSouthButton);
        buttonPanel.add(shiftEastButton);
        buttonPanel.add(shiftWestButton);

        shiftNorthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawingPanel.shiftImage(0, -20); // translate image north
            }
        });

        shiftSouthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawingPanel.shiftImage(0, 20); // translate image south
            }
        });

        shiftEastButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawingPanel.shiftImage(20, 0); // translate image east
            }
        });

        shiftWestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawingPanel.shiftImage(-20, 0); // translate image west
            }
        });

        return buttonPanel;
    }

    public static void main(String[] args) {
        new ModifiedPhoto();
    }
}

// hw3_ch9_p461_pdf466_ex21
