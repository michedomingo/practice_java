package userdefinedclasses;

import java.awt.*;
import java.awt.geom.*;
import com.programwithjava.basic.DrawingKit;

/*
 * The Lamp class defines a lamp object that can be drawn in a window.
 * Light may be turned on/off, wattage & lamp bulb diameter can be set.
 */

public class Lamp {
    // diameter of lamp globe (p134_pdf139)
    private double diameter;

    // wattage of bulb p135_pdf140
    private int wattage;

    // true if lamp is on
    private boolean lighted;

    // number of lamp objects created (p168_pdf173)
    private static int numberOfObjects;

    // lamp globe
    // private Ellipse2D.Double circle;

    // true if lamp outline is drawn
    // private boolean visible = false;

    /*
     * (p158_pdf163)
     * Constructs new Lamp, initialized diameter 10, wattage 100, lighted false.
     */
    public Lamp() {
        // this statement calls the Lamp(double, int, boolean) constructor
        this(10, 100, false);
    }

    /**
     * (p153_pdf158)
     * Constructs a new Lamp with the specified arguments.
     * 
     * @param dia   the shade diameter.
     * @param watt  the bulb wattage.
     * @param light true if the lamp is turned on, otherwise false.
     */
    public Lamp(double dia, int watt, boolean light) {
        diameter = dia;
        wattage = watt;
        lighted = light;
        ++numberOfObjects;
    }

    /** Method to light the lamp bulb (p137_pdf142) */
    public void turnOn() {
        lighted = true;
    }

    /** Method to turn the lamp OFF */
    public void turnOff() {
        lighted = false;
    }

    /**
     * Method to get lamp diameter.
     * 
     * @return the diameter of the lamp globe.
     */
    public double getDiameter() {
        return diameter;
    }

    /**
     * Method to find out if lamp is lighted.
     * 
     * @return true if lamp is lighted; otherwise, false.
     */
    public boolean isLighted() {
        return lighted;
    }

    /**
     * Method to get lamp wattage.
     * 
     * @return the wattage of the bulb.
     */
    /*
     * public int getWattage() {
     * return wattage;
     * }
     */

    /**
     * Method to change the bulb wattage to specified value
     * 
     * @param x the new wattage for this lamp.
     */
    /*
     * public void setWattage(int x) {
     * wattage = x;
     * }
     */

    /**
     * Method to change the globe diameter to specified value.
     * 
     * @param x the new diameter of the lamp shade.
     */
    /*
     * public void setDiameter(double x) {
     * diameter = x;
     * }
     */

    /**
     * (p169_pdf174)
     * Method to keep count of the number of lamp objects created.
     * 
     * @return the number of the lamp objects created.
     */
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    /**
     * Method to draw a simple outline of a lamp as a globe suspended on a wire.
     * 
     * @param x          the x-coordinate position of the lamp globe.
     * @param y          the y-coordinate of the lamp globe.
     * @param myGraphics the Graphics context to draw the shape.
     */
    /*
     * public void drawOutline(int x, int y, Graphics2D myGraphics) {
     * int w = 20, z = 50;
     * visible = true;
     * myGraphics.setPaint(Color.black);
     * circle = new Ellipse2D.Double(x, y, diameter * w, diameter * w);
     * myGraphics.draw(circle);
     * Line2D line = new Line2D.Double(x + diameter * w / 2, y, x + diameter * w /
     * 2, y - z);
     * myGraphics.draw(line);
     * }
     */

    /**
     * Method to light the lamp by coloring it yellow.
     * 
     * @param myGraphics the Graphics context to color the shape.
     */
    /*
     * public void turnOn(Graphics2D myGraphics) {
     * lighted = true;
     * if (visible) {
     * myGraphics.setPaint(Color.yellow);
     * myGraphics.fill(circle);
     * }
     * }
     */

    /**
     * Method to turn off the lamp by coloring it gray.
     * 
     * @param myGraphics the Graphics context to color the shape.
     */
    /*
     * public void turnOff(Graphics2D myGraphics) {
     * lighted = false;
     * if (visible) {
     * myGraphics.setPaint(Color.gray);
     * myGraphics.fill(circle);
     * }
     * }
     */

    public static void main(String[] args) {
        DrawingKit dk = new DrawingKit("Lamp");
        Graphics2D myGraphics = dk.getGraphics();
        Lamp lamp1 = new Lamp(6.2f, 20, false);
        lamp1.drawOutline(180, 180, myGraphics);
        lamp1.turnOn(myGraphics);
    }

}

// ch5