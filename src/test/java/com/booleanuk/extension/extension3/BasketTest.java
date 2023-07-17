package com.booleanuk.extension.extension3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BasketTest {

    @Test
    void discountShouldBe036For2CoffeeBagelBGLEBGLP(){
        Basket basket = new Basket();
        basket.addProduct(new CoffeeBagel(ProductType.BGLE));
        basket.addProduct(new CoffeeBagel(ProductType.BGLP));
        basket.getPrice();
        BigDecimal expectedValue = BigDecimal.valueOf(0.36);

        Assertions.assertEquals(expectedValue, basket.getDiscount());
    }

    @Test
    void discountShouldBe189For12BagelsBGLE(){
        Basket basket = new Basket();
        for (int i = 0; i < 12; i++){
            basket.addProduct(new Bagel(ProductType.BGLE));
        }
        basket.getPrice();
        BigDecimal expectedValue = BigDecimal.valueOf(1.89);
        Assertions.assertEquals(expectedValue, basket.getDiscount());
    }

    @Test
    void discountShouldBe069For12BagelsBGLP(){
        Basket basket = new Basket();
        for (int i = 0; i < 12; i++){
            basket.addProduct(new Bagel(ProductType.BGLP));
        }
        basket.getPrice();
        BigDecimal expectedValue = BigDecimal.valueOf(0.69);
        Assertions.assertEquals(expectedValue, basket.getDiscount());
    }

    @Test
    void discountShouldBe0For6BGLP(){
        Basket basket = new Basket();
        for (int i = 0; i < 6; i++){
            basket.addProduct(new Bagel(ProductType.BGLP));
        }

        basket.getPrice();

        BigDecimal expectedValue = BigDecimal.ZERO;
        Assertions.assertEquals(expectedValue, basket.getDiscount());
    }

    @Test
    void discountShouldBeFor6BGLEAnd12BGL(){
        Basket basket = new Basket();
        for (int i = 0; i < 12; i++){
            basket.addProduct(new Bagel(ProductType.BGLP));
        }

        for (int i = 0; i < 6; i++){
            basket.addProduct(new Bagel(ProductType.BGLE));
        }

        basket.getPrice();
        BigDecimal expectedValue = BigDecimal.valueOf(1.14);
        Assertions.assertEquals(expectedValue, basket.getDiscount());
    }

    @Test
    void discountShouldBe189For12BagelsBGLEWithFillings(){
        Basket basket = new Basket();
        Bagel bagel = new Bagel(ProductType.BGLE);
        bagel.addFilling(FillingType.FILB);
        for (int i = 0; i < 12; i++){
            basket.addProduct(bagel);
        }
        basket.getPrice();
        BigDecimal expectedValue = BigDecimal.valueOf(1.89);
        Assertions.assertEquals(expectedValue, basket.getDiscount());
    }

}
