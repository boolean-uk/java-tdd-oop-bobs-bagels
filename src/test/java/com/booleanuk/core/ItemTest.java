package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemTest {

    Bagel item_unfilled = new Bagel("XXX", 10.0, Item.Name.BAGEL, Item.Variant.CHEESE, null);
    Item item_filling = new Bagel("FFF", 10.0, Item.Name.FILLING, Item.Variant.CHEESE, null);
    Item item_not_a_filling = new Bagel("FFF", 10.0, Item.Name.COFFEE, Item.Variant.CHEESE, null);

    @Test
    public void testAddFilling() {
        InventoryManager inv = new InventoryManager();
        Assertions.assertTrue(item_unfilled.addFilling(item_filling));
        Assertions.assertFalse(item_unfilled.addFilling(item_not_a_filling));
        Assertions.assertNotEquals("", inv.costEachFilling());
    }

    @Test
    public void testCopy() {
        InventoryManager inv = new InventoryManager();
        BasketManager b = new BasketManager();
        b.add(inv.getInventory().get("COFW"));
        Assertions.assertNotSame(inv.getInventory().get("COFW"), b.getBasket().get(0));

        b.add(inv.getInventory().get("COFW"));
        b.add(inv.getInventory().get("COFW"));
        Assertions.assertNotSame(b.getBasket().get(1), b.getBasket().get(2));

        Item item = inv.getInventory().get("BGLO");
        b.getBasket().add(item);
        Assertions.assertSame(item, b.getBasket().get(3));
    }
}
