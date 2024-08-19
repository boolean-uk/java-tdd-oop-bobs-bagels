package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCore {

    Store store = new Store(10);

    @Test
    public void testOrderAddProduct(){
        Order order1 = new Order();
        Assertions.assertEquals(0, order1.basket.size());
        //Assertions.assertNull(order1.basket.get("BGLO"));
        order1.addProduct("BGLO", store);
        Assertions.assertEquals(1, order1.basket.size());
        Assertions.assertEquals(1, order1.basket.get("BGLO"));
    }

    @Test
    public void testOrderRemoveProduct(){
        Order order1 = new Order();
        order1.addProduct("BGLO", store);
        order1.addProduct("BGLO", store);
        order1.addProduct("BGLP", store);
        Assertions.assertEquals(2, order1.basket.get("BGLO"));
        Assertions.assertEquals(1, order1.basket.get("BGLP"));
        order1.removeProduct("BGLO");
        order1.removeProduct("BGLP");
        Assertions.assertEquals(1, order1.basket.get("BGLO"));
        Assertions.assertFalse(order1.basket.containsKey("BGLP"));
    }

    @Test
    public void testOrderRemoveProductThrow(){
        Order order1 = new Order();
        order1.addProduct("BGLO", store);
        Exception thrown = assertThrows(Exception.class, () -> order1.removeProduct("BGLP"));
    }

    @Test
    public void testStoreContains(){
        Assertions.assertTrue(store.contains("BGLO"));
    }

    /*
    @Test
    public void testOrderAddProductFromInventory(){
        Order order1 = new Order();
        order1.addProduct("BGLO");
        Assertions.assertTrue(order1.basket.containsKey("BGLO"));
        Exception thrown = assertThrows(Exception.class, () -> order1.addProduct("BGLX"));
    }
    */
}
