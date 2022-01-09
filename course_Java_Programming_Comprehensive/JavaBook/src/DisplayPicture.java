import java.awt.image.*;
import com.programwithjava.basic.DrawingKit;

public class DisplayPicture {
    public static void main(String[] args) {
        // create a window on computer screen using DrawingKit constructor
        // specify window size (update from default WxH: 500x500)
        DrawingKit dk = new DrawingKit("Daffodils", 850, 850);

        // transfer image from daffodils.jpg file into computer memory
        BufferedImage pict = dk.loadPicture("image/daffodils.jpg");

        // draw image referenced by pict on screen window at coordinate (25, 50)
        dk.drawPicture(pict, 25, 50);
    }
}

// ch3_p73_pdf78
