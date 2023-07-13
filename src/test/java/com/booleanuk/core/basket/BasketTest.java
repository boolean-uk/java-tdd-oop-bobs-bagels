package com.booleanuk.core.basket;

import com.booleanuk.core.products.Bagel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasketTest {

    @Test
    public void shouldCreateBasketWithEmptyList() {
        Basket basket = new Basket();

        Assertions.assertEquals(0, basket.getProductsAmount());
    }

    @Test
    public void shouldCreateBasketWithGivenCapacity() {
        Basket basket = new Basket(5);

        Assertions.assertEquals(5, basket.getCapacity());
    }

    @Test
    public void shouldAddNewProductToBasket() {
        Basket basket = new Basket(2);
        Bagel bagel = new Bagel("SKU1", 0.55);
        basket.addProduct(bagel);

        Assertions.assertEquals(bagel, basket.getProducts().get(0));
    }

    @Test
    public void shouldReturnBasketAmountOfProducts() {
        Bagel bagel = new Bagel("SKU1", 0.55);
        Bagel bagel1 = new Bagel("SKU1", 0.55);
        Basket basket = new Basket(3);

        basket.addProduct(bagel);
        basket.addProduct(bagel1);

        Assertions.assertEquals(2, basket.getProductsAmount());
    }

    @Test
    public void shouldRemoveProductFromBasket() {
        Basket basket = new Basket(2);
        Bagel bagel = new Bagel("SKU1", 0.55);

        basket.addProduct(bagel);
        basket.removeProduct(bagel);

        Assertions.assertEquals(0, basket.getProductsAmount());
    }

    @Test
    public void shouldReturnTrueWhenSuccessfulAddedProduct() {
        Basket basket = new Basket(1);
        Bagel bagel = new Bagel("SKU1", 0.55);

        basket.addProduct(bagel);

        Assertions.assertTrue(basket.isProductInBasket(bagel));
    }

    @Test
    public void shouldReturnFalseWhenProductIsNotInBasket() {
        Basket basket = new Basket(1);
        Bagel bagel = new Bagel("SKU1", 0.55);

        Assertions.assertFalse(basket.isProductInBasket(bagel));
    }

    @Test
    public void shouldReturnTrueWhenBasketIsFull() {
        Basket basket = new Basket(1);
        Bagel bagel = new Bagel("SKU1", 0.55);

        basket.addProduct(bagel);

        Assertions.assertFalse(basket.isFull());
    }

    @Test
    public void shouldReturnFalseWhenBasketIsNotFull() {
        Basket basket = new Basket(1);

        Assertions.assertFalse(basket.isFull());
    }

    @Test
    public void shouldCalculateTotalPriceOfAllProductsInBasket() {
        Basket basket = new Basket(1);
        Bagel bagel = new Bagel("SKU1", 0.55);

        basket.addProduct(bagel);

        Assertions.assertEquals(0.55, basket.summarizeBasket());
    }
}
