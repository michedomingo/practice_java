package ch12ex9;

import java.util.*;

public class CountriesWithCapitals {
    Map<String, String> linkedHashMapOfCountries = new LinkedHashMap<>() {
        {
            put("Canada", "Ottawa");
            put("Chile", "Santiago");
            put("Colombia", "Bogota");
            put("Argentina", "Buenos Aires");
            put("Armenia", "Yerevan");
            put("Australia", "Canberra");
            put("Bahamas", "Nassau");
            put("Bangladesh", "Dhaka");
            put("Belgium", "Brussels");
            put("Brazil", "Brasilia");

        }
    };

    public void displayHashMapOfCountries() {
        Map<String, String> hashMapOfCountries = new HashMap<>();

        hashMapOfCountries.putAll(linkedHashMapOfCountries);
        System.out.println("hashMapOfCountries: ");

        for (Map.Entry<String, String> entry : hashMapOfCountries.entrySet()) {
            System.out.println("\t" + entry.getKey() + ", " + entry.getValue());
        }
        System.out.println();
    }

    public void displayTreeMapOfCountries() {
        Map<String, String> treeMapOfCountries = new TreeMap<>();

        treeMapOfCountries.putAll(linkedHashMapOfCountries);
        System.out.println("treeMapOfCountries: ");

        for (Map.Entry<String, String> entry : treeMapOfCountries.entrySet()) {
            System.out.println("\t" + entry.getKey() + ", " + entry.getValue());
        }
        System.out.println();
    }

    public void displayLinkedHashMapOfCountries() {
        System.out.println("linkedHashMapOfCountries: ");

        for (Map.Entry<String, String> entry : linkedHashMapOfCountries.entrySet()) {
            System.out.println("\t" + entry.getKey() + ", " + entry.getValue());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CountriesWithCapitals c = new CountriesWithCapitals();
        c.displayHashMapOfCountries();
        c.displayTreeMapOfCountries();
        c.displayLinkedHashMapOfCountries();
    }
}

// hw5_ch12_p580_pdf585_ex9
