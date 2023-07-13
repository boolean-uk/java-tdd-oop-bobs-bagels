package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BasketTest {

    private static Bagle BAGLE1 = new Bagle(BagleType.BGLE);
    private static Bagle BAGLE2 = new Bagle(BagleType.BGLO);
    private static Bagle BAGLE3 = new Bagle(BagleType.BGLS);

    @Test
    void addProduct_ShouldAddProduct(){
        Basket basket = new Basket();
        ArrayList<Product> expectedBasket = new ArrayList<>();
        expectedBasket.add(BAGLE1);

        Assertions.assertDoesNotThrow(() -> basket.addProduct(BAGLE1));
        Assertions.assertEquals(expectedBasket, basket.getBagelsInBasket());
    }

    @Test
    void addProduct_ShouldNotAddProductCapacityFull(){
        Basket basket = new Basket();
        for (int i = 0; i < basket.getBasketCapacity(); i++){
            basket.addProduct(BAGLE1);
        }

        Assertions.assertThrows(IllegalStateException.class, () -> basket.addProduct(BAGLE1));
    }

    @Test
    void removeProduct_ShouldRemoveProduct(){
        Basket basket = new Basket();
        basket.addProduct(BAGLE1);
        basket.addProduct(BAGLE2);

        ArrayList<Product> expectedBasket = new ArrayList<>();
        expectedBasket.add(BAGLE1);

        Assertions.assertDoesNotThrow(() -> basket.removeProduct(BAGLE2));
        Assertions.assertEquals(expectedBasket, basket.getBagelsInBasket());
    }

    @Test
    void removeBagle_ShouldNotRemoveBagleNotInBaglesInBasket(){
        Basket basket = new Basket();
        basket.addProduct(BAGLE1);

        Assertions.assertThrows(IllegalStateException.class,() -> basket.removeProduct(BAGLE2));
    }

    @Test
    void changeBasketSize_ShouldChangeBasketCapacity(){
        Basket basket = new Basket();

        int expectedBasketCapacity = 10;
        basket.changeBasketCapacity(expectedBasketCapacity);

        Basket basket1 = new Basket();

        Assertions.assertEquals(expectedBasketCapacity, basket1.getBasketCapacity());
    }

    @Test
    void changeBasketSize_ShouldNotChangeBasketCapacityForPreviousBasket(){
        Basket basket = new Basket();
        int expectedBasketCapacity = basket.getBasketCapacity();
        basket.changeBasketCapacity(10);

        Assertions.assertEquals(expectedBasketCapacity, basket.getBasketCapacity());
    }

    @Test
    void getBasketPrice_ShouldBeFor110BGLEAndBGLSANDFILB(){
        Basket basket = new Basket();
        basket.addProduct(BAGLE1);
        BAGLE3.addFilling(FillingType.FILB);
        basket.addProduct(BAGLE3
        );

        BigDecimal expectedBigDecimal = BAGLE1.getPrice().add(BAGLE3.getPrice());

        Assertions.assertEquals(expectedBigDecimal, basket.getBasketPrice());
    }

    @Test
    void getPrice_ShouldReturnFor061BGLEAndFiLB(){
        Bagle bagle = new Bagle(BagleType.BGLE);
        bagle.addFilling(FillingType.FILB);

        BigDecimal expectedValue = BagleType.BGLE.getPrice().add(FillingType.FILB.getPrice());
        System.out.println(expectedValue);
        Assertions.assertEquals(expectedValue,bagle.getPrice());
    }
}