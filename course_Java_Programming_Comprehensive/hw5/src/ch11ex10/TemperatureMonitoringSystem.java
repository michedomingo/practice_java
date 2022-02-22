package ch11ex10;

import ch11ex9.Thermometer;
import java.io.*;

public class TemperatureMonitoringSystem extends Thermometer {
    Thermometer serializeT1;
    Thermometer serializeT2;
    // Thermometer deserializeT1;
    // Thermometer deserializeT2;

    // public TemperatureMonitoringSystem() {

    // }

    public TemperatureMonitoringSystem() {
        serializeT1 = new Thermometer().serializeThermometer();
        serializeT2 = new Thermometer().serializeThermometer();
    }

    public TemperatureMonitoringSystem serializeSystem() {
        TemperatureMonitoringSystem system = new TemperatureMonitoringSystem();
        // serializeT1 = new Thermometer().serializeThermometer();
        // serializeT2 = new Thermometer().serializeThermometer();

        try (FileOutputStream fileOut = new FileOutputStream("tempMonitor.dat");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(system);

            System.out.println("Inside serializeSystem()...");
            System.out.println("\tserializeT1.getThermometerType(): " + serializeT1.getThermometerType());
            System.out.println("\tserializeT1.getThermometerTemperature(): " +
                    serializeT1.getThermometerTemperature());
            System.out.println("\tserializeT2.getThermometerType(): " + serializeT2.getThermometerType());
            System.out.println("\tserializeT2.getThermometerTemperature(): " +
                    serializeT2.getThermometerTemperature());

        } catch (FileNotFoundException e) {
            System.err.println("File could not be found" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException" + e.getMessage());
        }
        return system;
    }

    public TemperatureMonitoringSystem deserializeSystem() {
        TemperatureMonitoringSystem system = new TemperatureMonitoringSystem();
        Thermometer deserializeT1 = deserializeThermometer();
        Thermometer deserializeT2 = deserializeThermometer();
        // deserializeT1 = deserializeThermometer();
        // deserializeT2 = deserializeThermometer();
        // system.deserializeThermometersInSystem();

        try (FileInputStream fileIn = new FileInputStream("tempMonitor.dat");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            system = (TemperatureMonitoringSystem) objectIn.readObject();

            System.out.println("Inside DEserializeSystem()...");
            System.out.println("\tdeserializeT1.getThermometerType(): " +
                    deserializeT1.getThermometerType());
            System.out.println("\tdeserializeT1.getThermometerTemperature(): " +
                    deserializeT1.getThermometerTemperature());
            System.out.println("\tdeserializeT2.getThermometerType(): " +
                    deserializeT2.getThermometerType());
            System.out.println("\tdeserializeT2.getThermometerTemperature(): " +
                    deserializeT2.getThermometerTemperature());

        } catch (FileNotFoundException e) {
            System.err.println("File could not be found" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException" + e.getMessage());
        }
        return system;
    }

    public boolean sameThermometerData(Thermometer inputOne, Thermometer inputTwo) {
        String inputOneType = inputOne.getThermometerType();
        String inputTwoType = inputTwo.getThermometerType();
        int inputOneTemp = inputOne.getThermometerTemperature();
        int inputTwoTemp = inputTwo.getThermometerTemperature();

        if (inputOneType.equals(inputTwoType) &&
                inputOneTemp == inputTwoTemp)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        TemperatureMonitoringSystem temperatureMonitor = new TemperatureMonitoringSystem();
        // TemperatureMonitoringSystem temperatureMonitor = new
        // TemperatureMonitoringSystem().serializeSystem();
        // TemperatureMonitoringSystem temperatureMonitor2 = new
        // TemperatureMonitoringSystem();

        // temperatureMonitor.serializeSystem();
        // temperatureMonitor2.deserializeSystem();
        System.out.println("\ttemperatureMonitor.serializeT1.getThermometerType(): "
                + temperatureMonitor.serializeT1.getThermometerType());
        System.out.println("\ttemperatureMonitor.serializeT1.getThermometerTemperature():"
                + temperatureMonitor.serializeT1.getThermometerTemperature());
        System.out.println("\ttemperatureMonitor.serializeT2.getThermometerType(): "
                + temperatureMonitor.serializeT2.getThermometerType());
        System.out.println("\ttemperatureMonitor.serializeT2.getThermometerTemperature(): " +
                temperatureMonitor.serializeT2.getThermometerTemperature());

        // System.out.println(
        // "T1 sameThermometerData(): " +
        // temperatureMonitor.sameThermometerData(temperatureMonitor.serializeT1,
        // temperatureMonitor.deserializeT1));
        // System.out.println(
        // "T2 sameThermometerData(): " +
        // temperatureMonitor.sameThermometerData(temperatureMonitor.serializeT2,
        // temperatureMonitor.deserializeT2));

    }
}

// hw5_ch11_p536_pdf541_ex10
