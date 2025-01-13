package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShopHandler {
    private static final List<Item> stock = new ArrayList<>(Arrays.asList(
            new Item("BGLO", 0.49, "Bagel", "Onion"),
            new Item("BGLP", 0.39, "Bagel", "Plain"),
            new Item("BGLE", 0.49, "Bagel", "Everything"),
            new Item("BGLS", 0.49, "Bagel", "Sesame"),
            new Item("COFB", 0.99, "Coffee", "Black"),
            new Item("COFW", 1.19, "Coffee", "White"),
            new Item("COFC", 1.29, "Coffee", "Cappuccino"),
            new Item("COFL", 1.29, "Coffee", "Latte"),
            new Item("FILB", 0.12, "Filling", "Bacon"),
            new Item("FILE", 0.12, "Filling", "Egg"),
            new Item("FILC", 0.12, "Filling", "Cheese"),
            new Item("FILX", 0.12, "Filling", "Cream Cheese"),
            new Item("FILS", 0.12, "Filling", "Smoked Salmon"),
            new Item("FILH", 0.12, "Filling", "Ham")
    ));
    private Scanner scanner;
    private Basket basket;

    public ShopHandler() {
        this.scanner = new Scanner(System.in);
        this.basket = new Basket();
    }

    public void placeOrder() {
        while (true) {
            String in;
            do {
                System.out.println("bagel/coffee/remove/pay");
                in = scanner.next();
            } while (!"bagel coffee remove pay".contains(in));
            switch (in) {
                case "bagel":
                    orderBagel();
                    break;
                case "coffee":
                    orderCoffee();
                    break;
                case "remove":
                    removeItem();
                    break;
                case "pay":
                    System.out.println("Print receipt tbd. total cost " + basket.getTotalCost());
                    return;
            }
        }
    }

    public void removeItem() {
        if (basket.getItems().isEmpty()) {
            System.out.println("No items in basket.");
            return;
        }
        System.out.println("Enter number of item to remove (0 to cancel):");
        System.out.println(showBasket());
        int in;
        do {
            in = scanner.nextInt();
        } while (in < 0 || in > basket.getItems().size());
        if (in == 0) return;
        basket.removeItem(basket.getItems().get(in-1).getSku());
    }

    public String showBasket() {
        StringBuilder sb = new StringBuilder();
        for (Item item : basket.getItems()) {
            sb.append(item.getName()).append(", ").append(item.getVariant()).append(", ").append(item.getPrice()).append("\n");
        }
        return sb.toString();
    }

    public String showItems() {
        // Maybe this method isn't useful, may remove
        StringBuilder sb = new StringBuilder();
        for (Item item : stock) {
            if (!item.getName().equals("Filling")) {
                sb.append(item.getName()).append("\t").append(item.getVariant()).append(item.getVariant().length() > 6 ? "\t" : "\t\t").append(item.getPrice()).append("\n");
            }
        }
        return sb.toString();
    }

    public String showFillings() {
        StringBuilder sb = new StringBuilder();
        for (Item item : stock) {
            if (item.getName().equals("Filling")) {
                sb.append(item.getVariant()).append(" (").append(item.getPrice()).append(")").append("\n");
            }
        }
        return sb.toString();
    }

    public String showBagels() {
        StringBuilder sb = new StringBuilder();
        for (Item item : stock) {
            if (item.getName().equals("Bagel")) {
                sb.append(item.getVariant()).append(item.getVariant().length() > 6 ? "\t" : "\t\t").append(item.getPrice()).append("\n");
            }
        }
        return sb.toString();
    }

    public String showCoffees() {
        StringBuilder sb = new StringBuilder();
        for (Item item : stock) {
            if (item.getName().equals("Coffee")) {
                sb.append(item.getVariant()).append(item.getVariant().length() > 6 ? "\t" : "\t\t").append(item.getPrice()).append("\n");
            }
        }
        return sb.toString();
    }

    public void orderBagel() {
        System.out.println("Select bagel variant:");
        System.out.println(showBagels());
        String in = "";
        do {
            in = this.scanner.next();
        } while (!isValidBagel(in));
        boolean success = basket.addItem(bagelFromVariant(in));
        if (success) {
            System.out.println("Add filling ([filling], no)? Available fillings:");
            System.out.println(showFillings());
            do {
                in = this.scanner.next();
            } while(!isValidFilling(in) && !in.equals("no"));
            if (!in.equals("no")) {
                basket.addItem(fillingFromVariant(in));
            }
        } else {
            System.out.println("Not able to add bagel to basket.");
        }
    }

    public void orderCoffee() {
        System.out.println("Select coffee variant:");
        System.out.println(showCoffees());
        String in = "";
        do {
            in = this.scanner.next();
        } while (!isValidCoffee(in));
        boolean success = basket.addItem(coffeeFromVariant(in));
        if (success) {
            System.out.println("Coffee added to basket.");
        } else {
            System.out.println("Not able to add coffee to basket.");
        }
    }

    private Item bagelFromVariant(String variant) {
        for (Item item : stock) {
            if (item.getVariant().equals(variant)) {
                return new Item(item.getSku(), item.getPrice(), item.getName(), item.getVariant());
            }
        }
        return null;
    }

    private Item coffeeFromVariant(String variant) {
        for (Item item : stock) {
            if (item.getVariant().equals(variant)) {
                return new Item(item.getSku(), item.getPrice(), item.getName(), item.getVariant());
            }
        }
        return null;
    }

    private Item fillingFromVariant(String variant) {
        for (Item item : stock) {
            if (item.getVariant().equals(variant)) {
                return new Item(item.getSku(), item.getPrice(), item.getName(), item.getVariant());
            }
        }
        return null;
    }

    private static boolean isValidBagel(String variant) {
        for (Item item: stock) {
            if (item.getName().equals("Bagel") && item.getVariant().equals(variant)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidCoffee(String variant) {
        for (Item item: stock) {
            if (item.getName().equals("Coffee") && item.getVariant().equals(variant)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidFilling(String variant) {
        for (Item item: stock) {
            if (item.getName().equals("Filling") && item.getVariant().equals(variant)) {
                return true;
            }
        }
        return false;
    }

    public static List<Item> getStock() {
        return stock;
    }
}
