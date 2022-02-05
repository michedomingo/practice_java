package ch7ex10;

public enum EnumWithErrors {
    SOCCERBALL (27.0f),
    TENNISBALL (2.25f),
    PINPONGBALL (0.75f)

    public float radius; // radius in inches

    public EnumWithErrors(float r) {
        radius = r;
    }

    public float getRadius() {
        return radius;
    }

    public static void main(String[] args) {
        System.out.println(EnumWithErrors.values()[0].getRadius());
    }
}

// hw2_ch7_p327_pdf332_ex10
