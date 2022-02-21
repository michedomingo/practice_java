package ch11ex10;

import ch11ex9.Thermometer;
import java.io.*;

public class TemperatureMonitoringSystem extends Thermometer {
    Thermometer t1;
    Thermometer t2;

    // save object's state as binary stream (sequence of bytes)
    public void serializeThermometer() {
        t1 = new Thermometer(getInputType(), getInputTemperature());
        System.out.println("Inside SErializeThermometer()...");
        t1.displayType();
        t1.displayTemperature();

        try (FileOutputStream fileOut = new FileOutputStream("thermometer.dat");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(t1);

        } catch (FileNotFoundException e) {
            System.err.println("File could not be found" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException" + e.getMessage());
        }
    }

    // reverse process/restore object back from binary data
    public void deserializeThermometer() {
        t2 = new Thermometer("Thermometer2", 100);

        try (FileInputStream fileIn = new FileInputStream("thermometer.dat");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            t2 = (Thermometer) objectIn.readObject();
            System.out.println("Inside deserializeThermometer()...");
            t2.displayType();
            t2.displayTemperature();
        } catch (FileNotFoundException e) {
            System.err.println("File could not be found" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException" + e.getMessage());
        }
    }

    public void thermometersAreSerialized() {
        System.out.println("Thermometer 1: " + t1);
        System.out.println("Thermometer 2: " + t2);
    }

    public static void main(String[] args) {
        TemperatureMonitoringSystem temperatureMonitor = new TemperatureMonitoringSystem();

        temperatureMonitor.serializeThermometer();
        temperatureMonitor.deserializeThermometer();
        temperatureMonitor.t2.displayType();
        temperatureMonitor.t2.displayTemperature();

    }
}

// hw5_ch11_p536_pdf541_ex10
