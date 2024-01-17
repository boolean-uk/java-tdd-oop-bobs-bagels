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
    }

    @Test
    public void testCheckItemInBasket(){
        BasketManager b = new BasketManager();
    }

    @Test
    public void testCheckItemInInventory(){
        BasketManager b = new BasketManager();
    }

    @Test
    public void testTotalCost(){
        BasketManager b = new BasketManager();
    }
}
