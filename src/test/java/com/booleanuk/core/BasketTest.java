package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BasketTest {
    private static Inventory inventory;

    @BeforeAll
    static void setup() {
        inventory = new Inventory();
        inventory.addProduct("BGLO", 0.49F, "Bagel", "Onion");
        inventory.addProduct("BGLP", 0.39F, "Bagel", "Plain");
        inventory.addProduct("BGLE", 0.49F, "Bagel", "Everything");
        inventory.addProduct("BGLS", 0.49F, "Bagel", "Sesame");

        inventory.addProduct("COFB", 0.99F, "Coffee", "Black");
        inventory.addProduct("COFW", 1.19F, "Coffee", "White");
        inventory.addProduct("COFC", 1.29F, "Coffee", "Cappuccino");
        inventory.addProduct("COFL", 1.29F, "Coffee", "Latte");

        inventory.addProduct("FILB", 0.12F, "Filling", "Bacon");
        inventory.addProduct("FILE", 0.12F, "Filling", "Egg");
        inventory.addProduct("FILC", 0.12F, "Filling", "Cheese");
        inventory.addProduct("FILX", 0.12F, "Filling", "Cream Cheese");
        inventory.addProduct("FILS", 0.12F, "Filling", "Smoked Salmon");
        inventory.addProduct("FILH", 0.12F, "Filling", "Ham");
        inventory.addProduct("FILNOT", 0.12F, "NotFilling", "Feeling");
    }

    @Test
    public void testAddProduct_WhenProductIsNotInTheBasketAndQuantityIsValidAndProductIsInInventory_ShouldReturnTrue() {
        //Given
        Basket basket = new Basket(inventory, 10);

        //When
        boolean result = basket.addProduct("BGLO", 2);

        //Then
        Assertions.assertTrue(result);
    }

    @Test
    public void testAddProduct_WhenProductIsNotInInventory_ShouldReturnFalse() {
        //Given
        Basket basket = new Basket(inventory, 10);

        //When
        boolean result = basket.addProduct("BGLOTY", 2);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testAddProduct_WhenQuantityIsNotValid_ShouldReturnFalse() {
        //Given
        Basket basket = new Basket(inventory, 10);

        //When
        boolean result = basket.addProduct("BGLO", -2);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testAddProduct_WhenBasketIsFull_ShouldReturnFalse() {
        //Given
        Basket basket = new Basket(inventory, 10);

        //When
        boolean result1 = basket.addProduct("BGLO", 2);
        boolean result2 = basket.addProduct("BGLO", 4);
        boolean result3 = basket.addProduct("BGLO", 5);

        //Then
        Assertions.assertTrue(result1);
        Assertions.assertTrue(result2);
        Assertions.assertFalse(result3);
    }

    @Test
    public void testRemoveProduct_WhenProductIsInBasketAndQuantityIsValid_ShouldReturnTrue() {
        //Given
        Basket basket = new Basket(inventory, 10);
        basket.addProduct("BGLO", 2);
        basket.addProduct("BGLO", 4);

        //When
        boolean result = basket.removeProduct("BGLO", 2);

        //Then
        Assertions.assertTrue(result);
    }

    @Test
    public void testRemoveProduct_WhenProductIsNotInBasket_ShouldReturnFalse() {
        //Given
        Basket basket = new Basket(inventory, 10);

        //When
        boolean result = basket.removeProduct("BGLO", 3);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testRemoveProduct_WhenQuantityIsNotValid_ShouldReturnFalse() {
        //Given
        Basket basket = new Basket(inventory, 10);
        basket.addProduct("BGLO", 4);

        //When
        boolean result = basket.removeProduct("BGLO", -3);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testRemoveProduct_WhenProductQuantityIsLessThanRemovingQuantity_ShouldReturnFalse() {
        //Given
        Basket basket = new Basket(inventory, 10);
        basket.addProduct("BGLO", 3);

        //When
        boolean result = basket.removeProduct("BGLO", 4);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testChangeBasketCapacity_WhenNewCapacityIsValid_ShouldReturnTrue() {
        //Given
        Basket basket = new Basket(inventory, 10);

        //When
        boolean result = basket.changeBasketCapacity(5);

        //Then
        Assertions.assertTrue(result);
    }

    @Test
    public void testChangeBasketCapacity_WhenNewCapacityIsInvalid_ShouldReturnFalse() {
        //Given
        Basket basket = new Basket(inventory, 10);

        //When
        boolean result = basket.changeBasketCapacity(-5);

        //Then
        Assertions.assertFalse(result);
    }
}
