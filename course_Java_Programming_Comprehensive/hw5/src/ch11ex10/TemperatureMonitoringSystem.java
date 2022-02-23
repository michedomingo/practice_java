package ch11ex10;

import ch11ex9.Thermometer;
import java.io.*;

public class TemperatureMonitoringSystem implements Serializable {
    private Thermometer thermometer1;
    private Thermometer thermometer2;

    public TemperatureMonitoringSystem(Thermometer t1, Thermometer t2) {
        thermometer1 = t1;
        thermometer2 = t2;
    }

    public TemperatureMonitoringSystem serializeSystem(TemperatureMonitoringSystem obj) {
        try (FileOutputStream fileOut = new FileOutputStream("temperatureMonitor.dat");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(obj);
        } catch (FileNotFoundException e) {
            System.err.println("File could not be found" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException" + e.getMessage());
        }
        return obj;
    }

    public TemperatureMonitoringSystem deserializeSystem(TemperatureMonitoringSystem obj) {
        try (FileInputStream fileIn = new FileInputStream("temperatureMonitor.dat");
                ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            obj = (TemperatureMonitoringSystem) objectIn.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("File could not be found" + e.getMessage());
        } catch (IOException e) {
            System.err.println("IOException" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException" + e.getMessage());
        }
        return obj;
    }

    public boolean verifyThermometerInstances(Thermometer inputOne, Thermometer inputTwo) {
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
        TemperatureMonitoringSystem temperatureMonitor = new TemperatureMonitoringSystem(
                new Thermometer(Thermometer.getInputType(), Thermometer.getInputTemperature()),
                new Thermometer(Thermometer.getInputType(), Thermometer.getInputTemperature()));
        temperatureMonitor = temperatureMonitor.serializeSystem(temperatureMonitor);
        TemperatureMonitoringSystem temperatureMonitor2 = new TemperatureMonitoringSystem(new Thermometer(null, 0),
                new Thermometer(null, 0));
        temperatureMonitor2 = temperatureMonitor2.deserializeSystem(temperatureMonitor2);
        System.out.println();
        System.out.println(
                "thermometer1 - verifyThermometerInstances(): " +
                        temperatureMonitor.verifyThermometerInstances(temperatureMonitor.thermometer1,
                                temperatureMonitor2.thermometer1));
        System.out.println(
                "thermometer2 - verifyThermometerInstances(): " +
                        temperatureMonitor.verifyThermometerInstances(temperatureMonitor.thermometer2,
                                temperatureMonitor2.thermometer2));

    }
}

// hw5_ch11_p536_pdf541_ex10
