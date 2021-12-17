package course_Java_Programming_Comprehensive.module_01.chapter_01.JavaBook.src;

import javax.swing.*;

public class HelloWorld {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First Program");
        frame.getContentPane().add(new JLabel(new ImageIcon("blimp.png")));
        frame.pack();
        frame.setVisible(true);
    }
}
