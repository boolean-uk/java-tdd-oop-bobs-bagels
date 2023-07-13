package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasketTest {
    private static Inventory inventory;

    @BeforeAll
    static void setup() {
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
    public void testGetTotal_WhenUsingDiscount_ShouldTotalCostOfProductsInTheBasket() {
        //Given
        Basket basket = new Basket(inventory, 20);
        basket.addProduct("BGLO", 6);
        basket.addProduct("BGLP", 12);

        //When
        float result = basket.getTotalCost();

        //Then
        Assertions.assertEquals(result, 2.49F + 3.99F);
    }

    @Test
    public void testGetTotal_WhenMixingDiscountWithNoDiscount_ShouldTotalCostOfProductsInTheBasket() {
        //Given
        Basket basket = new Basket(inventory, 22);
        basket.addProduct("BGLO", 8);
        basket.addProduct("BGLP", 12);
        basket.addProduct("COFW", 2);

        //When
        float result = basket.getTotalCost();

        //Then
        Assertions.assertEquals(result, 2.49F + 3.99F + 0.98F + 1.19F*2);
    }

    @Test
    public void testGetReceipt_WhenBasketIsNotEmpty_ShouldReturnReceipt() {
        //Given
        StringBuilder expected = new StringBuilder();
        LocalDateTime ldt = LocalDateTime.now();

        expected.append("    ~~~ Bob's Bagels ~~~    \n\n")
                .append("    " + ldt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + "   \n\n")
                .append("-".repeat(28) + "\n\n")
                .append("Onion Bagel       2   £0.98\n")
                .append("Plain Bagel       12  £3.99\n")
                .append("Everything Bagel  6   £2.49\n")
                .append("Black Coffee      3   £2.97\n\n")
                .append("-".repeat(28) + "\n\n")
                .append("Total                £10.43\n\n")
                .append("        Thank you\n")
                .append("      for your order! \n");


        Basket basket = new Basket(inventory, 23);
        basket.addProduct("BGLO", 2);
        basket.addProduct("BGLP", 12);
        basket.addProduct("BGLE", 6);
        basket.addProduct("COFB", 3);

        //When
        String result = basket.getReceipt();

        //Then
        Assertions.assertEquals(expected.toString(), result);
    }
}
