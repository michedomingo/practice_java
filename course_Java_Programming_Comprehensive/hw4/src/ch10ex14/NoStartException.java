package ch10ex14;

public class NoStartException extends Exception {

    public NoStartException() {
        this("No Start Exception");
    }

    public NoStartException(String message) {
        super(message);
    }

    // determine problems in the ignition - car can't start
    public static class BadIgnitionException extends NoStartException {
        public BadIgnitionException() {
            this("Bad Ignition Exception");
        }

        public BadIgnitionException(String message) {
            super(message);
        }
    }

    // determine problems in the battery - car can't start
    public static class DeadBatteryException extends NoStartException {
        public DeadBatteryException() {
            this("Dead Battery Exception");
        }

        public DeadBatteryException(String message) {
            super(message);
        }
    }
}

// hw3_c10_p483_pdf488_ex14
