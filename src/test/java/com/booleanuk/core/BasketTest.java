package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BasketTest {
    private static Basket basket;
    private static Bagel bagel;
    private static Filling filling;
    private static Coffee coffee;
    @BeforeAll
    public static void SetUp(){
        Inventory.createInventory();
    }
    @BeforeEach
    public void cleanUp(){
        basket = new Basket(5);
        bagel = new Bagel("BGLO", "Bagel", 0.49, "Onion");
        filling = new Filling("FILB", "Filling", 0.12, "Bacon");
        coffee = new Coffee("COFB", "Coffee", 0.99, "Black");
    }

    @Test
    public void addTest(){
        //add non existing item
        basket.add("Bagel", "NoSuchBagel");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        basket.add("Bagel", "NoSuchBagel");

        String output = outputStream.toString().trim();
        Assertions.assertTrue(output.contains("Item not found in inventory"));
        Assertions.assertEquals(0,basket.getShoppingList().size());

        //add existing item
        basket.add("Bagel","Onion");
        Assertions.assertTrue(basket.getShoppingList().containsKey(bagel));

        basket.add("Filling", "Bacon");
        Assertions.assertTrue(basket.getShoppingList().containsKey(filling));

        //add multiple of same item
        basket.add("Coffee","Black");
        basket.add("Coffee","Black");
        Assertions.assertEquals(2, basket.getShoppingList().get(coffee));



    }

    @Test
    public void removeTest(){
        //remove item not existing in basket
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        basket.remove("Bagel", "Onion");

        String output = outputStream.toString().trim();
        Assertions.assertTrue(output.contains("Item not found in basket"));


        //remove when quantity =1
        basket.add("Bagel","Onion");
        basket.remove("Bagel","Onion");
        Assertions.assertFalse(basket.getShoppingList().containsKey(bagel));

        //remove when quantity >1
        basket.add("Coffee","Black");
        basket.add("Coffee","Black");
        basket.remove("Coffee","Black");
        Assertions.assertEquals(1, basket.getShoppingList().get(coffee));
    }
}
