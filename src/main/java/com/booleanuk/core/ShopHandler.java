package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopHandler {
    private static List<Item> stock = new ArrayList<>(Arrays.asList(
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

    public String showItems() {
        StringBuilder sb = new StringBuilder();
        for (Item item : stock) {
            if (!item.getName().equals("Filling")) {
                sb.append(item.getName()).append("\t").append(item.getVariant()).append(item.getVariant().length() > 6 ? "\t" : "\t\t").append(item.getPrice()).append("\n");
            }
        }
        return sb.toString();
    }

    public static List<Item> getStock() {
        return stock;
    }
}
