package com.booleanuk.core;

import com.booleanuk.extension.Receipt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.IntStream;

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
        bagel = new Bagel("BGLO", "Bagel", BigDecimal.valueOf(0.49), "Onion");
        filling = new Filling("FILB", "Filling", BigDecimal.valueOf(0.12), "Bacon");
        coffee = new Coffee("COFB", "Coffee", BigDecimal.valueOf(0.99), "Black");
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
    public void isInBasketCheck(){
        basket.add("Bagel","Onion");
        Assertions.assertTrue(basket.isInBasket("Bagel", "Onion"));
        Assertions.assertFalse(basket.isInBasket("Bagel", "Bacon"));
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
    public void shouldNotReturnPriceForNonExistingItem(){

        Optional<BigDecimal> price2 = Inventory.getItemPrice("Covfefe", "Yellow");
        Assertions.assertFalse(price2.isPresent());
        Assertions.assertEquals(Optional.empty(), price2);
    }

    @Test
    public void totalPriceShouldCalculateCorrectly1(){
        basket.add("Bagel","Onion");
        basket.add("Coffee","Black");
        basket.add("Coffee","Black");
        Assertions.assertEquals(BigDecimal.valueOf(2.47), basket.totalPrice());
    }
    @Test
    public void totalPriceShouldCalculateCorrectly2(){
        basket.add("Bagel","Plain");
        basket.add("Coffee","Black");
        basket.add("Coffee","Black");
        Assertions.assertEquals(BigDecimal.valueOf(2.24), basket.totalPrice());
    }

    @Test
    public void totalPriceShouldCalculateCorrectly3(){
        basket.changeCapacity(16);
        for (int i = 0; i < 16; i++) {
            basket.add("Bagel", "Plain");
        }
        Assertions.assertEquals(BigDecimal.valueOf(5.55), basket.totalPrice());
    }
    @Test
    public void totalPriceShouldCalculateCorrectly4(){
        basket.changeCapacity(23);
        for (int i = 0; i < 12; i++) {
            basket.add("Bagel", "Plain");
        }
        for (int i = 0; i < 6; i++) {
            basket.add("Bagel", "Everything");
        }
        basket.add("Bagel", "Onion");
        basket.add("Bagel", "Onion");

        Assertions.assertEquals(BigDecimal.valueOf(7.46), basket.totalPrice());
    }
    @Test
    public void totalPriceShouldCalculateCorrectly5(){
        basket.changeCapacity(23);
        for (int i = 0; i < 12; i++) {
            basket.add("Bagel", "Plain");
        }
        basket.add("Coffee", "Black");
        basket.add("Coffee", "Black");
        basket.add("Coffee", "Black");

        Assertions.assertEquals(BigDecimal.valueOf(7.26), basket.totalPrice());
    }

    @Test
    public void totalPriceShouldCalculateCorrectly6(){
        basket.changeCapacity(23);
        for (int i = 0; i < 12; i++) {
            basket.add("Bagel", "Plain");
        }
        for (int i = 0; i < 6; i++) {
            basket.add("Bagel", "Everything");
        }
        basket.add("Bagel", "Onion");
        basket.add("Bagel", "Onion");
        basket.add("Coffee", "Black");
        basket.add("Coffee", "Black");
        basket.add("Coffee", "Black");

        Assertions.assertEquals(BigDecimal.valueOf(10.73), basket.totalPrice());
    }

}
