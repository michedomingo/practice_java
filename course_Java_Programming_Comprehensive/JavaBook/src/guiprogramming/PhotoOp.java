package guiprogramming;

import javax.swing.JFrame;

// program to modify photos
public class PhotoOp {
    private JFrame window;

    // constructor
    public PhotoOp() {
        // create the window
        window = new JFrame();
        // when window is closed, terminate the program as well
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set window size
        window.setSize(600, 600);
        // set window title
        window.setTitle("Photo Op");
        // make window visible
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new PhotoOp();
    }
}

// ch9_p380
