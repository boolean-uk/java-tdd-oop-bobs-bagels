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
    public void shouldNotAddBagelToBasketWhenBasketIsFull() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        basket.changeCapacity(2);
        basket.add("Bagel","Onion");
        basket.add("Coffee","Black");
        basket.add("Filling", "Bacon");

        String output = outputStream.toString().trim();

        //should not add last item
        Assertions.assertFalse(basket.getShoppingList().containsKey(filling));

        //should print message
        Assertions.assertTrue(output.contains("Basket is full."));

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

    @Test
    public void shouldChangeBasketCapacity() {
        int newCapacity = 4;
        basket.changeCapacity(newCapacity);
        Assertions.assertEquals(newCapacity, basket.getCapacity());
    }

    @Test
    public void shouldNotChangeBasketCapacityToNegativeValue() {
        //Setup
        int oldCapacity = basket.getCapacity();
        int newCapacity = -1;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //Execute
        basket.changeCapacity(newCapacity);
        String output = outputStream.toString().trim();

        //Verify
        //should not change capacity
        Assertions.assertEquals(oldCapacity, basket.getCapacity());
        //should print message
        Assertions.assertTrue(output.contains("Capacity cannot be less than 1."));

    }
    @Test
    public void shouldNotChangeBasketCapacityForLowerValueThanBasketSize() {
        //Setup
        int oldCapacity = basket.getCapacity();
        int newCapacity = 2;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        basket.add("Bagel","Onion");
        basket.add("Coffee","Black");
        basket.add("Filling", "Bacon");
        basket.add("Filling", "Egg");

        //Execute
        basket.changeCapacity(newCapacity);
        String output = outputStream.toString().trim();

        //Verify
        //should not change capacity
        Assertions.assertEquals(oldCapacity, basket.getCapacity());
        //should print message
        Assertions.assertTrue(output.contains("Capacity cannot be smaller than no. of items in basket."));
    }

    @Test
    public void shouldReturnTrueIfBasketIsFull() {
        basket.changeCapacity(2);
        basket.add("Bagel","Onion");
        basket.add("Coffee","Black");
        basket.add("Filling", "Bacon");

        boolean isBasketFull = basket.isBasketFull();
        Assertions.assertTrue(isBasketFull);
    }

    @Test
    public void shouldReturnFalseIfBasketIsNotFull() {
        basket.add("Bagel","Onion");
        basket.add("Coffee","Black");

        boolean isBasketFull = basket.isBasketFull();
        Assertions.assertFalse(isBasketFull);
    }

    @Test
    public void shouldReturnCorrectTotalCost() {
        basket.add("Bagel","Onion");
        basket.add("Coffee","Black");
        basket.add("Coffee","Black");
        double DELTA = 1e-9;

        Assertions.assertEquals(2.47, basket.totalCost(), DELTA);
    }


}
