package com.booleanuk.core;

import org.junit.jupiter.api.*;

public class BasketTest {
    private static Inventory inventory;

    @BeforeEach
    void setup() {
        inventory = new Inventory();
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

    @Test
    public void testChangeBasketCapacity_WhenNewCapacityIsValidButItIsLessThanBasketQuantity_ShouldReturnFalse() {
        //Given
        Basket basket = new Basket(inventory, 10);
        basket.addProduct("BGLO", 3);
        basket.addProduct("BGLO", 2);

        //When
        boolean result = basket.changeBasketCapacity(4);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testGetTotalCost_ShouldTotalCostOfProductsInTheBasket() {
        //Given
        Basket basket = new Basket(inventory, 10);
        basket.addProduct("BGLO", 3);
        basket.addProduct("COFB", 1);

        //When
        float result = basket.getTotalCost();

        //Then
        Assertions.assertEquals(result, 2.46F);
    }

    @Test
    public void testAddFillingToBagel_WhenThereIsNoFillingInBagel_ShouldReturnTrue() {
        //Given
        Basket basket = new Basket(inventory, 20);
        basket.addProduct("BGLO", 2);

        //When
        boolean result = basket.addFillingToBagel("BGLO", "FILB");

        //Then
        Assertions.assertTrue(result);
    }

    @Test
    public void testAddFillingToBagel_WhenThereIsAlreadyFillingInBagelAndItIsDifferent_ShouldReturnTrue() {
        //Given
        Basket basket = new Basket(inventory, 20);
        basket.addProduct("BGLO", 2);

        //When
        basket.addFillingToBagel("BGLO", "FILB");
        boolean result = basket.addFillingToBagel("BGLO", "FILE");

        //Then
        Assertions.assertTrue(result);
    }

    @Test
    public void testAddFillingToBagel_WhenThereIsAlreadyFillingInBagelAndItIsTheSame_ShouldReturnFalse() {
        //Given
        Basket basket = new Basket(inventory, 20);
        basket.addProduct("BGLO", 2);

        //When
        basket.addFillingToBagel("BGLO", "FILB");
        boolean result = basket.addFillingToBagel("BGLO", "FILB");

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testAddFillingToBagel_WhenInvalidInput_ShouldReturnFalse() {
        //Given
        Basket basket = new Basket(inventory, 20);
        basket.addProduct("BGLO", 2);

        //When
        boolean result = basket.addFillingToBagel("FILB", "BGLO");

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void testAddFillingToBagel_WhenThereIsNoSpecificBagelInBasket_ShouldReturnFalse() {
        //Given
        Basket basket = new Basket(inventory, 20);
        basket.addProduct("BGLO", 2);

        //When
        boolean result = basket.addFillingToBagel("BGLS", "FILE");

        //Then
        Assertions.assertFalse(result);
    }
}
