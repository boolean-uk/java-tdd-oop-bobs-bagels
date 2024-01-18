package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketManagerTest {

    Item item_a = new Item("XXX", 10.0, Item.Name.BAGEL, Item.Variant.CHEESE, null);
    Item item_b = new Item("FFF", 10.0, Item.Name.FILLING, Item.Variant.CHEESE, null);
    Item item_c = new Item("NNN", 10.0, Item.Name.FILLING, Item.Variant.CHEESE, null);

    @Test
    public void testAdd(){
        BasketManager b = new BasketManager();
        Assertions.assertNotNull(b.getBasket());
        Assertions.assertEquals(0, b.getBasket().size());
        b.add(item_a);
        Assertions.assertEquals(1, b.getBasket().size());
        Assertions.assertSame(item_a, b.getBasket().get(0));
    }

    @Test
    public void testRemove(){
        BasketManager b = new BasketManager();
        b.add(item_a);
        Assertions.assertNotNull(b.remove(item_a));
        Assertions.assertNull(b.remove(item_a));
        b.add(item_b);
        Assertions.assertSame(item_b, b.remove(item_b));
        Assertions.assertNull(b.remove(item_c));
        b.add(item_a);
        b.add(item_b);
        Assertions.assertNotEquals(item_a, b.remove(item_b));

    }

    @Test
    public void testCheckCapacity(){
        BasketManager b = new BasketManager();
        Assertions.assertEquals(b.getCapacity(), b.checkCapacity());
        Assertions.assertNotNull(b.checkCapacity());
        b.add(item_a);
        b.add(item_b);
        Assertions.assertTrue((b.getCapacity() - b.getBasket().size()) == b.checkCapacity());
    }

    @Test
    public void testChangeCapacity(){
        BasketManager b = new BasketManager();
        b.changeCapacity(5);
        Assertions.assertEquals(5, b.getCapacity());
        Assertions.assertNotEquals(10, b.getCapacity());
        b.changeCapacity(1);
        b.add(item_a);
        Assertions.assertNull(b.add(item_b));

        b.changeCapacity(2);
        b.add(item_b);
        b.add(item_c);
        Assertions.assertTrue(b.changeCapacity(1));
        Assertions.assertFalse(b.changeCapacity(-1));
    }

    /**
     * might be redundant
     */

    @Test
    public void testCheckItemInInventory(){
        BasketManager b = new BasketManager();
        InventoryManager inv = new InventoryManager();
        Assertions.assertTrue(b.checkItemInInventory(inv.getInventory().get("COFB")));
        Assertions.assertFalse(b.checkItemInInventory(item_a));
    }

    @Test
    public void testTotalCost(){
        BasketManager b = new BasketManager();
        Assertions.assertTrue(b.totalCost() == 0);
        b.add(item_a);
        b.add(item_b);
        b.add(item_c);
        Assertions.assertEquals(30, b.totalCost());
        Assertions.assertEquals(30, (b.remove(item_a).getPrice() + b.remove(item_b).getPrice() + b.remove(item_c).getPrice()));

    }
}
