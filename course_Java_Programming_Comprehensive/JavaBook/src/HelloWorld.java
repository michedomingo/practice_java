import javax.swing.*; 

public class HelloWorld {
  public static void main(String[] args) {
	// create a window with the title "My First Program"
    JFrame frame = new JFrame("My First Program");
    
    // add "blimp.png" picture in file to this window
    frame.getContentPane().add(new JLabel(new ImageIcon("blimp.png")));
    
    // set the window size so that the contents fit
    frame.pack();
    
    // make the window visible on computer screen
    frame.setVisible(true);				
  }
}
