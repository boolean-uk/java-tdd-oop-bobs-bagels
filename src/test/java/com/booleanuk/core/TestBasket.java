package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestBasket {
    @Test
    public void testAddProductToBasket(){
        Basket basket = new Basket();

        basket.addProductToBasket("Bagel","Plain","Yes");
        Assertions.assertEquals("BGLP",basket.basketArr[0]);
    }

    @Test
    public void testRemoveBagelFromBasket(){
        Basket basket = new Basket();
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        Assertions.assertTrue(basket.removeFromBasket("BGLP"));
    }

    @Test
    public void testAddToBasketDontExtendCapacity(){
        Basket basket = new Basket();
        basket.changeBasketCapacity(7);
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
        basket.addProductToBasket("Bagel","Plain","Yes");
        Assertions.assertEquals("Basket is full",basket.addProductToBasket("Bagel","Everything","Yes"));
    }

    @Test
    public void testChangeArrayCapacity(){
        Basket basket = new Basket();

        basket.changeBasketCapacity(6);
        Assertions.assertEquals(6,basket.basketArr.length);
    }

    @Test
    public void testIfBagelExists(){
        Basket basket = new Basket();

        Assertions.assertTrue(basket.checkProduct("Bagel"));
        Assertions.assertFalse(basket.checkProduct("Bogle"));
    }

    @Test
    public void testIfVariantExists(){
        Basket basket = new Basket();

        Assertions.assertTrue(basket.checkVariantForProduct("Bagel","Plain"));
        Assertions.assertFalse(basket.checkVariantForProduct("Bagel","Snow"));
    }

    @Test
    public void testTotalCostIsRight(){
        Basket basket = new Basket();

        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addFilling("Egg","Yes");
        Assertions.assertEquals(0.90d,basket.totalCost());
    }

    @Test
    public void testShouldSeeBagelPrices(){
        Basket basket = new Basket();
        double price = 0.0d;
        for (int i = 0; i < basket.inventoryList.size(); i++) {
            Inventory item = basket.inventoryList.get(i);
            if (item.getSKU().equals("BGLP")) {
                price=item.getPrice();
                break;
            }
        }
        Assertions.assertEquals(0.39d,price);
    }
    @Test
    public void testShouldGetConfirmationForNoAfterSeeingPrice(){
        Basket basket = new Basket();

        Assertions.assertEquals("Okey then",basket.addProductToBasket("Bagel","Plain","No"));
    }

    @Test
    public void testChooseFilling(){
        Basket basket = new Basket();
        basket.addProductToBasket("Bagel","Everything","Yes");
        basket.addFilling("Egg","Yes");

        Assertions.assertEquals("FILE", basket.fillingArr[0]);
    }

    @Test
    public void testShouldSeeFillingPrices(){
        Basket basket = new Basket();
        double price = 0.0d;
        for (int i = 0; i < basket.inventoryList.size(); i++) {
            Inventory item = basket.inventoryList.get(i);
            if (item.getSKU().equals("FILB")) {
                price=item.getPrice();
                break;
            }
        }
        Assertions.assertEquals(0.12d,price);
    }

    @Test
    public void testCanOnlyAddExistingValues(){
        Basket basket = new Basket();
        basket.addProductToBasket("Bagel","Plain","Yes");
        basket.addProductToBasket("Bagel","Plain","Yes");
        Assertions.assertEquals("That product doesnt exist",basket.addProductToBasket("Bogle","Plain","Yes"));
    }

}
