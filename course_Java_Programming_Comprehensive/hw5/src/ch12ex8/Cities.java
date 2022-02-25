package ch12ex8;

import java.util.*;

public class Cities {

    public void displayHashSetOfCities(ArrayList<String> cities) {
        HashSet<String> hashSetOfCities = new HashSet<String>();
        hashSetOfCities.addAll(cities);
        System.out.println("hashSetOfCities: " + hashSetOfCities);
    }

    public void displayTreeSetOfCities(ArrayList<String> cities) {
        TreeSet<String> treeSetOfCities = new TreeSet<String>();
        treeSetOfCities.addAll(cities);
        System.out.println("treeSetOfCities: " + treeSetOfCities);
    }

    public void displayLinkedHashSetOfCities(ArrayList<String> cities) {
        LinkedHashSet<String> linkedHashSetOfCities = new LinkedHashSet<String>();
        linkedHashSetOfCities.addAll(cities);
        System.out.println("linkedHashSetOfCities: " + linkedHashSetOfCities);
    }

    public static void main(String[] args) {
        ArrayList<String> citiesArrayList = new ArrayList<>(
                Arrays.asList("Hong Kong", "Cairo", "London", "New York", "Cairo", "London"));
        Cities c = new Cities();
        c.displayHashSetOfCities(citiesArrayList);
        c.displayTreeSetOfCities(citiesArrayList);
        c.displayLinkedHashSetOfCities(citiesArrayList);
    }
}

// hw5_ch12_p580_pdf585_ex8
