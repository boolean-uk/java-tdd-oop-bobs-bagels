package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    Item item_unfilled = new Item("XXX", 10.0, Item.Name.BAGEL, Item.Variant.CHEESE, null);
    Item item_filling = new Item("FFF", 10.0, Item.Name.FILLING, Item.Variant.CHEESE, null);
    Item item_not_a_filling = new Item("FFF", 10.0, Item.Name.COFFEE, Item.Variant.CHEESE, null);

    @Test
    public void testAddFilling() {
        InventoryManager inv = new InventoryManager();
        Assertions.assertTrue(item_unfilled.addFilling(item_filling));
        Assertions.assertFalse(item_unfilled.addFilling(item_not_a_filling));

        //Assertions.assertNotEquals("", inv.costEachFilling());
    }
}
