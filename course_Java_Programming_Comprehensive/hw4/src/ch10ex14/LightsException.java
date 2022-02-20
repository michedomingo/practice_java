package ch10ex14;

public class LightsException extends Exception { // determine lights are faulty
    public LightsException() {
        this("Lights Exception");
    }

    public LightsException(String message) {
        super(message);
    }

    public static class HeadLightException extends LightsException {
        public HeadLightException() {
            this("Head Light Exception");
        }

        public HeadLightException(String message) {
            super(message);
        }
    }

    public static class BrakeLightException extends LightsException {
        public BrakeLightException() {
            this("Brake Light Exception");
        }

        public BrakeLightException(String message) {
            super(message);
        }
    }

    public static class TailLightException extends LightsException {
        public TailLightException() {
            this("Tail Light Exception");
        }

        public TailLightException(String message) {
            super(message);
        }
    }

}

// hw3_c10_p483_pdf488_ex14
