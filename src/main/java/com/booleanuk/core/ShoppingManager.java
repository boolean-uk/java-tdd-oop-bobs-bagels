package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingManager {
    // this could technically be stored in a file and parsed when read... however, the task require no such feature
    public final static ArrayList<Item> availableItems = new ArrayList<>(){{
        add(new Item(0.49, "Onion", "BGLO", Category.BAGEL));
        add(new Item(0.39, "Plain", "BGLP", Category.BAGEL));
        add(new Item(0.49, "Everything", "BGLE", Category.BAGEL));
        add(new Item(0.49, "Sesame", "BGLS", Category.BAGEL));
        add(new Item(0.99, "Black", "COFB", Category.COFFEE));
        add(new Item(1.19, "White", "COFW", Category.COFFEE));
        add(new Item(1.29, "Capuccino", "COFC", Category.COFFEE));
        add(new Item(1.29, "Latte", "COFL", Category.COFFEE));
        add(new Item(0.12, "Bacon", "FILB", Category.FILLING));
        add(new Item(0.12, "Egg", "FILE", Category.FILLING));
        add(new Item(0.12, "Cheese", "FILC", Category.FILLING));
        add(new Item(0.12, "Cream Cheese", "FILX", Category.FILLING));
        add(new Item(0.12, "Smoked Salmon", "FILS", Category.FILLING));
        add(new Item(0.12, "Ham", "FILH", Category.FILLING));
    }};

    public Basket basket = new Basket();

    public void changeBasketCapacityCallback() {
        System.out.println("Specify the new capacity for baskets:");
        Scanner _scanner = new Scanner(System.in);
        int _capacity = 0;

        try {
            _capacity = Integer.parseInt(_scanner.next());
        }
        catch (Exception e) {
            System.out.println("That is not a valid number! Terminating order.");
        }

        basket.setCapacity(_capacity);
    }

    public void changeBasketCapacity(int newCapacity) {
        basket.setCapacity(newCapacity);
    }

    public static Item getItem(String uuid) {
        for (Item item : availableItems)
            if (item.uuid.equals(uuid))
                return item;
        return null;
    }
}
