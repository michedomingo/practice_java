package ch9ex11;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class WindowWithFlowLayout {
    private JFrame window;
    private JPanel topPanel, panelOne, panelTwo, panelThree, panelFour;

    public WindowWithFlowLayout() {
        window = new JFrame();
        createPanels();
        window.setContentPane(topPanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1100, 200);
        window.setTitle("Window with Flow Layout");
        window.setVisible(true);
    }

    public void createPanels() {
        topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 30, 50));
        topPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));

        panelOne = new JPanel();
        panelOne.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
                BorderFactory.createTitledBorder("Panel One")));
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        panelOne.add(button1);
        panelOne.add(button2);

        panelTwo = new JPanel();
        panelTwo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED),
                BorderFactory.createTitledBorder("Panel Two")));
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");
        panelTwo.add(button3);
        panelTwo.add(button4);

        panelThree = new JPanel();
        panelThree.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
                BorderFactory.createTitledBorder("Panel Three")));
        JButton button5 = new JButton("Button 5");
        JButton button6 = new JButton("Button 6");
        panelThree.add(button5);
        panelThree.add(button6);

        panelFour = new JPanel();
        panelFour.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED),
                BorderFactory.createTitledBorder("Panel Four")));
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
        new WindowWithFlowLayout();
    }
}

// hw3_ch9_p460_pdf465_ex11a
