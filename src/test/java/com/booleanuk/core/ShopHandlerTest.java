package com.booleanuk.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ShopHandlerTest {
    @Test
    public void showItemsShowsAllItemsThatAreNotFillings() {
        ShopHandler sh = new ShopHandler();
        String list = sh.showItems();
        System.out.println(list);
        for (Item item : ShopHandler.getStock()) {
            if (!item.getName().equals("Filling")) {
                // if item.name & price is in list, good
                assertTrue(list.contains(item.getName() + "\t" + item.getVariant() + (item.getVariant().length() > 6 ? "\t" : "\t\t") + item.getPrice()));
            }
        }
    }
}
