package ch6ex10;

import java.util.Scanner;

public abstract class Bird {

    // public void chirp() {
    // System.out.println("chirp");
    // }

    public abstract void chirp();

    public static void main(String[] args) {
        Bird bird;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number that is either 1, 2, or 3: ");
        int birdType = scanner.nextInt();

        while (true) {
            if (birdType == 1) {
                bird = new Goose();
                break;
            } else if (birdType == 2) {
                bird = new Mallard();
                break;
            } else if (birdType == 3) {
                bird = new Crow();
                break;
            } else {
                System.out.print("Try again, enter either 1, 2, or 3: ");
                birdType = scanner.nextInt();
            }
        }
        bird.chirp();
    }
}

// hw2_ch6_p264_pdf269_ex10
