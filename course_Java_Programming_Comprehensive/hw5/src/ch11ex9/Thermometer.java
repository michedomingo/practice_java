package ch11ex9;

import java.io.*;
import java.util.Scanner;

public class Thermometer implements Serializable {
    private String type; // type = mercury or digital
    private int temperature;

    public Thermometer(String typeInput, int tempInput) {
        type = typeInput;
        temperature = tempInput;
    }

    public Thermometer() {
    }

    public void getType() {
        System.out.println("type: " + type);
    }

    public void getTemp() {
        System.out.println("temperature: " + temperature);
    }

    public static void main(String[] args) {
        System.out.println("Enter type - mercury or digital: ");
        Scanner s1 = new Scanner(System.in);
        String inputType = s1.next();
        System.out.println("Enter temperature: ");
        Scanner s2 = new Scanner(System.in);
        int inputTemp = s2.nextInt();

        try {
            Thermometer data1 = new Thermometer(inputType, inputTemp);
            FileOutputStream fileOut = new FileOutputStream("thermometer.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(data1);
            objectOut.close();

            Thermometer data2 = new Thermometer();
            FileInputStream fileIn = new FileInputStream("thermometer.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            data2 = (Thermometer) objectIn.readObject();
            objectIn.close();
            data2.getType();
            data2.getTemp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// hw5_ch11_p536_pdf541_ex9
