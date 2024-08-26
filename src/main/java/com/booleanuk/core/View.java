package com.booleanuk.core;

import java.util.*;

public class View {
    private final Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public int mainMenu() {
        System.out.println("What do you want to do?");
        System.out.println("1. Add Bagel");
        System.out.println("2. Remove Bagel");
        System.out.println("3. Change basket size");
        System.out.println("4. See total cost");
        System.out.println("5. Add Coffee");
        System.out.println("6. Get receipt and clear basket");

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
        if (bagelType == null) return null;

        System.out.println("Choose filling, choose None to stop choosing.");
        boolean loop = true;
        ArrayList<Triple<String, String, Float>> fillings = new ArrayList<>();
        while (loop) {
            Triple<String, String, Float> temp = displayPrices("Filling");
            if (temp != null) {
                fillings.add(temp);
            } else {
                loop = false;
            }
        }
        Bagel b = new Bagel(bagelType, fillings);
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

    public Coffee addCoffee() {
        System.out.println("Choose a coffee type");
        Triple<String, String, Float> coffeeType = displayPrices("Coffee");
        if (coffeeType == null) return null;
        Coffee c = new Coffee(coffeeType);
        System.out.printf("It will cost $%.2f, is this ok?%n", c.calculateCost());
        System.out.println("1. Yes");
        System.out.println("2. No");
        int ans = getInt();
        if (ans == 1) {
            return c;
        } else {
            return null;
        }
    }

    private Triple<String, String, Float> displayPrices(String filter) {
        ArrayList<Triple<String, String, Float>> temp = new ArrayList<>();
        int increment = 1;
        System.out.println("0. None");
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
        if (output >= temp.size() || output < 0) {
            return null;
        }
        return temp.get(output);
    }

    public void basketFull() {
        System.out.println("Basket is full. You cannot add more bagels.");
    }

    public Product chooseBagel(ArrayList<Product> bagels) {
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

    public void printReceipt(float totCost, float totDisc, Basket.ReceiptInfo info) {
        Date now = new Date();
        System.out.printf("~~~ Bob's Bagels ~~~\n" +
                "\n" +
                "    %tF %tT\n" +
                "\n" +
                "----------------------------\n" +
                "\n\nLone Products:\n", now, now);
        for (Product p: info.remaining()) {
            System.out.printf("%-25s %8.2f%n", p.name(), p.basicPrice());
        }
        if (info.remaining().isEmpty()) {
            System.out.println("None\n");
        }


        System.out.println("\nFillings:");
        for (Map.Entry<String, Integer> item :info.fillings().entrySet()) {
            System.out.printf("%-20s %4d %8.2f%n", item.getKey(), item.getValue(), item.getValue() * 0.12f);
        }
        if (info.fillings().entrySet().isEmpty()) {
            System.out.println("None\n");
        }
        System.out.println("\nDeals:");
        // HM<name, num>, price, discount
        for (Triple<HashMap<String, Integer>, Float, Float> deal: info.deals()) {
            for (Map.Entry<String, Integer> item : deal.a().entrySet()) {
                System.out.printf("    %-16s %4d%n", item.getKey(), item.getValue());
            }
            System.out.printf("  Deal Cost %22.2f%n", deal.b());
            System.out.printf("  Discount %23.2f%n%n", deal.c());

        }
        if (info.deals().isEmpty()) {
            System.out.println("None\n");
        }

        System.out.print("Total Cost");
        System.out.printf("%24.2f%n", totCost);
        System.out.print("Total Saved");
        System.out.printf("%23.2f", totDisc);
    }
}
