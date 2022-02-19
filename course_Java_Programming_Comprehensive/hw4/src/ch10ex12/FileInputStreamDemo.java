package ch10ex12;

import java.io.*;
import javax.swing.*;

public class FileInputStreamDemo {
    public FileInputStreamDemo(String name) {
        createFileInputStreamInstance(name);
    }

    public void createFileInputStreamInstance(String inputFile) {
        FileInputStream in = null;
        try {
            File file = new File(inputFile);
            in = new FileInputStream(file);
            long size = file.length();
            byte[] temp = new byte[(int) size];
            in.read(temp);
            JFrame frame = new JFrame("Hummingbirds");
            frame.getContentPane().add(new JLabel(new ImageIcon(temp)));
            frame.pack();
            frame.setVisible(true);
        } catch (FileNotFoundException e) {
            System.err.println("FileNotFoundException" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException" + e.getMessage());
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                System.err.println("IOException" + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new FileInputStreamDemo("image/birds.jpeg");
    }
}

// hw3_c10_p482_pdf487_ex12
