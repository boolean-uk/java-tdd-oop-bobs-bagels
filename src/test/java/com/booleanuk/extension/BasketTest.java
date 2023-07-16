package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class BasketTest {

    Basket basket;
    Bagel bagel;
    Filling filling;

    @BeforeEach
    void beforeEach() {
        basket = new Basket(3);
        bagel = new Bagel("BF", BigDecimal.valueOf(15),"variantBagel");
        filling = new Filling("FV", BigDecimal.valueOf(5), "variantFilling");
    }

    @Test
    void ShouldAddBagelToTheBasket() {
        basket.add(bagel);
        Assertions.assertEquals(1, basket.getProducts().size());
    }

    @Test
    void ShouldRemoveBagelFromList() {
        basket.add(bagel);
        Assertions.assertEquals(1, basket.getProducts().size());
        basket.remove(bagel);
        Assertions.assertEquals(0, basket.getProducts().size());
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
        Bagel bagel1 = new Bagel("BF1", BigDecimal.valueOf(10), "variantBagel1");
        bagel1.setFillings(List.of(filling));
        basket.add(bagel1);
        Assertions.assertTrue(basket.isFull());
    }

    @Test
    void ShouldCheckIfBagelIsInBasket() {
        Assertions.assertFalse(basket.doesProductExist(bagel));
        basket.add(bagel);
        Assertions.assertTrue(basket.doesProductExist(bagel));
    }

    @Test
    void ShouldReturnTotalCostOfProducts() {
        Assertions.assertEquals(BigDecimal.valueOf(0), basket.totalCost());
        basket.add(bagel);
        Assertions.assertEquals(BigDecimal.valueOf(15), basket.totalCost());
        bagel.setFillings(List.of(filling));
        Assertions.assertEquals(BigDecimal.valueOf(20), basket.totalCost());
    }

    @Test
    void ShouldReturnDiscountsForProducts() {
        basket.setCapacity(1000);

        Bagel BGLO = new Bagel("BGLO", BigDecimal.valueOf(0.49), "Onion");  // 6 for 2.49
        Bagel BGLP = new Bagel("BGLP", BigDecimal.valueOf(0.39), "Plain");  // 12 for 3.99
        Bagel BGLE = new Bagel("BGLE", BigDecimal.valueOf(0.49), "Everything"); // 6 for 2.49
        Coffee COFB = new Coffee("COFB", BigDecimal.valueOf(0.99), "Black");    // Coffee & Bagel for 1.25

        for(int i = 0; i < 5; i++)
            basket.add(BGLO);
        Assertions.assertEquals(Map.of(BGLO, BigDecimal.valueOf(0.0)), basket.calculateDiscounts());

        basket.add(BGLO);
        Assertions.assertEquals(Map.of(BGLO, BigDecimal.valueOf(0.45)), basket.calculateDiscounts());

        for(int i = 0; i < 12; i++)
            basket.add(BGLP);
        Assertions.assertEquals(Map.of(
                BGLO, BigDecimal.valueOf(0.45),
                BGLP, BigDecimal.valueOf(0.69)
        ), basket.calculateDiscounts());

        for(int i = 0; i < 12; i++)
            basket.add(BGLP);
        Assertions.assertEquals(Map.of(
                BGLO, BigDecimal.valueOf(0.45),
                BGLP, BigDecimal.valueOf(1.38)
        ), basket.calculateDiscounts());

        basket.add(COFB);
        Assertions.assertEquals(Map.of(
                BGLO, BigDecimal.valueOf(0.45),
                BGLP, BigDecimal.valueOf(1.38),
                COFB, BigDecimal.valueOf(0)
        ), basket.calculateDiscounts());

        basket.add(BGLP);
        Assertions.assertEquals(Map.of(
                BGLO, BigDecimal.valueOf(0.45),
                BGLP, BigDecimal.valueOf(1.38),
                COFB, BigDecimal.valueOf(0.13)
        ), basket.calculateDiscounts());

        basket.add(COFB);
        Assertions.assertEquals(Map.of(
                BGLO, BigDecimal.valueOf(0.45),
                BGLP, BigDecimal.valueOf(1.38),
                COFB, BigDecimal.valueOf(0.13)
        ), basket.calculateDiscounts());

        basket.add(BGLO);
        Assertions.assertEquals(Map.of(
                BGLO, BigDecimal.valueOf(0.45),
                BGLP, BigDecimal.valueOf(1.38),
                COFB, BigDecimal.valueOf(0.36)
        ), basket.calculateDiscounts());
    }
}
