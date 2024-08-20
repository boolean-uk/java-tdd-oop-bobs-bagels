package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public int mainMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. Add Bagel");

        return getInt();
    }

    public void printExit() {
        System.out.println("Exiting...");
    }

    public int getInt() {
        int output;
        try {
            output = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Something went wrong");
            output = Integer.MIN_VALUE;
        }
        return output;
    }

    public Bagel addBagel() {
        System.out.println("Choose a bagel");
        Triple<String, String, Float> bagelType = displayPrices("Bagel");
        System.out.println("Choose a filling");
        Triple<String, String, Float> fillingType = displayPrices("Filling");

        return new Bagel(bagelType, fillingType);
    }

    private Triple<String, String, Float> displayPrices(String filter) {
        ArrayList<Triple<String, String, Float>> temp = new ArrayList<>();
        int increment = 1;
        for (Triple<String, String, Float> t: Controller.prices.values()) {
            if (t.a().equals(filter) || filter.isEmpty()) {
                System.out.printf("%h. %s: $%.2f%n", increment, t.b(), t.c());
                temp.add(t);
                increment++;
            }
        }
        if (temp.isEmpty()) {
            System.out.println("No options available");
            return null;
        }
        System.out.println("Please write what you want");
        int output = getInt() - 1;
        if (output == temp.size()) {
            return null;
        }
        return temp.get(output);
    }
}
