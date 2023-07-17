package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class BasketTest {

    Basket basket;
    Bagel bagel;
    Filling filling;

    @BeforeEach
    void beforeEach() {
        basket = new Basket(3);
        bagel = new Bagel(BigDecimal.valueOf(15),"variantBagel");
        filling = new Filling(BigDecimal.valueOf(5), "variantFilling");
    }

    @Test
    void ShouldAddBagelToTheBasket() {
        basket.add(bagel);
        Assertions.assertEquals(1, basket.getBagels().size());
    }

    @Test
    void ShouldRemoveBagelFromList() {
        basket.add(bagel);
        Assertions.assertEquals(1, basket.getBagels().size());
        basket.remove(bagel);
        Assertions.assertEquals(0, basket.getBagels().size());
    }


    @Test
    void ShouldCheckIfBasketIsFullAndChangeCapacity() {
        Assertions.assertFalse(basket.isFull());
        basket.add(bagel);
        basket.add(bagel);
        basket.add(bagel);
        Assertions.assertTrue(basket.isFull());
        basket.setCapacity(5);
        Assertions.assertFalse(basket.isFull());
        Bagel bagel1 = new Bagel(BigDecimal.valueOf(10), "variantBagel1");
        bagel1.setFillings(List.of(filling));
        basket.add(bagel1);
        Assertions.assertTrue(basket.isFull());
    }

    @Test
    void ShouldCheckIfBagelIsInBasket() {
        Assertions.assertFalse(basket.doesBagelExist(bagel));
        basket.add(bagel);
        Assertions.assertTrue(basket.doesBagelExist(bagel));
    }

    @Test
    void ShouldReturnTotalCostOfProducts() {
        Assertions.assertEquals(BigDecimal.valueOf(0), basket.totalCost());
        basket.add(bagel);
        Assertions.assertEquals(BigDecimal.valueOf(15), basket.totalCost());
        bagel.setFillings(List.of(filling));
        Assertions.assertEquals(BigDecimal.valueOf(20), basket.totalCost());
    }
}
