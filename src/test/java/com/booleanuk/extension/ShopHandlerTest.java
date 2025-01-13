package com.booleanuk.extension;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopHandlerTest {
    @Test
    public void showItemsShowsAllItemsThatAreNotFillings() {
        ShopHandler sh = new ShopHandler();
        String list = sh.showItems();
//        System.out.println(list);
        for (Item item : ShopHandler.getStock()) {
            if (!item.getName().equals("Filling")) {
                // if item.name & price is in list, good
                assertTrue(list.contains(item.getName() + "\t" + item.getVariant() + (item.getVariant().length() > 6 ? "\t" : "\t\t") + item.getPrice()));
            }
        }
    }

    @Test
    public void showFillingsWorks() {
        ShopHandler sh = new ShopHandler();
        String list = sh.showFillings();
//        System.out.println(list);
        for (Item item : ShopHandler.getStock()) {
            if (item.getName().equals("Filling")) {
                // if item.name & price is in list, good
                assertTrue(list.contains(item.getVariant()));
            }
        }
    }

    @Test
    public void showBagelsWorks() {
        ShopHandler sh = new ShopHandler();
        String list = sh.showBagels();
//        System.out.println(list);
        for (Item item : ShopHandler.getStock()) {
            if (item.getName().equals("Bagel")) {
                // if item.name & price is in list, good
                assertTrue(list.contains(item.getVariant() + (item.getVariant().length() > 6 ? "\t" : "\t\t") + item.getPrice()));
            }
        }
    }

    @Test
    public void showCoffeesWorks() {
        ShopHandler sh = new ShopHandler();
        String list = sh.showCoffees();
//        System.out.println(list);
        for (Item item : ShopHandler.getStock()) {
            if (item.getName().equals("Coffee")) {
                // if item.name & price is in list, good
                assertTrue(list.contains(item.getVariant() + (item.getVariant().length() > 6 ? "\t" : "\t\t") + item.getPrice()));
            }
        }
    }
}
