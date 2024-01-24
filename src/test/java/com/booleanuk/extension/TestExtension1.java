package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestExtension1 {
    @Test
    public void testShouldGiveDiscountFor12(){
        Basket basket = new Basket();
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        Assertions.assertEquals(3.99,basket.totalCost());
    }

    @Test
    public void testShouldGiveDiscountFor6(){
        Basket basket = new Basket();
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        Assertions.assertEquals(2.49,basket.totalCost());
    }

    @Test
    public void testShouldGiveDiscountForCoffeeWithBagle(){
        Basket basket = new Basket();

        basket.addProductToBasket("Coffee","Black","Yes");
        basket.addProductToBasket("Bagel","Onion","Yes");
        Assertions.assertEquals(1.25,basket.totalCost());
    }

    @Test
    public void testShouldGiveDiscountFor6AndForCoffeeWithBagle(){
        Basket basket = new Basket();
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Coffee","Black","Yes");
        basket.addProductToBasket("Bagel","Onion","Yes");
        Assertions.assertEquals(3.74,basket.totalCost());
    }
    @Test
    public void testShouldGiveDiscountFor6AndForCoffeeWithBagleAndNotForSingleBagel(){
        Basket basket = new Basket();
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addProductToBasket("Coffee","Black","Yes");
        basket.addProductToBasket("Bagel","Onion","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        Assertions.assertEquals(4.13,basket.totalCost());
    }
}
