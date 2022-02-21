package ch11ex9;

import java.io.*;
import java.util.Scanner;

public class Thermometer implements Serializable {
    private String type; // type = mercury or digital
    private int temperature;
    private static Scanner scan;

    public Thermometer() {
    }

    public Thermometer(String inputType, int inputTemperature) {
        type = inputType;
        temperature = inputTemperature;
    }

    public static String getInputType() {
        System.out.println("Enter type - mercury or digital: ");
        scan = new Scanner(System.in);
        String inputType = scan.next();
        return inputType;
    }

    public static int getInputTemperature() {
        System.out.println("Enter temperature: ");
        int inputTemp = scan.nextInt();
        return inputTemp;
    }

    public void displayType() {
        System.out.println("type: " + type);
    }

    public void displayTemperature() {
        System.out.println("temperature: " + temperature);
    }

    public static void main(String[] args) {
        try {
            Thermometer data1 = new Thermometer(getInputType(), getInputTemperature());
            FileOutputStream fileOut = new FileOutputStream("thermometer.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(data1);
            objectOut.close();

            Thermometer data2 = new Thermometer(null, 0);
            FileInputStream fileIn = new FileInputStream("thermometer.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            data2 = (Thermometer) objectIn.readObject();
            objectIn.close();
            data2.displayType();
            data2.displayTemperature();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// hw5_ch11_p536_pdf541_ex9
