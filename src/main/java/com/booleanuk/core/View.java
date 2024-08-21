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
        System.out.println("2. Remove Bagel");
        System.out.println("3. Change basket size");
        System.out.println("4. See total cost");

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
        Bagel b = new Bagel(bagelType, fillingType);
        System.out.printf("It will cost $%.2f, is this ok?%n", b.calculateCost());
        System.out.println("1. Yes");
        System.out.println("2. No");
        int ans = getInt();
        if (ans == 1) {
            return b;
        } else {
            return null;
        }
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

    public void basketFull() {
        System.out.println("Basket is full. You cannot add more bagels.");
    }

    public Bagel chooseBagel(ArrayList<Bagel> bagels) {
        if (bagels.isEmpty()) {
            System.out.println("No options available");
            return null;
        }
        System.out.println("Choose a bagel");
        for (int i = 0; i < bagels.size(); i++) {
            System.out.printf("%h. %s%n", i + 1, bagels.get(i).toString());
        }
        System.out.println("Please write what you want");
        int output = getInt() - 1;
        if (output == bagels.size()) {
            return null;
        }
        return bagels.get(output);
    }

    public int getNewBasketSize() {
        System.out.println("What should the new basket size be?");
        System.out.println("WARNING: Changing basket size to a number smaller than the current number of bagels will empty the current basket!");
        return getInt();
    }

    public void printPrice(float price) {
        System.out.printf("The total cost is $%.2f.%n", price);
    }

    public void emptyBasket() {
        System.out.println("Your basket is empty.");
    }
}
