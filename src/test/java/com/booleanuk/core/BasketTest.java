package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class BasketTest {

    @Test
    public void testContainsItem(){
        Basket basket = new Basket();
        basket.getInventory().addStockItem("BGLP", 1);
        basket.getInventory().addStockItem("FILE", 1);


        // To simulate customer responses
        String inputYes = "yes\n";
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("BGLP");

        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("FILE");

        Assertions.assertTrue(basket.containsItem("BGLP"));
        Assertions.assertTrue(basket.containsItem("FILE"));
        Assertions.assertEquals(0, basket.getInventory().getStockSize());
    }

    @Test
    public void testAddItem(){
        Basket basket = new Basket();
        basket.getInventory().addStockItem("BGLP", 1);
        basket.getInventory().addStockItem("FILE", 1);

        String inputYes = "yes\n";
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("BGLP");

        String inputNo = "no\n";
        System.setIn(new ByteArrayInputStream(inputNo.getBytes()));
        basket.addItem("FILE");

        Assertions.assertEquals(1, basket.getItems().size());
    }

    @Test
    public void testRemoveItem(){
        Basket basket = new Basket();
        basket.getInventory().addStockItem("BGLP", 1);
        basket.getInventory().addStockItem("FILE", 1);


        String inputYes = "yes\n";
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("BGLP");

        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("FILE");

        Assertions.assertTrue(basket.containsItem("BGLP"));
        Assertions.assertTrue(basket.containsItem("FILE"));
        basket.removeItem("FILE");
        Assertions.assertFalse(basket.containsItem("FILE"));
        Assertions.assertEquals(1, basket.getInventory().getStockSize());

    }

    @Test
    public void testCheckCapacity(){
        Basket basket = new Basket();
        basket.getInventory().addStockItem("BGLP", 5);
        basket.getInventory().addStockItem("FILE", 5);

        basket.checkCapacity();
        Assertions.assertFalse(basket.getIsFull());

        String inputYes = "yes\n";
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("BGLP");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("FILE");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("BGLP");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("FILE");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("BGLP");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("FILE");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("BGLP");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("FILE");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("BGLP");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("FILE");
        basket.checkCapacity();
        Assertions.assertTrue(basket.getIsFull());
    }

    @Test
    public void testChangeCapacity(){
        Basket basket = new Basket();
        Assertions.assertEquals(10, basket.getCapacity());
        basket.changeCapacity(20);
        Assertions.assertEquals(20, basket.getCapacity());
    }

    @Test
    public void testTotalCost(){
        Basket basket = new Basket();
        basket.getInventory().addStockItem("BGLP", 1);
        basket.getInventory().addStockItem("FILE", 1);
        basket.getInventory().addStockItem("COFB", 1);


        String inputYes = "yes\n";
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("BGLP");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("FILE");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket.addItem("COFB");
        Assertions.assertEquals(1.5f, basket.totalCost());

        Basket basket2 = new Basket();
        basket2.getInventory().addStockItem("COFB", 3);

        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket2.addItem("COFB");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket2.addItem("COFB");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket2.addItem("COFB");
        Assertions.assertEquals(2.97f, basket2.totalCost());
    }

}
