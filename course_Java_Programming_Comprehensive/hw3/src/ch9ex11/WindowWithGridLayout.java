package ch9ex11;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class WindowWithGridLayout {
    private JFrame window;
    private JPanel topPanel, panelOne, panelTwo, panelThree, panelFour;

    public WindowWithGridLayout() {
        window = new JFrame();
        createPanels();
        window.setContentPane(topPanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600, 200);
        window.setTitle("Window with Grid Layout");
        window.setVisible(true);
    }

    public void createPanels() {
        topPanel = new JPanel(new GridLayout(2, 2, 20, 40));
        topPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));

        panelOne = new JPanel();
        panelOne.setBorder(BorderFactory.createTitledBorder("Panel One"));
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        panelOne.add(button1);
        panelOne.add(button2);

        panelTwo = new JPanel();
        panelTwo.setBorder(BorderFactory.createTitledBorder("Panel Two"));
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");
        panelTwo.add(button3);
        panelTwo.add(button4);

        panelThree = new JPanel();
        panelThree.setBorder(BorderFactory.createTitledBorder("Panel Three"));
        JButton button5 = new JButton("Button 5");
        JButton button6 = new JButton("Button 6");
        panelThree.add(button5);
        panelThree.add(button6);

        panelFour = new JPanel();
        panelFour.setBorder(BorderFactory.createTitledBorder("Panel Four"));
        JButton button7 = new JButton("Button 7");
        JButton button8 = new JButton("Button 8");
        panelFour.add(button7);
        panelFour.add(button8);

        topPanel.add(panelOne);
        topPanel.add(panelTwo);
        topPanel.add(panelThree);
        topPanel.add(panelFour);
    }

    public static void main(String[] args) {
        new WindowWithGridLayout();
    }
}

// hw3_ch9_p460_pdf465_ex11c
