package ch10ex14;

public class BrakeException extends Exception { // determine brakes are faulty
    public BrakeException() {
        this("Brake Exception");
    }

    public BrakeException(String message) {
        super(message);
    }

    public static class FootBrakeException extends BrakeException {
        public FootBrakeException() {
            this("Foot Brake Exception");
        }

        public FootBrakeException(String message) {
            super(message);
        }
    }

    public static class ParkingBrakeException extends BrakeException {
        public ParkingBrakeException() {
            this("Parking Brake Exception");
        }

        public ParkingBrakeException(String message) {
            super(message);
        }
    }
}

// hw3_c10_p483_pdf488_ex14
