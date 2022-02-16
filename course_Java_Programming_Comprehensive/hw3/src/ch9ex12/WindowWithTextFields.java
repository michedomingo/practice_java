package ch9ex12;

import java.awt.event.*;
import javax.swing.*;

public class WindowWithTextFields {

    public static void main(String[] args) {
        JFrame window = new JFrame("Window with Text Fields");
        JPanel panel = new JPanel();
        window.setContentPane(panel);

        JTextField inputField = new JTextField("Enter text here", 20);
        JTextField displayField = new JTextField("see character count here", 15);
        displayField.setEditable(false);

        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer num = inputField.getText().length();
                displayField.setText((num.toString()));
            }
        });
        panel.add(inputField);
        panel.add(displayField);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 100);
        window.setVisible(true);
    }
}

// hw3_ch9_p460_pdf465_ex12
