package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketManagerTest {

    Item item_a = new Item("XXX", 10.0, Item.Name.BAGEL, Item.Variant.CHEESE, null);

    @Test
    public void testAdd(){
        BasketManager b = new BasketManager();
        Assertions.assertNotNull(b.getBasket());
        b.add(item_a);
        Assertions.assertNotNull(b.getBasket());
    }

    @Test
    public void testRemove(){
        BasketManager b = new BasketManager();
    }

    @Test
    public void testCheckCapacity(){
        BasketManager b = new BasketManager();
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
