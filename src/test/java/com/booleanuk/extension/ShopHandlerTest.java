package com.booleanuk.extension;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShopHandlerTest {
    double delta = 0.0001;
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

    @Test
    public void sixpackBagelsDiscount() {
        double delta = 0.0001;
        ShopHandler sh = new ShopHandler();
        for (int i=0; i<7; i++) {
            sh.orderBagel("Onion");
        }
        assertEquals(0.45, sh.calculateDiscounts(), delta);
    }

    @Test
    public void dozenBagelsDiscount() {
        double delta = 0.0001;
        ShopHandler sh = new ShopHandler();
        int oldCapacity = Basket.getCapacity();
        Basket.setCapacity(20);
        for (int i=0; i<13; i++) {
            sh.orderBagel("Onion");
        }
        assertEquals(1.89, sh.calculateDiscounts(), delta);
    Basket.setCapacity(oldCapacity);
    }

    @Test
    public void dozenAndSixBagelsDiscount() {
        ShopHandler sh = new ShopHandler();
        int oldCapacity = Basket.getCapacity();
        Basket.setCapacity(20);
        for (int i=0; i<19; i++) {
            sh.orderBagel("Onion");
        }
        assertEquals(2.34, sh.calculateDiscounts(), delta);
        Basket.setCapacity(oldCapacity);
    }

    @Test
    public void coffeeDiscount() {
        ShopHandler sh = new ShopHandler();
        sh.orderCoffee("Black", "Onion");
        assertEquals(0.23, sh.calculateDiscounts(), delta);
    }


}
