package com.booleanuk.core.basket;

import com.booleanuk.core.products.Bagel;
import com.booleanuk.core.products.BagelVariant;
import com.booleanuk.core.store.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BasketTest {

    Store store = Store.getInstance();

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
        Bagel bagel = new Bagel("SKU1", BigDecimal.valueOf(0.55));
        boolean result = basket.addProduct(bagel);

        Assertions.assertTrue(result);
        Assertions.assertEquals(bagel, basket.getProducts().get(0));
    }

    @Test
    public void shouldReturnBasketAmountOfProducts() {
        Bagel bagel = new Bagel("SKU1", BigDecimal.valueOf(0.55));
        Bagel bagel1 = new Bagel("SKU1", BigDecimal.valueOf(0.55));
        Basket basket = new Basket(3);

        basket.addProduct(bagel);
        basket.addProduct(bagel1);

        Assertions.assertEquals(2, basket.getProductsAmount());
    }

    @Test
    public void shouldRemoveProductFromBasket() {
        Basket basket = new Basket(2);
        Bagel bagel = new Bagel("SKU1", BigDecimal.valueOf(0.55));

        basket.addProduct(bagel);
        boolean result = basket.removeProduct(bagel);

        Assertions.assertTrue(result);
        Assertions.assertEquals(0, basket.getProductsAmount());
    }

    @Test
    public void shouldReturnTrueWhenSuccessfulAddedProduct() {
        Basket basket = new Basket(1);
        Bagel bagel = new Bagel("SKU1", BigDecimal.valueOf(0.55));

        basket.addProduct(bagel);

        Assertions.assertTrue(basket.isProductInBasket(bagel));
    }

    @Test
    public void shouldReturnFalseWhenProductIsNotInBasket() {
        Basket basket = new Basket(1);
        Bagel bagel = new Bagel("SKU1", BigDecimal.valueOf(0.55));

        Assertions.assertFalse(basket.isProductInBasket(bagel));
    }

    @Test
    public void shouldReturnTrueWhenBasketIsFull() {
        Basket basket = new Basket(1);
        Bagel bagel = new Bagel("SKU1", BigDecimal.valueOf(0.55));

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
        Bagel bagel = new Bagel("SKU1", BigDecimal.valueOf(0.55));

        basket.addProduct(bagel);

        Assertions.assertEquals(BigDecimal.valueOf(0.55), basket.summarizeBasket().total());
    }

    @Test
    public void shouldReturnTrueWhenProductIsInStore() {

        Bagel bagel = new Bagel("BGLO", BigDecimal.valueOf(0.49), BagelVariant.Onion);

        Assertions.assertTrue(store.isProductAvailable(bagel));
    }

    @Test
    public void shouldReturnFalseWhenProductIsNotInStore() {

        Bagel bagel = new Bagel("BGLO", BigDecimal.valueOf(0.99), BagelVariant.Plain);

        Assertions.assertFalse(store.isProductAvailable(bagel));
    }
}
