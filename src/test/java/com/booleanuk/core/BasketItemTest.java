package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BasketItemTest {

    @Test
    public void testBasketItemConstructor(){

        Inventory inventory = new Inventory();
        InventoryItem item = inventory.getInventoryItemDetails("BGLO");
        InventoryItem filling1 = inventory.getInventoryItemDetails("FILS");
        InventoryItem filling2 = inventory.getInventoryItemDetails("FILH");
        ArrayList<InventoryItem> addOns = new ArrayList<>(Arrays.asList(filling1, filling2)) ;
        BasketItem itemAndAddons = new BasketItem(item, addOns);
        System.out.println(itemAndAddons.getAddOns().get(0).getSku().toString());
    }

    @Test
    public void testaddAddon(){

        Inventory inventory = new Inventory();
        InventoryItem item = inventory.getInventoryItemDetails("BGLO");
        InventoryItem filling1 = inventory.getInventoryItemDetails("FILS");
        InventoryItem filling2 = inventory.getInventoryItemDetails("FILH");
        ArrayList<InventoryItem> addOns = new ArrayList<>(Arrays.asList(filling1, filling2)) ;
        BasketItem itemAndAddons = new BasketItem(item, addOns);
        itemAndAddons.addAddon("FILC");
        System.out.println(itemAndAddons.getAddOns().get(2).getSku().toString());
        Assertions.assertEquals("FILC", itemAndAddons.getAddOns().get(2).getSku());
        itemAndAddons.addAddon("test");
        Assertions.assertEquals(3, itemAndAddons.getAddOns().size());
    }

}
