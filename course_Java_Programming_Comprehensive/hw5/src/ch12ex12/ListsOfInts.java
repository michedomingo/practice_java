package ch12ex12;

import java.util.*;

public class ListsOfInts {

    public void displayIntegersArrayList(ArrayList<Integer> ints) {
        System.out.println("Size of ArrayList with Integers: " + ints.size());
        Iterator<Integer> iter = ints.iterator();
        while (iter.hasNext()) {
            System.out.println("\t" + iter.next());
        }
    }

    public void displayIntegersLinkedList(ArrayList<Integer> ints) {
        List<Integer> integersLinkedList = new LinkedList<>(ints);
        System.out.println("Size of LinkedList with Integers: " + integersLinkedList.size());
        Iterator<Integer> iter = integersLinkedList.listIterator();
        while (iter.hasNext()) {
            System.out.println("\t" + iter.next());
        }
    }

    public static void main(String[] args) {
        ListsOfInts intsList = new ListsOfInts();
        ArrayList<Integer> integersArrayList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 4, 5));
        intsList.displayIntegersArrayList(integersArrayList);
        System.out.println();
        intsList.displayIntegersLinkedList(integersArrayList);
    }
}

// hw5_ch12_p580_pdf585_ex12
