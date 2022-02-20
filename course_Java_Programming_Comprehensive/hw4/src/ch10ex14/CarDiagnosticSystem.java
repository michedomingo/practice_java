package ch10ex14;

import ch10ex14.NoStartException.*;
import ch10ex14.LightsException.*;
import ch10ex14.BrakeException.*;
import java.util.Random;

public class CarDiagnosticSystem {
    public void diagnostics() throws BadIgnitionException, DeadBatteryException, HeadLightException,
            BrakeLightException,
            TailLightException, FootBrakeException, ParkingBrakeException {
        Random r = new Random();
        int randomNumber = r.nextInt(10);

        if (randomNumber == 0)
            throw new BadIgnitionException();
        else if (randomNumber == 1)
            throw new DeadBatteryException();
        else if (randomNumber == 2)
            throw new HeadLightException();
        else if (randomNumber == 3)
            throw new BrakeLightException();
        else if (randomNumber == 4)
            throw new TailLightException();
        else if (randomNumber == 5)
            throw new FootBrakeException();
        else if (randomNumber == 6)
            throw new ParkingBrakeException();

    }

    public void display() {
        try {
            diagnostics();
            System.out.println("Diagnostic test completed - no problems found.");
        } catch (NoStartException e) {
            System.out.println(e.getMessage());
        } catch (LightsException e) {
            System.out.println(e.getMessage());
        } catch (BrakeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        CarDiagnosticSystem test = new CarDiagnosticSystem();
        test.display();
    }

}

// hw3_c10_p483_pdf488_ex14
