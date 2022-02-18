package ch9ex21;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class ModifiedPhoto {
    private JFrame window;
    private JPanel topPanel, groupPanel;
    private ModifiedPhotoDrawingPanel drawingPanel;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JFileChooser chooser;
    private JTextField shearHorizontal;
    private JTextField shearVertical;
    private String rotationAngle;

    public ModifiedPhoto() {
        window = new JFrame("Modified Photo");

        createPanels();
        titlePanel = createTitlePanel(); // panel to hold photo's title
        titleLabel = new JLabel("birds.jpeg"); // create label
        titlePanel.add(titleLabel);

        window.setJMenuBar(createMenuBar()); // create menu bar
        groupPanel.add(createShiftPanel()); // create shift panel

        window.setContentPane(topPanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800, 600);
        window.setVisible(true);
    }

    public void createPanels() {
        topPanel = new JPanel(new BorderLayout());
        drawingPanel = new ModifiedPhotoDrawingPanel();
        groupPanel = new JPanel();

        // add drawingPanel & groupPanel to topPanel
        topPanel.add(drawingPanel, BorderLayout.CENTER);
        topPanel.add(groupPanel, BorderLayout.SOUTH);

        // add borders & backgrounds
        groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.X_AXIS)); // add components to a single row
        groupPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        groupPanel.setBackground(Color.red);
        topPanel.setBackground(Color.blue);
        topPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));
    }

    // creates light gray panel at top of window to label photo
    public JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        topPanel.add(titlePanel, BorderLayout.NORTH);
        titlePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        titlePanel.setBackground(Color.lightGray);
        return titlePanel;
    }

    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile); // add a menu called File to menuBar
        JMenuItem menuFileOpenImage = new JMenuItem("Open Image");
        menuFile.add(menuFileOpenImage); // add Open Image item to File menu

        JMenu menuImage = new JMenu("Image");
        menuBar.add(menuImage); // add a menu called Image to menuBar
        JMenuItem menuImageRotate = new JMenuItem("Rotate");
        menuImage.add(menuImageRotate); // add Rotate item to Image menu
        JMenuItem menuImageShear = new JMenuItem("Shear");
        menuImage.add(menuImageShear); // add Shear item to Image menu
        JMenuItem menuImageScale = new JMenuItem("Scale");
        menuImage.add(menuImageScale); // add Scale item to Image menu

        menuFileOpenImage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectFile();
            }
        });

        menuImageRotate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createRotateOptionPane();
            }
        });

        menuImageShear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createShearValuesOptionPane();
            }
        });

        menuImageScale.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createScaleAmountOptionPane();
            }
        });

        menuBar.setBackground(Color.lightGray);
        return menuBar;
    }

    public void selectFile() {
        chooser = new JFileChooser();
        // file filter allows user to select JPEG & PNG files only
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG & PNG files", "JPG", "JPEG", "PNG");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(window);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            // open a dialog box to select files
            File file = chooser.getSelectedFile();
            System.out.println(file.getPath());

            // load the image from the file and put it in drawing panel
            Image image = new javax.swing.ImageIcon(file.getPath()).getImage();
            drawingPanel.loadImage(image);

            // update the title of the image
            titleLabel.setText(file.getName());
            titlePanel.repaint();
        }
    }

    public void createRotateOptionPane() {
        rotationAngle = JOptionPane.showInputDialog(window, "Enter rotation angle:", "Rotate Image",
                JOptionPane.PLAIN_MESSAGE);
        drawingPanel.rotateImage(Double.valueOf(rotationAngle));
    }

    public void createShearValuesOptionPane() {
        shearHorizontal = new JTextField(5);
        shearVertical = new JTextField(5);

        JPanel shearValuesPanel = new JPanel();
        shearValuesPanel.add(new JLabel("Enter horizontal shear value:"));
        shearValuesPanel.add(shearHorizontal);
        shearValuesPanel.add(Box.createHorizontalStrut(15)); // space between input fields
        shearValuesPanel.add(new JLabel("Enter vertical shear value:"));
        shearValuesPanel.add(shearVertical);

        int result = JOptionPane.showConfirmDialog(null, shearValuesPanel,
                "Shear Image", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            if (!shearHorizontal.getText().isEmpty() && !shearVertical.getText().isEmpty()) {
                drawingPanel.shearImage(Float.parseFloat(shearHorizontal.getText()) / 100.0f,
                        Float.parseFloat(shearVertical.getText()) / 100.0f);
            } else if (!shearHorizontal.getText().isEmpty() && shearVertical.getText().isEmpty()) {
                drawingPanel.shearImage(Float.parseFloat(shearHorizontal.getText()) / 100.0f, 0);
            } else if (shearHorizontal.getText().isEmpty() && !shearVertical.getText().isEmpty()) {
                drawingPanel.shearImage(0, Float.parseFloat(shearVertical.getText()) / 100.0f);
            } else {
                drawingPanel.shearImage(0, 0);
            }
        }
    }

    public void createScaleAmountOptionPane() {
        String scaleAmount = JOptionPane.showInputDialog(window, "Enter scale amount:", "Scale Image",
                JOptionPane.PLAIN_MESSAGE);
        drawingPanel.scaleImage(Float.valueOf(scaleAmount));
    }

    // creates panel with buttons to shift the image when clicked
    public JPanel createShiftPanel() {
        JPanel shiftPanel = new JPanel();
        Border bevelLowered = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
        Border titledCentered = BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(10, 10,
                10, 10, Color.darkGray), "Shift Image", TitledBorder.CENTER, TitledBorder.TOP);
        shiftPanel.setBorder(BorderFactory.createCompoundBorder(bevelLowered, titledCentered));

        JButton shiftNorthButton = new JButton("North");
        JButton shiftSouthButton = new JButton("South");
        JButton shiftEastButton = new JButton("East");
        JButton shiftWestButton = new JButton("West");
        shiftPanel.add(shiftNorthButton);
        shiftPanel.add(shiftSouthButton);
        shiftPanel.add(shiftEastButton);
        shiftPanel.add(shiftWestButton);

        shiftNorthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawingPanel.shiftImage(0, -20); // translate image north
            }
        });

        shiftSouthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawingPanel.shiftImage(0, 20); // translate image south
            }
        });

        shiftEastButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawingPanel.shiftImage(20, 0); // translate image east
            }
        });

        shiftWestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawingPanel.shiftImage(-20, 0); // translate image west
            }
        });
        shiftNorthButton.setToolTipText("Shift image North");
        shiftSouthButton.setToolTipText("Shift image South");
        shiftEastButton.setToolTipText("Shift image East");
        shiftWestButton.setToolTipText("Shift image West");
        shiftPanel.setBackground(Color.lightGray);
        return shiftPanel;
    }

    public static void main(String[] args) {
        new ModifiedPhoto();
    }
}

// hw3_ch9_p461_pdf466_ex21
