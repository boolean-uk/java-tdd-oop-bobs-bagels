package com.booleanuk.core.basket;

import com.booleanuk.core.products.Bagel;
import com.booleanuk.core.products.BagelVariant;
import com.booleanuk.core.products.Coffee;
import com.booleanuk.core.products.CoffeeVariant;
import com.booleanuk.core.store.Discount;
import com.booleanuk.core.store.Store;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

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

    @Test
    public void shouldDiscountOnSingleBagels() {
        Bagel bagelOnion = new Bagel("BGLO", BigDecimal.valueOf(0.49), BagelVariant.Onion);

        Discount discountBagelOnion = new Discount(bagelOnion, 6, BigDecimal.valueOf(2.49));

        store.addDiscount(discountBagelOnion);

        Basket basket = new Basket(6);
        basket.addProduct(bagelOnion, 6);

        Assertions.assertEquals(BigDecimal.valueOf(2.49), basket.summarizeBasket().total());

    }

    @Test
    public void shouldDiscountOnMultipleBagels() {
        Bagel bagelOnion = new Bagel("BGLO", BigDecimal.valueOf(0.49), BagelVariant.Onion);
        Bagel bagelPlain = new Bagel("BGLP", BigDecimal.valueOf(0.39), BagelVariant.Plain);

        Discount discountBagelPlain = new Discount(bagelPlain, 12, BigDecimal.valueOf(3.99));
        Discount discountBagelOnion = new Discount(bagelOnion, 6, BigDecimal.valueOf(2.49));


        store.setAvailableProducts(new ArrayList<>());
        store.addDiscount(discountBagelPlain);
        store.addDiscount(discountBagelOnion);


        Basket basket = new Basket(18);
        basket.addProduct(bagelOnion, 6);
        basket.addProduct(bagelPlain, 12);

        Assertions.assertEquals(BigDecimal.valueOf(2.49).add(BigDecimal.valueOf(3.99)), basket.summarizeBasket().total());

    }

    @Test
    public void shouldDiscountBagelWithCoffee() {
        Bagel bagelOnion = new Bagel("BGLO", BigDecimal.valueOf(0.49), BagelVariant.Onion);
        Coffee coffeeBlack = new Coffee("COFB", BigDecimal.valueOf(0.99), CoffeeVariant.Black);

        Discount discount = new Discount(coffeeBlack, 1, BigDecimal.valueOf(1.25), bagelOnion);

        store.addDiscount(discount);

        Basket basket = new Basket(2);
        basket.addProduct(bagelOnion);
        basket.addProduct(coffeeBlack);

        Assertions.assertEquals(BigDecimal.valueOf(1.25), basket.summarizeBasket().total());
    }

    @Test
    public void shouldDiscountOnMultipleBagelsWithCoffee() {
        Bagel bagelOnion = new Bagel("BGLO", BigDecimal.valueOf(0.49), BagelVariant.Onion);
        Bagel bagelPlain = new Bagel("BGLP", BigDecimal.valueOf(0.39), BagelVariant.Plain);
        Bagel bagelEverything = new Bagel("BGLE", BigDecimal.valueOf(0.49), BagelVariant.Everything);
        Coffee coffeeBlack = new Coffee("COFB", BigDecimal.valueOf(0.99), CoffeeVariant.Black);


        Discount discountCoffeeBlack = new Discount(coffeeBlack, 1, BigDecimal.valueOf(1.25), bagelEverything);
        Discount discountBagelPlain = new Discount(bagelPlain, 12, BigDecimal.valueOf(3.99));
        Discount discountBagelOnion = new Discount(bagelOnion, 6, BigDecimal.valueOf(2.49));


        store.setAvailableProducts(new ArrayList<>());
        store.setAvailableDiscounts(new ArrayList<>());
        store.addDiscount(discountBagelPlain);
        store.addDiscount(discountBagelOnion);
        store.addDiscount(discountCoffeeBlack);


        Basket basket = new Basket(19);
        basket.addProduct(bagelOnion, 6);
        basket.addProduct(bagelPlain, 12);
        basket.addProduct(coffeeBlack);
        SummarizedBasket total = basket.summarizeBasket();
        Assertions.assertEquals(BigDecimal.valueOf(2.49).add(BigDecimal.valueOf(3.99).add(BigDecimal.valueOf(1.25))), total.total());

    }
}
