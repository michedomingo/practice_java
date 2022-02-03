package ch7ex9;

import java.util.Arrays;

public class ReverseArray {
    // method to reverse contents of array passed in as argument
    public void reverse(double[] array) {
        int index, size = array.length;
        double temp;
        // System.out.println("size: " + size);

        for (index = 0; index < size / 2; index++) {
            temp = array[index];
            array[index] = array[size - index - 1];
            array[size - index - 1] = temp;
        }
        System.out.println("Reversed array: " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        ReverseArray a = new ReverseArray();
        double[] arr = { 1.0, 2.0, 3.0, 4.0, 5.0 };
        System.out.println("Original array: " + Arrays.toString(arr));
        a.reverse(arr);
    }
}

// hw2_ch7_p326_pdf331_ex9
