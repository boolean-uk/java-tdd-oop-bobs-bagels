package com.booleanuk.extension.extension1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BasketTest {

    private Bagel TEST_BAGEL = new Bagel(ProductType.BGLE);
    private static final BigDecimal PRICE_FOR_12_BAGELS = BigDecimal.valueOf(3.99);
    private static final BigDecimal PRICE_FOR_6_BAGELS = BigDecimal.valueOf(2.49);
    private static final BigDecimal PRICE_FOR_COFFEE_AND_BAGEL = BigDecimal.valueOf(1.25);

    @Test
    void getPrice_ShouldBe3_99ForDiscount12Bagels(){
        Basket basket = new Basket();
        int numberOfBagels = 12;
        for (int i = 0; i < numberOfBagels; i++){
            basket.addProduct(TEST_BAGEL);
        }

        Assertions.assertEquals(PRICE_FOR_12_BAGELS, basket.getPrice());
    }

    @Test
    void getPrice_ShouldBe2_49ForDiscount6Bagels(){
        Basket basket = new Basket();
        int numberOfBagels = 6;
        for (int i = 0; i < numberOfBagels; i++){
            basket.addProduct(TEST_BAGEL);
        }

        Assertions.assertEquals(PRICE_FOR_6_BAGELS, basket.getPrice());
    }

    @Test
    void getPrice_DiscountForCoffeeAndBagel(){
        Basket basket = new Basket();
        CoffeeBagel cb = new CoffeeBagel(ProductType.COFB, TEST_BAGEL);
        basket.addProduct(cb);
        Assertions.assertEquals(PRICE_FOR_COFFEE_AND_BAGEL,basket.getPrice());
    }

    @Test
    void getPrice_DiscountForCoffeeAndBagelButNotForFilling(){
        Basket basket = new Basket();
        Bagel filBagel = new Bagel(ProductType.BGLO);
        filBagel.addFilling(FillingType.FILB);
        CoffeeBagel cb = new CoffeeBagel(ProductType.COFB, filBagel);
        basket.addProduct(cb);

        Assertions.assertEquals(PRICE_FOR_COFFEE_AND_BAGEL.add(FillingType.FILB.getPrice()), basket.getPrice());
    }

    @Test
    void getPrice_ShouldBe5_55ForDiscount6BagelsAndDiscount12Bagels(){
        Basket basket = new Basket();
        int numberOfBagels = 18;
        BigDecimal expectedValue = PRICE_FOR_12_BAGELS.add(PRICE_FOR_6_BAGELS);
        for (int i = 0; i < numberOfBagels; i++){
            basket.addProduct(TEST_BAGEL);
        }

        Assertions.assertEquals(expectedValue, basket.getPrice());
    }

    @Test
    void getPrice_ShouldBe7_26For15BagelsWithFillingFILB(){
        Basket basket = new Basket();
        Bagel bagel = new Bagel(ProductType.BGLO);
        bagel.addFilling(FillingType.FILB);
        for (int i = 0; i< 15; i++){
            basket.addProduct(bagel);
        }
        BigDecimal expectedValue = BigDecimal.valueOf(7.26);
        Assertions.assertEquals(expectedValue, basket.getPrice());
    }

    @Test
    void checkIfProductIsBagelShouldNotThrow(){
        Assertions.assertThrows(IllegalStateException.class, () -> new Bagel(ProductType.COFW));
    }

    @Test
    void checkIfProductIsBagelShouldThrow(){
        Assertions.assertDoesNotThrow(() -> new Bagel(ProductType.BGLE));
    }

    @Test
    void checkIfProductIsCoffeeShouldNotThrow(){
        Assertions.assertThrows(IllegalStateException.class, () -> new Coffee(ProductType.BGLE));
    }

    @Test
    void checkIfProductIsCoffeeShouldThrow(){
        Assertions.assertDoesNotThrow(() -> new Coffee(ProductType.COFW));
    }


}
