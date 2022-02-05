package ch7ex18;

import java.util.*;

public class ReadConsole {

    public static void storeInput(ArrayList<String> wordsArray) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("Enter words ('END' to quit program): ");
            input = scanner.nextLine();

            if (input.isEmpty())
                continue;

            if (!input.contains(" ")) {
                wordsArray.add(input);
            } else {
                String[] splitWords = input.split(" ");
                for (String word : splitWords)
                    wordsArray.add(word);
            }

        } while (!input.equalsIgnoreCase("END"));
        scanner.close();
    }

    public static void displayWordCount(ArrayList<String> wordsArray) {
        System.out.println("\nYou entered: ");
        for (String word : wordsArray) {
            System.out.println("\t" + word);
        }
        System.out.println("\nTotal number of words: " + wordsArray.size());
    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();
        storeInput(a);
        displayWordCount(a);
    }
}

// hw2_ch7_p329_pdf334_ex18
