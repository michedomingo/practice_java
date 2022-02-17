package ch9ex16;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonsAndTextArea {
    private JRadioButton rbuttonGreen;
    private JRadioButton rbuttonRed;
    private JRadioButton rbuttonOrange;
    private JRadioButton rbuttonBlue;
    private JRadioButton rbuttonYellow;
    private JRadioButton rbuttonBlack;
    private JTextArea textArea;

    public RadioButtonsAndTextArea() {
        JFrame window = new JFrame("Radio Buttons with Text Area");
        JPanel topPanel = new JPanel(new BorderLayout());
        ButtonGroup group = new ButtonGroup();
        textArea = new JTextArea(5, 15);
        rbuttonGreen = new JRadioButton("Green");
        rbuttonRed = new JRadioButton("Red");
        rbuttonOrange = new JRadioButton("Orange");
        rbuttonBlue = new JRadioButton("Blue");
        rbuttonYellow = new JRadioButton("Yellow");
        rbuttonBlack = new JRadioButton("Black");
        group.add(rbuttonGreen);
        group.add(rbuttonRed);
        group.add(rbuttonOrange);
        group.add(rbuttonBlue);
        group.add(rbuttonYellow);
        group.add(rbuttonBlack);

        rbuttonGreen.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (((JRadioButton) e.getSource()).isSelected())
                    textArea.setText("Green radio button selected");
            }
        });

        rbuttonRed.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (((JRadioButton) e.getSource()).isSelected())
                    textArea.setText("Red radio button selected");
            }
        });

        rbuttonOrange.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (((JRadioButton) e.getSource()).isSelected())
                    textArea.setText("Orange radio button selected");
            }
        });

        rbuttonBlue.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (((JRadioButton) e.getSource()).isSelected())
                    textArea.setText("Blue radio button selected");
            }
        });

        rbuttonYellow.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (((JRadioButton) e.getSource()).isSelected())
                    textArea.setText("Yellow radio button selected");
            }
        });

        rbuttonBlack.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (((JRadioButton) e.getSource()).isSelected())
                    textArea.setText("Black radio button selected");
            }
        });

        JPanel radioButtonPanel = new JPanel(new GridLayout(3, 2, 100, 20));
        radioButtonPanel.add(rbuttonGreen);
        radioButtonPanel.add(rbuttonRed);
        radioButtonPanel.add(rbuttonOrange);
        radioButtonPanel.add(rbuttonBlue);
        radioButtonPanel.add(rbuttonYellow);
        radioButtonPanel.add(rbuttonBlack);

        JPanel titlePanel = new JPanel();
        titlePanel.add(new JLabel("Select a color:\n"));
        topPanel.add(titlePanel, BorderLayout.NORTH);
        topPanel.add(radioButtonPanel, BorderLayout.CENTER);
        topPanel.add(textArea, BorderLayout.SOUTH);
        window.setContentPane(topPanel);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new RadioButtonsAndTextArea();
    }
}

// hw3_ch9_p461_pdf466_ex16
