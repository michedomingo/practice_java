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

    public void displayType() {
        System.out.println("type: " + type);
    }

    public void displayTemperature() {
        System.out.println("temperature: " + temperature);
    }

    // save object's state as binary stream (sequence of bytes)
    public Thermometer serializeThermometer() {
        Thermometer thermometerToSerialize = new Thermometer(getInputType(), getInputTemperature());

        try (FileOutputStream fileOut = new FileOutputStream("thermometer.dat");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(thermometerToSerialize);
        } catch (FileNotFoundException e) {
            System.err.println("File could not be found" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException" + e.getMessage());
        }
        return thermometerToSerialize;
    }

    // reverse process/restore object back from binary data
    public Thermometer deserializeThermometer() {
        Thermometer thermometerToDeserialize = new Thermometer(null, 0);

        try (FileInputStream fileIn = new FileInputStream("thermometer.dat");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            thermometerToDeserialize = (Thermometer) objectIn.readObject();

        } catch (FileNotFoundException e) {
            System.err.println("File could not be found" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException" + e.getMessage());
        }
        return thermometerToDeserialize;
    }

    public static void main(String[] args) {
        Thermometer data1 = new Thermometer().serializeThermometer();
        System.out.println("data1.getThermometerType(): " + data1.getThermometerType());
        System.out.println("data1.getThermometerTemperature(): " +
                data1.getThermometerTemperature());

        Thermometer data2 = new Thermometer().deserializeThermometer();
        System.out.println("data2.getThermometerType(): " + data2.getThermometerType());
        System.out.println("data2.getThermometerTemperature(): " +
                data2.getThermometerTemperature());
    }
}

// hw5_ch11_p536_pdf541_ex9
