/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        String numPeopleString = myApp.readInfo("How many people? ");
        String numPizzasString = myApp.readInfo("How many pizzas do you have? ");
        String numSlicesString = myApp.readInfo("How many slices per pizza? ");
        int numPeople = myApp.convertNumString(numPeopleString);
        int numPizzas = myApp.convertNumString(numPizzasString);
        int numSlices = myApp.convertNumString(numSlicesString);
        int totalSlices = myApp.computeTotalSlices(numSlices, numPizzas);
        int slicesPerPerson = myApp.computeSlicePerPerson(totalSlices, numPeople);
        int leftoverSlices = myApp.computeLeftoverSlices(totalSlices, numPeople);
        String outputString = myApp.generateOutputString(numPeople, numPizzas, numSlices, slicesPerPerson, leftoverSlices);
        myApp.printOutputString(outputString);
    }

    private String generateOutputString(int numPeople, int numPizzas, int numSlices, int slicesPerPerson, int leftoverSlices) {
        return String.format("%d people with % pizzas (%d slices)\nEach person gets %d pieces of pizza.\nThere are %d leftover pieces.",numPeople, numPizzas, numSlices, slicesPerPerson, leftoverSlices);
    }

    private int computeLeftoverSlices(int totalSlices, int numPeople) {
        int leftoverSlices = totalSlices % numPeople;
        return leftoverSlices;
    }

    private String readInfo(String str) {
        System.out.print(str);
        String num = in.nextLine();
        return num;
    }

    private Integer convertNumString(String numString) {
        int num = Integer.parseInt(numString);
        return num;
    }

    private int computeTotalSlices(int numSlices, int numPizzas) {
        int totalSlices = numSlices * numPizzas;
        return totalSlices;
    }

    private int computeSlicePerPerson(int totalSlices, int numPeople) {
        int slicePerPerson = totalSlices / numPeople;
        return slicePerPerson;
    }

    private void printOutputString(String outputString) { System.out.println(outputString); }
}
