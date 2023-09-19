package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {
    @Test
    public void shouldAddProductsIfSpaceExists() {
        Basket basket = new Basket(3);
        Product bagel = new Bagel("Onion",0.49, "BGLO");
        Assertions.assertTrue(basket.addProduct(bagel));
        Product coffee = new Coffee("Black", 0.99, "COFB");
        Assertions.assertTrue(basket.addProduct(coffee));
    }

    @Test
    public void shouldNotAddProductsIfFull() {
        Basket basket = new Basket(1);
        Product bagel = new Bagel("Onion",0.49, "BGLO");
        Assertions.assertTrue(basket.addProduct(bagel));
        Product coffee = new Coffee("Black", 0.99, "COFB");
        Assertions.assertFalse(basket.addProduct(coffee));
    }

    @Test
    public void emptyBasketShouldHaveZeroCost() {
        Basket basket = new Basket(4);
        Assertions.assertEquals(0,basket.getTotalCost());
    }

    @Test
    public void shouldGetTotalCost() {
        Basket basket = new Basket(3);
        Product bagel = new Bagel("Onion",0.49, "BGLO");
        basket.addProduct(bagel);
        Product coffee = new Coffee("Black", 0.99, "COFB");
        basket.addProduct(coffee);
        Assertions.assertEquals(1.48, basket.getTotalCost());
    }

    @Test
    public void capacityCantDecrease() {
        Basket basket = new Basket(3);
        Assertions.assertFalse(basket.setCapacity(2));
    }

    @Test
    public void capacityShouldIncrease() {
        Basket basket = new Basket(1);
        Product bagel = new Bagel("Onion",0.49, "BGLO");
        Assertions.assertTrue(basket.addProduct(bagel));
        Product coffee = new Coffee("Black", 0.99, "COFB");
        Assertions.assertFalse(basket.addProduct(coffee));
        basket.setCapacity(2);
        Assertions.assertTrue(basket.addProduct(coffee));
    }

    @Test
    public void shouldRemoveExistingProduct() {
        Basket basket = new Basket(3);
        Product bagel = new Bagel("Onion",0.49, "BGLO");
        basket.addProduct(bagel);
        Assertions.assertEquals(0.49,basket.getTotalCost());
        Assertions.assertTrue(basket.removeProduct(bagel));
        Assertions.assertEquals(0,basket.getTotalCost());
    }

    @Test
    public void shouldReturnFalseOnFalseRemove() {
        Basket basket = new Basket(3);
        Product bagel = new Bagel("Onion",0.49, "BGLO");
        Product coffee = new Coffee("Black", 0.99, "COFB");
        basket.addProduct(bagel);
        Assertions.assertEquals(0.49,basket.getTotalCost());
        Assertions.assertFalse(basket.removeProduct(coffee));
        Assertions.assertEquals(0.49,basket.getTotalCost());
    }

    @Test
    public void shouldShowProductsCorrectly() {
        Basket basket = new Basket(10);
        Product bagel = new Bagel("Onion",0.49, "BGLO");
        Product coffee = new Coffee("Black", 0.99, "COFB");
        basket.addProduct(bagel);
        basket.addProduct(bagel);
        basket.addProduct(bagel);
        basket.addProduct(coffee);
        basket.addProduct(coffee);
        String expected = "3x BGLO = 1.47\n2x COFB = 1.98\n";
        Assertions.assertEquals(expected, basket.showProducts());
    }
}
