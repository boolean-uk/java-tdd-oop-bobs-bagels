package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class BasketTest {

    @Test
    public void testContainsItem(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
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
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
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
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
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
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
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
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
        Assertions.assertEquals(10, basket.getCapacity());
        basket.changeCapacity(20);
        Assertions.assertEquals(20, basket.getCapacity());
    }

    @Test
    public void testTotalCost(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
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
        Assertions.assertEquals(1.37f, basket.totalCost());

        Basket basket2 = new Basket(inventory);
        basket2.changeCapacity(20);
        inventory.addStockItem("BGLP", 15);
        inventory.addStockItem("FILE", 1);
        inventory.addStockItem("COFB", 2);

        for (int i = 0; i < 15; i++){
            System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
            basket2.addItem("BGLP");
        }
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket2.addItem("FILE");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket2.addItem("COFB");
        System.setIn(new ByteArrayInputStream(inputYes.getBytes()));
        basket2.addItem("COFB");

        Assertions.assertEquals(7f, basket2.totalCost());
    }

    @Test
    public void testGetReceipt(){
        Inventory inventory = new Inventory();
        Basket basket = new Basket(inventory);
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

        String receipt = basket.getReceipt();
        System.out.println(receipt);
    }

}
