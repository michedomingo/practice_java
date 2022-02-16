package ch9ex15;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckBoxesAndTextArea {
    private JCheckBox checkboxName;
    private JCheckBox checkboxAddress;
    private JCheckBox checkboxPhone;
    private JTextArea textArea;

    public CheckBoxesAndTextArea() {
        JFrame window = new JFrame("Check Boxes with Text Area");
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel checkboxPanel = new JPanel();

        textArea = new JTextArea(5, 25);
        checkboxName = new JCheckBox("Name", false);
        checkboxAddress = new JCheckBox("Address", false);
        checkboxPhone = new JCheckBox("Phone Number", false);

        // create and add the event handler to checkboxName
        checkboxName.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String txt = textArea.getText();
                String name = "Person's name\n";
                if (checkboxName.isSelected())
                    textArea.append(name);
                else if (txt.contains(name))
                    textArea.setText(txt.replaceAll(name, ""));
            }
        });

        // create and add the event handler to checkboxAddress
        checkboxAddress.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String txt = textArea.getText();
                String address = "Person's address\n";
                if (checkboxAddress.isSelected())
                    textArea.append(address);
                else if (txt.contains(address))
                    textArea.setText(txt.replaceAll(address, ""));
            }
        });

        // create and add the event handler to checkboxPhone
        checkboxPhone.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String txt = textArea.getText();
                String phone = "Person's phone number\n";
                if (checkboxPhone.isSelected())
                    textArea.append(phone);
                else if (txt.contains(phone))
                    textArea.setText(txt.replaceAll(phone, ""));
            }
        });

        // add check boxes to checkboxPanel
        checkboxPanel.add(checkboxName);
        checkboxPanel.add(checkboxAddress);
        checkboxPanel.add(checkboxPhone);
        // use border layout for topPanel
        topPanel.add(checkboxPanel, BorderLayout.NORTH);
        topPanel.add(textArea, BorderLayout.CENTER);

        window.setContentPane(topPanel);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBoxesAndTextArea();
    }
}

// hw3_ch9_p461_pdf466_ex15
