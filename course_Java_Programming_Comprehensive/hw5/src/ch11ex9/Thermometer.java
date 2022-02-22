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

    public String getThermometerType() {
        return this.type;
    }

    public int getThermometerTemperature() {
        return this.temperature;
    }

    // save object's state as binary stream (sequence of bytes)
    public Thermometer serializeThermometer(Thermometer t1) {

        try (FileOutputStream fileOut = new FileOutputStream("thermometer.dat");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(t1);
        } catch (FileNotFoundException e) {
            System.err.println("File could not be found" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException" + e.getMessage());
        }
        return t1;
    }

    // reverse process/restore object back from binary data
    public Thermometer deserializeThermometer(Thermometer t2) {
        try (FileInputStream fileIn = new FileInputStream("thermometer.dat");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            t2 = (Thermometer) objectIn.readObject();

        } catch (FileNotFoundException e) {
            System.err.println("File could not be found" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException" + e.getMessage());
        }
        return t2;
    }

    public static void main(String[] args) {
        Thermometer data1 = new Thermometer(getInputType(), getInputTemperature());
        data1 = data1.serializeThermometer(data1);
        System.out.println();
        System.out.println("data1.getThermometerType(): " + data1.getThermometerType());
        System.out.println("data1.getThermometerTemperature(): " +
                data1.getThermometerTemperature());
        System.out.println();
        Thermometer data2 = new Thermometer(null, 0);
        data2 = data2.deserializeThermometer(data2);
        System.out.println("data2.getThermometerType(): " + data2.getThermometerType());
        System.out.println("data2.getThermometerTemperature(): " +
                data2.getThermometerTemperature());
    }
}

// hw5_ch11_p536_pdf541_ex9
